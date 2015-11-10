package im.dayi.app.library.media;

import android.media.MediaRecorder;
import android.os.Environment;

import com.anchorer.lib.utils.L;

import java.io.File;

import im.dayi.app.library.core.LibConfig;

public class AudioRecorder {

    private final MediaRecorder recorder = new MediaRecorder();
    private final String path;
    private static int SAMPLE_RATE_IN_HZ = 8000;

    public AudioRecorder(String path) {
        this.path = path;
    }


    /**
     * 开始录音
     */
    public void start() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return;
        }
        File directory = new File(path).getParentFile();
        if (!directory.exists() && !directory.mkdirs()) {
            return;
        }

        try {
            //设置声音的来源
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            //设置声音的输出格式
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            //设置声音的编码格式
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            //设置音频采样率
            recorder.setAudioSamplingRate(SAMPLE_RATE_IN_HZ);
            //设置输出文件
            recorder.setOutputFile(path);
            //准备录音
            recorder.prepare();
            //开始录音
            recorder.start();
        } catch (Exception e) {
            L.e(LibConfig.LOG, "AudioRecorder Start Fail", e);
        }
    }

    /**
     * 停止录音
     */
    public void stop() {
        try {
            //停止录音
            recorder.stop();
            //释放资源
            recorder.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getAmplitude() {
        if (recorder != null) {
            return (recorder.getMaxAmplitude());
        } else
            return 0;
    }

}
