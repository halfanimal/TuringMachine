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

            // Print input word if accepted.
            printResult(!(prevCalc == null) && prevCalc.getNextState().isTerminal());

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void printStrip() {
        System.out.println("Step " + stepCount + " (" + currentCalc + "):");
        System.out.println(strip);
    }

    private void printResult(boolean accepted) {
        String r = "Input word: \"" + inputWord + "\" ";


        if(accepted) {
            r = r + "accepted.\n" +
                    "Result on strip: ";
            r = r + strip.getString();
        } else {
            r = r + "not accepted.";
        }

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
