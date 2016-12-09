public class ArrTestH {
	
	// from ArrayUtils
	public static String arrToStr( int[] arr ) { 
		String retStr = "" ;
		for ( int i : arr ) {
			retStr += i + " " ;
		}
	
		return retStr ;
    	}	
	
	public static void populate( int[] arr ) {
	// ints will range from 0 (inclusive) - 10 (exclusive)
		for ( int i = 0 ; i < arr.length ; i += 1 ) {
			arr[ i ] = ( int )( Math.random() * 10.0 ) ; 
		}
    	}
	
	public static void main( String[] args ) {
		int[][] a2 = new int[ 2 ][ 3 ] ;
		for( int[] arr : a2 ) {
			// arrToStr takes in each row of a2 as the input
			System.out.println( arrToStr( arr )) ;		
		} 
		/* 0 0 0
		   0 0 0 */		

		System.out.println( a2.length ) ; // num rows: 2
		System.out.println( a2[ 0 ].length ) ; // num columns: 3
	
		for( int[] arr : a2 ) {
			populate( arr ) ;
		}

		for( int[] arr : a2 ) {
			// arrToStr takes in each row of a2 as the input
			System.out.println( arrToStr( arr )) ;		
		}
		
	}
}
