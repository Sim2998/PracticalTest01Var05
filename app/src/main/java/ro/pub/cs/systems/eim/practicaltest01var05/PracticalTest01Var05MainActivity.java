package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {

    private EditText text;
    private Button left_top;
    private Button right_top;
    private Button center;
    private Button left_bottom;
    private Button right_bottom;
    private String displaytext = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        left_top = (Button)findViewById(R.id.top_left_b);
        right

    }
}