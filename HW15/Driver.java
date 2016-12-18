public class Driver {
    
    public static void main( String[] args ) {
	System.out.println( Stats.mean( 3 , 6 )) ; // 4
	System.out.println( Stats.mean( 3.0 , 6.0 )) ; // 4.5
	
	System.out.println( Stats.max( 3 , 6 )) ; // 6
	System.out.println( Stats.max( 3.0 , 6.0 )) ; // 6.0
	System.out.println( Stats.max( 3 , 6 , 9 )) ; // 9
	System.out.println( Stats.max( 3.0 , 6.0 , 9.0 )) ; // 9.0

	System.out.println( Stats.geoMean( 3 , 6 )) ; // 4
	System.out.println( Stats.geoMean( 3.0 , 6.0 )) ; // ~4.2426
	System.out.println( Stats.geoMean( 3 , 6  , 9 )) ; // ~5
	System.out.println( Stats.geoMean( 3.0 , 6.0 , 9.0 )) ; // ~5.4513
    }
}
