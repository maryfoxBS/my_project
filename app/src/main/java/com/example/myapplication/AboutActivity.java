package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    EditText txtIn;
    EditText txtKey;
    EditText txtOut;
    SeekBar sb;
    Button btn;

    public String encode(String message, int keyVal) {
        String output = "";
        char key = (char) keyVal;
        for (int x = 0; x < message.length(); x++) {
            char input = message.charAt(x);
            if (input >= 'A' && input <= 'Z')
            {
                input += key;
                if (input > 'Z')
                    input -= 26;
                if (input < 'A')
                    input += 26;
            }
            else if (input >= 'a' && input <= 'z')
            {
                input += key;
                if (input > 'z')
                    input -= 26;
                if (input < 'a')
                    input += 26;
            }
            else if (input >= '0' && input <= '9')
            {
                input += (keyVal% 10);
                if (input > '9')
                    input -= 10;
                if (input < '0')
                    input += 10;
            }
            output += input;
        }
        return output;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        txtIn = (EditText)findViewById(R.id.txtIn);
        txtKey = (EditText)findViewById(R.id.txtKey);
        txtOut = (EditText)findViewById(R.id.txtOut);
        sb = (SeekBar)findViewById(R.id.seekBar);
        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int key = Integer.parseInt(txtKey.getText().toString());
                String message = txtIn.getText().toString();
                String output = encode(message, key);
                txtOut.setText(output);
            }
        });
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int key = sb.getProgress() - 13;
                String message = txtIn.getText().toString();
                String output = encode(message, key);
                txtOut.setText(output);
                txtKey.setText("" + key);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}