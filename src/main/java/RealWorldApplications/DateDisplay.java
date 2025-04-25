package RealWorldApplications;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateDisplay {

    public static void main(String[] args) {
        // Starting and ending dates
        LocalDate startDate = LocalDate.of(2024, 9, 24);
        LocalDate endDate = LocalDate.of(2024, 11, 20);

        // Formatter for the output in the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d'st' MMMM, yyyy");

        long totalDays = ChronoUnit.DAYS.between(startDate, endDate);

        // Loop through all the dates
        for (int i = 0; i <= totalDays; i++) {
            LocalDate currentDate = startDate.plusDays(i);

            // Adjust day suffix (st, nd, rd, th)
            String daySuffix;
            int day = currentDate.getDayOfMonth();
            if (day == 1 || day == 21 || day == 31) {
                daySuffix = "st";
            } else if (day == 2 || day == 22) {
                daySuffix = "nd";
            } else if (day == 3 || day == 23) {
                daySuffix = "rd";
            } else {
                daySuffix = "th";
            }

            // Replace the generic "st" suffix in the formatter with the correct one
            String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("d'" + daySuffix + "'-MMMM-yyyy"));

            // Output the formatted date
            System.out.println("Day " + (i + 1) + ": " + formattedDate);
        }
    }
}
