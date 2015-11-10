package im.dayi.app.library.media;

import android.media.MediaPlayer;

/**
 * 监听各种播放事件
 */
public abstract class OnPlayListener implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {

    @Override
    abstract public void onPrepared(MediaPlayer mediaPlayer);

    @Override
    abstract public void onCompletion(MediaPlayer mp);

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        String toastMsg = "";
        switch (extra) {
            case MediaPlayer.MEDIA_ERROR_IO:
                toastMsg = "文件或网络出错";
                break;
            case MediaPlayer.MEDIA_ERROR_MALFORMED:
                toastMsg = "无法解析音频流";
                break;
            case MediaPlayer.MEDIA_ERROR_UNSUPPORTED:
                toastMsg = "不支持该音频流";
                break;
            case MediaPlayer.MEDIA_ERROR_TIMED_OUT:
                toastMsg = "请求超时，请稍后再试";
                break;
        }
        mediaPlayer.reset();
        return true;
    }

}
