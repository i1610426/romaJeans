package com.example.alumno.myapplication.helpers;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

import javax.security.auth.callback.Callback;

public class obServerBind implements Observer {
    private Callback callback;

    public void update(Observable o, Object arg){

        Log.v(lag, "update: <<<<");
        if (this.callback!=null){
            this.callback.doThis(o,arg);
        }
    }

    public void setCallback(Callback callback) {
        if (callback==null){
            return;
        }
        this.callback = callback;
    }

    public obServerBind(Callback callback) {
        this.callback = callback;

    }
}