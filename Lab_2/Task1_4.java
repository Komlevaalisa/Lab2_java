package Lab2;

public class Task1_4 {
    private int seconds;

    public Task1_4(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        int totalSeconds = seconds % (24 * 3600);
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        return String.format("%d:%02d:%02d", hours, minutes, secs);
    }
}