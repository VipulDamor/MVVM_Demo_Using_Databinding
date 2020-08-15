package com.eryushion.mvvmdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.eryushion.mvvmdemo.R;
import com.eryushion.mvvmdemo.databinding.ActivityMainBinding;
import com.eryushion.mvvmdemo.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setViewmodel(new LoginViewModel());
        activityMainBinding.executePendingBindings();
    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view , String message){
        if (message!=null){
            Toast.makeText(view.getContext(), message+"", Toast.LENGTH_SHORT).show();
        }
    }
}