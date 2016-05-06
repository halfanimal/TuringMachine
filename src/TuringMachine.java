/**
 * Created by furka on 15.04.2016.
 */

public class TuringMachine {
    private TuringDefinition tDef;
    private TuringStrip strip;
    private boolean isSilentMode = true;

    private String inputWord;
    private TuringCalc currentCalc;
    private int stepCount = 0;

    public TuringMachine(TuringDefinition tDef, String inputWord, TuringState startState) {
        this.tDef = tDef;
        this.inputWord = inputWord;
        strip = new TuringStrip();

        // Fill strip with input word
        strip.putString(this.inputWord);

        currentCalc = tDef.getTuringCalc(startState, strip.read());
    }

    public void run() {
        TuringCalc prevCalc = null;
        long duration = System.nanoTime();

        try {
            while(currentCalc != null && (!currentCalc.getState().isTerminal() || !(strip.read() == TuringChar.SPACE.asChar()))) {
                ++stepCount;

                // Print strip, only if not in silent mode
                if(!isSilentMode)
                    printStrip();

                // Write symbol from calc
                strip.write(currentCalc.getToWrite());

                // Move strip (false: left, true: right)
                strip.moveTo(currentCalc.getMovement());

                // Set previous calc, for printing result
                prevCalc = currentCalc;

                // Get next calc
                currentCalc = tDef.getTuringCalc(currentCalc.getNextState(), strip.read());
            }
            duration = System.nanoTime() - duration;

            // Print input word if accepted.
            printResult(!(prevCalc == null) && prevCalc.getNextState().isTerminal(), duration);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void printStrip() {
        System.out.println("Step " + stepCount + " (" + currentCalc + "):");
        System.out.println(strip);
    }

    private void printResult(boolean accepted, long duration) {
        String r = "Input word:\t\t\t\"" + inputWord + "\" ";

        if(accepted) {
            r = r + "accepted.\n" +
                    "Result on strip:\t";
            r = r + strip.getString();
        } else {
            r = r + "not accepted.";
        }

        r = r + "\nElapsed time:\t\t" + (int)(duration * 0.000001) + " ms";
        r = r + "\nTotal steps:\t\t" + stepCount;

        System.out.println(r);
    }

    public boolean silentModeOn() {
        if(!isSilentMode)
            isSilentMode = true;
        return isSilentMode;
    }

    public boolean silentModeOff() {
        if(isSilentMode)
            isSilentMode = false;
        return isSilentMode;
    }
}
