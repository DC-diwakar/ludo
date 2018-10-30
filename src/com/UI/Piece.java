package com.UI;

public class Piece {
    public int Location;

    public boolean IsHome() {
        System.out.println("Piece: Is Home");
        if (this.Location < 44 && this.Location > 27)
            return true;
        else
            return false;
    }

    public boolean IsFinish() {
       System.out.println("Piece:IsFinish");
        if (this.Location > 43)
            return true;
        else
            return false;
    }

}
