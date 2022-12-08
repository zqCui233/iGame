package com.coolteam.igame.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {
    private SimpleStringProperty name = new SimpleStringProperty("initialName");
    private IntegerProperty points = new SimpleIntegerProperty(0);
    public User(){


    }
    public User(String name, int points){
        this.name = new SimpleStringProperty(name);
        this.points = new SimpleIntegerProperty(points);
    }
    public SimpleStringProperty getName()
    {
        return name;
    }
    public void setName(String n)
    {
        name = new SimpleStringProperty(n);
    }
    public IntegerProperty getPoints()
    {
        return points;
    }
    public void setPoints(int p)
    {
        points = new SimpleIntegerProperty(p);
    }

}
