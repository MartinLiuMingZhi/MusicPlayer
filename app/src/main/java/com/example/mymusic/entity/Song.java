package com.example.mymusic.entity;

import java.util.Objects;

public class Song {
    private String name;
    private String author;
    private int imgId;
    private int MusicId;

    public Song(String name, String author, int imgId,int MusicId) {
        this.name = name;
        this.author = author;
        this.imgId = imgId;
        this.MusicId = MusicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return imgId == song.imgId && MusicId == song.MusicId && Objects.equals(name, song.name) && Objects.equals(author, song.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, imgId, MusicId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getMusicId() {
        return MusicId;
    }

    public void setMusicId(int musicId) {
        MusicId = musicId;
    }
//    @Override
//    public String toString() {
//        return "Song{" +
//                "name='" + name + '\'' +
//                ", author='" + author + '\'' +
//                ", imgId=" + imgId +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Song song = (Song) o;
//        return imgId == song.imgId && Objects.equals(name, song.name) && Objects.equals(author, song.author);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, author, imgId);
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public int getImgId() {
//        return imgId;
//    }
//
//    public void setImgId(int imgId) {
//        this.imgId = imgId;
//    }
}
