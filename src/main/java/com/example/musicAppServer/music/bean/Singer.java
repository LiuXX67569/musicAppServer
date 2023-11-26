package com.example.musicAppServer.music.bean;

public class Singer {
    private Integer id;
    private String singer_name;
    private String photo_path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public Singer() {
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id=" + id +
                ", singer_name='" + singer_name + '\'' +
                ", photo_path='" + photo_path + '\'' +
                '}';
    }
}
