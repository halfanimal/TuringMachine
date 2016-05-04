import java.util.HashMap;

/**
 * Created by furka on 02.05.2016.
 */
public class TuringStrip {
    private int STRIP_OFFSET = 20;

    private HashMap<Integer, Character> strip;
    private int pos;

    public TuringStrip(){
        strip = new HashMap<>();
        pos = 0;
    }

    /**
     * Put Character at given position on strip
     * @param pos
     * @param c
     */
    private void putCharAt(int pos, char c) {
        strip.put(pos, c);
    }

    /**
     * Put Character at current position on strip
     * @param c
     */
    public void write(char c) {
        putCharAt(pos, c);
    }

    /**
     * Get Character at given position
     * @param pos
     * @return
     */
    private char getCharAt(int pos) {
        char c = strip.get(pos) != null ? strip.get(pos) : '_'; // TODO: Make enum for fix chars like '_' <-- space on strip
        return c;
    }

    /**
     * Get Character at given position
     * @return
     */
    public char read() {
        return getCharAt(pos);
    }

    /**
     * Put String on strip
     * @param s
     */
    public void putString(String s){
        for(int i = 0; i < s.length(); i++) {
            strip.put(i, s.charAt(i));
        }
    }

    /**
     * Moves strip one position  to (direction: 0 - left, 1 - right)
     * @param direction 0: left, 1: right
     */
    public void moveTo(boolean direction) {
        pos = direction ? pos + 1 : pos - 1;
    }

    @Override
    public String toString() {
        String stripStr = "";
        String currentPosStr = "";

        for(int i = pos - STRIP_OFFSET; i <= pos + STRIP_OFFSET; i++) {
            stripStr = stripStr + getCharAt(i);

            if(i == pos) {
                currentPosStr = currentPosStr + "^";
            }
            else {
                currentPosStr = currentPosStr + " ";
            }
        }

        return stripStr + "\n" + currentPosStr;
    }
}
