package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {

    private TextView text;
    private Button left_top;
    private Button right_top;
    private Button center;
    private Button left_bottom;
    private Button right_bottom;
    private String displaytext = "";

    int no_of_clicks = 0;

    GenericButtonListener buttonListener = new GenericButtonListener();
    private class GenericButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.top_left) {
                no_of_clicks++;
                displaytext = displaytext + left_top.getText().toString();
            }
            if (v.getId() == R.id.top_right) {
                no_of_clicks++;
                displaytext = displaytext + right_top.getText().toString();
            }
            if (v.getId() == R.id.bottom_left) {
                no_of_clicks++;
                displaytext = displaytext + left_bottom.getText().toString();
            }
            if (v.getId() == R.id.bottom_right) {
                no_of_clicks++;
                displaytext = displaytext + right_bottom.getText().toString();
            }
            if (v.getId() == R.id.center) {
                no_of_clicks++;
                displaytext = displaytext + center.getText().toString();
            }
            if(v.getId() == R.id.navigate_to_secondary_activity_button) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SecondaryActivity.class);
                intent.putExtra("text", displaytext);
                Toast.makeText(getApplicationContext(), "text: " + displaytext, Toast.LENGTH_LONG).show();
                startActivityForResult(intent, 8);
                displaytext = "";
                no_of_clicks = 0;
            }
            displaytext = displaytext + ",";
            Log.d("mamaam", "onCreate() method was invoked" + no_of_clicks);
            text.setText(displaytext);

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        left_top = (Button)findViewById(R.id.top_left);
        right_top = (Button)findViewById(R.id.top_right);

        left_bottom = (Button)findViewById(R.id.bottom_left);
        right_bottom = (Button)findViewById(R.id.bottom_right);

        center = (Button)findViewById(R.id.center);

        left_top.setOnClickListener(buttonListener);
        right_top.setOnClickListener(buttonListener);
        left_bottom.setOnClickListener(buttonListener);
        right_bottom.setOnClickListener(buttonListener);
        center.setOnClickListener(buttonListener);

        text = (TextView)findViewById(R.id.text);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        Log.d("mama", "onSAveInstanceState() method was invoked");
        savedInstanceState.putInt("nr de clickuri", no_of_clicks);
        super.onSaveInstanceState(savedInstanceState);

    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("nr de clickuri")){
            int nr = savedInstanceState.getInt("nr de clickuri", -1);
            Log.d("mama", "nr de clickuri este : " + nr);
            Toast.makeText(getApplicationContext(), "nr de clickuri este: " +  nr, Toast.LENGTH_LONG).show();
        }
    }
}