package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class PracticalTest01MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		EditText lefttext = (EditText)findViewById(R.id.editText1left);
		EditText righttext = (EditText)findViewById(R.id.editText2right);
		lefttext.setText(String.valueOf(0));
		righttext.setText(String.valueOf(0));
		
		
		//setare listeneri pe butoane
		MyListener ml = new MyListener();
		
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(ml);
		Button button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(ml);
		Button button3 = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
		button3.setOnClickListener(ml);
		
		//verificare pentru salvare context
		if (savedInstanceState != null) {
			String left_count = savedInstanceState.getString("left_count");
			if (left_count != null) {
				lefttext.setText(left_count);
			} else {
				lefttext.setText(String.valueOf(0));
			}
			String right_count = savedInstanceState.getString("right_count");
			if (right_count != null) {
				righttext.setText(right_count);
			} else {
				righttext.setText(String.valueOf(0));
			}
		} else {
			lefttext.setText(String.valueOf(0));
			righttext.setText(String.valueOf(0));
		}
	}

	//implementare clasa listener
	protected class MyListener implements View.OnClickListener {
		
		//implementare clasa onClick
		@Override
		public void onClick(View view) {
			
			EditText lefttext = (EditText)PracticalTest01MainActivity.this.findViewById(R.id.editText1left);
			EditText righttext = (EditText)PracticalTest01MainActivity.this.findViewById(R.id.editText2right);
			
			if (view instanceof Button) {
				if (view.getId() == R.id.button1) {
					String stanga = lefttext.getText().toString();
					int cont1 = Integer.parseInt(stanga);
					cont1++;
					EditText text1 = (EditText)findViewById(R.id.editText1left);
					text1.setText(String.valueOf(cont1));
				}
				if (view.getId() == R.id.button2) {
					String dreapta = righttext.getText().toString();
					int cont2 = Integer.parseInt(dreapta);
					cont2++;
					EditText text2 = (EditText)findViewById(R.id.editText2right);
					text2.setText(String.valueOf(cont2));
				}
				if (view.getId() == R.id.navigate_to_secondary_activity_button) {
					Intent intent = new Intent("ro.pub.cs.systems.pdsd.practicaltest01.PracticalTest01SecondaryActivity");
					int suma = Integer.parseInt(lefttext.getText().toString()) + Integer.parseInt(righttext.getText().toString());
					intent.putExtra("number_of_clicks", String.valueOf(suma));
					startActivityForResult(intent, 2015);
				}
			}
		}
		
	}
	
	//salvare context
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
			super.onSaveInstanceState(savedInstanceState);
			
			EditText leftEditText = (EditText)findViewById(R.id.editText1left);
			EditText rightEditText = (EditText)findViewById(R.id.editText2right);
			
			savedInstanceState.putString("left_count", leftEditText.getText().toString());
			savedInstanceState.putString("right_count", rightEditText.getText().toString());
	};
	
	//returneaza result code
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
