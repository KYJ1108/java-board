package org.example.boardExam;
// 조회수

public class ViewCounter {
    private int views; // 조회수
    public ViewCounter(){
        this.views = 0;
    }

    public void incrementViews(){
        views++;
    }
    public int getViews(){
        return views;
    }
}
