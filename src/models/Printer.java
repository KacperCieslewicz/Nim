package models;

import java.util.List;

public class Printer {
    private static final String PLAYER = "Player ";
    private static final String ENTER_NAME = ", enter your name: ";
    private static final String GAME_START = "The game has started!";
    private static final String CHOOSE_PILE = ", choose a pile: ";
    private static final String WRONG_PILE = "No such a pile. Try again: ";
    private static final String HOW_MANY = "How many to remove from pile ";
    private static final String EMPTY_PILL = "That pile is empty. Choose again: ";
    private static final String TOO_MANY = "That pile doesn't have that many. Try again: ";
    private static final String NOT_ENOUGH = "You must choose at least 1. How many? ";
    private static final String WIN = " wins the game!";

    public void printStart(){
        System.out.println(GAME_START);
        newLine();
    }

    public void newLine(){
        System.out.println("");
    }

    public void printPiles(List<Pile> piles){
        for(Pile p : piles){
            System.out.print(p.getName() + ": " + p.getValue() + "     ");
        }
        newLine();
    }

    public void printPileChoose(String name){
        System.out.println(name + CHOOSE_PILE);
    }

    public void printHowMany(char choosedPile){
        System.out.println(HOW_MANY + choosedPile + ":");
        newLine();
    }

    public void printEnterName(int number){
        System.out.println(PLAYER + number + ENTER_NAME);
    }

    public void printWrongPile() {
        System.out.println(WRONG_PILE);
    }

    public void printEmptyPill(){
        System.out.println(EMPTY_PILL);
    }

    public void printTooMany(){
        System.out.println(TOO_MANY);
        newLine();
    }

    public void printNotEnough(){
        System.out.println(NOT_ENOUGH);
        newLine();
    }

    public void printWin(String name){
        System.out.println(name + WIN);
    }

}


