package com.fdmkst.ltl_pc.brain;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

public class Game extends AppCompatActivity {
    TextView S00,S01,S02,S03,S04,
            S10,S11,S12,S13,S14,
            S20,S21,S22,S23,S24,
            S30,S31,S32,S33,S34,
            S40,S41,S42,S43,S44,
            S50,S51,S52,S53,S54;
    TextView[] numbers = {
            S00,S01,S02,S03,S04,
            S10,S11,S12,S13,S14,
            S20,S21,S22,S23,S24,
            S30,S31,S32,S33,S34,
            S40,S41,S42,S43,S44,
            S50,S51,S52,S53,S54};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        S00 = (TextView) findViewById(R.id.S00);
        S01 = (TextView) findViewById(R.id.S01);
        S02 = (TextView) findViewById(R.id.S02);
        S03 = (TextView) findViewById(R.id.S03);
        S04 = (TextView) findViewById(R.id.S04);
        S10 = (TextView) findViewById(R.id.S10);
        S11 = (TextView) findViewById(R.id.S11);
        S12 = (TextView) findViewById(R.id.S12);
        S13 = (TextView) findViewById(R.id.S13);
        S14 = (TextView) findViewById(R.id.S14);
        S20 = (TextView) findViewById(R.id.S20);
        S21 = (TextView) findViewById(R.id.S21);
        S22 = (TextView) findViewById(R.id.S22);
        S23 = (TextView) findViewById(R.id.S23);
        S24 = (TextView) findViewById(R.id.S24);
        S30 = (TextView) findViewById(R.id.S30);
        S31 = (TextView) findViewById(R.id.S31);
        S32 = (TextView) findViewById(R.id.S32);
        S33 = (TextView) findViewById(R.id.S33);
        S34 = (TextView) findViewById(R.id.S34);
        S40 = (TextView) findViewById(R.id.S40);
        S41 = (TextView) findViewById(R.id.S41);
        S42 = (TextView) findViewById(R.id.S42);
        S43 = (TextView) findViewById(R.id.S43);
        S44 = (TextView) findViewById(R.id.S44);
        S50 = (TextView) findViewById(R.id.S50);
        S51 = (TextView) findViewById(R.id.S51);
        S52 = (TextView) findViewById(R.id.S52);
        S53 = (TextView) findViewById(R.id.S53);
        S54 = (TextView) findViewById(R.id.S54);



    }
    public void generateNums(int n){
        int num;
        Random rand = new Random();
        for(int i = 0 ; i < n ; i++){
            num = rand.nextInt(30) + 1;
            numbers[num-1].setText(String.valueOf(i));
            numbers[num-1].setAlpha(1.0f);
        }
    }
}
