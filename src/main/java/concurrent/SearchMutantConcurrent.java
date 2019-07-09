package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SearchMutantConcurrent {
	
	public static void main(String[] args) {
		
		String[] dna = {"ATGCGA","CCGGGC","TTATGT","AGAAGA","CCCCTA","TCACTT"};
		
		ExecutorService executor  = Executors.newSingleThreadExecutor();
		
		VerticalSearch vs = new VerticalSearch(dna);
		HorizontalSearch hs = new HorizontalSearch(dna);
		DaigonalSearch ds = new DaigonalSearch(dna);
	    Future<Boolean> futureV = executor.submit(vs);
	    Future<Boolean> futureH = executor.submit(hs);
	    Future<Boolean> futureD = executor.submit(ds);
	    try {
			System.out.println("1 "+futureV.get());
			System.out.println("2 "+futureH.get());
			System.out.println("3 "+futureD.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

    
}
