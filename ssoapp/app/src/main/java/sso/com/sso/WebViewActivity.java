package sso.com.sso;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebViewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = (WebView) findViewById(R.id.ssoWebView);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new MyWebViewClient());
        String url = "http://www.google.com";
        url = "http://10.0.2.2:3001/login";
        webView.loadUrl(url);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            System.out.println("The shouldOverrideUrlLoading is called , The URL is "+url);

            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
            //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            //startActivity(intent);
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            System.out.println("******The shouldOverrideUrlLoading is called , The URL is >>>>"+url);
            Intent intent = new Intent();
            intent.putExtra("URL",url);
            setResult(RESULT_OK,intent);
            finish();

        }
    }
}
