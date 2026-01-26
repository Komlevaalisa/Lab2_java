package Lab2;

public class Task4_4 {
    private int seconds;

    public Task4_4(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Количество секунд не может быть отрицательным");
        }
        // Приводим к формату времени суток (от 0 до 86399 секунд)
        this.seconds = seconds % (24 * 3600);
        if (this.seconds < 0) {
            this.seconds += 24 * 3600; // Корректировка для отрицательных значений
        }
    }

    // Конструктор из часов, минут, секунд
    public Task4_4(int hours, int minutes, int seconds) {
        // Делегируем создание методу validateAndConvert и основному конструктору
        this(validateAndConvert(hours, minutes, seconds));
    }

    // Статический приватный метод для валидации и конвертации
    private static int validateAndConvert(int hours, int minutes, int seconds) {
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Часы должны быть в диапазоне 0-23");
        }
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Минуты должны быть в диапазоне 0-59");
        }
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Секунды должны быть в диапазоне 0-59");
        }
        return hours * 3600 + minutes * 60 + seconds;
    }

    @Override
    public String toString() {
        int hours = getHours();
        int minutes = getMinutes();
        int secs = getSecondsPart();

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }

    public int getHours() {
        return (seconds / 3600) % 24;
    }

    public int getMinutes() {
        return (seconds % 3600) / 60;
    }

    public int getSecondsPart() {
        return seconds % 60;
    }

    public int getTotalSeconds() {
        return seconds;
    }
}