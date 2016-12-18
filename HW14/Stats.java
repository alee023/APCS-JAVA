// Alison Lee
// APCS1 pd5
// HW14 -- stAtistically sPeaking
// 2016-10-07

public class Stats {
    
    public static int mean( int a , int b ) {
		return ( a + b ) / 2 ;
    }
    
    public static double mean( double a , double b ) {
        return ( a + b ) / 2 ;
    }

    public static int max( int a , int b ) {
        if ( a >= b ) {
	    return a ;
	}
	else {
	    return b ;
	}
    }

    public static double max( double a , double b ) {
        if ( a >= b ) {
	    return a ;
	}
	else {
	    return b ;
	}
    }

    public static int geoMean( int a , int b ) {
	return (int)Math.sqrt( a * b ) ;
    }

    public static double geoMean( double a , double b ) {
	return Math.sqrt( a * b ) ;
    }

    public static void main( String[] args ) {
	System.out.println( mean( 3 , 6 )) ; // 4
	System.out.println( mean( 3.0 , 6.0 )) ; // 4.5
	System.out.println( max( 3 , 6 )) ; // 6
	System.out.println( max( 3.0 , 6.0 )) ; // 6.0
	System.out.println( geoMean( 3 , 6 )) ; // 4
	System.out.println( geoMean( 3.0 , 6.0 )) ; // ~4.2426
    }
}
