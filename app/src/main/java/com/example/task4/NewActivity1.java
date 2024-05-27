package com.example.task4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NewActivity1 extends AppCompatActivity {
    TextView rname;
    TextView rsurname;
    TextView date;
    TextView time;
    TextView comms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_1);
        rname = findViewById(R.id.name2);
        rsurname = findViewById(R.id.surname2);
        Intent intent = getIntent();
        rname.setText(intent.getStringExtra("name"));
        rsurname.setText(intent.getStringExtra("surname"));
    }

    ActivityResultLauncher<Intent> mstartForResult = registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            date = findViewById(R.id.date2);
                            time = findViewById(R.id.time2);
                            comms = findViewById(R.id.comments2);
                            if(result.getResultCode() == Activity.RESULT_OK){
                                Intent intent = result.getData();
                                date.setText(intent.getStringExtra("date"));
                                time.setText(intent.getStringExtra("time"));
                                comms.setText(intent.getStringExtra("comms"));
                            }
                        }
                    });
    public void nextAct(View view){
        Intent intent = new Intent(this, NewActivity2.class);
        mstartForResult.launch(intent);
    }
}