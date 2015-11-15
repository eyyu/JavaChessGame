
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
