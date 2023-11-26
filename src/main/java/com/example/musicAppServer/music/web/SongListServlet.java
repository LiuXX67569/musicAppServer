package com.example.musicAppServer.music.web;

import com.example.musicAppServer.music.bean.SongList;
import com.example.musicAppServer.music.service.SongListService;
import com.example.musicAppServer.music.service.impl.SongListServiceImpl;
import com.example.musicAppServer.music.utils.JsonUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

@WebServlet(name = "SongListServlet", value = "/SongListServlet")
public class SongListServlet extends HttpServlet {
    private final SongListService songListService = new SongListServiceImpl();
    private SongList songList;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        try {
            Class<?extends Servlet> cls = this.getClass();
            Method method = cls.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        songList = JsonUtils.parseJSON2Object(request, SongList.class);
        // 路径处理!!!需补充
        try {
            response.getWriter().write(songListService.add(songList));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBySongListId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("songListId"));
        try {
            response.getWriter().write(songListService.deleteBySongListId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        songList = JsonUtils.parseJSON2Object(request, SongList.class);
        try {
            response.getWriter().write(songListService.update(songList));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findBySongListId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("songListId"));
        try {
            JsonUtils.printResult(response, songListService.findBySongListId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("songListId"));
        String name = request.getParameter("name");
        try {
            JsonUtils.printResult(response, songListService.findByName(id, name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
