package pt.ua.tqs.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.ua.tqs.services.ConvertService;

@RestController
public class ConvertResource {
	
	@Autowired
	private ConvertService service;
	
	@RequestMapping(value="/api/conversions", method=RequestMethod.GET)
	public ResponseEntity<?> getCurrencyConversion(@RequestParam("cur1") String cur1,
			@RequestParam("cur2") String cur2, @RequestParam("amount") Double amount) {
		Double converted = service.convertFromCurrencyToAnother(cur1, cur2, amount);
		
		return ResponseEntity.ok(converted);
		
	}
}
