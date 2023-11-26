package com.example.musicAppServer.music.service.impl;

import com.example.musicAppServer.music.bean.SongList;
import com.example.musicAppServer.music.dao.SongListDao;
import com.example.musicAppServer.music.dao.impl.SongListDaoImpl;
import com.example.musicAppServer.music.service.SongListService;

import java.sql.SQLException;
import java.util.List;

public class SongListServiceImpl implements SongListService {
    private final SongListDao songListDao = new SongListDaoImpl();
    @Override
    public int add(SongList songList) throws SQLException {
        return songListDao.add(songList);
    }

    @Override
    public int deleteBySongListId(Integer id) throws SQLException {
        return songListDao.deleteBySongListId(id);
    }

    @Override
    public int update(SongList songList) throws SQLException {
        return songListDao.update(songList);
    }

    @Override
    public List<SongList> findBySongListId(Integer id) throws SQLException {
        return songListDao.findBySongListId(id);
    }

    @Override
    public List<SongList> findByName(Integer id, String name) throws SQLException {
        return songListDao.findByName(id, name);
    }
}
