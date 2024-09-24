package gui.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public  class CreateTime {
    private static LocalDateTime currentDate;

    public static  String  getTime(){
        currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentDate.format(formatter);
    }

}
