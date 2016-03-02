package me.khrystal.appbarlayoutwithwebviewdemo;

import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.List;

/**
 * Created by kHRYSTAL on 2015/8/18.
 */
public class TencentWebViewClient extends WebViewClient {

    private List<String> urlStrings;

    public TencentWebViewClient() {
    }

    public TencentWebViewClient(List<String> urlStrings) {
        this.urlStrings = urlStrings;
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if( url.startsWith("http:") || url.startsWith("https:") ) {
            urlStrings.add(url);
            return false;
        }
        return false;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        if(!view.getSettings().getLoadsImagesAutomatically()) {
            view.getSettings().setLoadsImagesAutomatically(true);
        }
    }
}
