package br.com.androidnarede.deltaapp.test;

import junit.framework.Assert;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import br.com.androidnarede.deltaapp.SplashActivity;

public class SplashActivityTest extends ActivityInstrumentationTestCase2<SplashActivity> {
	
	private Activity activity;
	private EditText campoLogin;
	private EditText campoSenha;
	private Button botaoEntrar;
	
	public void setUp(){
		activity = getActivity();
		campoLogin = (EditText) activity.findViewById(br.com.androidnarede.deltaapp.R.id.editText1);
		campoSenha = (EditText) activity.findViewById(br.com.androidnarede.deltaapp.R.id.editText2);
		botaoEntrar = (Button) activity.findViewById(br.com.androidnarede.deltaapp.R.id.button1);
	}
	
	public SplashActivityTest() {
		super(SplashActivity.class);
	}
	
	@MediumTest
	public void testSeUsuarioInformouLoginEsenhaCorretamente(){
		
		activity.runOnUiThread(new Runnable(){
			@Override
			public void run() {
				// coloca o foco no campo de login 
				campoLogin.requestFocus();				
			}
		});
		
		// preenche a string "delta" no campo de login
		sendKeys(KeyEvent.KEYCODE_D, 
				 KeyEvent.KEYCODE_E, 
				 KeyEvent.KEYCODE_L, 
				 KeyEvent.KEYCODE_T, 
				 KeyEvent.KEYCODE_A);
		
		activity.runOnUiThread(new Runnable(){
			@Override
			public void run() {
				// coloca o foco no campo de senha 
				campoSenha.requestFocus();				
			}
		});
		
		// preenche a string "delta" no campo de senha
		sendKeys(KeyEvent.KEYCODE_D, 
				 KeyEvent.KEYCODE_E, 
				 KeyEvent.KEYCODE_L, 
				 KeyEvent.KEYCODE_T, 
				 KeyEvent.KEYCODE_A);
		
		// simula o pressionamento do bot‹o
		TouchUtils.clickView(this, botaoEntrar);
		
		getInstrumentation().waitForIdleSync();
	    Assert.assertEquals("delta", campoLogin.getText().toString());
	    Assert.assertEquals("delta", campoSenha.getText().toString());    
	}
}
