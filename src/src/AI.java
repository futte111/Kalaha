package src;

import java.util.ArrayList;

public class AI implements Player{

    public AI(Gamestate gameState){}

    public int makeMove(Gamestate gameState, boolean playerTurn){

        MoveGeneration mover = new MoveGeneration(gameState, playerTurn);
        ArrayList<Gamestate> initialGameStates = mover.generateGameStates();
        int[] abValues = new int[initialGameStates.size()];
        for(int i = 0; i < initialGameStates.size(); i++){
            System.out.println("game " + i);
            AlphaBeta ab = new AlphaBeta(initialGameStates.get(i).player, 21);
            abValues[i] = ab.runAlphaBeta(Integer.MIN_VALUE,Integer.MAX_VALUE , initialGameStates.get(i), 0);
            System.out.println("index: " + i + " value: " + abValues[i]);
        }
        int min = 0;
        int index = 0;
        for(int i = 0; i < abValues.length; i++){
            if(abValues[i] < min){
                min = abValues[i];
                index = i;
            }
        }
        System.out.println("best choice was: " + index);

        return min;
    }
}
