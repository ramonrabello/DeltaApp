package br.com.androidnarede.deltaapp;

import java.util.Locale;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import br.com.androidnarede.deltaapp.fragments.WebViewFragment;

public class PrincipalActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_sobre){
			exibirAlertaSobre();
		}
		return true;
	}
	
	private void exibirAlertaSobre(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(getString(R.string.texto_descricao_sobre_deltaapp));
		builder.setPositiveButton("OK", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		builder.create().show();
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			
			Fragment fragment = null;
			Bundle parametros = new Bundle();
			fragment = new WebViewFragment();
			switch (position) {
				case 0:{
					parametros.putString("webview_url", getString(R.string.url_home));
					break;
				}
				case 1:{
					parametros.putString("webview_url", getString(R.string.url_sobre));
					break;
				}
				case 2:{
					parametros.putString("webview_url", getString(R.string.url_inscricoes_e_valores));
					break;
				}
				case 3:{
					parametros.putString("webview_url", getString(R.string.url_programacao));
					break;
				}
				case 4:{
					parametros.putString("webview_url", getString(R.string.url_palestrantes));
					break;
				}
				case 5:{
					parametros.putString("webview_url", getString(R.string.url_patrocinio));
					break;
				}
				case 6:{
					parametros.putString("webview_url", getString(R.string.url_contato));
					break;
				}
				default:
					break;
				}
			fragment.setArguments(parametros);
			return fragment;
		}

		@Override
		public int getCount() {
			return 7;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
				case 0:{
					return getString(R.string.title_section1).toUpperCase(l);
				} 
				case 1:{
					return getString(R.string.title_section2).toUpperCase(l);
				}
				case 2:{
					return getString(R.string.title_section3).toUpperCase(l);
				}
				case 3:{
					return getString(R.string.title_section4).toUpperCase(l);
				}
				case 4:{
					return getString(R.string.title_section5).toUpperCase(l);
				}
				case 5:{
					return getString(R.string.title_section6).toUpperCase(l);
				}
				case 6:{
					return getString(R.string.title_section7).toUpperCase(l);
				}
			}
			return null;
		}
	}
}