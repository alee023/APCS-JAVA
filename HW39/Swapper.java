// Alison Lee
// APCS1 pd5
// HW39 -- Put it together
// 2016-12-03

import cs1.Keyboard ;

public class Swapper {
	
	/* There is a array printing and a swapping method, as well as the main. 
	The swap method stores the string contained in the user specified locations of the array, and replaces both with one another.
	The main method takes in the user input, utilizing Keyboard.java. There are prompts asking for the row and column of the two strings that the user wants to switch. If the input is greater than the number of rows or columns for that row (so that there will not be any errors related to an array being jagged), an error message will be printed and it will prompt the user again (as many times as the user puts in an invalid integer).
	*/
	
	public static void print( String[][] a ) { // from TwoDimArray
		String retStr = "" ; 
		for( String[] i : a ) {
			for( String ii : i ) {
				retStr += ii + " " ;
			}
			retStr += "\n" ;
		}
	
		System.out.println( retStr ) ;
    }
	
	public static void swap( String[][] sArr , int r1 , int c1 , int r2 , int c2 ) {
		String first = sArr[ r1 ][ c1 ] ;
		String second = sArr[ r2 ][ c2 ] ;
		
		sArr[ r1 ][ c1 ] = second ;
		sArr[ r2 ][ c2 ] = first ;
	}
	
	public static void main( String[] args ) {
		
		// local vars
		int firstRow ;
		int firstCol ;
		int secondRow ;
		int secondCol ;
		
		// collecting user input
		String[][] arr = { { "Good", " morning.", " How", " are" } , 
						   { "you", "my " , "dear?" , " I am" } , 
						   { "well,", " ... ", " thank", " you." } 
						 } ;
		
		// stores number of rows
		int rows = arr.length ;
		
		System.out.println( "Your array: \n" ) ;
		print( arr ) ;
		
		// =============================
		System.out.println( "What is the row number of the first value you want swapped?" ) ;
		firstRow = Keyboard.readInt() ;
		
		boolean big = false ;
		
		// tests to see if the input is bigger than the dimensions of the array
		if ( firstRow > rows - 1 ) {
			big = true ;
		}
		
		while ( big ) {
			System.out.println( "The number you gave is too big. Try again with an integer less than " + rows + ": " ) ;
			firstRow = Keyboard.readInt() ;
			
			if ( firstRow < rows ) {
				big = false ;
			}
		}
		// ================================
		System.out.println( "Column number?" ) ;
		firstCol = Keyboard.readInt() ;
		
		if ( firstCol > arr[ firstRow ].length - 1 ) {
			big = true ;
		}
		
		while ( big ) {
			System.out.println( "The number you gave is too big. Try again with an integer less than: " + arr[ firstRow].length + ": " ) ;
			firstCol = Keyboard.readInt() ;
			
			if ( firstCol < arr[ firstRow ].length ) {
				big = false ;
			}
		}
		// ================================
		System.out.println( "Okay! And the row number of the second value is?" ) ;
		secondRow = Keyboard.readInt() ;
		
		if ( secondRow > rows - 1 ) {
			big = true ;
		}
		
		while ( big ) {
			System.out.println( "The number you gave is too big. Try again with an integer less than " + rows + ": " ) ;
			secondRow = Keyboard.readInt() ;
			
			if ( secondRow < rows ) {
				big = false ;
			}
		}
		// ================================
		System.out.println( "Column?" ) ;
		secondCol = Keyboard.readInt() ;
		
		if ( secondCol > arr[ secondRow ].length - 1 ) {
			big = true ;
		}
		
		while ( big ) {
			System.out.println( "The number you gave is too big. Try again with an integer less than: " + arr[ secondRow].length + ": " ) ;
			secondCol = Keyboard.readInt() ;
			
			if ( secondCol < arr[ secondRow ].length ) {
				big = false ;
			}
		}
		// ================================
		System.out.println( "Okay! Swapping... \n" ) ;
		
		swap( arr , firstRow , firstCol , secondRow , secondCol ) ;
		
		System.out.println( "Your new array: \n" ) ;
		print( arr ) ;	

		/* ***EXAMPLE. Swapping arr[ 2 ][ 1 ] and arr[ 0 ][ 3 ] ***
		
		Your array:

		Good  morning.  How  are
		you my  dear?  I am
		well,  ...   thank  you.

		What is the row number of the first value you want swapped?
		6
		The number you gave is too big. Try again with an integer less than 3:
		2	
		Column number?
		1
		Okay! And the row number of the second value is?
		0
		Column?
		4
		The number you gave is too big. Try again with an integer less than: 4:
		3
		Okay! Swapping...

		Your new array:

		Good  morning.  How  ...
		you my  dear?  I am
		well,  are  thank  you.
*/
	}
}
