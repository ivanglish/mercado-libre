package concurrent;

import java.util.concurrent.Callable;

public class DaigonalSearch implements Callable<Boolean> {
	
	private String[] dna;
	
	public DaigonalSearch(String[] dna) {
		super();
		this.dna = dna;
	}
	
	@Override
	public Boolean call() throws Exception {
		
		int ocurrences;
		char letter; 
		ocurrences=1;
		letter=' ';
	    int pointerY = dna.length-4;
	    int pointerX = 0;
	    int loop=0;
	    int limit=dna.length-1;
	    boolean switchLimit=false;
	    do {	
	    	if (letter==dna[pointerY+loop].charAt(pointerX+loop)) {
				ocurrences++;
			}else {
				ocurrences=1;		
			}
			if (ocurrences==4) return true;
			letter = dna[pointerY+loop].charAt(pointerX+loop);
			
			if (!switchLimit) {
				if (pointerY+loop==limit) {
					pointerY--;
					pointerX=0;
					loop=0;
					if (pointerY==-1) {
						pointerY=0;
						pointerX=1;
						limit=dna[0].length()-1;
						switchLimit=true;
					}
					ocurrences=1;
					letter=' ';
				}else {
				loop++;
				}
			}else{
				if (pointerX+loop==limit) {
					if (pointerX==dna[0].length()-4) return false;
					pointerY=0;
					pointerX++;
					loop=0;
					ocurrences=1;
					letter=' ';
				}else {
				loop++;
				}
			}
		} while (true);
	}
}
