package br.com.androidnarede.deltaapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
	}

	public void entrar(View v){
		
		// intent expl’cita
		Intent intent = new Intent(this, PrincipalActivity.class); 
		finish();
		startActivity(intent);
	}
}