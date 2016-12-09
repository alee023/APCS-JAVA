// Alison Lee
// APCS1 pd5
// HW40 -- Rational Equality
// 2016-12-06

public class Rational implements Comparable {
    private int numer ; // numerator
    private int denom ; // denominator
    
    public Rational() { // default
		numer = 0 ;
		denom = 1 ;
    }
    
    public Rational( int num , int den ) {
		if ( den == 0 ) {
			System.out.println( "Invalid denominator. Number set to 0/1." ) ;
				numer = 0 ;
				denom = 1 ;
		}	
		else {
			numer = num ;
			denom = den ;
		}
   	}
    
    public String toString() {
		String retStr = "" ;
		// returns in the numer/denom format
		return retStr + numer + "/" + denom + "\n" ;
    }
    
	public double floatValue() {
		return ( double )( numer / denom ) ;
    }
    
	// changes the rationals so that they will have the same denominator which is the LCD of the original both
    public void convLCD( Rational other ) { 
		// changes this rational
		int oldDen = denom ;
		numer *= other.denom ; 
		denom *= other.denom ;
		// changes other rational
		other.numer *= oldDen ;
		other.denom *= oldDen ;
    }
    
    public int gcdER() {
		int num = numer ;
		int den = denom ;
	
		if ( num == 0 ) {
			return den ;
		}
		if ( den == 0 ) {
			return num ;
		}
       	if ( num > den ) {
			return gcdER( num - den , den );
       	} 
		else {
			return gcdER( num, den -  num );
       	}
	}
    
    public static int gcdER( int num , int  den ){
		if ( num == 0 ) {
			return den ;
		}
		if ( den == 0 ) {
			return num ;
		}
		if ( num >  den ) {
			return gcdER( num - den , den );
		} 
		else {
			return gcdER( num , den - num );
		}
    }
    
    public void reduce() {
		int gcd = gcdER() ;
		numer /= gcd ;
		denom /= gcd ;
    }
    
    public void add( Rational other ) {
		// if the denominators of both rationals are the same, then all you have to do is add the numerators and denom stays the same
		if ( denom == other.denom ) {
			numer += other.numer ;
	    }
		// else, utilize convLCD so that the denoms will be the same, and then add the numers
		else {
			convLCD( other ) ;
			numer += other.numer ;
		}
    }
    
    public void subtract( Rational other ) {
		if ( denom == other.denom ) {
			numer -= other.numer ;
		}
		else {
			convLCD( other ) ;
			numer -= other.numer ;
		}
    }
    
    public void multiply( Rational other ) {
		numer *= other.numer ;
		denom *= other.denom ;
    }
    
    public void divide( Rational other ) {
		numer *= other.denom ;
		denom *= other.numer ;
    }
    
    public int compareTo( Object o ) {
		Rational other = ( Rational ) o ;
		return ( numer * other.denom ) - ( other.numer * denom ) ;
    }	
    
    public boolean equals( Object other ) {
		return (( other instanceof Rational ) && ( compareTo( other ) == 0 )) ;
    }
	
    // =====================================================================

    public static void main( String[] args ) {
		// tests constructor
		Rational first = new Rational( 1 , 0 ) ;
		System.out.println( first ) ; // error message
	
		Rational second = new Rational( 2 , 3 ) ;
		Rational third  = new Rational( 1 , 2 ) ;
		Rational fourth = new Rational( 3 , 4 ) ; 
		
		second.multiply( third ) ;
		System.out.println( second ) ; // 2 / 6
	
		fourth.divide( third ) ;
		System.out.println( fourth ) ; // 3 / 2
	
	
		fourth.add( third ) ; // 3/2 + 1/2 
		System.out.println( fourth ) ; // 4/2
	
		third.add( second ) ; // 1/2 + 2/6
		System.out.println( third ) ; // 10/12
	
		third.reduce() ;
		System.out.println( third ) ; // 5/6
		fourth.reduce() ;
		System.out.println( fourth ) ; // 2/1
	
		fourth.subtract( third ) ;
		System.out.println( fourth ) ; // 7/6
	
		System.out.println( gcdER( 3 , 6 )) ; // 3
	
		System.out.println( fourth.compareTo( third )) ; // 12
		System.out.println( fourth.equals( third )) ; // false
		third = new Rational( 7 , 6 ) ;
		System.out.println( fourth.equals( third )) ; // true
		
    }	
}
