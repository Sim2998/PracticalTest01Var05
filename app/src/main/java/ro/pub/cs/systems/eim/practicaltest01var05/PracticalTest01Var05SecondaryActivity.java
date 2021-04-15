package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var05SecondaryActivity extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();

        Intent intent = getIntent();
        Log.d("main", "SecondActivity() method was invoked");
        if (intent != null && intent.getExtras().containsKey("text") {
            String s = intent.getStringExtra("text");
            Intent intentRes = new Intent();
            // SECOND_RETURN_KEY = cheia, iar valoarea este sum
            intentRes.putExtra("sablon", s);
            setResult(RESULT_OK, intentRes);
            finish();
        }
    }
}