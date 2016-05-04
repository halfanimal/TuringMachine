import java.util.ArrayList;

/**
 * Created by furka on 02.05.2016.
 */
public class TuringDefinition {
    private ArrayList<TuringCalc> tcList;

    public TuringDefinition() {
        tcList = new ArrayList<>();
    }

    public void add(TuringCalc tc) {
        tcList.add(tc);
    }

    // TODO: Maybe not a for-loop for getting the next TuringCalc, maybe there is a better method for searching TuringCalc in TuringDefinition.
    public TuringCalc getTuringCalc(TuringState state, Character toRead) {
        TuringCalc tcResult = null;

        for(TuringCalc tc : tcList) {
            if(state.equals(tc.getState()) && toRead.equals(tc.getToRead())) {
                tcResult = tc;
                break;
            }
        }
        return tcResult;
    }
}
