public class Swapper implements Runnable {
    private int offset;
    private Interval interval;
    private String content;
    private char[] buffer;

    public Swapper(Interval interval, String content, char[] buffer, int offset) {
        this.offset = offset;
        this.interval = interval;
        this.content = content;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int intervalLength = interval.getY() - interval.getX() + 1;  // calculate a single Interval length
        for(int i = 0; i < intervalLength; i++) {
        	buffer[offset + i] = content.charAt(interval.getX() + i);
        }
    }
}