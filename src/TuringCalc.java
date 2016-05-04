import java.util.ArrayList;

/**
 * Created by furka on 15.04.2016.
 */
public class TuringCalc {
    private TuringState state;
    private TuringState nextState;
    private Character toRead;
    private Character toWrite;
    private boolean movement; // 0 = left, 1 = right

    public TuringCalc(TuringState state, char toRead, char toWrite, TuringState nextState, boolean movement) {
        this.state = state;
        this.toRead = toRead;
        this.toWrite = toWrite;
        this.nextState = nextState;
        this.movement = movement;
    }

    public TuringState getState() {
        return state;
    }

    public TuringState getNextState() { return nextState; }

    public char getToRead() { return toRead; }

    public char getToWrite() {
        return toWrite;
    }

    public boolean getMovement() {
        return movement;
    }

    // TODO: Add toString method and print calc with strip (upgrade: e.g. q0'0' --> '1'q2)
    @Override
    public String toString() {
        return state + "'" + toRead + "'" + " --> " + "'" + toWrite + "'" + nextState;
    }
}
