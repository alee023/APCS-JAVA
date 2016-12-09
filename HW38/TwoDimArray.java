// Alison Lee
// APCS1 pd5
// HW38 -- Arrays of Arrays
// 2016-12-01

// skeleton file for 
// class TwoDimArray
// ...practice working with 2D arrays

public class TwoDimArray {

    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a ) {
		String retStr = "" ; 
		for( int i = 0 ; i < a.length ; i ++ ) {
			for( int ii = 0 ; ii < a[ i ].length ; ii ++ ) {
				retStr += a[ i ][ ii ] + " " ;
			}
			retStr += "\n" ;
		}
	
		System.out.println( retStr ) ;
    }
    
    
    
    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a ) { 
		String retStr = "" ; 
		for( int[] i : a ) {
			for( int ii : i ) {
				retStr += ii + " " ;
			}
			retStr += "\n" ;
		}
	
		System.out.println( retStr ) ;
    }
    

	
    //postcond: returns sum of all items in 2D integer array a
    public static int sum1( int[][] a ) {
		int Sum = 0 ;
		for( int[] i : a ) {
			for( int ii : i ) {
				Sum += ii ;
			}
		}
	
		return Sum ;
    }
    
    
    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m ) { 
		int Sum = 0 ;
		for ( int row = 0 ; row < m.length ; row ++ ) {
			Sum += sumRow( row , m ) ;
		}
	
		return Sum ;
    }
    
    
    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOR loop
    public static int sumRow( int r , int[][] a ) {
		int Sum = 0 ;
		for ( int i = 0 ; i < a[ r ].length ; i ++ ) {
			Sum += a[ r ][ i ] ;
		}
	
		return Sum ;
    }
    
    
    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOREACH loop
    public static int sumRow2( int r, int[][] m ) { 
		int Sum = 0 ;
		for ( int i : m[ r ] ) {
			Sum += i ;
		}
	
		return Sum ;
    }
    
    
    //postcond: returns sum of all items in column c of 2D integer array 
    public static int sumCol( int c, int[][] m ) { 
		int Sum = 0 ;
		for ( int[] i : m ) {
			Sum+= i[ c ] ;
		}
	
		return Sum ;
    }
    
    
    public static void main( String [] args ) {
		int [][] m1 = new int[4][2];
		int [][] m2 = { {2,4,6}, {3,5,7} };
		int [][] m3 = { {2}, {4,6}, {1,3,5} };
		print1(m1);
		print1(m2);
		print1(m3);
		print2(m1);
		print2(m2);
		print2(m3);
		System.out.print("testing sum1...\n");
		System.out.println("sum m1 : " + sum1(m1)); // 0
		System.out.println("sum m2 : " + sum1(m2)); // 27
		System.out.println("sum m3 : " + sum1(m3)); // 21
		System.out.print("testing sum2...\n");
		System.out.println("sum m1 : " + sum2(m1));
		System.out.println("sum m2 : " + sum2(m2));
		System.out.println("sum m3 : " + sum2(m3));

    }

}//end class TwoDimArray
