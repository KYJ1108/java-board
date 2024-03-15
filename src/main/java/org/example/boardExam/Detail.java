package org.example.boardExam;

import org.example.boardExam.Post; // Post 클래스 import


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class Detail {
    public static void detailFunction(ArrayList<Post> posts, Scanner scan) {
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int number = Integer.parseInt(scan.nextLine());

        // 1~n 번째 사이의 숫자가 아니면 else문
        if (number > 0 && number <= posts.size()) { // posts.size는 게시물 리스트 몇개인지
            Post post = posts.get(number - 1);
            // 조회수 증가
            post.incrementViews();
            
            // 게시물 정보
            System.out.println("==== "+ post.getNumber() +"번 게시물 ====");
            System.out.println("번호 : " + post.getNumber());
            System.out.println("제목 : " + post.getTitle());
            System.out.println("내용 : " + post.getContent());
            System.out.println("등록날짜 : " + post.getCreatedAt());
            System.out.println("조회수 : " + post.getViews());
            System.out.println("======================");

            // 상세보기 기능 시작
            while (true) {
                System.out.print("상세보기 기능을 선택해주세요 (1. 댓글 등록, 2.추천, 3.수정, 4.삭제, 5. 목록으로) : ");
                int num = Integer.parseInt(scan.nextLine());
                switch (num) {
                    case 1: // 댓글 등록
                        System.out.println("==== 1. 댓글 등록 ====");
                        System.out.print("댓글 내용 : ");
                        String comment = scan.nextLine();
                        post.addComment(comment); // 댓글 추가 (Cooment Class에 있음.)

                        System.out.println("댓글이 성공적으로 등록되었습니다.");
                        post.printPost(); // 댓글추가한거 보여줌
                        break; // 멈춤.
                    case 2: // 게시물 추천
                        System.out.println("==== 2. 추천 ====");
                        System.out.println("======================");
                        break;
                    case 3: // 댓글 수정
                        System.out.println("==== 3. 수정 ====");
                        System.out.println("======================");
                        break;
                    case 4: // 댓글 삭제
                        System.out.println("==== 4. 삭제 ====");
                        System.out.println("======================");
                        break;
                    case 5: // 목록으로 빠져나감.
                        break; // 메서드 종료 switch문 탈출, while문에서 한번 더 해서 빠져나감.
                    default:
                        System.out.println("존재하지 않는 기능입니다."); // 1~5 외의 번호 선택시
                        break;
                }
                if (num == 5) {
                    break; // 목록으로 돌아가는 기능 선택 시 반복문 탈출
                }
            }
        } else {
            System.out.println("존재하지 않는 게시물 번호입니다.");
        }
    }
}

