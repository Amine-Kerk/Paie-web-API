package dev.paie.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.DTO.EmployeRequestDto;
import dev.paie.entite.Employe;
import dev.paie.service.EmployeService;

@RestController
	@RequestMapping("employe")
	public class EmployeController {


		private EmployeService employeService ;

		public EmployeController(EmployeService employeService) {
			super();
			this.employeService = employeService;
		}
		@PostMapping //ajout de lapi post pour creer un nouveau employe
		public Employe ajouterEmploye(@RequestBody   EmployeRequestDto employeRequestDto) {
	    return employeService.ajouterEmploye(employeRequestDto);

		}
}
