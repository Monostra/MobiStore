package ua.com.internet_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.com.internet_shop.editor.DeliveryEditor;
import ua.com.internet_shop.entity.Cart;
import ua.com.internet_shop.entity.Delivery;
import ua.com.internet_shop.entity.Orders;
import ua.com.internet_shop.entity.Zakaz;
import ua.com.internet_shop.service.*;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	@Autowired
	private UserService userService;
	@Autowired
	private DeliveryService deliveryService;
	@Autowired
	private ZakazService zakazService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CartService cartService;

	@InitBinder
	public void InitBinder(WebDataBinder binder){
		binder.registerCustomEditor(Delivery.class, new DeliveryEditor(deliveryService));
	}
//
//	@RequestMapping(value="/newOrders", method=RequestMethod.GET)
//	public String newOrders(org.springframework.ui.Model model){
//		model.addAttribute("orders", ordersService.findAll());
//		return "admin-newOrders";
//	}
	
	@RequestMapping(value="/saveOrder", method=RequestMethod.POST)
	public String saveOrders(
			@ModelAttribute Orders orders,
			Principal principal
			){
		
		orders.setDate(LocalDateTime.now());
		orders.setUser(userService.findOne(Integer.parseInt(principal.getName())));
//		ordersService.save(orders);
		Orders orders1 = ordersService.SaveAndFlash(orders);

//		cartService.deleteByUser(Integer.parseInt(principal.getName()));
//		for (int i=0; i<id.length; i++){
//			Zakaz zakaz = new Zakaz();
//			zakaz.setOrders(orders1);
//			zakaz.setQuantity(Integer.parseInt(quantity[i]));
//			zakaz.setGoods(goodsService.findOne(Integer.parseInt(id[i])));
//			zakazService.save(zakaz);
//		}
//		for (Cart c: cartService.cartByUser(Integer.parseInt(principal.getName()))) {
//			cartService.delete(c.getId());
//		}

		for (Cart c: cartService.cartByUser(Integer.parseInt(principal.getName()))) {
			Zakaz zakaz = new Zakaz();
			zakaz.setOrders(orders1);
			zakaz.setQuantity(c.getQuantity());
			zakaz.setGoods(c.getGoods());
			zakazService.save(zakaz);
			cartService.delete(c.getId());
		}
		return "redirect:/home";
	}
}
