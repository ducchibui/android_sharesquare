package com.humber.sharesquare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.humber.sharesquare.Presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity {
    String email, password;
    EditText et_email, et_password;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        loginPresenter = new LoginPresenter();
    }
    public void clickSignin(View view) {
        email = et_email.getText().toString();
        password = et_password.getText().toString();

        if (email.isEmpty()) {
            et_email.setError("Please enter Email");
            et_email.requestFocus();
        } else if (password.isEmpty()) {
            et_password.setError("Please enter Password");
            et_password.requestFocus();
        } else if (!email.isEmpty() && !password.isEmpty()) {
            Task<AuthResult> task = loginPresenter.signInWithEmailAndPassword(email, password);
            task.addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        task.toString();
                        Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent toHomePage = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(toHomePage);
                        Toast.makeText(LoginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void clickLinkSignup(View view) {
        Intent toSignupPage = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(toSignupPage);
    }
}
