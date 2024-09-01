import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DayOfWeek day;
        LocalDate date = LocalDate.now();

        day = DayOfWeek.of(date.getDayOfWeek().getValue());

        System.out.println(day);
    }
}