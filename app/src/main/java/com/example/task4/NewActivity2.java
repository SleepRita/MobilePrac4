package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewActivity2 extends AppCompatActivity {
    EditText date;
    EditText time;
    EditText comms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_2);
    }

    public void onOkClick(View view){
        Intent intent = new Intent();
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        comms = findViewById(R.id.comms);
        intent.putExtra("date", date.getText().toString());
        intent.putExtra("time", time.getText().toString());
        intent.putExtra("comms",comms.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
