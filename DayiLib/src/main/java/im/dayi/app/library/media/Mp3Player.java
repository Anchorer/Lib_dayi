package im.dayi.app.library.media;

import android.media.MediaPlayer;
import android.text.TextUtils;

import java.io.IOException;

/**
 * Created by wragony on 13-6-5.
 */
public class Mp3Player {

    // 播放控制对象
    private MediaPlayer myMediaPlayer;

    private OnPlayListener playListener;

    private String mCurrentAudioPath;

    public Mp3Player(OnPlayListener playListener) {
        myMediaPlayer = new MediaPlayer();
        this.playListener = playListener;
    }

    private void playListner() {
        myMediaPlayer.setOnPreparedListener(playListener);
        myMediaPlayer.setOnCompletionListener(playListener);
        myMediaPlayer.setOnErrorListener(playListener);
    }

    // 播放
    public void play(String path) {
        if (null != myMediaPlayer) {
            myMediaPlayer.reset();
            try {
                this.mCurrentAudioPath = path;
                myMediaPlayer.setDataSource(path);
                myMediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            myMediaPlayer.start();
            playListner();
        }
    }


    /**
     * 暂停
     */
    public void puase() {
        if (null != myMediaPlayer) {
            if (myMediaPlayer.isPlaying()) {
                myMediaPlayer.pause();
            } else {
                myMediaPlayer.start();
            }
            playListner();
        }
    }

    /**
     * 停止
     */
    public void stop() {
        if (null != myMediaPlayer) {
            if (myMediaPlayer.isPlaying()) {
                myMediaPlayer.reset();
                this.mCurrentAudioPath = null;
            }
            playListner();
        }
    }

    /**
     * 释放
     */
    public void release() {
        if (null != myMediaPlayer) {
            myMediaPlayer.stop();
            myMediaPlayer.release();
            myMediaPlayer = null;
            playListner();
        }
    }

    /**
     * 是否正在播放
     */
    public boolean isPlaying() {
        if (myMediaPlayer != null) {
            return myMediaPlayer.isPlaying();
        }
        return false;
    }

    /**
     * 判断是否正在播放指定的音频
     * @param path  指定的音频路径
     */
    public boolean isPlayingSpecificAudio(String path) {
        return !TextUtils.isEmpty(mCurrentAudioPath) && isPlaying() && mCurrentAudioPath.equals(path);
    }

}
