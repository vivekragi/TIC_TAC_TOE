package com.nagal.splitwise.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Data
@Component
public class Board {
    private List <List<Character>> location;
    private int size;
    private int moveNumber;
    private User user1,user2;

    public Board () {
        this.size = 3;
        this.location = new ArrayList<List <Character> > (this.size);
        this.moveNumber=1;
        this.user1=new User("vivek",'X');
        this.user2=new User("diskhit",'O');
        for(int i=0;i<this.size;i++) {
            ArrayList<Character> temp= new ArrayList<>(this.size);
            for(int j=0;j<this.size;j++){
                temp.add('-');
            }
            this.location.add(temp);
        }
    }

    public void incMoveNumber() {
        moveNumber++;
    }

}
