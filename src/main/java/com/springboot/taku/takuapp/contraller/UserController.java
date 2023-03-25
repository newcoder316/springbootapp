package com.springboot.taku.takuapp.contraller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.taku.takuapp.entity.User;
import com.springboot.taku.takuapp.serviceImpl.UserServiceImpl;

@Controller
public class UserController {
  
  @Autowired
  private UserServiceImpl userServiceImpl;
  
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String registerUser(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Model model) {
    try {
      User user = new User();
      user.setUsername(username);
      user.setPassword(password);
      userServiceImpl.registerUser(user);
      return "redirect:/succeed";
    } catch (Exception e) {
      model.addAttribute("error", e.getMessage());
      return "register";
    }
  }
  
//GET请求，显示注册页面
 @GetMapping("/register")
 public String showRegistrationForm(Model model) {
   // 将一个空的User对象添加到模型中，用于绑定表单数据
   model.addAttribute("user", new User());
   return "register"; // 返回视图名称
 }
//GET请求，显示注册成功页面
@GetMapping("/succeed")
public String showSucceed( ) {
  return "succeed"; // 返回视图名称
}
  
}
