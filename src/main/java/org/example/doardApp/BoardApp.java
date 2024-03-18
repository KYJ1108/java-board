package org.example.doardApp;

import org.example.doardApp.domain.Article;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BoardApp {
    ArrayList<Article> articleList = new ArrayList<Article>(); // 인스턴스 변수

    public void run() {
        Scanner scan = new Scanner(System.in);

        // 변수에는 하나의 값만 저장 가능하므로 여러개의 게시물을 저장하려면 ArrayList를 사용한다.

        // 시작 번호를 1로 지정
        // 테스트 데이터 3개 있으므로 시작 번호 4로 지정
        int latestArticleId = 4; // 게시물 번호

        // 테스트 데이터
        Article a1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "냉무", getCurrentDateTime());
        Article a2 = new Article(2, "자바 질문좀 할게요~", "냉무", getCurrentDateTime());
        Article a3 = new Article(3, "정처기 따야되나요?", "냉무", getCurrentDateTime());
        articleList.add(a1);
        articleList.add(a2);
        articleList.add(a3);

        // 반복 횟수 정할 수 없음 => 무한 반복 구조

        while (true) { // 반복 조건이 true 이기 때문에 무한 반복
            System.out.print("명령어 : ");
            String cmd = scan.nextLine();

            if (cmd.equals("exit")) { // 숫자가 아닌 경우 같다라는 표현을 할 때 ==이 아닌, .equals()를 사용해야 한다.
                System.out.println("프로그램을 종료합니다.");
                break; // 반복문 탈출
            } else if (cmd.equals("add")) {
                System.out.print("게시물 제목을 입력해 주세요 : ");
                String title = scan.nextLine();

                System.out.print("게시물 내용을 입력해 주세요 : ");
                String content = scan.nextLine();

                // 모든 매개변수를 받는 생성자 이용
                Article article = new Article(latestArticleId, title, content, getCurrentDateTime());

                articleList.add(article);
                System.out.println("게시물이 등록되었습니다.");

                latestArticleId++; // 게시물이 생성될 때마다 번호를 증가
            } else if (cmd.equals("list")) {
                System.out.println("================");
                for (int i = 0; i < articleList.size(); i++) {
                    Article article = articleList.get(i);
                    //int id = idList.get(i);
                    System.out.println("번호 : " + article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.println("================");
                }
            } else if (cmd.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                int inputId = Integer.parseInt(scan.nextLine());
                // 1-> index : 0 // 2 -> index : 1

                int index = findIndexById(inputId);
                if (index == -1) {
                    System.out.println("없는 게시물입니다.");
                    continue;
                }

                System.out.print("새로운 제목 : ");
                String newTitle = scan.nextLine();

                System.out.print("새로운 내용 : ");
                String newBody = scan.nextLine();

                // id로 게시물 찾기 // 인덱스로 찾아서 수정
//                titleList.set(id -1, newTitle);
//                bodyList.set(id -1, newBody);

                Article target = articleList.get(index);
                target.setTitle(newTitle);
                target.setBody(newBody);

                System.out.printf("%d번 게시물이 수정되었습니다.\n", inputId);
            } else if (cmd.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int inputId = Integer.parseInt(scan.nextLine());

                int index = findIndexById(inputId);

                if (index == -1) {
                    System.out.println("없는 게시물입니다.");
                    continue;
                }

                articleList.remove(index);
                System.out.printf("%d번 게시물이 삭제되었습니다.\n", inputId);
            } else if (cmd.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
                int inputId = Integer.parseInt(scan.nextLine());
                int index = findIndexById(inputId);
                if (index == -1) {
                    System.out.println("없는 게시물 입니다.");
                    continue;
                }
                Article article = articleList.get(index);

                System.out.println("=======================");
                System.out.println("번호 : " + article.getId());
                System.out.println("제목 : " + article.getTitle());
                System.out.println("내용 : " + article.getBody());
                System.out.println("등록날짜 : " + article.getRegDate());
                System.out.println("=======================");
            }
        }
    }

    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);

            if (article.getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public String getCurrentDateTime(){
        LocalDateTime now = LocalDateTime.now();

        // 날짜와 시간의 형식을 지정합니다. 여기서는 연-월-일 시:분:초 형식을 사용합니다.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

        // 지정한 형식으로 날짜와 시간을 출력합니다.
        String formattedDate = now.format(formatter);

        return formattedDate;
    }
}