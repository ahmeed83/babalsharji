package controller;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import services.UserService;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class HelloWorldController {

@Autowired
private UserService userService;

@RequestMapping(value="/hello", method=GET)
 public String hello(@RequestParam(value="id", required=false, defaultValue="helloworld param") String n,ModelMap model) {
  model.addAttribute("name", n);
  
  //this shit down here is just a connection test with the MONGOTEMPLATE BEAN
  //this bean is supposed to make the connection to the database
  //also this should be implemented into a service class instead of directly into the controller
  User u = new User();
  u.setName("michel dolstra");
  u.setUserName("mdo001");
  u.setPassword("welkom001");
  
  User frommongo = userService.getById("549f33492f738a1117bd5a18");
  frommongo.setAge("22");
  System.out.println(frommongo.getName()+" "+frommongo.getAge());
  userService.merge(frommongo);
  
  return "helloworld";
 }
}