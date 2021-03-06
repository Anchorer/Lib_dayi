package im.dayi.app.library.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anchorer.lib.utils.L;

import im.dayi.app.library.R;
import im.dayi.app.library.core.LibConfig;
import im.dayi.app.library.util.SystemUtils;

/**
 * @author wragony
 * @version 1.0.0
 * @description 自定义进度条加载对话框
 * @email: wxl@wisezone.org
 * @createDate: 2013-4-11
 * @copyright Copyright(c) 2013 jifenzhong.com. All Rights Reserved
 */
public class CustomProgressDialog extends Dialog {

    private static CustomProgressDialog customProgressDialog = null;

    public CustomProgressDialog(Context context) {
        super(context);
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    private static CustomProgressDialog createDialog(Context context, boolean cancelable) {
        customProgressDialog = new CustomProgressDialog(context, R.style.customProgressDialog);
        try {
            customProgressDialog.setContentView(R.layout.widget_dialog_loading);
        } catch (Exception | Error e) {}
        customProgressDialog.setCancelable(cancelable);
        return customProgressDialog;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (customProgressDialog == null) {
            return;
        }
        ImageView imageView = (ImageView) customProgressDialog.findViewById(R.id.widget_dialog_loading_image);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
    }

    /**
     * 设置加载提示文本
     *
     * @param strMessage
     * @return
     * @author wragony
     */
    private CustomProgressDialog setMessage(String strMessage) {
        if (customProgressDialog != null) {
            TextView textView = (TextView) customProgressDialog.findViewById(R.id.widget_dialog_loading_text);
            if (textView != null) {
                textView.setText(strMessage);
                textView.setVisibility(View.VISIBLE);
            }
        }
        return customProgressDialog;
    }

    /**
     * 显示加载对话框
     * @param context
     */
    public static void showProgressDialog(Context context, boolean cancelable, String loadingText) {
        if (context != null && SystemUtils.isActivityRunning(context)) {
            customProgressDialog = CustomProgressDialog.createDialog(context, cancelable);
            if (!TextUtils.isEmpty(loadingText)) {
                customProgressDialog.setMessage(loadingText);
            }
            try {
                customProgressDialog.show();
            } catch (Exception | Error e) {
                L.e(LibConfig.LOG, "CustomProgressDialog show Exception", e);
            }
        }
    }

    /**
     * 隐藏加载对话框
     */
    public static void hideProgressDialog() {
        try {
            if (customProgressDialog != null && customProgressDialog.isShowing()) {
                customProgressDialog.dismiss();
            }
        } catch (Exception | Error e) {
            L.e(LibConfig.LOG, "CustomProgressDialog hide Exception.", e);
        } finally {
            customProgressDialog = null;
        }
    }

}
