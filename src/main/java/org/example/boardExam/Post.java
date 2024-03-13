package org.example.boardExam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String title;
    private String content;
    private int number; // 게시물 번호
    private String createdAt;
    private int views; // 조회수


    public Post(int number, String title, String content) {
        this.number = number;
        this.title = title;
        this.content = content;
        this.createdAt = getCurrentDateTime(); // 생성 시간을 초기화
        this.views = 0; // 초기 조회수 0으로 설정
    }
    // 현재 날짜와 시간을 문자열로 반환하는 메서드
    public String getCurrentDateTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return now.format(formatter);
    }
    // 생성자 오버로딩
    public Post(int number, String title, String content, String createdAt) {
        this.number = number;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public int getNumber(){
        return number;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getCreatedAt(){return createdAt;}
    public int getViews(){return views;}
    public void incrementViews(){views++;}
}
