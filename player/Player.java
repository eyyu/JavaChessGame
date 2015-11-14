package assignment2.player;

/**
 * @author Eva
 */
/**
 * This class represents a player for a game it has a turn value that is boolean
 * of true or false each player can be asigned a name, otherwise it will be set
 * to null
 *
 * Each player also has a boolean value to win set to true or false. this can be
 * set on or off according to the game and its limitations
 *
 */
public class Player {

    boolean turn = true;
    String name = null;
    boolean winner = false;
    boolean setColor = true;
    /**
     * [THe constructor for palyer class that sets up an unnamed character that
     * has a default turn to true]
     */
    public Player() {
    }

    /**
     * [The constructor for player class with a name assigned to the player sets
     * the default turn to true ]
     * @param s [description]
     */
    public Player(String s) {
        this.setName(s);
    }

    /**
     * [The constructor for the player that will set turn off the turn so the
     * players first turn is turned on or off. THis constructor also takes in a
     * String literal to represent the name of the player]
     * @param s [The string literal to represetnt the name]
     * @param setTurnOff [either 1 or 0;]
     */
    public Player(String s, boolean setTurnOff) {
        this.setName(s);
        if (setTurnOff) {
            this.restrictTurn();
        }
    }

    /**
     * [The constructor for player class that wil not have a name for the player
     * but will set the players turn off as the first turn of the player]
     * @param s [description]
     * @return [description]
     */
    public Player(Boolean setTurnOff) {
        if (setTurnOff) {
            this.restrictTurn();
        }
    }

    /**
     * [The constructor for player class that ]
     * @param s [description]
     * @return [description]
     */
    public void setTurn() {
        this.turn = true;
    }

    public void restrictTurn() {
        this.turn = false;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setWin() {
        this.winner = true;
    }

    public boolean isWinner() {
        return this.winner;
    }
    
    // is this suposed to be in player class? perhaps a i need a chess player class
    public void setSetColor(boolean setCol){
        this.setColor = setCol;
    }
    //same for this method here 
    public boolean getSetColor(){
        return this.setColor;
    }
}

/**
 *
 * I AM JUST TAKING A BREAK FROM MY PROJECT. PLease, please, please don't take
 * this seriously. enjoy the critique of social behaviour through this neat
 * little player class . :)
 *
 *
 */
/**
 * this class is the playa class. you cant hate the playa, you can only hate the
 * game.
 */
class Playa {

    static final Boolean SWAG = true; //cuz i always got SWAG
    Boolean gotGame = false;
    int demBitches;
    int brothas;
    int problems = 99;
    int billlls;

    public Playa(int bitches, int bros) {
        this.demBitches = bitches;
        this.brothas = bros;
    }

    public void usePickUpMove() {
        System.out.println(" Hay Gurrrl, How you Doin'? ;) ");
        if (this.gotGame) {
            demBitches++;
            System.out.println("BAM!");
            billlls -= 1000;
        }
    }

    public void getGame() {
        if (!gotGame && billlls < 1000000) {
            System.out.println("Gott get some bills, brah' ");
        }
        if (!gotGame && billlls >= 1000000) {
            this.gotGame = true;
            System.out.println("NOW YOU GOT SOME GAME BRAH' ");
        }
        if (gotGame && demBitches == 0 && billlls < 1000000) {
            System.out.println("Losing your game brah' ");
            gotGame = false;
        }
    }

    public void gettingRich(int dollaz) {
        billlls += dollaz;
    }

    public static void main(String args[]) {

        Playa me = new Playa(0, 600);
        System.out.println("I got " + me.problems + " but a bitch aint one.");
        me.usePickUpMove();
        System.out.println("Dayum... gotta get myself some game");
        me.getGame();
        me.usePickUpMove();

    }
}
