package com.example.administrator.goneat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main6Activity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        webView = (WebView)findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setLightTouchEnabled(true);
        webView.getSettings().setSavePassword(true);
        webView.getSettings().setSaveFormData(true);

        webView.setWebViewClient(new MyWebViewClient());

        webView.loadUrl("https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%ED%95%9C%EC%96%91%EB%8C%80+%EA%B3%A0%EB%B0%B0%EC%9A%B0%EC%9D%98%EA%B9%9C%EB%8B%AD&oquery=%ED%95%9C%EC%96%91%EB%8C%80+%EC%9E%A5%EC%96%B4%EA%B5%AC%EC%9D%B4&tqi=TAdmkspVuENsstQXlawssssssBo-419877");


//        String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%ED%95%9C%EC%96%91%EB%8C%80+%EC%9C%A1%EC%95%A4%EC%83%A4";
//        WebView webView = (WebView)findViewById(R.id.webView);
//        webView.setWebChromeClient(new WebChromeClient());
//
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//        webView.loadUrl(url);

    }

    private class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);

            return true;
        }
    }

    public void nextScene( View view ){
        Intent i = new Intent(this, MapsActivity2.class);
        this.startActivity( i );
    }
}
