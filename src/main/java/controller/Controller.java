package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.DNA;
import services.ISearchMutant;

@RestController
public class Controller {
	
   @Autowired
   private ISearchMutant searchMutant;
   
   @RequestMapping(value = "/mutant", method = RequestMethod.POST)
   public ResponseEntity<Object> searchMutant(@RequestBody DNA dna) {
      if (searchMutant.isMutant(dna.getDna())) {
    	  return new ResponseEntity<>("Is Mutant", HttpStatus.OK);
      }else {
    	  return new ResponseEntity<>("Is not Mutant", HttpStatus.FORBIDDEN);
      }
   }
}

