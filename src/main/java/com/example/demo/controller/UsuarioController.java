package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(path = "/crear/{nombre}/{edad}", method = RequestMethod.POST)
	public String crearUsuario(@PathVariable("nombre") String nombre, @PathVariable("edad") String edad) {

		return usuarioService.crearUsuario(nombre, edad);
	}

	@RequestMapping(value = "/eliminar/{nombre}", method = RequestMethod.DELETE)
	public boolean eliminarUsuario(@PathVariable("nombre") String nombre) {
		return usuarioService.eliminarUsuario(nombre);
	}

	@RequestMapping(path = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}

	
	@RequestMapping(path = "/actualizar/{nombre}/{nuevoNombre}/{nuevaEdad}"
			,method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public String buscarUsuario(@PathVariable("nombre") String nombreUsuario,
			@PathVariable("nuevoNombre") String nuevoNombre, @PathVariable("nuevaEdad") String nuevaEdad) {
		return usuarioService.actualizarUsuario(nombreUsuario, nuevoNombre, nuevaEdad);

	}

	@RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object buscarUsuario(@PathVariable("nombre") String nombre) {
		return usuarioService.buscarUsuario(nombre);
	}
}
