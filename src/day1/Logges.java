package day1;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logges {
    public static List<Map<String,String>> getLogges(String fromDate,String toDate){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;

        ZonedDateTime initialDate = ZonedDateTime.parse(fromDate,dateTimeFormatter);
        ZonedDateTime finalDate = ZonedDateTime.parse(toDate,dateTimeFormatter);

        System.out.println("fromDate:"+initialDate+" toDate:"+finalDate);

        List<Map<String,String>> l = new ArrayList<>();

        if(initialDate.toLocalDate().equals(finalDate.toLocalDate())){
            Map<String,String> m1 = new HashMap<>();
            m1.put("fromDate:",initialDate.format(dateTimeFormatter));
            m1.put("toDAte:",finalDate.format(dateTimeFormatter));
            l.add(m1);
        }
        else if (initialDate.isBefore(finalDate)) {
            ZonedDateTime dayStart = initialDate;
            while(dayStart.isBefore(finalDate)){

                ZonedDateTime dayEnd = dayStart.with(LocalTime.of(23,59,59));
                if(dayEnd.isAfter(finalDate)){
                    dayEnd = finalDate;
                }

                Map<String,String> m1 = new HashMap<>();
                m1.put("fromDate:",dayStart.format(dateTimeFormatter));
                m1.put("toDate:",dayEnd.format(dateTimeFormatter));

                l.add(m1);

                dayStart = dayEnd.plusSeconds(1);
            }
        }
        else{
            System.out.println("Given data is invalid");
        }
        return l;
    }
    public static void main(String[] args) {
        String fromDate = "2014-01-01T10:23:45Z";
//        String toDate = "2014-01-01T10:20:40Z";
//        String toDate = "2014-01-01T10:23:45Z";
        String toDate = "2014-01-03T22:07:08Z";

        List<Map<String,String>> log = getLogges(fromDate,toDate);

        for(Map<String,String> logges:log){
            System.out.println(logges);
        }
    }
}
