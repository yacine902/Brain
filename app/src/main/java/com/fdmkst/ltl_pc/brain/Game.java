package com.fdmkst.ltl_pc.brain;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.TypedValue;
import android.view.View;
import android.webkit.WebHistoryItem;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.Duration;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")

public class Game extends AppCompatActivity{
    private ArrayList<Integer> nums = new ArrayList<Integer>();
    private int level = 10,corr=0,wins=0,fails=0;
    static int BAge;
    private Position[] positions = new Position[30];

    GridLayout gridL,gridL2;
    LinearLayout outerL;
    TextView Tfails,Twins,Tlevel;
    TextView[] numbers = new TextView[30];
    ImageView[] circles = new ImageView[30];
//    Thread thread;
    TextView textViewTime;
    Button startButton;
    //TextView countDownTextViewInButton;
    final Handler handler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        //AgeCount();
        Twins = (TextView) findViewById(R.id.wins);
        Tfails = (TextView) findViewById(R.id.fails);
        Tlevel = (TextView) findViewById(R.id.remain);

        //countDownTextViewInButton = (TextView) findViewById(R.id.S32);
        //countDownTextViewInButton.setText("3");

        TypedArray ArrayNums = getResources().obtainTypedArray(R.array.numbers);
        TypedArray ArrayCirs = getResources().obtainTypedArray(R.array.circles);
        for(int i = 0 ; i < 30 ; i++){
            numbers[i] = (TextView) findViewById(ArrayNums.getResourceId(i,-1));
            ArrayNums.recycle();//what does recycle do??
            circles[i] = (ImageView) findViewById(ArrayCirs.getResourceId(i,-1));
            ArrayCirs.recycle();
            positions[i] = new Position(i,circles[i],numbers[i]);
        }

        gridL = (GridLayout)findViewById(R.id.gridLayout);
        gridL2 = (GridLayout)findViewById(R.id.gridLayout2);
        outerL = (LinearLayout)findViewById(R.id.LinLayout);
        System.out.println(outerL.getHeight());
        System.out.println(gridL2.getWidth());
        gridL.setMinimumWidth(gridL2.getWidth());
        System.out.println(gridL.getWidth());
        System.out.println("CountDown... 3.2.1.Go...");
        generateNums(3);
    }

    public class Position{
        private int index;
        private Circle circle;
        private Number number;
        public Position(int index,ImageView circle,TextView number){
            this.index=index;
            this.circle = new Circle(circle);
            this.number = new Number(number,0);
        }
    }

    public class Circle{
        private ImageView image;
        public Circle(ImageView image){
            this.image=image;
        }
        public void appear(){
            image.setAlpha((float)1);
        }
        public void disappear(){
            image.setAlpha((float)0);
        }
        public void setClickable(boolean a){
            image.setClickable(a);
        }
        public boolean isAppearing(){
            return image.getAlpha()!=0.0;
        }
        public int getId(){
            return image.getId();
        }
    }

    public class Number{
        private TextView text;
        private int value;
        public Number(TextView text,int value){
            this.text=text;
            this.value=value;
        }
        public void appear(){
            text.setAlpha((float)1);
        }
        public void disappear(){
            text.setAlpha((float)0);
        }
        public void setValue(int value){
            this.value=value;
            text.setText(String.valueOf(value));
        }
        public void setSize(int size){
            text.setTextSize(size);
        }
    }

//    public void countDown(){
//
//        positions[12].number.setSize(100);
//        //positions[12].number.setValue(3);
//        positions[12].number.appear();
//        new CountDownTimer(4000, 1000) {
//
//            public void onTick(long millisUntilFinished) {
//                positions[12].number.setSize(100);
//                positions[12].number.appear();
//                positions[12].number.setValue((int) (millisUntilFinished / 1000));
//                System.out.println(" .." + (int) (millisUntilFinished / 1000));
//                System.out.println(" .."+numbers[12].getAlpha());
//
//            }
//
//            public void onFinish() {
//            }
//        }.start();
//
//
//    }

    public void countDown(){

        //positions[12].number.setSize(100);
        //positions[12].number.setValue(3);
        positions[12].number.appear();
        new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {
                //positions[12].number.setSize(100);
                positions[12].number.appear();
                positions[12].number.setValue((int) (millisUntilFinished / 1000));
                System.out.println(" .." + (int) (millisUntilFinished / 1000));
                System.out.println(" .."+numbers[12].getAlpha());

            }

            public void onFinish() {
            }
        }.start();


    }

    public void generateNums(final int n){
        System.out.println("generating with n=" + n);
        reset();
        nums.clear();
        countDown();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() { // how does this delaying work??
                reset();
                int i = 0;
                Random rand = new Random();
                while (i < n) {
                    int random = rand.nextInt(30);
                    if (!nums.contains(random)) {
                        nums.add(random);
                        System.out.println(random);
                    } else
                        continue;
                    positions[random].number.setValue(i + 1);
                    if (i < 9) positions[random].number.appear();
                    i++;
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < n; i++) {
                            positions[nums.get(i)].circle.appear();
                            positions[nums.get(i)].circle.setClickable(true);
                        }
                    }
                }, 700);
            }
        }, 3000);
    }

    public void reset(){
        System.out.println("resetting...");
        //System.out.println(numbers[0].getTextSize());
        numbers[12].setTextSize(50);
        gridL.setBackgroundColor(0xff2aaae1);
        gridL2.setBackgroundColor(0xff2aaae1);
        outerL.setBackgroundColor(0xff2aaae1);
        for(int i=0 ; i<30 ; i++){
            positions[i].number.disappear();
            //numbers[i].setMaxWidth(GridLayout.LayoutParams.WRAP_CONTENT);
            positions[i].circle.disappear();
            positions[i].circle.setClickable(false);
        }
    }

    public void onCircleClick(View v){
        v.setAlpha(0);
        v.setClickable(false);
        int i = 0;
        while ( i<nums.size() && circles[nums.get(i)].getAlpha()==0)
            i++;
        System.out.println(i);
        if (i!=0)System.out.println(circles[nums.get(i - 1)].getId() == v.getId());
        if(i==0 || circles[nums.get(i - 1)].getId() != v.getId()){
            fails++;
            level--;
            Tfails.setText(String.valueOf(fails));
            Tlevel.setText(String.valueOf(level));
            System.out.println("fail");
            for(i=0;i<30;i++){
                positions[i].circle.disappear();
            }
            gridL.setBackgroundColor(0xffff7d7d);
            gridL2.setBackgroundColor(0xffff7d7d);
            outerL.setBackgroundColor(0xffff7d7d);
            //delay(1000);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
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
                        AgeCount();
                    }
                }
            }, 1000);

        } else {
            corr+=nums.size();
            System.out.println("corr = "+corr);
            if ((i==9 && nums.size()>9)||(i == nums.size())) {
                System.out.println("win  ..");
                for(i=0;i<30;i++){
                    positions[i].circle.disappear();
                }
                gridL.setBackgroundColor(0xff7dff7d);
                gridL2.setBackgroundColor(0xff7dff7d);
                outerL.setBackgroundColor(0xff7dff7d);
                wins++;
                level--;
                Twins.setText(String.valueOf(wins));
                Tlevel.setText(String.valueOf(level));
                if (level > 1) {

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            generateNums(nums.size() + 1);
                        }
                    }, 1000);
                }
                else {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("count age");
                            AgeCount();
                        }
                    }, 1000);
                }
            }
        }
    }

    public void AgeCount(){
        int age;
        reset();
//        if(corr>3000)
//            age = 20;
//        else
        age = (int) (120*Math.exp(-0.015*corr)+20);
        BAge = age;
        System.out.println("corr = " + corr);
        System.out.println("age = " + BAge);
        Intent intent = new Intent("com.fdmkst.ltl_pc.brain.AgeCount");
        intent.putExtra("age", Integer.toString(BAge));
        startActivity(intent);
    }
}