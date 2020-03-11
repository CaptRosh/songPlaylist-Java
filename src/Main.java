package com.RS.SongPlaylist;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static Folder folder = new Folder("My Songs");
    public static Scanner in = new Scanner(System.in);
    public static LinkedList<Song> playlist = new LinkedList<>();
//   public static ListIterator<Song> order = playlist.listIterator();

    public static void main(String[] args) {

        int choice;
        boolean cond = true;

        while(cond){
            menuChoice();
            choice = in.nextInt();
            switch (choice){
                case 1:
                    addToPlaylist();
                    break;
                case 2:
                    removeFromPlaylist();
                    break;
                case 3:
                    printPlaylist();
                    break;
                case 4:
                    albumChoice();
                    break;
                case 5:
                    startPlaying();
                    break;
                case 6:
                    cond = false;
                    break;
            }
        }
    }
    public static void menuChoice(){
        System.out.println("Menu:\n" +
                "1: Add song to playlist\n" +
                "2: Remove song from playlist\n" +
                "3: List Playlist\n" +
                "4: Album and Song Settings\n" +
                "5: Start Playing\n" +
                "6: Quit");
    }
    public static void addToPlaylist(){
        System.out.println("Select Album:");
        for(int i=0;i<folder.albums.size();i++){
            folder.listAlbums();
            albumSelect(in.nextInt());
        }
    }
    public static void albumSelect(int input){
        Album album = folder.albums.get(input-1);
        System.out.println("Select song");
        album.listSongs();
        songSelect(input,in.nextInt());

    }
    public static void songSelect(int album,int input){
        Album selected = folder.albums.get(album-1);
        playlist.add(selected.album.get(input-1));
        System.out.println("Song successfully added to your playlist");
    }
    public static void removeFromPlaylist(){
        System.out.println("Which song do you want to remove?");
        playlist.remove(in.nextInt()-1);
        System.out.println("Song successfully removed from the playlist");
    }
    public static void startPlaying(){
        ListIterator<Song> order = playlist.listIterator();
        System.out.println("Now Playing: "+ order.next().getTitle());
        System.out.println("1: Next Song\n" +
                "2: Previous Song\n" +
                "3: Repeat Song\n" +
                "4: Quit");
        boolean cond = true;
        boolean forward = true;
        while(cond){
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    if(!forward){
                        if(order.hasNext()){
                            order.next();
                        }
                        forward = true;
                    }
                    if(order.hasNext()){
                        System.out.println("Now Playing: " + order.next().title);
                    }
                    else{
                        System.out.println("Reached the end of the playlist.");
                        forward=false;
                    }
                    break;
                case 2:
                    if(forward){
                    if(order.hasPrevious()){
                        order.previous();
                    }
                    forward = false;
                }
                    if(order.hasPrevious()){
                        System.out.println("Now Playing: " + order.previous().getTitle());
                    }
                    else{
                        System.out.println("Reached the start of the playlist.");
                        forward=true;
                    }
                    break;
                case 3:
                    if(forward){
                        System.out.println("Now Playing: " + order.previous().getTitle());
                    }
                    else{
                        System.out.println("Now Playing: " + order.next().getTitle());
                    }
                    break;
                case 4:
                    cond = false;
                    break;
            }
        }
    }
    public static void albumChoice(){
        folder.albumMenu();
        boolean cond = true;
        int choice;
        while(cond){
            choice = in.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Album Name");
                    in.nextLine();
                    String name = in.nextLine();
                    if(folder.albums.contains(name)){
                        System.out.println("Error: An album with the same name exists.");
                    }
                    else{
                        folder.addAlbum(name);
                        System.out.println("Album successfully added");
                    }
                    break;
                case 2:
                    System.out.println("Album List");
                    folder.listAlbums();
                    int input = in.nextInt();
                    songChoice(input -1);
                    break;
                case 3:
                    folder.listAlbums();
                    break;
                case 4:
                    cond = false;
                    break;
            }
        }
    }
    public static void songChoice(int input){
        Album selected = folder.albums.get(input);
        int choice;
        boolean cond = true;
        selected.songMenu();
        while(cond){
            choice = in.nextInt();
            switch (choice){
                case 1:
                    in.nextLine();
                    System.out.println("Enter name of the song");
                    String title = in.nextLine();
                    System.out.println("Enter the duration of the song");
                    String dur = in.nextLine();
                    selected.addSong(title,dur);
                    break;
                case 2:
                    selected.listSongs();
                    break;
                case 3:
                    cond = false;
                    folder.albumMenu();
                    break;
            }
        }
    }
    public static void printPlaylist(){
     Iterator<Song> iterator = playlist.iterator();
     while(iterator.hasNext()){
         Song out = iterator.next();
         System.out.println(out.title + "\t" + out.duration);
        }
    }
}