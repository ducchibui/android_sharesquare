package com.humber.sharesquare.Presenter;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public interface ILoginPresenter {
    Task<AuthResult> signInWithEmailAndPassword(String username,String password);
}
