public class BigSib {
    private String helloMsg ;
    public BigSib() {
		helloMsg = "Mmk bye " ;
    }
    public BigSib( String Greeting ) {
		helloMsg = Greeting + " " ;
	
    }
    
    public String greet( String name ) { 
		helloMsg += name ;
		return helloMsg ;
    }
}

