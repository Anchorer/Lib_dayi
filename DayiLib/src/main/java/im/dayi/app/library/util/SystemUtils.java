package im.dayi.app.library.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import com.anchorer.lib.utils.L;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import im.dayi.app.library.core.AppConfig;

/**
 * Utility: SystemUtils
 * 系统工具，提供各种和系统操作相关的方法，提供各种调用系统API的入口
 * This class provides a lot of operations on System level.
 *
 * Created by Anchorer/duruixue on 2013/8/6.
 * @author Anchorer
 */
public class SystemUtils {

    /**
     * 读取assets文件的内容
     * @param context   上下文环境
     * @param fileName  要读取的文件名称
     */
    public static String readFromAsset(Context context, String fileName) {
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, "UTF-8");
        } catch (IOException e) {
            L.e(AppConfig.LOG, "ReadFromAssets Exception", e);
        }
        return "";
    }

    /**
     * 获取APP的版本信息
     */
    public static String getAppVersionName(Context context) {
        try {
            if (context != null) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    PackageInfo info = packageManager.getPackageInfo(context.getPackageName(), 0);
                    if (info != null) {
                        return info.versionName;
                    }
                }
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 判断Activity是否正在运行
     * @param context
     */
    public static boolean isActivityRunning(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
            for (ActivityManager.RunningTaskInfo task : tasks) {
                if (packageName.equalsIgnoreCase(task.baseActivity.getPackageName()))
                    return true;
            }
        }
        return false;
    }
}
