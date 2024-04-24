package com.souleimen.avions.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import com.souleimen.avions.entities.Avion;
import com.souleimen.avions.service.AvionService;

@Controller
public class AvionController {
	@Autowired
	AvionService avionService;

	@RequestMapping("/ListeAvions")
	public String listeAvions(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)
 {
		Page<Avion> avios = avionService.getAllAvionsParPage(page, size);
		modelMap.addAttribute("avions", avios);
		modelMap.addAttribute("pages", new int[avios.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

		return "listeAvions";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createAvion";
	}

	@RequestMapping("/saveAvion")
	public String saveAvion(@ModelAttribute("avion") Avion avion, @RequestParam("date") String date, ModelMap modelMap)
			throws ParseException {
//conversion de la date 
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		avion.setDateFabrication(dateCreation);

		Avion saveAvion = avionService.saveAvion(avion);
		String msg = "avion enregistré avec Id " + saveAvion.getIdAvion();
		modelMap.addAttribute("msg", msg);
		return "createAvion";
	}

	@RequestMapping("/supprimerAvion")
	public String supprimerAvion(@RequestParam("id") Long id,
							ModelMap modelMap,
							@RequestParam (name="page",defaultValue = "0") int page,
							@RequestParam (name="size", defaultValue = "2") int size)
		 {
		avionService.deleteAvionById(id);
		
		Page<Avion> avios = avionService.getAllAvionsParPage(page, 
				size);
				modelMap.addAttribute("avions", avios);
				modelMap.addAttribute("pages", new int[avios.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);
				
		return "listeAvions";
	}

	@RequestMapping("/modifierAvion")
	public String editerAvion(@RequestParam("id") Long id, ModelMap modelMap) {
		Avion p = avionService.getAvion(id);
		modelMap.addAttribute("avion", p);
		return "editerAvion";
	}

	@RequestMapping("/updateAvion")
	public String updateAvion(@ModelAttribute("avion") Avion avion, @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
		//conversion de la date 
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFabrication = dateformat.parse(String.valueOf(date));
		avion.setDateFabrication(dateFabrication);

		avionService.updateAvion(avion);
		List<Avion> avios = avionService.getAllAvions();
		modelMap.addAttribute("avions", avios);
		return "listeAvions";
	}
}