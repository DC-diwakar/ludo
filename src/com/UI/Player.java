package com.UI;

public class Player {
    public OurColor color;
    public Piece[] pieces;

    public Player(OurColor color) {
        color = this.color;
    }

    public int GetLoopStart() {
        System.out.println("Player:GetLoopStart");
        switch (this.color) {
            case RED:
                return 0;
            case GREEN:
                return 7;
            case YELLOW:
                return 14;
            case BLUE:
                return 21;
            default:
                return -1;
        }
    }
//
//    public boolean IsWinner() {
//        for (int i = 0; i < pieces.length; i++) {
//            if (!pieces[i].IsFinish()) {
//                //At least one piece is not in the finish position
//                return false;
//            }
//        }
//        //All pieces are in the Finish
//        return true;
//    }

    public boolean AnyPiecesHome() {
        System.out.println("Player:Any Pieces Home");
        for (int i = 0; i < pieces.length; i++) {
            if (!pieces[i].IsHome()) {
                //At least one piece is in the home position
                return true;
            }
        }
        //No available pieces to move out of home
        return false;
    }
    public void MovePieceToPlayerStart(){
        System.out.println("Player: Move piece to Player start");
        int maxPos = 0;
        int piece = 0;
        //Find max piece in home
        for (int i = 0; i < pieces.length; i++) {
            if(pieces[i].IsHome() && (pieces[i].Location > maxPos)){
                maxPos = pieces[i].Location;
                piece = i;

            }

        }
        //set max piece in home onto board
        pieces[piece].Location = this.GetLoopStart();

    }
}
