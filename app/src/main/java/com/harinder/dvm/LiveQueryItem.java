package com.harinder.dvm;


public class LiveQueryItem {

    String crop;
    int id;

    public LiveQueryItem(String crop, int id) {
        this.crop = crop;
        this.id = id;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
