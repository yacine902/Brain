package com.fdmkst.ltl_pc.brain;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.facebook.login.LoginManager;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    private static Button startbtn;
    private static Button logOut;
    private static Button getHelpBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        startbtn = (Button) findViewById(R.id.start_button);
        startbtn.setOnClickListener(this);
        logOut = (Button)findViewById(R.id.logout_button);
        logOut.setOnClickListener(this);
        getHelpBtn = (Button) findViewById(R.id.how_to_play_button);
        getHelpBtn.setOnClickListener(this);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment()).commit();
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle app bar item clicks here. The app bar
        // automatically handles clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            //com.fdmkst.ltl_pc.firstapp.R.id.action_settings
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startGame(){
        startActivity(new Intent("com.fdmkst.ltl_pc.brain.Game"));
    }
    private void getHelp(){
        startActivity(new Intent("com.fdmkst.ltl_pc.brain.HowToPlayBtn"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_button:
                System.out.println("starting game...");
                startGame();
                break;
            case R.id.logout_button:
                System.out.println("Logged out...");
                LoginManager.getInstance().logOut();
                finish();
            case R.id.how_to_play_button:
                System.out.println("Getting help...");
                getHelp();
                break;
        }
    }

//    public static class PlaceholderFragment extends Fragment {
//
//        public PlaceholderFragment() { }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.main_menu,
//                    container, false);
//            return rootView;
//        }
//
//
//        @Override
//        public void onViewCreated(View view, Bundle savedInstanceState) {
//            super.onViewCreated(view, savedInstanceState);
//
//        }
//    }
//    @Override
//    public void onBackPressed() {
//    }
}
