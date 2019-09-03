package com.rohman.myintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt_message;
    Button btn_message;
    final String EXTRA_MESSAGE = "message";
    TextView tv_header;
    TextView tv_message;
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_message = (EditText) findViewById(R.id.edt_main);
        btn_message = (Button) findViewById(R.id.btn_main);
        tv_header = (TextView) findViewById(R.id.tv_header);
        tv_message = (TextView) findViewById(R.id.tv_message);

    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = edt_message.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST){
            if (resultCode == RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                tv_message.setText(reply);
            }
        }
    }
}
