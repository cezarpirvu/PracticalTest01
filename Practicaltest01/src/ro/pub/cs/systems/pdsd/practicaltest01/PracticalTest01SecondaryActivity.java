package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01SecondaryActivity extends Activity {

	
	protected class MyListener implements View.OnClickListener {
		
		@Override
		public void onClick(View view) {
			//listeneri pentru ok si cancel
			if (view instanceof Button) {
				if (view.getId() == R.id.buttonok) {
					setResult(RESULT_OK, new Intent());
					finish();
				}
				if (view.getId() == R.id.buttoncancel) {
					setResult(RESULT_CANCELED, new Intent());
					finish();
				}
			}
			
		}
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		//listeneri pentru ok si cancel
		MyListener ml = new MyListener();
		
		TextView text_suma = (TextView)findViewById(R.id.editText3sum);
		
		Intent intent = getIntent();
		if (intent != null) {
			String numberOfClicks = intent.getStringExtra("number_of_clicks");
		      if (numberOfClicks != null) {
		    	  text_suma.setText(text_suma.getText().toString().replace("", numberOfClicks));
		      }
		}
		
		
		Button ok = (Button)findViewById(R.id.buttonok);
		Button cancel = (Button)findViewById(R.id.buttoncancel);
		ok.setOnClickListener(ml);
		cancel.setOnClickListener(ml);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
