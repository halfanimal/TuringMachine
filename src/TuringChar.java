/**
 * Created by furka on 04.05.2016.
 */
public enum TuringChar {
    SPACE('_');

    public char asChar() {
        return c;
    }

    @Override
    public String toString() {
        return String.valueOf(c);
    }

    private final char c;

    private TuringChar(char c) {
        this.c = c;
    }
}
