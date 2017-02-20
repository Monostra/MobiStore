package ua.com.internet_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.internet_shop.service.UserService;

@Controller
public class CookieController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/buyGood/{id}", method = RequestMethod.GET)
//    public String buyGood(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
//        userService.intoBasket(Integer.parseInt(id), request, response);
//        return "redirect:/";
//    }
//
//    @RequestMapping(value = "/profile")
//    public String profile(Principal principal, Model model, HttpServletRequest request){
////		model.addAttribute("user", userService.getOne(Integer.parseInt(principal.getName())));
////		model.addAttribute("userDto", DtoUtilMapper.userToUserDto(userService.getAll()));
//        User user = userService.findUserWithImage(Integer.parseInt(principal.getName()));
//        model.addAttribute("goods", userService.userGoodsCookie(request));
//        model.addAttribute("user", user);
//
//        return "views-base-profile";
//    }
//
//    @RequestMapping(value = "/deleteFromCookie/{id}", method = RequestMethod.GET)
//    public String deleteCookie(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
//        userService.deleteCookieFromOrder(id, request, response);
//        return "redirect:/profile";
//    }

}
