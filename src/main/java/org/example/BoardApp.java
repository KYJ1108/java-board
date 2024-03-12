package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {
    public void run() {
        Scanner scan = new Scanner(System.in);

        // 변수에는 하나의 값만 저장 가능하므로 여러개의 게시물을 저장하려면 ArrayList를 사용한다.
        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<String> bodyList = new ArrayList<>();

//        String title = "";
//        String content = "";

        // 반복 횟수 정할 수 없음 => 무한 반복 구조

        while(true) { // 반복 조건이 true 이기 때문에 무한 반복
            System.out.print("명령어 : ");
            String cmd = scan.nextLine();

            if (cmd.equals("exit")) { // 숫자가 아닌 경우 같다라는 표현을 할 때 ==이 아닌, .equals()를 사용해야 한다.
                System.out.println("프로그램을 종료합니다.");
                break; // 반복문 탈출
            }
            else if (cmd.equals("add")) {
                System.out.print("게시물 제목을 입력해 주세요 : ");
                String title = scan.nextLine();
                titleList.add(title);

                System.out.print("게시물 내용을 입력해 주세요 : ");
                String content = scan.nextLine();
                bodyList.add(content);

                System.out.println("게시물이 등록되었습니다.");
            }
            else if (cmd.equals("list")) {
                System.out.println("================");
                for (int i=0; i<titleList.size(); i++){
                    String title = titleList.get(i);
                    System.out.printf("제목 : %s\n", title);

                    String content = bodyList.get(i);
                    System.out.printf("내용 : %s\n", content);
                    System.out.println("=================");
                }
            }
            else if (cmd.equals("update")) {

            }
        }
    }
}
