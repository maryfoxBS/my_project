package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button buttonSTART;
    Button buttonAUTHOR;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSTART = (Button) findViewById(R.id.buttonSTART);
        buttonSTART.setOnClickListener(this);

        buttonAUTHOR = (Button) findViewById(R.id.buttonAUTHOR);
        buttonAUTHOR.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSTART:
                // TODO Call second activity
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonAUTHOR:
                // TODO Call THIRD activity
                Intent intent1 = new Intent(this, AuthorActivity.class);
                startActivity(intent1);
                break;

            default:
                break;
        }
    }
}
