package com.RS.SongPlaylist;

public class Song {
    String title;
    String duration;

    public Song(String title, String duration) {
        this.title = title;
        this.duration = duration;
        System.out.println("New song added");
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }
    public void printSong(){
        System.out.println(title + "\t" + duration);
    }
}
