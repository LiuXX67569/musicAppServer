package com.example.musicAppServer.music.service.impl;

import com.example.musicAppServer.music.bean.Singer;
import com.example.musicAppServer.music.dao.SingerDao;
import com.example.musicAppServer.music.dao.impl.SingerDaoImpl;
import com.example.musicAppServer.music.service.SingerService;

import java.sql.SQLException;
import java.util.List;

public class SingerServiceImpl implements SingerService {
    private final SingerDao singerDao = new SingerDaoImpl();
    @Override
    public int add(Singer singer) throws SQLException {
        return singerDao.add(singer);
    }

    @Override
    public List<Singer> findByName(String name) throws SQLException {
        return singerDao.findByName(name);
    }

    @Override
    public List<Singer> findAll(String name) throws SQLException {
        return singerDao.findAll(name);
    }
}
