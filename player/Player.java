package assignment2.player;
/**
 * @author Eva
 */
class Player2{
	boolean turn;
	String name = NULL;
	boolean winner = false;

	public Player(){
	}

	public Player(String s){
		this.setName(s);
	}

	public Player(String s, boolean setTurnOff){
		this.setName(s);
		if(setTurnOff){
			this.restrictTurn();
		}
	}

	public Player(Boolean setTurnOff){
		if(setTurnOff){
			this.restrictTurn();
		}
	}

	public void setTurn(boolean set){
		this.turn = true;
	}

	public void restrictTurn(){
		this.turn = false;
	}

	public void setName(String s){
		this.name  = s;
	}

	public void setWin(){
		this.winner = true;
	}

	public boolean isWinner(){
		return this.winner;
	}

}



/** 
 * 
 * I AM JUST TAKING A BREAK FROM MY PROJECT. 
 * PLease, please, please don't take this seriously. 
 * enjoy the critique of social behaviour through this neat little player class .
 * :)
 * 
 */

public class Player {
	
	static final Boolean SWAG = true; //cuz i always got SWAG
	Boolean gotGame = false; 
	int demBitches;
	int brothas;
	int problems = 99;
	int billlls;

	public Player(int bitches, int bros){
		this.demBitches = bitches;
		this.brothas = bros;
	}

	public void usePickUpMove(){
		System.out.println(" Hay Gurrrl, How you Doin'? ;) ");
		if(this.gotGame){
			demBitches++;
			System.out.println("BAM!");
			billlls -= 1000;
		}
	}

	public void getGame(){
		if(!gotGame && billlls < 1000000){
			System.out.println("Gott get some bills, brah' ");
		}if(!gotGame && billlls >= 1000000){
			this.gotGame = true; 
			System.out.println("NOW YOU GOT SOME GAME BRAH' ");
		}if(gotGame && demBitches == 0 && billlls < 1000000){
			System.out.println("Losing your game brah' ");
			gotGame = false;
		}
	}

	public void gettingRich(int dollaz){
		billlls += dollaz;
	}
}

public static void main(String args[]){
	
	Player me = new Player(0, 600);
	System.out.println("I got " + me.problems + " but a bitch aint one.");
	me.usePickUpMove();
	System.out.println("Dayum... gotta get myself some game");
	me.getGame();
	me.usePickUpMove();

}