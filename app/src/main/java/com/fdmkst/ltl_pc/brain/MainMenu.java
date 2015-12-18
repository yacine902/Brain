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
    Button startbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        startbtn = (Button) findViewById(R.id.start_button);
        startbtn.setOnClickListener(this);
        Intent intent = getIntent();
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment()).commit();
//        }
    }
    public void logOutButton(View view){
        Button logoutButton = (Button) view.findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
            }
        });
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
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_button:
                startGame();
                break;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() { }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.main_menu,
                    container, false);
            return rootView;
        }


        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

        }
    }
    @Override
    public void onBackPressed() {
    }
}
