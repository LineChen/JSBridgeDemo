package com.line.jsbridgedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);

        initSettins();

        webView.loadUrl("file:///android_asset/jsbridge.html");

        addJavascriptInterface();
    }

    private void initSettins(){
        WebSettings webSettings = webView.getSettings();
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setDefaultFontSize(10);
        webSettings.setDomStorageEnabled(true);

        webView.setWebViewClient(new MyWebClient());
        webView.setWebChromeClient(new MyChomeClient());

    }

    /**
     * 普通方式，让js调用native方法
     */
    public void addJavascriptInterface(){
        webView.addJavascriptInterface(new JavascriptInterface(), "javascriptInterface");
    }

    public class JavascriptInterface{

        @android.webkit.JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();
        }
    }


}
