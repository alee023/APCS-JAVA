// Alison Lee
// APCS1 pd5
// HW45 -- Al<B> Sorted!
// 2016-12-13

import java.util.ArrayList ;

public class ALTester {
	private ArrayList<Integer> arr = new ArrayList<Integer>() ;
	
	public ALTester() {
		for( int i = 0 ; i < 23 ; i ++ ) {
			arr.add( i ) ;
		}
	}
	
	public String toString() { // similar to that of SuperArray
		String retStr = "[ " ;
		for( Object a : arr ) {
			retStr += a + ", " ;
		}
		// [ 0, 1, ... 22, ]
		retStr = retStr.substring( 0 , retStr.length() - 2 ) ;
		// [ 0, 1, ... 22]
		retStr += " ]" ;
		// [ 0, 1, ... 22 ]
		
		return retStr ;
	}
	
	public boolean sorted() {
		for( int i = 0 ; i < arr.size() - 1 ; i ++ ) {
			// if integer at index i is greater than the next integer
			if( arr.get( i ) > arr.get( i + 1 )) { 
				return false ;
			}
		}
		
		return true ; // else true
	}
	
	public static void main( String[] args ) {
		ALTester at = new ALTester() ;
		System.out.println( at ) ; // [ 0, 1, ... 22 ]
		System.out.println( at.sorted() ) ; // true
		
		at.arr.set( 2 , 5 ) ;
		System.out.println( at ) ;
		System.out.println( at.sorted() ) ; // false 
		
		at.arr.set( 3 , 6 ) ;
		System.out.println( at ) ;
		System.out.println( at.sorted() ) ; // false
		
	}
	
}
