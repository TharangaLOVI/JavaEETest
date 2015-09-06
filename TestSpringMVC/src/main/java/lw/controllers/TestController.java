package lw.controllers;

import lw.models.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TestController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadForm_EX1() {

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("message", "Hi welcome");
		return modelAndView;

	}
	
	@RequestMapping("/form")
	public String loadForm_EX2() {

		return "index";

	}
	
	@RequestMapping("/rest/{id}")
	public @ResponseBody String load_Rest_EX1(@PathVariable("id") int id) {

		return "Got Rest ID : " + id;

	}
	
	@RequestMapping("/rest2/{id}") //http://localhost:8081/TestSpringMVC/rest2/2?name=tharanga
	public @ResponseBody String load_Rest_EX2(@PathVariable("id") int id,String name) {

		return "Got Rest ID : " + id + " ,Name : " + name;

	}
	
	@RequestMapping(value = "/add/{type}",method = RequestMethod.POST)
	public ModelAndView loadRequestBody_EX2(@RequestBody Employee employee) {

		ModelAndView modelAndView = new ModelAndView("view_emp");
		modelAndView.addObject("employee", employee);
		return modelAndView;

	}
	
	@RequestMapping("/responce_body")
	public @ResponseBody String loadExResponceBody_EX1() {

		return "Hi ResponseBody";

	}
	
}
