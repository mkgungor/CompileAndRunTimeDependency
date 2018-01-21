abstract class Account {
	// ...
	// Many lines for generic bank account needs
	// ...
	
	// Default sorting method for transactions etc.
	public void sort(){
		System.out.println("Insertion Sort");
	}
}

class Saving extends Account{
	// ...
	// Many lines for saving account needs
	// ...
	
	// Saving accounts likes to use Bubble sort for sorting needs.
	@Override
	public void sort(){
		System.out.println("Bubble Sort");
	}
}
class Debit extends Account{
	// ...
	// Many lines for debit account needs
	// ...
	
	//Inherits the base class sorting functions
}

class Dividend extends Account{
	// ...
	// Many lines for dividend account needs
	// ...
	@Override
	public void sort(){
		System.out.println("Bubble Sort");
	}
}

// For demonstration purpose, we have only main method here
public class CompileRunTimeDependency{
	
	public static void main(String[] args) {
		Account accSaving = new Saving(); 
		accSaving.sort(); //Prints: Bubble Sort
		Account accDebit = new Debit();
		accDebit.sort(); //Prints: Insertion Sort
		Account accDividend = new Dividend();
		accDividend.sort(); //Prints: Bubble Sort
		/* CONSOLE OUTPUT:
		 * Bubble Sort
		 * Insertion Sort
		 * Bubble Sort
		 * 
		 * */
	}
}
