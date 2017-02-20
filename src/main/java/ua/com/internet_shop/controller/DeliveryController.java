package ua.com.internet_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.internet_shop.dto.DeliveryDto;
import ua.com.internet_shop.dto.DtoUtilMapper;
import ua.com.internet_shop.entity.Delivery;
import ua.com.internet_shop.service.DeliveryService;

import java.util.List;

@Controller
public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService; 

	@RequestMapping(value="/newDelivery", method=RequestMethod.GET)
	public String newDelivery(Model model){
		model.addAttribute("deliveries", deliveryService.findAll());

		model.addAttribute("delivery", new Delivery());
		return "admin-newDelivery";
	}



	//	@RequestMapping(value="/saveDelivery", method=RequestMethod.POST)
//	public String saveCat(@RequestParam String name){
//
//		deliveryService.save(new Delivery(name));
//
//		return "redirect:/newDelivery";
//	}
	@RequestMapping(value="/saveDelivery", method=RequestMethod.POST)
	public @ResponseBody List<DeliveryDto> saveDelivery(@RequestBody Delivery delivery){

		deliveryService.save(delivery);
		return DtoUtilMapper.deliveriesToDeliveriesDtos(deliveryService.findAll());
	}
}
