// Alison Lee
// APCS1 pd5
// HW47 -- Keep Guessing
// 2016-12-18

import cs1.Keyboard ; 

public class GuessNumber {
	
    private int lowerBound = 1 ; 
    private int upperBound = 100 ;    
    private int uI ; // userInput
	private int numTries = 0 ; // number of guesses
	private int target = ( int )( Math.random() * 100 ) + 1 ;

	public boolean check() {
		if( uI == target ) {
			return true ;
		}
		else {
			return false ;
		}
	}
	
	public void playI() {
		uI = Keyboard.readInt() ;
		numTries += 1 ;
		while( !( check()) ) {
			if( uI > target ) {
				if( uI <= upperBound ) {
					upperBound = uI ;
				}
				System.out.println( "Too high. Try again... \nGuess a number from " + lowerBound + " to " + upperBound ) ;
			}
			else { // uI < target 
				if( uI >= lowerBound ) {
					lowerBound = uI ;
				} 
				System.out.println( "Too low. Try again... \nGuess a number from " + lowerBound + " to " + upperBound ) ;
			}
			uI = Keyboard.readInt() ;
			numTries += 1 ;
		}
		
		System.out.println( "Correct! It took " + numTries + " guesses." ) ;
	}
	
    public static void main( String[] args ) {
		GuessNumber game = new GuessNumber() ;
		game.playI() ;
    }
}