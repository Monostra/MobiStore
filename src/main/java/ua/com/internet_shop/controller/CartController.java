package ua.com.internet_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.internet_shop.dto.CartDto;
import ua.com.internet_shop.dto.DtoUtilMapper;
import ua.com.internet_shop.editor.DeliveryEditor;
import ua.com.internet_shop.editor.GoodsEditor;
import ua.com.internet_shop.editor.UserEditor;
import ua.com.internet_shop.entity.*;
import ua.com.internet_shop.service.*;

import java.security.Principal;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PagesService pagesService;
    @Autowired
    private NewsService newsService;

    @InitBinder
    public void InitBinder(WebDataBinder binder){
        binder.registerCustomEditor(Goods.class, new GoodsEditor(goodsService));
        binder.registerCustomEditor(User.class, new UserEditor(userService));
        binder.registerCustomEditor(Delivery.class, new DeliveryEditor(deliveryService));
    }

    @RequestMapping(value = "/cart")
    public String cart(Model model, Principal principal){
        int userId = Integer.parseInt(principal.getName());
        model.addAttribute("orders", new Orders());
        model.addAttribute("cartsUser", cartService.allGoods(userId));
        model.addAttribute("loadCart", cartService.totalQuantityAndPrice(userId));
        model.addAttribute("deliveries", deliveryService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("pages", pagesService.findAll());
        model.addAttribute("allNews", newsService.findAll());
        return "views-base-cart";
    }

    @RequestMapping(value = "/buyGood")
    public @ResponseBody List<CartDto> buyGood(Principal principal, @RequestBody Goods good) {

        cartService.buyGood(good.getId(), principal);
        return DtoUtilMapper.cartToCartDtos(cartService.findAll());
    }

    @RequestMapping(value = "/deleteCart")
    public @ResponseBody List<CartDto> deleteCart(@RequestBody Cart cart) {
        cartService.delete(cart.getId());
        return DtoUtilMapper.cartToCartDtos(cartService.findAll());
    }

    @Transactional
    @RequestMapping(value = "/countCart")
    public @ResponseBody List<CartDto> countCart(@RequestBody Cart cart) {
//        cartService.delete(cart.getId());
        cartService.findOne(cart.getId()).setQuantity(cart.getQuantity());
        return DtoUtilMapper.cartToCartDtos(cartService.findAll());
    }

    @RequestMapping(value = "/loadCart")
    public @ResponseBody  Object loadCart(Principal principal){
        return cartService.totalQuantityAndPrice(Integer.parseInt(principal.getName()));
    }







}
