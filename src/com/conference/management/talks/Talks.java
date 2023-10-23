package com.conference.management.talks;

public class Talks {
    private int id;
    private  String title;
    private  int minutes;

    public Talks(int id, int minutes, String title){
        this.id = id;
        this.minutes = minutes;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public int getMinutes() {
        return minutes;
    }

}
