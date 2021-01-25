package com.delaroystudios.alarmreminder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class healthtips extends AppCompatActivity {

    private WebView healthtipweb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthtips);


        healthtipweb = (WebView) findViewById(R.id.healthtips);
        WebSettings webSettings = healthtipweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //improve webView performance
        healthtipweb.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        healthtipweb.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        healthtipweb.getSettings().setAppCacheEnabled(true);
        healthtipweb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);

        healthtipweb.loadUrl("http://www.newsweek.com");
        //force links open in webview only
        //   healthtipweb.setWebViewClient(new knowurmed.MyWebviewClient());

    }


    private class MyWebviewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().equals("www.newsweek.com")) {
                //open url contents in webview
                return false;
            } else {
                //here open external links in external browser or app
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }

        }
        //ProgressDialogue
//        ProgressDialog pd = null;
//
//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            pd=new ProgressDialog(knowurmed.this);
//            pd.setTitle("Please Wait..");
//            pd.setMessage("Website is Loading..");
//            pd.show();
//            super.onPageStarted(view, url, favicon);
//        }
//
//        @Override
//        public void onPageFinished(WebView view, String url) {
//            pd.dismiss();
//            super.onPageFinished(view, url);
//        }
    }
    //goto previous page when pressing back button

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (healthtipweb.canGoBack()) {
                        healthtipweb.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}