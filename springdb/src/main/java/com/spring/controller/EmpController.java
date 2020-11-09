package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.EmpDAO;
import com.spring.dto.EmpDTO;

@Controller
public class EmpController {
    @Autowired
	EmpDAO dao;
    
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("emp") EmpDTO e) {
		dao.save(e);
		return "redirect:/viewemp";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute("emp") EmpDTO e) {
		dao.edit(e);
		return "redirect:/viewemp";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/viewemp";
	}
	@RequestMapping(value="/viewemp")
	public String getAllEmployees(Model md){
		List<EmpDTO> l=dao.getAllEmployees();
		md.addAttribute("list",l);
		return "redirect/viewemp";
	
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String getbyId(@PathVariable int id,Model m) {
		EmpDTO et=dao.getById(id);
		m.addAttribute("search",et);
		return "search";
	}
	
}
