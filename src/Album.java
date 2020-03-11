package com.RS.SongPlaylist;


import java.util.ArrayList;

public class Album {
    public String albumName;
    public ArrayList<Song> album;

    public Album(String albumName) {
        this.albumName = albumName;
        this.album = new ArrayList<>();
    }

    public void addSong(String title, String duration){
        album.add(new Song(title,duration));
    }
    public void listSongs(){
        System.out.println("All songs in this album");
        for(int i =0; i<album.size();i++){
            System.out.println(i+1 +": "+album.get(i).getTitle() + "\t"+ album.get(i).getDuration() );
        }
    }
    public void songMenu(){
        System.out.println("1: Add Song\n" +
                "2: List Songs\n" +
                "3: Quit");
    }
}
