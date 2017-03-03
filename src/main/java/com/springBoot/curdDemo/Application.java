package com.springBoot.curdDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springBoot.curdDemo.service.PersonService;

@SpringBootApplication
@Controller
public class Application {
	@Autowired
	PersonService personService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("persons", personService.read());
		return "index";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Model model, Integer id, String name, String phone) {
		personService.update(id, name, phone);
		model.addAttribute("persons", personService.read());
		return "index";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model, String name, String phone) {
		personService.create(name, phone);
		model.addAttribute("persons", personService.read());
		return "index";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model, Integer id) {
		personService.delete(id);
		model.addAttribute("persons", personService.read());
		return "index";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}




















