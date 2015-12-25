//package com.fdmkst.ltl_pc.brain;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.CountDownTimer;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.TextView;
//
//import java.util.concurrent.TimeUnit;
//
////@TargetApi(Build.VERSION_CODES.GINGERBREAD)
////@SuppressLint("NewApi")
//public class CountDownActivity extends AppCompatActivity {
//    TextView textViewTime;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_count_down);
//        textViewTime = (TextView) findViewById(R.id.textViewTimeCount);
//        textViewTime.setText("3");
//    }
////    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
////    @SuppressLint("NewApi")
////    public class CounterClass extends CountDownTimer{
////        @Override
////        public void onTick(long millisUntilFinished) {
////        }
////
////        @Override
////        public void onFinish() {
////            textViewTime.setText("GO");
////
////        }
////
////        public CounterClass(long millisInFuture,long countDownInterval){
////            super(millisInFuture,countDownInterval);
////
////        }
////    }
//CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
//    @Override
//    public void onTick(long millisUntilFinished) {
//        long millis = millisUntilFinished;
//        String hms = String.format("%01d", TimeUnit.MILLISECONDS.toMinutes(millis)-
//                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)));
//        System.out.println(hms);
//        textViewTime.setText(hms);
//    }
//
//    @Override
//    public void onFinish() {
//        startActivity(new Intent("com.fdmkst.ltl_pc.brain.Game"));
//    }
//};
//}
