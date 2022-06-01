package sistema.integrador.oo2.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sistema.integrador.oo2.entities.User;
import sistema.integrador.oo2.helpers.ViewRouteHelper;
import sistema.integrador.oo2.services.IUserService;

@Controller
@RequestMapping
public class UserControllerCrud {
	@Autowired
	private IUserService service;
	BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<User>users=service.listar();
		model.addAttribute("users", users);
		return ViewRouteHelper.USER_LISTAR;//tengo que poner el nnombre del archivo html
	}
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("user", new User());
		return"user/form";
	}
	@PostMapping("/save")
	public String save(@Valid User u,Model model) {
		
		u.setPassword(pe.encode(u.getPassword()));
		service.save(u);
		return "redirect:listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id,Model model) {
		Optional<User>user=service.listarId(id);
		model.addAttribute("user", user);
		return "user/form";
	}
}
