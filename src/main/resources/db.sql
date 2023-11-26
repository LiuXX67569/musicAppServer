drop database if exists userDatabase;
create database if not exists userDatabase character set utf8;
use userDatabase;

-- 用户表
drop table if exists userInfo;
create table if not exists userInfo(
    pk_id int primary key auto_increment,
    phone varchar (20),
    portrait varchar (32) default './images/portrait_default.png',
    name varchar (32),
    level integer default 0,
    introduction varchar (100),
    create_time date default now(),
    modified_time timestamp default now()
);

-- 音乐表
DROP TABLE IF EXISTS music;
CREATE TABLE music(
    id int primary key AUTO_INCREMENT,
    song_name varchar(255) NOT NULL,
    singer varchar(255) NOT NULL,
    mp3_file_path varchar(255) NOT NULL,
    cover_image_path varchar(255) NOT NULL,
    lyrics_path varchar(255) DEFAULT NULL,
    created_at timestamp DEFAULT now(),
    updated_at timestamp DEFAULT now(),
    introduction varchar(255),
    singer_id int NOT NULL
);

-- 歌单列表
DROP TABLE IF EXISTS songlist;
CREATE TABLE songlist  (
    id int NOT NULL AUTO_INCREMENT primary key,
    name varchar(100) DEFAULT NULL COMMENT '歌曲名称',
    singer varchar(100) DEFAULT NULL COMMENT '歌手名称',
    album varchar(100) DEFAULT NULL COMMENT '专辑名称',
    song_id int NOT NULL COMMENT '歌曲id',
    album_id int NOT NULL COMMENT '专辑id',
    singer_id int NOT NULL COMMENT '歌手id',
    songlist_name varchar(100) DEFAULT NULL COMMENT '歌单名称',
    username varchar(100) DEFAULT NULL COMMENT '用户名称',
    songlist_id int NOT NULL COMMENT '歌单id',
    songlist_intro varchar(255) DEFAULT NULL COMMENT '歌单简介信息'
);
-- 歌手表
DROP TABLE IF EXISTS singer;
CREATE TABLE singer(
                       id int primary key AUTO_INCREMENT,
                       singer_name varchar(255) NOT NULL,
                       photo_path varchar(255) NOT NULL
);

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO music VALUES (1, '夜曲', '周杰伦', './music/sources/testmusic.mp3', './music/images/testimg.png', './music/lrc/testlrc.lrc', '2023-11-21 09:07:53', '2023-11-21 09:08:38' , 'jj1', 1);
INSERT INTO music VALUES (2, '执迷不悟', '小乐哥', './music/sources/test2music.mp3', './music/images/test2img.png', './music/lrc/test2lrc.lrc', '2023-11-21 09:07:53', '2023-11-21 09:09:03', 'jj2', 2);
INSERT INTO music VALUES (3, '游山恋', '海伦', './music/sources/test3music.mp3', './music/images/test3img.png', './music/lrc/test3lrc.lrc', '2023-11-21 09:07:53', '2023-11-21 09:09:32' , 'jj3', 3);
INSERT INTO music VALUES (4, 'test', '海伦', './music/sources/test3music.mp3', './music/images/test3img.png', './music/lrc/test3lrc.lrc', '2023-11-21 09:07:53', '2023-11-21 09:09:32' , 'jj3', 3);
INSERT INTO music VALUES (5, 'test', '海伦', './music/sources/test3music.mp3', './music/images/test3img.png', './music/lrc/test3lrc.lrc', '2023-11-21 09:07:53', '2023-11-21 09:09:32' , 'jj3', 3);

INSERT INTO singer VALUES (1,'周杰伦', '/null');
INSERT INTO singer VALUES (2,'小乐哥', '/null');
INSERT INTO singer VALUES (3,'海伦', '/null');
INSERT INTO singer VALUES (4,'test', '/null');
INSERT INTO singer VALUES (5,'test', '/null');
INSERT INTO singer VALUES (6,'test', '/null');
