// Alison Lee (of Team Take2)
// APCS1 pd5
// HW10 -- CMYM
// 2016-09-27

public class BankAccount {
    // instance vars
    private String accName ;
    private String pw ;
    private int pin ;
    private int accNum ;
    private Float balance ;

    public void setInfo( String name , String PW , int Pin , int accNo , float money ) {
	    accName = name ;
	    pw = PW ;
	    pin = Pin ;
	    accNum = accNo ;
	    balance = money ;
    }
    public void accInfo( ) {
	    System.out.println( "Account Holder: " + accName ) ;
	    System.out.println( "Password: " + pw ) ;
	    System.out.println( "Pin: " + pin ) ;
	    System.out.println( "Account Number: " + accNum ) ;
	    System.out.println( "Balance: $" + balance ) ;
    }

    public void withdraw( int withAmt ) {
	    balance -= withAmt ;
    }
    public void deposit( int withDep ) {
	    balance += withDep ;
    }

    public static void main( String[] args ) {
	    BankAccount cust = new BankAccount( ) ;
	    cust.setInfo( "John Doe" , "password123" , 123 , 1234 , 100 ) ;
	    System.out.println( "Account Info: " ) ;
	    cust.accInfo( ) ;

	    // Added test cases using withdraw and deposit as suggested by peers
	    cust.withdraw( 50 ) ;
	    System.out.println( "New account info:" ) ;
	    cust.accInfo( ) ;
	
	    cust.deposit( 50 ) ;
	    System.out.println( "New account info:" ) ;
	    cust.accInfo( ) ;
    }
    
} 
