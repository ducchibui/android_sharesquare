package com.humber.sharesquare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.humber.sharesquare.Presenter.SignupPresenter;

import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {
    String email, password;
    EditText et_email,et_password;
    TextView tv_signIn;
    Button btn_signUp;
    SignupPresenter signupPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_email = (EditText)findViewById(R.id.et_email);
        et_password = (EditText)findViewById(R.id.et_password);
        btn_signUp = (Button) findViewById(R.id.btn_signup);
        tv_signIn = (TextView) findViewById(R.id.tv_signin);
        signupPresenter = new SignupPresenter();
    }

    public void clickSignup(View view) {
        email = et_email.getText().toString();
        password = et_password.getText().toString();
        if(email.isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et_email.setError("Please enter valid Email");
            et_email.requestFocus();
        } else if (password.isEmpty() && password.length() < 6){
            et_password.setError("Please enter password at least 6 characters");
            et_password.requestFocus();
        } else if (!email.isEmpty() && !password.isEmpty()) {
            Task<AuthResult> task = signupPresenter.createUserWithEmailAndPassword(email,password);
            task.addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(MainActivity.this,"Sign up failed",Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MainActivity.this,"Sign up successful",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    }
                }
            });
        }
    }

    public void clickLinkSignin(View view) {
        Intent toLoginPage = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(toLoginPage);
        Toast.makeText(MainActivity.this,"Go to Sign In",Toast.LENGTH_SHORT).show();

    }
}
