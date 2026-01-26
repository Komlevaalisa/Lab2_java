package Lab2;

public class Task5_4 {
    private int totalSeconds;

    // Конструктор из секунд
    public Task5_4(int totalSeconds) {
        if (totalSeconds < 0) {
            throw new IllegalArgumentException("Количество секунд не может быть отрицательным");
        }
        this.totalSeconds = totalSeconds; // Инициализируем поле
    }

    public int getHours() {
        return totalSeconds / 3600;
    }

    public int getMinutes() {
        return (totalSeconds % 3600) / 60;
    }

    public int getSecondsPart() {
        return totalSeconds % 60;
    }


    @Override
    public String toString() {
        int hours = getHours();
        int minutes = getMinutes();
        int seconds = getSecondsPart();

        return String.format("%d:%02d:%02d", hours, minutes, seconds);
    }
}