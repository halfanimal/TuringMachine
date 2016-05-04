/**
 * Created by furka on 27.04.2016.
 */
public class TuringState {
    private static int stateCount = 0;

    // TODO: Instead of a number, make a name, which is unique in a Definition
    private Integer number;
    private Boolean isTerminal;

    public TuringState(boolean isTerminal) {
        number = stateCount++;
        this.isTerminal = isTerminal;
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public int getNumber() {
        return number;
    }

    // TODO: Is this the best way to make a equals implementation for custom class?
    @Override
    public int hashCode() {
        return number.hashCode() + isTerminal.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TuringState)) {
            return false;
        }
        if (obj == this) { return true; }

        TuringState ts = (TuringState) obj;
        return ts.number.equals(number) && ts.isTerminal.equals(isTerminal);
    }

    @Override
    public String toString(){
        return String.valueOf(number);
    }
}
