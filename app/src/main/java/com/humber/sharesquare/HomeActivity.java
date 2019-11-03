package com.humber.sharesquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    TextView tv_welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv_welcome = (TextView)findViewById(R.id.tv_welcome);
    }

    public void clickLogout(View view) {
        Intent toMainPage = new Intent(HomeActivity.this,MainActivity.class);
        startActivity(toMainPage);
        Toast.makeText(HomeActivity.this,"Go to Sign up Page",Toast.LENGTH_SHORT).show();
    }
}
