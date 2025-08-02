package RealWorldApplications;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class TimeLeftInDay {
    public static void main(String[] args) {
        String format;
        SimpleDateFormat sdf;
        Date d = new Date();

        format = "y";
        sdf = new SimpleDateFormat(format);
        System.out.println("Current Year: " + sdf.format(d));

    }
}
