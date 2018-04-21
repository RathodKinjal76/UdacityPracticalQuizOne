package com.example.android.udacitypracticalquizone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText edtUserName, edtEmail, edtAboutUser;
    Button next;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ImageView image;
    private static final String USER_NAME = "username";
    private static final String USER_EMAIL = "useremail";
    private static final String ABOUT = "about";
    private static final String ON_SAVE_INSTANCE_STATE = "onSaveInstanceState";
    String username, useremail, about;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.img);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        next = (Button) findViewById(R.id.btnNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtUserName = (EditText) findViewById(R.id.user_name);
                edtEmail = (EditText) findViewById(R.id.email);
                edtAboutUser = (EditText) findViewById(R.id.about);

                /*if (savedInstanceState != null) {
                    if (savedInstanceState.containsKey(USER_NAME)) {
                        String allPreviousLifecycleCallbacks = savedInstanceState
                                .getString(USER_NAME);
                        edtUserName.setText(allPreviousLifecycleCallbacks);
                    }
                    if (savedInstanceState.containsKey(USER_EMAIL)) {
                        String allPreviousLifecycleCallbacks = savedInstanceState
                                .getString(USER_EMAIL);
                        edtEmail.setText(allPreviousLifecycleCallbacks);
                    }
                    if (savedInstanceState.containsKey(ABOUT)) {
                        String allPreviousLifecycleCallbacks = savedInstanceState
                                .getString(ABOUT);
                        edtAboutUser.setText(allPreviousLifecycleCallbacks);
                    }
                }*/

                editor.putString("USER_NAME", edtUserName.getText().toString());
                editor.putString("USER_EMAIL", edtEmail.getText().toString());
                editor.putString("ABOUT_USER", edtAboutUser.getText().toString());
                editor.commit();

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        username = edtUserName.getText().toString();
        useremail = edtEmail.getText().toString();
        about = edtAboutUser.getText().toString();
        outState.putString(USER_NAME, username);
        outState.putString(USER_EMAIL, useremail);
        outState.putString(ABOUT, about);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);

        String savName = savedInstanceState.getString(USER_NAME);
        String savEmail = savedInstanceState.getString(USER_EMAIL);
        String savAbout = savedInstanceState.getString(ABOUT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_user) {
            Intent intent = new Intent(this, DetailsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
