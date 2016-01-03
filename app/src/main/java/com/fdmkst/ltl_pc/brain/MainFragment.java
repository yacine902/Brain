package com.fdmkst.ltl_pc.brain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;



public class MainFragment extends Fragment {
    private ImageView logo;
    private TextView mTextDetail;
    private CallbackManager mcallbackManager;
    private AccessTokenTracker mTokenTracker;
    private ProfileTracker mProfileTracker;
    private ImageButton goBackToMenuBtn;
    private FacebookCallback<LoginResult> mcallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            AccessToken accessToken = loginResult.getAccessToken();
            Profile profile = Profile.getCurrentProfile();
            Intent goToMainMenu = new Intent(getContext(),MainMenu.class);
            //logo.setClickable(true);
            startActivity(goToMainMenu);
        }


        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {

        }
    };
    public MainFragment(){
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        mcallbackManager = CallbackManager.Factory.create();
        AccessTokenTracker tracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            }
        };
//        ProfileTracker profileTracker = new ProfileTracker() {
//            @Override
//            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
//                if (currentProfile != null)
//                    mTextDetail.setText("Welcome " + currentProfile.getFirstName());
//            }
//        };
        //mTokenTracker.startTracking();
        //mProfileTracker.startTracking();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
        RelativeLayout mRelativeLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_main,
                container, false);
//        goBackToMenuBtn = (ImageButton) mRelativeLayout.findViewById(R.id.go_Back_to_MainMenu);
//        goBackToMenuBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("Going back to Main menu...");
//                goBackToMenu();
//            }
//        });
        return mRelativeLayout;
    }


    private void goBackToMenu(){
        startActivity(new Intent("com.fdmkst.ltl_pc.brain.MainMenu"));
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        LoginButton loginButton = (LoginButton) view.findViewById(R.id.login_button);
        //loginButton.setReadPermissions("publish_actions");
        loginButton.setFragment(this);
        loginButton.registerCallback(mcallbackManager,mcallback);
    }

    @Override
    public void onResume() {
        super.onResume();
        Profile profile = Profile.getCurrentProfile();
        if(profile != null){
            Intent goToMainMenu = new Intent(getContext(),MainMenu.class);
            //logo.setClickable(true);
            startActivity(goToMainMenu);
        }
//        if (profile != null)
//            mTextDetail.setText("Welcome " + profile.getFirstName());
    }

    @Override
    public void onStop(){
        super.onStop();
        //mTokenTracker.stopTracking();
        //mProfileTracker.stopTracking();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mcallbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
