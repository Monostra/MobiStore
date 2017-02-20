package ua.com.internet_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.internet_shop.entity.Zakaz;
import ua.com.internet_shop.service.ZakazService;

@Controller
public class ZakazController {
	
	@Autowired
	private ZakazService zakazService; 

	@RequestMapping(value="/newZakaz", method=RequestMethod.GET)
	public String newZakaz(org.springframework.ui.Model model){
		model.addAttribute("zakaz", zakazService.findAll());
		return "admin-newZakaz";
	}
	@RequestMapping(value="/saveZakaz", method=RequestMethod.POST)
	public String saveCat(@RequestParam String quantity){
		
		Zakaz zakaz = new Zakaz();
		zakaz.setQuantity(Integer.parseInt(quantity));
		
		zakazService.save(zakaz);

		return "redirect:/newZakaz";
	}
}
