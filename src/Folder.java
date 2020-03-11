package com.RS.SongPlaylist;

import java.util.ArrayList;

public class Folder {
    String name;
    ArrayList<Album> albums;

    public Folder(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
    }
    public void addAlbum(String name){
        this.albums.add(new Album(name));
    }
    public void listAlbums(){
        System.out.println("Present albums are:");
        for( int i=0;i< albums.size();i++){
            System.out.println(i+1 +": "+ albums.get(i).albumName);
        }
    }
    public void albumMenu(){
        System.out.println("1: Create Album\n" +
                "2: Existing Albums\n" +
                "3: List Albums\n" +
                "4: Quit");
    }
}
