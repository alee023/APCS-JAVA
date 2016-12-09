public class ArrTest {
	
	public static String arrToStr( int[][] arr ) {
		String retStr = "" ; 
		for( int i = 0 ; i < arr.length ; i ++ ) {
			for( int ii = 0 ; ii < arr[ 0 ].length ; ii ++ ) {
				retStr += arr[ i ][ ii ] + " " ;
			}
			retStr += "\n" ;
		}
		
		return retStr ;
	}

	public static void populate( int[][] arr ) { 
		for( int i = 0 ; i < arr.length ; i ++ ) {
			for( int ii = 0 ; ii < arr[ 0 ].length ; ii ++ ) {
				arr[ i ][ ii ] = ( int )( Math.random() * 10.0 ) ;
			}
		}
	}
	
	public static void main( String[] args ) {
		int[][] a2 = new int[ 2 ][ 3 ] ;
		
		System.out.println( "INITIAL ARRAY: " ) ;
		System.out.println( arrToStr( a2 )) ;
		/* 0 0 0
		   0 0 0 */		

		System.out.println( "Number of rows: " + a2.length ) ; 
		System.out.println( "Number of columns: " + a2[ 0 ].length + "\n" ) ;
	
		populate( a2 ) ;
		System.out.println( "RANDOMIZED ARRAY:" ) ;
		System.out.println( arrToStr( a2 )) ;		
		
	}
}
