package mechanics;

import models.Pile;
import models.Player;
import models.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private boolean win;
    private Scanner scanner = new Scanner(System.in);
    private Printer printer = new Printer();
    private Player player1, player2;
    private List<Pile> piles = new ArrayList<Pile>();

    public void start(){
        initializePiles();
        initializePlayers();
        printer.printStart();
        printer.printPiles(piles);

        while(!win){
            if(!player1.getWaiting()){
                playTurn(player1);
                nextTurn();
                if(win){
                    printer.printWin(player1.getName());
                    break;
                }
            }
            else{
                playTurn(player2);
                nextTurn();
                if(win){
                    printer.printWin(player2.getName());
                    break;
                }
            }
        }
        scanner.close();
    }

    private void initializePiles() {
        this.piles.add(new Pile('A',3));
        this.piles.add(new Pile('B',4));
        this.piles.add(new Pile('C',5));
    }

    private void initializePlayers() {
        printer.printEnterName(1);
        this.player1 = new Player(scanner.next(), false);

        printer.printEnterName(2);
        this.player2 = new Player(scanner.next(), true);
    }

    private void playTurn(Player player){
        char name;
        int value;

        printer.printPileChoose(player.getName());
        name = scanner.next().charAt(0);
        printer.printHowMany(name);
        value = scanner.nextInt();

        checkAndWork(name, value);
        win = checkWin();
    }

    private void checkAndWork(char name, int value){
        int index;
        index = findIndex(name);
        int currentValue = piles.get(index).getValue();

        while (name != 'A' && name != 'B' && name != 'C'){
            printer.printWrongPile();
            name = retypeName();
        }
        while(piles.get(index).getValue() == 0){
            printer.printEmptyPill();
            name = retypeName();
            index = findIndex(name);
        }
        while (value<1){
            printer.printNotEnough();
            value = retypeValue();
        }
        while(value > piles.get(index).getValue()){
            printer.printTooMany();
            value = retypeValue();
        }

        int newValue = currentValue - value;
        piles.get(index).setValue(newValue);
    }

    private char retypeName(){
        return scanner.next().charAt(0);
    }

    private int retypeValue(){
        return scanner.nextInt();
    }

    private void nextTurn(){
        if(player1.getWaiting()){
            player1.setWaiting(false);
            player2.setWaiting(true);
        }
        else{
            player1.setWaiting(true);
            player2.setWaiting(false);
        }
    }

    private int findIndex(char name) {
        for (int i = 0; i < 3; i++) {
            if (this.piles.get(i).getName() == name) {
                return i;
            }
        }
        return 0;
    }

    private boolean checkWin(){
        int sum=0;
        for(Pile p : piles){
            sum += p.getValue();
        }
        if(sum == 1){
            return true;
        }
        return false;
    }
}