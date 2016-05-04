/**
 * Created by furka on 04.05.2016.
 */
public enum TuringCharr {
    SPACE('_');

    public char asChar() {
        return c;
    }

    @Override
    public String toString() {
        return String.valueOf(c);
    }

    private final char c;

    private TuringCharr(char c) {
        this.c = c;
    }
}
