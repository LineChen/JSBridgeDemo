package com.line.jsbridgedemo;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;


/**
 * Created by chenliu on 2017/12/21.
 */

public class MyChomeClient extends WebChromeClient{

    private static final String TAG = "WebChromeClient";

    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        return super.onJsAlert(view, url, message, result);
    }

    @Override
    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        return super.onJsConfirm(view, url, message, result);
    }

    @Override
    public boolean onJsPrompt(final WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        Log.e(TAG, "url=" + url + ",message=" + message + ",default=" + defaultValue);
        if(message.equals("asyncPlus")){
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    view.loadUrl("javascript:showToast('5')");
                }
            }, 5000);
        }
        result.confirm(message);
        return true;
    }

}
