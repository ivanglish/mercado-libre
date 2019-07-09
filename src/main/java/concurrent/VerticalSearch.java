package concurrent;

import java.util.concurrent.Callable;

public class VerticalSearch implements Callable<Boolean> {
	
	private String[] dna;
	
	public VerticalSearch(String[] dna) {
		super();
		this.dna = dna;
	}

	@Override
	public Boolean call() throws Exception {
		
		int ocurrences;
		char letter; 
		ocurrences=1;
		letter=' ';
		for (int i = 0; i < dna[0].length(); i++) {
			for (int j = 0; j < dna.length; j++) {
				if (letter==dna[j].charAt(i)) {
					ocurrences++;
				}else {
					ocurrences=1;		
				}
				if (ocurrences==4) return true;
				letter = dna[j].charAt(i);
			}
		}
		return false;
	}
}
