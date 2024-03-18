package org.example.doardApp.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class CommonUtil {
    private Scanner scan = new Scanner(System.in);

    public Scanner getScanner(){
        return scan;
    }

    // 모든 곳에서 자주 사용되는 것은 여기에 모아두는 것이 좋다.
    public String getCurrentDateTime(){
        LocalDateTime now = LocalDateTime.now();

        // 날짜와 시간의 형식을 지정한다.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

        // 지정한 형식으로 날짜와 시간을 출력한다.
        String formeattedDate = now.format(formatter);

        return formeattedDate;
    }
}
