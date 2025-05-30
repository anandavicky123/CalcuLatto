package com.softgasm.calculatto.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class basic_viewmodel extends ViewModel {

    private MutableLiveData<String> parser = new MutableLiveData<>();
    private MutableLiveData<String> operator = new MutableLiveData<>();
    private MutableLiveData<String> getpercent = new MutableLiveData<>();
    private MutableLiveData<String> thepercent = new MutableLiveData<>();
    private MutableLiveData<String> result = new MutableLiveData<>();
    private MutableLiveData<Integer> numlength = new MutableLiveData<>();
    private MutableLiveData<Integer> angle_basic = new MutableLiveData<>();
    private MutableLiveData<Double> acent = new MutableLiveData<>();
    private MutableLiveData<Double> ccent = new MutableLiveData<>();
    private MutableLiveData<Boolean> takepercent = new MutableLiveData<>();

    public LiveData<String> getResult() {
        if (result == null) {
            result = new MutableLiveData<>();
            putresult("");
        }
        return result;
    }


    public LiveData<String> getParser() {
        if (parser == null) {
            parser = new MutableLiveData<>();
            setParser("");
        }
        return parser;
    }

    public LiveData<String> getOperator() {
        if (operator == null) {
            operator = new MutableLiveData<>();
            setOperator("nothing");
        }
        return operator;
    }

    public LiveData<String> getPercent() {
        if (getpercent == null) {
            getpercent = new MutableLiveData<>();
            setPercent("");
        }
        return getpercent;
    }

    public LiveData<String> getThePercent() {
        if (thepercent == null) {
            thepercent = new MutableLiveData<>();
            setthepercent("");
        }
        return thepercent;
    }

    public LiveData<Integer> getnumlength() {
        if (numlength == null) {
            numlength = new MutableLiveData<>();
            setnumlength(0);
        }
        return numlength;
    }

    public LiveData<Integer> getangle_basic() {
        if (angle_basic == null) {
            angle_basic = new MutableLiveData<>();
            setangle_basic(0);
        }
        return angle_basic;
    }

    public LiveData<Double> getacent() {
        if (acent == null) {
            acent = new MutableLiveData<>();
            setacent(0.0);
        }
        return acent;
    }

    public LiveData<Double> getccent() {
        if (ccent == null) {
            ccent = new MutableLiveData<>();
            setccent(0.0);
        }
        return ccent;
    }

    public LiveData<Boolean> gettakepercent() {
        if (takepercent == null) {
            takepercent = new MutableLiveData<>();
            setTakepercent(false);
        }
        return takepercent;
    }

    // Simulate data loading for each value
    public  void setParser(String value) {
        parser.setValue(value);
    }

    public  void setOperator(String value) {
        operator.setValue(value);
    }

    public  void setPercent(String value) {
        getpercent.setValue(value);
    }

    public  void setthepercent(String value) {
        thepercent.setValue(value);
    }

    public  void setnumlength(int value) {
        numlength.setValue(value);
    }

    public  void setangle_basic(int value) {
        angle_basic.setValue(value);
    }

    public  void setacent(Double value) {
        acent.setValue(value);
    }

    public  void setccent(Double value) {
        ccent.setValue(value);
    }

    public  void setTakepercent(Boolean value) {
        takepercent.setValue(value);
    }

    public  void putresult(String value) {
        result.setValue(value);
    }
}