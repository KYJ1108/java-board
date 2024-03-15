package org.example.boardExam;

import java.util.List;

public class PostPrinter {
    // 게시물 정보 출력
    public void printPost(Post post){
        System.out.println("==== "+post.getNumber() +"번 게시물 ====");
        System.out.println("제목 : "+post.getTitle());
        System.out.println("내용: " + post.getContent());
        System.out.println("작성일: " + post.getCreatedAt());
        System.out.println("조회수: " + post.getViews());
        System.out.println("===================");

        System.out.println("======= 댓글 =======");
        List<String> comments = post.getComments();
        List<String> commentTimes = post.getCommentTimes();

        System.out.print("댓글: ");
        for (int i = 0; i<comments.size(); i++){
            System.out.println("댓글 내용 : " + comments.get(i));
            System.out.println("댓글 작성일: " + commentTimes.get(i));
            System.out.println("===================");
        }
    }
}
