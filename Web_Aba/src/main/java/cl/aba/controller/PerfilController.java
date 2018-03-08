package cl.aba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.aba.business.service.PerfilService;
import cl.aba.business.vo.PerfilVO;
import cl.aba.business.vo.RespuestaVO;

@Controller
public class PerfilController {

	@Autowired
	private PerfilService perfilService;
	
	@RequestMapping(value = "perfil.json", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<RespuestaVO>  setPerfil(@Valid @ModelAttribute("perfil") PerfilVO perfil, Model model) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		
		PerfilVO usuario = perfilService.getPerfil(userDetails.getUsername());
	
		if (perfil.getPass() != usuario.getPass()) {
			if(encoder.matches(perfil.getPass(), usuario.getPass())) {
				perfil.setNewpass(encoder.encode(perfil.getNewpass()));
				perfilService.updatePerfil(perfil, userDetails.getUsername());
				return new ResponseEntity<>(new RespuestaVO("Los datos se han modificado correctamente.", "success"), HttpStatus.OK);
			} else
				return new ResponseEntity<>(new RespuestaVO("La contraseña es incorrecta.", "error"), HttpStatus.BAD_REQUEST);
		} else {
			perfil.setNewpass(usuario.getPass());
			return new ResponseEntity<>(new RespuestaVO("Los datos se han modificado correctamente.", "success"), HttpStatus.OK);
		}
		
}
	
	@RequestMapping(value = "perfil.json", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<PerfilVO>  getPerfil() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String username = userDetails.getUsername();
		
		return new ResponseEntity<>(perfilService.getPerfil(username), HttpStatus.OK);
	} 
	
}
