package com.example.musicAppServer.music.dao.impl;

import com.example.musicAppServer.music.bean.Singer;
import com.example.musicAppServer.music.dao.SingerDao;
import com.example.musicAppServer.user.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class SingerDaoImpl implements SingerDao {
    private final QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    @Override
    public int add(Singer singer) throws SQLException {
        String sql = "insert into singer(singer_name,photo_path) values(?,?)";
        Object[] params = {
                singer.getSinger_name(),
                singer.getPhoto_path()
        };
        return queryRunner.update(sql, params);
    }

    @Override
    public List<Singer> findByName(String name) throws SQLException {
        String sql = "select * from singer where singer_name like ?";
        Object[] params = {
                '%'+name+'%'
        };
        return queryRunner.query(sql, new BeanListHandler<>(Singer.class), params);
    }

    @Override
    public List<Singer> findAll(String name) throws SQLException {
        String sql = "select * from music";
        return queryRunner.query(sql, new BeanListHandler<>(Singer.class));
    }
}
