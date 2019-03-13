package com.baizhi.util;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.File;

/**
 *获取上传音频的大小,时长,名称
 */
public class Mp3Util {
    public static String getDuration(File file) {
        int length = 0;
        try {
            MP3File f = (MP3File) AudioFileIO.read(file);
            MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
            length = audioHeader.getTrackLength();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int second = length % 60;
        String second1=String.valueOf(second);
        if(second<10){
            second1="0"+second;
        }
        int minute = length / 60;
        String minute1=String.valueOf(minute);
        if(minute<10){
            minute1="0"+minute;
        }
        return minute1 + ":" + second1;
    }
}