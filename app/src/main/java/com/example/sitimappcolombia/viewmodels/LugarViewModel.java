package com.example.sitimappcolombia.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.example.sitimappcolombia.modelos.Lugares;


public class LugarViewModel extends androidx.lifecycle.ViewModel {

    private MutableLiveData<Lugares> lugar = new MutableLiveData<>();


    public MutableLiveData<Lugares> getLugar() {
        return lugar;
    }


    public void setLugar(Lugares lugar) {
        this.lugar.setValue(lugar);
    }
}
