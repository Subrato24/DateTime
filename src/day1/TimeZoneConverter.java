package day1;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneConverter {
    static void convertTimeZone(LocalDateTime india){
        ZonedDateTime istZone = india.atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println(istZone);

        ZonedDateTime huwaii = istZone.withZoneSameInstant(ZoneId.of("US/Hawaii"));
        System.out.println(huwaii);
    }
    public static void main(String[] args) {
        LocalDateTime ist = LocalDateTime.now();
        convertTimeZone(ist);
    }
}
