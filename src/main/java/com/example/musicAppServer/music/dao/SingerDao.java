package com.example.musicAppServer.music.dao;

import com.example.musicAppServer.music.bean.Singer;

import java.sql.SQLException;
import java.util.List;

public interface SingerDao {
    int add(Singer singer) throws SQLException;
    List<Singer> findByName(String name) throws SQLException;
    List<Singer> findAll(String name) throws SQLException;
}
