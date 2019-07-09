package concurrent;

import java.util.concurrent.Callable;

public class HorizontalSearch implements Callable<Boolean> {
	
	private String[] dna;
	
	public HorizontalSearch(String[] dna) {
		super();
		this.dna = dna;
	}

	@Override
	public Boolean call() throws Exception {
		
		int ocurrences;
		char letter; 
		for (int i = 0; i < dna.length; i++) {
			ocurrences=1;
			letter=' '; 
			for (int j = 0; j < dna[i].length(); j++) {
				if (letter==dna[i].charAt(j)) {
					ocurrences++;
				}else {
					ocurrences=1;		
				}
				if (ocurrences==4) return true;
				letter = dna[i].charAt(j);
			}
		}
		return false;
	}
}
