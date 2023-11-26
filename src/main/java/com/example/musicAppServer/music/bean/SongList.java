package com.example.musicAppServer.music.bean;

public class SongList {
    private Integer id;
    private String name;
    private String singer;
    private String album;
    private Integer song_id;
    private Integer album_id;
    private Integer singer_id;
    private String songList_name;
    private String username;
    private Integer songList_id;
    private String songList_intro;

    public SongList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getSong_id() {
        return song_id;
    }

    public void setSong_id(Integer song_id) {
        this.song_id = song_id;
    }

    public Integer getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(Integer album_id) {
        this.album_id = album_id;
    }

    public Integer getSinger_id() {
        return singer_id;
    }

    public void setSinger_id(Integer singer_id) {
        this.singer_id = singer_id;
    }

    public String getSongList_name() {
        return songList_name;
    }

    public void setSongList_name(String songList_name) {
        this.songList_name = songList_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSongList_id() {
        return songList_id;
    }

    public void setSongList_id(Integer songList_id) {
        this.songList_id = songList_id;
    }

    public String getSongList_intro() {
        return songList_intro;
    }

    public void setSongList_intro(String songList_intro) {
        this.songList_intro = songList_intro;
    }

    @Override
    public String toString() {
        return "SongListBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", album='" + album + '\'' +
                ", song_id=" + song_id +
                ", album_id=" + album_id +
                ", singer_id=" + singer_id +
                ", songList_name='" + songList_name + '\'' +
                ", username='" + username + '\'' +
                ", songList_id=" + songList_id +
                ", songList_intro='" + songList_intro + '\'' +
                '}';
    }
}
