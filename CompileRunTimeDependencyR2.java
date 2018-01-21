package R2;
abstract class Account {
	//We added reference to interface
	SortingServices sortService;
	// ...
	// Many lines for generic bank account needs
	// ...
	
	// We can change sorting algorithm at run-time 
	// We do not need to change our code anymore for sorting algorithm
	public void setSortingAlgorithm(SortingServices sort){
		this.sortService = sort;	
	}
	
	// Default sorting method for transactions etc.
	public void sort(){
		// Default sorting still Insertion
		sortService = new InsertionSort();
		sortService.sort();
		//System.out.println("Insertion Sort");
	}
}

class Saving extends Account{
	// ...
	// Many lines for saving account needs
	// ...
	
	// Saving accounts likes to use Bubble sort for sorting needs.
	
	public Saving(){
		//Default sorting for Saving Account
		sortService = new BubbleSort();
	}
		
	@Override
	public void sort(){
		//Just call sort method
		sortService.sort();
		//System.out.println("Bubble Sort");
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
	
	public Dividend(){
		//Default sorting for Saving Account
		sortService = new BubbleSort();
	}
	
	@Override
	public void sort(){
		//Just call sort method
		sortService.sort();
		//System.out.println("Bubble Sort");
	}
}

interface SortingServices{
	void sort();
}

class BubbleSort implements SortingServices{
	public void sort(){
		System.out.println("Bubble Sort");
	}
}
class InsertionSort implements SortingServices{
	public void sort(){
		System.out.println("Insertion Sort");
	}
}


// For demonstration purpose, we have only main method here
public class CompileRunTimeDependencyR2{
	
	public static void main(String[] args) {
		Account accSaving = new Saving(); 
		accSaving.sort(); //Prints: Bubble Sort
		Account accDebit = new Debit();
		accDebit.sort(); //Prints: Insertion Sort
		Account accDividend = new Dividend();
		accDividend.sort(); //Prints: Bubble Sort
		accDividend.setSortingAlgorithm(new InsertionSort());
		accDividend.sort(); //Prints: Insertion Sort // At runtime we can change.
		/* CONSOLE OUTPUT:
		 * Bubble Sort
		 * Insertion Sort
		 * Bubble Sort
		 */
	}
}
