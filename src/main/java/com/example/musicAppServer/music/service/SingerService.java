package com.example.musicAppServer.music.service;

import com.example.musicAppServer.music.bean.Singer;

import java.sql.SQLException;
import java.util.List;

public interface SingerService {
    int add(Singer singer) throws SQLException;
    List<Singer> findByName(String name) throws SQLException;
    List<Singer> findAll(String name) throws SQLException;
}
