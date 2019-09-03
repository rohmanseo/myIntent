package com.rohman.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv_message;
    final static String EXTRA_MESSAGE = "message";
    final static String EXTRA_REPLY = "reply";
    EditText edt_reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_message = (TextView) findViewById(R.id.tv_message);
        edt_reply = (EditText) findViewById(R.id.edt_sec);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        tv_message.setText(message);

    }

    public void returnReply(View view) {
        String reply = edt_reply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}
