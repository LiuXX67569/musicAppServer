package com.example.musicAppServer.music.service;

import com.example.musicAppServer.music.bean.SongList;

import java.sql.SQLException;
import java.util.List;

public interface SongListService {
    int add(SongList songList) throws SQLException;
    int deleteBySongListId(Integer id) throws SQLException;
    int update(SongList songList) throws SQLException;
    List<SongList> findBySongListId(Integer id) throws SQLException;
    List<SongList> findByName(Integer id, String name) throws SQLException;
}
