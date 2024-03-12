package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Post> posts = new ArrayList<>();
        
        int postCount = 1; // 시작번호 1, 밖에 있는 이유는 반복문 안에 있으면 반복됨.

        posts.add(new Post(1, "안녕하세요 반갑습니다. 자바공부중이에요.",""));
        posts.add(new Post(2, "안녕하세요 반갑습니다. 자바 공부중이에요",""));
        posts.add(new Post(3, "정처기 따야되나요?", ""));


        // 반복 횟수 정할 수 없음 => 무한 반복 구조

        while(true) { // 반복 조건이 true 이기 때문에 무한 반복
            System.out.print("명령어 : ");
            String cmd = scan.nextLine();

            // 종료
            if (cmd.equals("exit")) { // 숫자가 아닌 경우 같다라는 표현을 할 때 ==이 아닌, .equals()를 사용해야 한다.
                System.out.println("프로그램을 종료합니다.");
                break; // 반복문 탈출
            }
            // 게시물 추가
            else if (cmd.equals("add")) {
                System.out.print("게시물 제목을 입력해 주세요 : ");
                String title = scan.nextLine();
                System.out.print("게시물 내용을 입력해 주세요 : ");
                String content = scan.nextLine();

                // 현재 날짜와 시간 구하기
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
                String formattedDateTime = now.format(formatter);

                // 게시물 내용
                Post post = new Post(postCount, title, content, formattedDateTime);
                // 내용 저장
                posts.add(post);
                // 게시물 번호
                postCount++;



                System.out.println("게시물이 등록되었습니다.");

            }
            // 게시물 리스트
            else if (cmd.equals("list")) {
                for (Post post : posts){
                    System.out.println("====================");
                    // 제목 + 게시물 번호
                    System.out.println("번호 : "+ post.getNumber());
                    System.out.println("제목 : "+ post.getTitle());
                    System.out.println("====================");
                }
            }
            // 게시물 수정
            else if (cmd.equals("update")){
                System.out.print("수정할 게시물 번호 : ");
                int number = Integer.parseInt(scan.nextLine()); // 문자열 -> 정수

                System.out.print("새로운 재목 : ");
                String newTitle = scan.nextLine();
                System.out.print("새로운 내용 : ");
                String newContent = scan.nextLine();

                // 해당 번호 게시물 가져오기.
                // -1 하는 이유는 인덱스는 0부터 시작이기 때문에  n버째 요소의 인데스는 n-1
                Post post = posts.get(number-1);
                // 게시물 수정
                post.setTitle(newTitle);
                post.setContent(newContent);

                System.out.println(post.getNumber()+"번 게시물이 수정되었습니다.");
                posts.set(number -1, post); // 수정된 게시물 다시 리스트에 저장
            }
            // 게시물 삭제
            else if (cmd.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int number = Integer.parseInt(scan.nextLine());

                posts.remove(number - 1);
                System.out.println(number + "번 게시물이 삭제되었습니다.");
            }
            // 게시물 디테일
            else if (cmd.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
                int number = Integer.parseInt(scan.nextLine());

                // 1~n 번째 사이의 숫자가 아니면 else문
                if (number > 0 && number <= posts.size()){ // posts.size는 게시물 리스트 몇개인지
                    Post post = posts.get(number - 1);
                    System.out.println("======================");
                    System.out.println("번호 : "+ post.getNumber());
                    System.out.println("제목 : "+ post.getTitle());
                    System.out.println("내용 : "+ post.getContent());
                    System.out.println("등록날짜 : "+post.getCreatedAt());
                    System.out.println("======================");
                }else {
                    System.out.println("존재하지 않는 게시물 번호입니다.");
                }
            }
        }
        // 반복문 제어 하던 방법 :
        // 1. 반복 횟수 세서 특정 횟수 지나면 탈출
        // 2. break문을 사용하여 강제 탈출 가능

//        for (int i=1; i<=10; i++){
//            if(i == 5){
//                break; // i가 5일 때 반복문 탈출
//            }
//            System.out.println(i);
//        }
    }
}
class Post {
    private String title;
    private String content;
    private int number; // 게시물 번호
    private String createdAt;
    

    public Post(int number, String title, String content) {
        this.number = number;
        this.title = title;
        this.content = content;
        this.createdAt = null; // 생성 시간을 초기화
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
}