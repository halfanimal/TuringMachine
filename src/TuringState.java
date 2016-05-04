/**
 * Created by furka on 27.04.2016.
 */
public class TuringState {
    private static int stateCount = 0;

    private Integer number;
    private String name;
    private Boolean isTerminal;

    public TuringState(String name, boolean isTerminal) {
        number = stateCount++;
        this.name = name;
        this.isTerminal = isTerminal;
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        return number.hashCode() + name.hashCode() + isTerminal.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TuringState)) {
            return false;
        }
        if (obj == this) { return true; }

        TuringState ts = (TuringState) obj;
        return ts.number.equals(number) && ts.name.equals(name) && ts.isTerminal.equals(isTerminal);
    }

    @Override
    public String toString(){
        return name;
    }
}
