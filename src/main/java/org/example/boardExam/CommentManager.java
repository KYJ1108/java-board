package org.example.boardExam;
// 게시물 출력

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CommentManager {
    private List<String> comments; // 댓글 리스트 추가(detail)
    private List<String> commenTimes; //댓글 등록 시간

    public CommentManager(){
        this.comments = new ArrayList<>();
        this.commenTimes = new ArrayList<>();
    }
    public void addComment(String comment){
        comments.add(comment); // 댓글 작성 시간 추가
        commenTimes.add(getCurrentDateTime());
    }
    public void printComments(){
        if (comments.isEmpty()) {
            System.out.print("댓글이 없습니다. ");
        }
        else {
            for (int i = 0; i<comments.size(); i++){
                System.out.println("댓글 내용 : " + comments.get(i));
                System.out.println("댓글 작성일: " + commenTimes.get(i));
                System.out.println("===================");
            }
        }
    }

    // 현재 날짜와 시간을 문자열로 반환하는 메서드
    public String getCurrentDateTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formetter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return now.format(formetter);
    }
    public void removeComment(int index){

    }
}
