package at.fhooe.mc.android;

import java.io.Serializable;

public class Name implements Serializable {
    String name;

    Name(String name){
        this.name=name;
    }

    public String getUnamie(){
        return name;
    }
}
