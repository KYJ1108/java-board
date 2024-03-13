package org.example.boardExam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private String title;
    private String content;
    private int number; // 게시물 번호
    private String createdAt;
    private int views; // 조회수
    private List<String> comments; // 댓글 리스트 추가(detail)
    private List<String> commenTimes; //댓글 등록 시간


    public Post(int number, String title, String content) {
        this.number = number;
        this.title = title;
        this.content = content;
        this.createdAt = getCurrentDateTime(); // 생성 시간을 초기화
        this.views = 0; // 초기 조회수 0으로 설정
        this.comments = new ArrayList<>(); // 댓글 리스트 초기화
        this.commenTimes = new ArrayList<>(); // 댓글 등록 시간 리스트 초기화
    }
    // 댓글 추가 메서드
    public void addComment(String comment){
        comments.add(comment);
        commenTimes.add(getCurrentDateTime());
    }

    // 게시물 정보 출력
    public void printPost(){
        System.out.println("==== "+getNumber() +"번 게시물 ====");
        System.out.println("제목 : "+title);
        System.out.println("내용: " + content);
        System.out.println("작성일: " + createdAt);
        System.out.println("조회수: " + views);
        System.out.println("===================");
        System.out.println("======= 댓글 =======");
        System.out.print("댓글: ");
        for (int i = 0; i<comments.size(); i++){
            System.out.println("댓글 내용 : " + comments.get(i));
            System.out.println("댓글 작성일: " + commenTimes.get(i));
            System.out.println("===================");
        }
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
