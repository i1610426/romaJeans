package com.example.alumno.myapplication.helpers;

import com.example.alumno.myapplication.models.client;

import java.util.Observable;

public class monitorObservable extends Observable {
    client wacheValue;

    public void setWacheValue (client o){
        if (o!=null && o.getYear_old()!=this.wacheValue.getYear_old()) {
            this.wacheValue = o;
            setChanged();
            notifyObservers(o);
        }else {
            setChanged();
            notifyObservers(o);
        }
    }
}