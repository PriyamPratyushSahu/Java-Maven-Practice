//Part of the CSAT-Reasoning Calendar course to find the day when date is given

package CSAT_Practice;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

public class RandomDateDisplay {

    public static void main(String[] args) throws InterruptedException {
        LocalDate randomDate = getRandomDate();

        // Format and print the date
        String formattedDate = formatDate(randomDate);
        System.out.println("Random Date: " + formattedDate);

        // Wait for 60 seconds
        System.out.println("Waiting 60 seconds...");
        Thread.sleep(60_000);

        // Display day of the week
        String dayOfWeek = randomDate.getDayOfWeek()
                .getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        System.out.println("Day of the week: " + dayOfWeek);
    }

    public static LocalDate getRandomDate() {
        LocalDate today = LocalDate.now();
        Random random = new Random();
        int daysRange = 365 * 100;
        int randomDays = random.nextInt(daysRange * 2 + 1) - daysRange;
        return today.plusDays(randomDays);
    }

    public static String formatDate(LocalDate date) {
        int day = date.getDayOfMonth();
        String suffix = getDaySuffix(day);
        String month = date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        int year = date.getYear();
        return String.format("%d%s %s, %d", day, suffix, month, year);
    }

    public static String getDaySuffix(int day) {
        if (day >= 11 && day <= 13) return "th";
        switch (day % 10) {
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            default: return "th";
        }
    }
}
