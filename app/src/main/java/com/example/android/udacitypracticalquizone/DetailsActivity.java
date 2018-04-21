package com.example.android.udacitypracticalquizone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {
    TextView tvUserName, tvUserEmail, tvAboutUser;
    Toolbar toolbar;
    String UserName, UserEmail, AboutUser;
    ImageView imageDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Setting toolbar as the ActionBar with setSupportActionBar() call
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        imageDisplay = (ImageView) findViewById(R.id.imgDisplay);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        tvUserName = (TextView) findViewById(R.id.user_name_Display);
        tvUserEmail = (TextView) findViewById(R.id.email_display);
        tvAboutUser = (TextView) findViewById(R.id.about_user_display);

        UserName = sharedPreferences.getString("USER_NAME", null);
        UserEmail = sharedPreferences.getString("USER_EMAIL", null);
        AboutUser = sharedPreferences.getString("ABOUT_USER", null);

        tvUserName.setText(UserName);
        tvUserEmail.setText(UserEmail);
        tvAboutUser.setText(AboutUser);
    }
}
