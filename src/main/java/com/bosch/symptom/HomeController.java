package com.bosch.symptom;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bosch.symptom.dto.DtcDTO;
import com.bosch.symptom.dto.SymptomDTO;
import com.bosch.symptom.model.Symptom;
import com.bosch.symptom.service.SymptomService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	SymptomService symptomService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Symptom> symptoms = symptomService.findAll();
		model.addAttribute("symptoms", symptoms );
		
		return "home";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Locale locale, Model model, @ModelAttribute("symptomDTO") SymptomDTO symptomDTO) {
		symptomService.create(symptomDTO);
		
		return "redirect:";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Locale locale, Model model, @ModelAttribute("symptomDTO") SymptomDTO symptomDTO) {
		symptomService.update(symptomDTO);
		
		return "redirect:";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable Long id) {
		symptomService.delete(id);
		
		return "redirect:/";
	}
	
}
