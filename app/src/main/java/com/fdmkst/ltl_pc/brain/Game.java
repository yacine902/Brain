package com.fdmkst.ltl_pc.brain;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.Duration;

public class Game extends AppCompatActivity{
    ArrayList<Integer> nums = new ArrayList<Integer>();
    int level = 10,corr=0,wins=0,fails=0;
    GridLayout gridL;
    TextView Tfails,Twins,Tlevel;
    TextView S00,S01,S02,S03,S04,
            S10,S11,S12,S13,S14,
            S20,S21,S22,S23,S24,
            S30,S31,S32,S33,S34,
            S40,S41,S42,S43,S44,
            S50,S51,S52,S53,S54;
    TextView[] numbers = new TextView[30];
    ImageView C00,C01,C02,C03,C04,
            C10,C11,C12,C13,C14,
            C20,C21,C22,C23,C24,
            C30,C31,C32,C33,C34,
            C40,C41,C42,C43,C44,
            C50,C51,C52,C53,C54;
    public ImageView[] circles = new ImageView[30];
    //Handler myHandler = new Handler();
    //            {
//            C00,C01,C02,C03,C04,
//            C10,C11,C12,C13,C14,
//            C20,C21,C22,C23,C24,
//            C30,C31,C32,C33,C34,
//            C40,C41,C42,C43,C44,
//            C50,C51,C52,C53,C54};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        Twins = (TextView) findViewById(R.id.wins);
        Tfails = (TextView) findViewById(R.id.fails);
        Tlevel = (TextView) findViewById(R.id.remain);
//        myHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                delToast();
//            }
//        },1000);
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

        numbers[0]=S00;
        numbers[1]=S01;
        numbers[2]=S02;
        numbers[3]=S03;
        numbers[4]=S04;
        numbers[5]=S10;
        numbers[6]=S11;
        numbers[7]=S12;
        numbers[8]=S13;
        numbers[9]=S14;
        numbers[10]=S20;
        numbers[11]=S21;
        numbers[12]=S22;
        numbers[13]=S23;
        numbers[14]=S24;
        numbers[15]=S30;
        numbers[16]=S31;
        numbers[17]=S32;
        numbers[18]=S33;
        numbers[19]=S34;
        numbers[20]=S40;
        numbers[21]=S41;
        numbers[22]=S42;
        numbers[23]=S43;
        numbers[24]=S44;
        numbers[25]=S50;
        numbers[26]=S51;
        numbers[27]=S52;
        numbers[28]=S53;
        numbers[29]=S54;


        C00 = (ImageView) findViewById(R.id.C00);
        C01 = (ImageView) findViewById(R.id.C01);
        C02 = (ImageView) findViewById(R.id.C02);
        C03 = (ImageView) findViewById(R.id.C03);
        C04 = (ImageView) findViewById(R.id.C04);
        C10 = (ImageView) findViewById(R.id.C10);
        C11 = (ImageView) findViewById(R.id.C11);
        C12 = (ImageView) findViewById(R.id.C12);
        C13 = (ImageView) findViewById(R.id.C13);
        C14 = (ImageView) findViewById(R.id.C14);
        C20 = (ImageView) findViewById(R.id.C20);
        C21 = (ImageView) findViewById(R.id.C21);
        C22 = (ImageView) findViewById(R.id.C22);
        C23 = (ImageView) findViewById(R.id.C23);
        C24 = (ImageView) findViewById(R.id.C24);
        C30 = (ImageView) findViewById(R.id.C30);
        C31 = (ImageView) findViewById(R.id.C31);
        C32 = (ImageView) findViewById(R.id.C32);
        C33 = (ImageView) findViewById(R.id.C33);
        C34 = (ImageView) findViewById(R.id.C34);
        C40 = (ImageView) findViewById(R.id.C40);
        C41 = (ImageView) findViewById(R.id.C41);
        C42 = (ImageView) findViewById(R.id.C42);
        C43 = (ImageView) findViewById(R.id.C43);
        C44 = (ImageView) findViewById(R.id.C44);
        C50 = (ImageView) findViewById(R.id.C50);
        C51 = (ImageView) findViewById(R.id.C51);
        C52 = (ImageView) findViewById(R.id.C52);
        C53 = (ImageView) findViewById(R.id.C53);
        C54 = (ImageView) findViewById(R.id.C54);
        //System.out.println(C00==null);

        circles[0] = C00;
        circles[1] = C01;
        circles[2] = C02;
        circles[3] = C03;
        circles[4] = C04;
        circles[5] = C10;
        circles[6] = C11;
        circles[7] = C12;
        circles[8] = C13;
        circles[9] = C14;
        circles[10] = C20;
        circles[11] = C21;
        circles[12] = C22;
        circles[13] = C23;
        circles[14] = C24;
        circles[15] = C30;
        circles[16] = C31;
        circles[17] = C32;
        circles[18] = C33;
        circles[19] = C34;
        circles[20] = C40;
        circles[21] = C41;
        circles[22] = C42;
        circles[23] = C43;
        circles[24] = C44;
        circles[25] = C50;
        circles[26] = C51;
        circles[27] = C52;
        circles[28] = C53;
        circles[29] = C54;


        gridL = (GridLayout)findViewById(R.id.gridLayout);
//        for(int i =0 ; i<30 ; i++)
//            circles[i].setOnClickListener(this);
        //System.out.println(circles[5].getAlpha());
        generateNums(3);

    }
//    void delToast(){
//        Toast.makeText(this,"...", Toast.LENGTH_LONG);
//    }
    public void generateNums(int n){
        System.out.println("generating with n="+n);
        nums.clear();
        //delay(1000);
        int[] num = new int[n];
        int i=0;
        Random rand = new Random();
        while(i<n){
            int random = rand.nextInt(30);
            if (!nums.contains(random)) {
                nums.add(random);
                System.out.println(random);
            }
            else
                continue;
            numbers[random].setText(String.valueOf(i));
            numbers[random].setAlpha(1);
            i++;
        }
//        try {
//            TimeUnit.MILLISECONDS.sleep(700);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        delay(700,n);
//        for(i = 0 ; i < n ; i++){
//            circles[nums.get(i)].setClickable(true);
//            circles[nums.get(i)].setAlpha((float)1.0);
//        }
    }
    public void delay(int time, final int n){
        System.out.println("delay with n="+n);
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("Again!! delay with n="+n);

                                // TODO Auto-generated method stub
                                if(n==0){
                                    System.out.println("delay found n ==0");
                                    reset();
                                    gridL.setBackgroundColor(0xffffff);
                                }
                                else
                                for (int i = 0; i < n; i++) {
                                    circles[nums.get(i)].setClickable(true);
                                    circles[nums.get(i)].setAlpha((float) 1.0);
                                }
                            }
                        });
                    }
                },
                time
        );
    }

    public void reset(){
        System.out.println("resetting...");
        for(int i=0 ; i<30 ; i++){
            numbers[i].setAlpha(0);
            circles[i].setAlpha((float)0.0);
            circles[i].setClickable(false);
        }
    }
    public void onCircleClick(View v){
        v.setAlpha(0);
        v.setClickable(false);
        int i = 0;
        while ( i<nums.size() && circles[nums.get(i)].getAlpha()==0)
            i++;
        System.out.println(i);
        if (i!=0)System.out.println(circles[nums.get(i-1)].getId()==v.getId());
        if(i==0 || circles[nums.get(i-1)].getId()!=v.getId()){
            fails++;
            level--;
            Tfails.setText(String.valueOf(fails));
            Tlevel.setText(String.valueOf(level));
            System.out.println("fail");
            gridL.setBackgroundColor(0xff7d7d);
            delay(1000, 0);
            //reset();
            if(level>0)
                if(nums.size()!=3) {
                    generateNums(nums.size() - 1);
                    //return;
                }
                else {
                    generateNums(nums.size());
                    //return;
                }

            else {

                System.out.println("count age");
            }
        } else {
            corr++;

            if (i == nums.size()){
                System.out.println("win  ..");
                gridL.setBackgroundColor(0x7dff7d);
                //delay(500);
                if (level > 0) {
                    wins++;
                    level--;
                    Twins.setText(String.valueOf(wins));
                    Tlevel.setText(String.valueOf(level));
                    delay(1000, 0);
                    //reset();
                    generateNums(nums.size() + 1);
//                    return;
                }
                else {
                    delay(1000,0);
                    System.out.println("LAST reset calling..");

                    reset();
                    System.out.println("count age");
                }
            }
        }
    }
}