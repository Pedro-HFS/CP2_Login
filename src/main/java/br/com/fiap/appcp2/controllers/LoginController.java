package br.com.fiap.appcp2.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.appcp2.dto.LoginDto;
import br.com.fiap.appcp2.model.Login;
import br.com.fiap.appcp2.repositories.LoginRepository;

@Controller
public class LoginController {
	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/login")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("login/index");
		List<Login> loginsDaRepository = loginRepository.findAll();
		modelView.addObject("listaLogin", loginsDaRepository);

		return modelView;
	}

	@GetMapping("/login/criar")
	public ModelAndView criar(LoginDto model) {
		ModelAndView modelView = new ModelAndView("login/criar");

		return modelView;
	}

	@PostMapping("/login")
	public ModelAndView salvar(@Valid LoginDto login, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("login/criar");
		}

		Login loginEntity = modelMapper.map(login, Login.class);

		loginRepository.save(loginEntity);
		return new ModelAndView("redirect:/login");
	}
}
