package com.humber.sharesquare.Presenter;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public interface ISignupPresenter {
        Task<AuthResult> createUserWithEmailAndPassword(String username, String password);
}
