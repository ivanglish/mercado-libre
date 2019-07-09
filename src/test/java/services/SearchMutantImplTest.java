package services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import junit.framework.Assert;

public class SearchMutantImplTest {
	
	private ISearchMutant searchMutant=new SearchMutantImpl();

	@Test
	public void IsMutant() {
		
		String[] dna = {"ATGCGA","CCGGGC","TTATGT","AGAAGA","CCCCTA","TCACTT"};
		Assert.assertTrue(searchMutant.isMutant(dna));
	}
	
	@Test
	public void IsNotMutant() {
		
		String[] dna = {"AAACAA","CCCTCC","TTTGTT","GGGAGG","CCACTA","TCACTT"};
		Assert.assertFalse(searchMutant.isMutant(dna));
	}
	
	

}
