public class Rational {
    private int numer ; // numerator
    private int denom ; // denominator

    public Rational() {
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
		return retStr + numer + "/" + denom + "\n" ;
    }

    public double floatValue() {
		return ( double )( numer / denom ) ;
    }

    public void multiply( Rational other ) {
		numer *= other.numer ;
		denom *= other.denom ;
    }

    public void divide( Rational other ) {
		numer /= other.numer ;
		denom /= other.denom ;
    }

    public static void main( String[] args ) {
		// tests constructor
		Rational first = new Rational( 1 , 0 ) ;
		System.out.println( first ) ; // error message
		Rational second = new Rational( 2 , 3 ) ;
		Rational third  = new Rational( 1 , 2 ) ;

		second.multiply( third ) ;
		System.out.println( second ) ; // 2 / 6

		Rational fourth = new Rational( 3 , 4 ) ; 
		fourth.divide( third ) ;
		System.out.println( fourth ) ; // 3 / 2
    }
}
