package com.fdmkst.ltl_pc.brain;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.webkit.WebHistoryItem;
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
    private ArrayList<Integer> nums = new ArrayList<Integer>();
    private int level = 10,corr=0,wins=0,fails=0;
    private Position[] positions = new Position[30];

    GridLayout gridL;
    TextView Tfails,Twins,Tlevel;
    TextView[] numbers = new TextView[30];
    ImageView[] circles = new ImageView[30];
    Thread thread;
    final Handler handler = new Handler();

        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        Twins = (TextView) findViewById(R.id.wins);
        Tfails = (TextView) findViewById(R.id.fails);
        Tlevel = (TextView) findViewById(R.id.remain);

        TypedArray ArrayNums = getResources().obtainTypedArray(R.array.numbers);
        TypedArray ArrayCirs = getResources().obtainTypedArray(R.array.circles);
        for(int i = 0 ; i < 30 ; i++){
            numbers[i] = (TextView) findViewById(ArrayNums.getResourceId(i,-1));
            ArrayNums.recycle();
            circles[i] = (ImageView) findViewById(ArrayCirs.getResourceId(i,-1));
            ArrayCirs.recycle();
            positions[i] = new Position(i,circles[i],numbers[i]);
        }

        gridL = (GridLayout)findViewById(R.id.gridLayout);
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
    }

    public void generateNums(final int n){
        System.out.println("generating with n=" + n);
        reset();
        nums.clear();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                Random rand = new Random();
                while (i < n) {
                    int random = rand.nextInt(30);
                    if (!nums.contains(random)) {
                        nums.add(random);
                        System.out.println(random);
                    } else
                        continue;
                    positions[random].number.setValue(i);
                    positions[random].number.appear();
                    i++;
                }
                //delay(700);
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
        gridL.setBackgroundColor(0xff2aaae1);
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
            for(i=0;i<30;i++){
                positions[i].circle.disappear();
            }
            gridL.setBackgroundColor(0xffff7d7d);
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
                    }
                }
            }, 1000);
            //reset();

        } else {
            corr++;

            if (i == nums.size()) {
                System.out.println("win  ..");
                gridL.setBackgroundColor(0xff7dff7d);
                //delay(500);
                if (level > 1) {
                    wins++;
                    level--;
                    Twins.setText(String.valueOf(wins));
                    Tlevel.setText(String.valueOf(level));
                    //delay(1000);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            generateNums(nums.size() + 1);
                        }
                    }, 1000);
                    //reset();

//                    return;
                }
                else {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("count age");
                        }
                    }, 1000);
                }
            }
        }
    }
}