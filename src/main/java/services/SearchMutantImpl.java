package services;

import org.springframework.stereotype.Service;

@Service
public class SearchMutantImpl implements ISearchMutant{
	
	public boolean isMutant(String[] dna) {
		
		if(checkOccurHorizon(dna)) return true;
		if(checkOccurVert(dna)) return true;
		if(checkOccurDiag(dna)) return true;
		return false;
		
	}
	
	private boolean checkOccurHorizon(String[] dna) {
		
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
	
	private boolean checkOccurVert(String[] dna) {
		
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
	
	private boolean checkOccurDiag(String[] dna) {
		
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
