package com.eryushion.mvvmdemo.viewmodel;

import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.eryushion.mvvmdemo.BR;
import com.eryushion.mvvmdemo.model.User;

public class LoginViewModel extends BaseObservable {

    private User user;

    public LoginViewModel() {
        user = new User("", "");
    }

    @Bindable
    private String toastMessage = null;

    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }
    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public void OnLoginonClick() {
       if (isInputValid()){
           String successMessage = "Login was successful";
           setToastMessage(successMessage);
       }else {
           String errorMessage = "Email or Password not valid";
           setToastMessage(errorMessage);
       }
    }

    private boolean isInputValid() {
        return !TextUtils.isEmpty(user.getEmail()) && !TextUtils.isEmpty(user.getPassword());
    }
}
