package com.example.trackerczasu;

public class TActivity {
    private int id;

    public boolean isCurrent;
    public String type;
    public String tag;
    public String comment;
    public long startTime;
    public long endTime;

    TActivity(String type) {
        this.type = type;
        startTime = System.currentTimeMillis()/1000;
        isCurrent = true;
    }

    TActivity(String type, long startTime, long endTime) {
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        isCurrent = false;
    }

    public long getDuration() {
        return isCurrent ? System.currentTimeMillis()/1000 - startTime : endTime - startTime;
    }

    public boolean editType(ActivityTypeList List, String name){
        if(List.findType(name)) {
            type = name;
            return true;
        }
        else
            return false;
    }

    public void editTag(String name){
        tag = name;
    }

    public void editComment(String name){
        comment = name;
    }

    public void editTime(long start, long end){
        startTime = start;
        endTime= end;
    }
}
