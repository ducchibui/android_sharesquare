package com.humber.sharesquare.Presenter;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupPresenter implements ISignupPresenter {
    FirebaseAuth firebaseAuth;
    public SignupPresenter() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public Task<AuthResult> createUserWithEmailAndPassword(String username, String password) {
        return firebaseAuth.createUserWithEmailAndPassword(username, password);
    }
}
