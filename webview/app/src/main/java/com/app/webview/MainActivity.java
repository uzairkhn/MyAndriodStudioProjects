package com.app.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Browser = (WebView)findViewById(R.id.webkit);
        //Browser.loadUrl("http://ebay.com");
        //Browser.getSettings().setJavaScriptEnabled(true);

        //Browser.loadData("<html><body><h1 style='color:red;'>Hello, world!</h1></body></html>",
        //        "text/html",
        //       "UTF-8");
        /*
        String img = "<img src='https://dummyimage.com/150X150/000/fff.gif&text=Hello+World'";

        String myHtmlPage = "<html> <body> Hello, world! "
                + "<br> Greetings from Musadaq <br>"
                + img
                + " </body>  </html>";

        Browser.loadData(myHtmlPage, "text/html", "UTF-8");
        */

        WebView wvContent = (WebView) findViewById(R.id.webkit);
        WebSettings webSettings = wvContent.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvContent.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    //view.evaluateJavascript("loadMsg('How are you today!')", null);
                    view.evaluateJavascript("add(2,3)", null);
                } else {
                    //view.loadUrl("javascript:loadMsg('How are you today!')");
                    view.loadUrl("javascript:add(2,3)");
                }
            }
        });
        wvContent.loadUrl("file:///android_asset/mypage.html");
    }
}