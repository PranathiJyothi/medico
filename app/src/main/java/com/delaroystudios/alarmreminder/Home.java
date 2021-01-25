package com.delaroystudios.alarmreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

private Button bt,bt1;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bt = (Button) findViewById(R.id.knowmedact);
        bt.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        openKnowurmed();
        }
        });

        bt1 = (Button) findViewById(R.id.healthtioact);
        bt1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        openhealthtip();
        }
        });


        }

public void openKnowurmed(){

        Intent intent = new Intent(this,knowurmed.class);
        startActivity(intent);
        }

public void openhealthtip(){

        Intent intent = new Intent(this,knowurmed.class);
        startActivity(intent);
        }
        }