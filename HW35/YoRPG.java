/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster, Mage, Rogue
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG
{
    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a [ character ] and a Monster will be instantiated...
    private Character pat;   //Is it man or woman?
    private Character smaug; //Friendly generic monster name?

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG() {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- gathers info to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a [ character ]
      =============================================*/
    public void newGame() {
	String s;
	String name = "";
	s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}	
	catch ( IOException e ) { }

	s = "Intrepid warrior, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	//instantiate the player's character
	System.out.print("Are you a Warrior, Mage, Rogue, Elf or Dwarf? ");
	String charac = "";
	try {
	    charac = in.readLine();
	}
	catch (IOException e) {}
	if (charac.equals("Warrior")) {
	    pat = new Warrior(name);
	}
	else if (charac.equals("Mage")) {
	    pat = new Mage(name);
	}
	else if (charac.equals("Rogue")) {
	    pat = new Rogue(name);
	}
	else if (charac.equals("Elf")) {
	    pat = new Elf(name);
	}
	else if (charac.equals("Dwarf")) {
	    pat = new Dwarf(name);
	}
	System.out.println(pat.about());

    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  [ character ] pat has been initialized
      post: Returns true if player wins (monster dies).
      Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn() {
	int i = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
	else {
	    //Give possibility of encountering SuperMonster or Demon
	    double randNum = Math.random();
	    if (randNum >= (2 /difficulty)) {
		smaug = new SuperMonster();}
	    else if (randNum >= (1.5 / difficulty)) {
		smaug = new Demon();}
	    else {
		smaug = new Monster();}

	    String description;
	    if (smaug.HP == 250) {
		description  = " Super Monster ";}
	    else if (smaug.HP == 200) {
		description = " Demon ";
	    }
	    else {
		description = " Monster ";}

	    System.out.println( "\nLo, yonder" + description + "approacheth!" );

	    while( smaug.isAlive() && pat.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "\nDo you feel lucky?" );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    System.out.print( "Selection: " );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		if ( i == 2 )
		    pat.specialize();
		else
		    pat.normalize();

		d1 = pat.attack( smaug );
		d2 = smaug.attack( pat );

		System.out.println( "\n" + pat.getName() + " dealt " + d1 +
				    " points of damage.");

		System.out.println( "\n" + "Ye Olde" + description + "smacked " + pat.getName() +
				    " for " + d2 + " points of damage.");
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde" + description +  "down, but " +
				    "with its dying breath ye old " + description + 
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "HuzzaaH! Ye olde" + description + "hath been slain!" );
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args ) {

	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Thy game doth be over." );
    }//end main

}//end class YoRPG


