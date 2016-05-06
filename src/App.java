import java.util.HashMap;

/**
 * Created by furka on 15.04.2016.
 */
public class App {

    public static void main(String[] args) {
        /*
        // Make Turing Def. from THIN Uebungsblatt 6, Aufgabe 1
        TuringState q0 = new TuringState(false);
        TuringState q1 = new TuringState(false);
        TuringState q2 = new TuringState(false);
        TuringState q3 = new TuringState(false);
        TuringState q4 = new TuringState(false);
        TuringState q5 = new TuringState(false);
        TuringState q6 = new TuringState(true);

        HashMap<String, TuringCalc> turingDef1 = new HashMap<>();

        turingDef1.put("00", new TuringCalc(q1, '_', true));
        turingDef1.put("01", new TuringCalc(q3, '_', true));
        turingDef1.put("0_", new TuringCalc(q6, '_', true));

        turingDef1.put("10", new TuringCalc(q1, '0', true));
        turingDef1.put("11", new TuringCalc(q1, '1', true));
        turingDef1.put("1_", new TuringCalc(q2, '_', false));

        turingDef1.put("20", new TuringCalc(q5, '_', false));

        turingDef1.put("30", new TuringCalc(q3, '0', true));
        turingDef1.put("31", new TuringCalc(q3, '1', true));
        turingDef1.put("3_", new TuringCalc(q4, '_', false));

        turingDef1.put("41", new TuringCalc(q5, '_', false));

        turingDef1.put("50", new TuringCalc(q5, '0', false));
        turingDef1.put("51", new TuringCalc(q5, '1', false));
        turingDef1.put("5_", new TuringCalc(q0, '_', true));
        */

        /*
        // Make Turing Def. from THIN Uebungsblatt 6, Aufgabe 2
        TuringState q0 = new TuringState(false);
        TuringState q1 = new TuringState(false);
        TuringState q2 = new TuringState(true);

        HashMap<String, TuringCalc> turingDef2 = new HashMap<>();
        turingDef2.put("00", new TuringCalc(q0, "0", true));
        turingDef2.put("01", new TuringCalc(q0, "1", true));
        turingDef2.put("0_", new TuringCalc(q1, "_", false));
        turingDef2.put("11", new TuringCalc(q1, "0", false));
        turingDef2.put("10", new TuringCalc(q2, "1", true));
        turingDef2.put("1_", new TuringCalc(q2, "1", true));
        */


        // Multiplikation
        TuringState q0 = new TuringState("q0", false);
        TuringState q1 = new TuringState("q1", false);
        TuringState q2 = new TuringState("q2", false);
        TuringState q3 = new TuringState("q3", false);
        TuringState q4 = new TuringState("q4", false);
        TuringState q5 = new TuringState("q5", false);
        TuringState q6 = new TuringState("q6", false);
        TuringState q7 = new TuringState("q7", true);

        TuringDefinition tDefMult = new TuringDefinition();
        tDefMult.add(new TuringCalc(q0, '0', 'X', q1, true));
        tDefMult.add(new TuringCalc(q0, '_', '_', q7, true));

        tDefMult.add(new TuringCalc(q1, '0', '0', q1, true));
        tDefMult.add(new TuringCalc(q1, 'Y', 'Y', q0, true));
        tDefMult.add(new TuringCalc(q1, '_', '_', q2, true));

        tDefMult.add(new TuringCalc(q2, '0', '0', q2, true));
        tDefMult.add(new TuringCalc(q2, '_', '0', q3, false));

        tDefMult.add(new TuringCalc(q3, '0', '0', q3, false));
        tDefMult.add(new TuringCalc(q3, '_', '_', q3, false));
        tDefMult.add(new TuringCalc(q3, 'X', 'X', q4, true));

        tDefMult.add(new TuringCalc(q4, '0', 'X', q1, true));
        tDefMult.add(new TuringCalc(q4, '_', '_', q5, false));

        tDefMult.add(new TuringCalc(q5, 'X', '0', q5, false));
        tDefMult.add(new TuringCalc(q5, 'Y', 'Y', q6, false));

        tDefMult.add(new TuringCalc(q6, '0', '0', q6, false));
        tDefMult.add(new TuringCalc(q6, 'X', 'X', q7, true));

        tDefMult.add(new TuringCalc(q7, '0', 'X', q1, true));

        TuringMachine tm = new TuringMachine(tDefMult, "000Y_", q0);
        tm.silentModeOff();
        tm.run();
    }
}
