package im.dayi.app.library.media;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;

import java.io.File;

/**
 * 使文件显示在相册中
 * Created by Anchorer/duruixue on 2015/8/5.
 */
public class SingleMediaScanner implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection scanner;
    private File file;

    public SingleMediaScanner(Context context, File f) {
        this.file = f;
        scanner = new MediaScannerConnection(context, this);
        scanner.connect();
    }

    @Override
    public void onMediaScannerConnected() {
        scanner.scanFile(file.getAbsolutePath(), null);
    }

    @Override
    public void onScanCompleted(String path, Uri uri) {
        scanner.disconnect();
    }
}
