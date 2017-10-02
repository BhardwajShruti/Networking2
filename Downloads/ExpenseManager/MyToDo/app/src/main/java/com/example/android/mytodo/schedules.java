package com.example.android.mytodo;

import java.io.Serializable;

/**
 * Created by shruti on 09-09-2017.
 */

public class schedules implements Serializable {
    private String title;
    private String description;
    private long toDoID;
 public  schedules( String title,String description,long id){
     this.title = title;
     this.description = description;
     this.toDoID=id;
 }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public long getToDoID(){
        return toDoID;
    }

    public void setToDoID(long toDoID) {
        this.toDoID = toDoID;
    }
}
