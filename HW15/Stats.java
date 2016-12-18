// Alison Lee
// APCS1 pd5
// HW15 -- May ah Hahv S'maur, Please?
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

    public static int max( int a , int b , int c ) {
	if ( a >= b  &&  a >= c ) {
	    return a ;
	}
	else if ( b >= c  &&  b > a ) {
	    return b ;
	}
	else {
	    return c ;
	}
    }

    public static double max( double a , double b , double c ) {
	if ( a >= b  &&  a >= c ) {
	    return a ;
	}
	else if ( b >= c  &&  b > a ) {
	    return b ;
	}
	else {
	    return c ;
	}
    }
    
    public static int geoMean( int a , int b ) {
	return (int)Math.sqrt( a * b ) ;
    }

    public static double geoMean( double a , double b ) {
	return Math.sqrt( a * b ) ;
    }

    public static int geoMean( int a , int b , int c ) {
	return (int)Math.pow(( a * b * c ) , ( 1.0 / 3 )) ;
    }

    public static double geoMean( double a , double b , double c ) {
	return Math.pow(( a * b * c ) , ( 1.0 / 3 )) ;
    }
}
