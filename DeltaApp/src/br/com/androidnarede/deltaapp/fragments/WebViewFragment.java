package br.com.androidnarede.deltaapp.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import br.com.androidnarede.deltaapp.R;

public class WebViewFragment extends Fragment {
	
	private WebView webView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.webview_include_layout, null);
		webView = (WebView) v.findViewById(R.id.webview);
		
		// ativar JavaScript
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				if (Uri.parse(url).getHost().equals(getString(R.string.url_home))){
					return false;
				}
				
				 // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
		        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		        startActivity(intent);
		        return true;
			}
		});
		webView.loadUrl(getArguments().getString("webview_url"));
		return v;
	}
}
