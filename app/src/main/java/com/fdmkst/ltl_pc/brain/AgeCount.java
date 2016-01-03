package com.fdmkst.ltl_pc.brain;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.ShareApi;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;

import java.util.Arrays;
import java.util.List;

public class AgeCount extends AppCompatActivity implements View.OnClickListener{
    private CallbackManager callbackManager;
    private LoginManager loginManager;
    private TextView age;
    private Button shareBtn;
    public String s;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.age_count);
        age= (TextView) findViewById(R.id.age);
        String s = getIntent().getStringExtra("age");

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        List<String> permissionNeeds = Arrays.asList("publish_actions");

        loginManager = LoginManager.getInstance();

        loginManager.logInWithPublishPermissions(this, permissionNeeds);

        loginManager.registerCallback(callbackManager, new FacebookCallback<LoginResult>()
        {
            @Override
            public void onSuccess(LoginResult loginResult)
            {
                //sharePhotoToFacebook();
            }

            @Override
            public void onCancel()
            {
                System.out.println("onCancel");
            }

            @Override
            public void onError(FacebookException exception)
            {
                System.out.println("onError");
            }
        });

        shareBtn = (Button) findViewById(R.id.share_button);

        //age.setText(s);
        displayAge(s);
        System.out.println("ma brain age " + s);
    }
    public void sharePhotoToFacebook(){
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.mipmap.original);
        SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(image)
                .setCaption("Check it out guys,my brain is Young " )
                .build();

        SharePhotoContent content = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();

        ShareApi.share(content, null);
    }

    @Override
    public void onClick(View v) {
        sharePhotoToFacebook();
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
