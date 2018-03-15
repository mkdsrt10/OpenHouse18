package com.openhouse.mayankdubey.openhouse;

/**
 * Created by mayankdubey on 11/03/18.
 */

public class projectContaint {
    String name, about_project;

    public projectContaint(String name, String about_project){
        this.name = name;
        this.about_project = about_project;
    }

    public String getName(){
        return name;
    }

    public String getAbout_project(){
        return about_project;
    }
}
