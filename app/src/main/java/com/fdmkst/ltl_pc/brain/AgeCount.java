package com.fdmkst.ltl_pc.brain;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AgeCount extends AppCompatActivity implements View.OnClickListener{
    private TextView age;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.age_count);
        age= (TextView) findViewById(R.id.age);
        String s = getIntent().getStringExtra("age");

        //age.setText(s);
        displayAge(s);
        System.out.println("ma brain age "+s);
    }

    @Override
    public void onClick(View v) {

    }

    public void displayAge(String s){
        int agen = Integer.parseInt(s);

        final int[] counter = {0};
        final int total = agen;
        new Thread(new Runnable() {
            public void run() {
                while (counter[0] < total) {
                    try {
                        Thread.sleep(2000/total);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    age.post(new Runnable() {
                        public void run() {
                            age.setText("" + counter[0]);
                        }
                    });
                    counter[0]++;
                }
            }
        }).start();
    }


}
