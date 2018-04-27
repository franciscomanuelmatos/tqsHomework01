package pt.ua.tqs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pt.ua.tqs.CachedData;

@Controller
public class ConversionFormController {
	
	@RequestMapping(value={"/conversion"}, method=RequestMethod.GET)
	public String getConversionForm(Model model) {
		model.addAttribute("currencies", CachedData.getCurrencies());
		return "index";	
	}
}
