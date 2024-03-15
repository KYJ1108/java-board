package org.example.boardExam;

import org.example.boardExam.ViewCounter; // 조회수 관리
import org.example.boardExam.CommentManager; // 댓글 관리
import org.example.boardExam.PostPrinter; // 게시물 출력 클래스

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Post {
    private String title;
    private String content;
    private int number; // 게시물 번호
    private String createdAt;
    private ViewCounter viewCounter;
    private CommentManager commentManager;
    private List<String> comments; // 댓글 목록
    private List<String> commentTimes; // 댓글 작성 시간 목록



    public Post(int number, String title, String content) {
        this.number = number;
        this.title = title;
        this.content = content;
        this.createdAt = getCurrentDateTime(); // 생성 시간을 초기화
        this.viewCounter = new ViewCounter();
        this.commentManager = new CommentManager();
        this.comments = new ArrayList<>(); // 빈 ArrayList로 초기화
        this.commentTimes = new ArrayList<>(); // 빈 ArrayList로 초기화
    }
    // 게시물 조회수 증가 메서드
    public void incrementViews() {
        viewCounter.incrementViews();
    }

    // 현재 조회수 반환 메서드
    public int getViews() {
        return viewCounter.getViews();
    }

    // 댓글 추가 메서드
    public void addComment(String comment) {
        commentManager.addComment(comment);
    }

    // 게시물 정보 출력 메서드
    public void printPost() {
        System.out.println("==== " + getNumber() + "번 게시물 ====");
        System.out.println("제목 : " + getTitle());
        System.out.println("내용 : " + getContent());
        System.out.println("작성일 : " + getCreatedAt());
        System.out.println("조회수 : " + getViews());
        System.out.println("===================");

        // 댓글 출력
        commentManager.printComments();
    }

    // 현재 날짜와 시간을 문자열로 반환하는 메서드
    public String getCurrentDateTime() {
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

    public List<String> getComments() {
        // 댓글 목록을 반환합니다.
        return this.comments;
    }

    public List<String> getCommentTimes() {
        // 댓글 시간 목록을 반환합니다.
        return this.commentTimes;
    }
}
