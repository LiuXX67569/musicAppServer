package com.example.musicAppServer.music.dao.impl;

import com.example.musicAppServer.music.bean.SongList;
import com.example.musicAppServer.music.dao.SongListDao;
import com.example.musicAppServer.user.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class SongListDaoImpl implements SongListDao {
    private final QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    @Override
    public int add(SongList songList) throws SQLException {
        String sql = "insert into songlist(" +
                "id," +
                "name," +
                "singer," +
                "album," +
                "song_id," +
                "album_id," +
                "singer_id," +
                "songlist_name," +
                "username," +
                "songlist_id," +
                "songlist_intro) " +
                "values(?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {
                songList.getId(),
                songList.getName(),
                songList.getSinger(),
                songList.getAlbum(),
                songList.getSong_id(),
                songList.getAlbum_id(),
                songList.getSinger_id(),
                songList.getSongList_name(),
                songList.getUsername(),
                songList.getSongList_id(),
                songList.getSongList_intro()
        };
        return queryRunner.update(sql, params);
    }

    @Override
    public int deleteBySongListId(Integer id) throws SQLException {
        String sql = "delete from songlist where songlist_id=?";
        return queryRunner.update(sql, id);
    }

    @Override
    public int update(SongList songList) throws SQLException {
        String sql = "update songlist set " +
                "id=?," +
                "name=?," +
                "singer=?," +
                "album=?," +
                "song_id=?," +
                "album_id=?," +
                "singer_id=?," +
                "songlist_name=?" +
                "username=?" +
                "songlist_intro=?" +
                "where songlist_id=?";
        Object[] params = {
                songList.getId(),
                songList.getName(),
                songList.getSinger(),
                songList.getAlbum(),
                songList.getSong_id(),
                songList.getAlbum_id(),
                songList.getSinger_id(),
                songList.getSongList_name(),
                songList.getUsername(),
                songList.getSongList_intro(),
                songList.getSongList_id()
        };
        return queryRunner.update(sql, params);
    }

    @Override
    public List<SongList> findBySongListId(Integer id) throws SQLException {
        String sql = "select * from songlist where songlist_id=?";
        return queryRunner.query(sql, new BeanListHandler<>(SongList.class), id);
    }

    @Override
    public List<SongList> findByName(Integer id, String name) throws SQLException {
        String sql = "select * from songlist where songlist_id=? and (name like ? or singer like ? or album like ?)";
        Object[] params = {
                id,
                '%'+name+'%',
                '%'+name+'%',
                '%'+name+'%'
        };
        return queryRunner.query(sql, new BeanListHandler<>(SongList.class), params);
    }
}
