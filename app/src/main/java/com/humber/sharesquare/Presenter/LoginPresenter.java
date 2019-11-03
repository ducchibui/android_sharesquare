package com.humber.sharesquare.Presenter;

import android.content.Intent;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginPresenter implements ILoginPresenter {
    FirebaseAuth firebaseAuth;

    public LoginPresenter() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public Task<AuthResult> signInWithEmailAndPassword(String email, String password) {
        return firebaseAuth.signInWithEmailAndPassword(email,password);
    }
}
