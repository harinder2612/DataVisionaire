package com.harinder.dvm;



public class queryItemClass {

    String cropName, time, results, activeMonths;

    public queryItemClass(String cropName, String time, String results, String activeMonths) {
        this.cropName = cropName;
        this.time = time;
        this.results = results;
        this.activeMonths = activeMonths;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getActiveMonths() {
        return activeMonths;
    }

    public void setActiveMonths(String activeMonths) {
        this.activeMonths = activeMonths;
    }
}
