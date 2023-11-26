package com.example.musicAppServer.music.web;

import com.example.musicAppServer.music.bean.Music;
import com.example.musicAppServer.music.bean.Singer;
import com.example.musicAppServer.music.service.MusicService;
import com.example.musicAppServer.music.service.SingerService;
import com.example.musicAppServer.music.service.impl.MusicServiceImpl;
import com.example.musicAppServer.music.service.impl.SingerServiceImpl;
import com.example.musicAppServer.music.utils.JsonUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.sql.SQLException;

@WebServlet(name = "MusicServlet", value = "/MusicServlet")
public class MusicServlet extends HttpServlet {
    private final MusicService musicService = new MusicServiceImpl();
    private final SingerService singerService = new SingerServiceImpl();
    private Music music;

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
        music = JsonUtils.parseJSON2Object(request, Music.class);
        // 路径处理!!!需补充
        try {
            response.getWriter().write(musicService.add(music));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            response.getWriter().write(musicService.deleteById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        music = JsonUtils.parseJSON2Object(request, Music.class);
        // 路径处理!!!需补充
        try {
            response.getWriter().write(musicService.update(music));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        if (name.length() > 0) {
            name = URLDecoder.decode(name, "UTF-8");
        }
        try {
            JsonUtils.printResult(response, musicService.findByName(name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findBySinger(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String singer = request.getParameter("singer");
        if (singer.length() > 0) {
            singer = URLDecoder.decode(singer, "UTF-8");
        }
        try {
            JsonUtils.printResult(response, musicService.findBySinger(singer));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            JsonUtils.printResult(response, musicService.findById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            JsonUtils.printResult(response, musicService.findAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findSinger(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String name = request.getParameter("name");
        if (name.length() > 0) {
            name = URLDecoder.decode(name, "UTF-8");
        }
        try{
            JsonUtils.printResult(response, singerService.findByName(name));
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
