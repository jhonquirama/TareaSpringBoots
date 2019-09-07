package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public String crearUsuario(String nombre, String edad) {
		try {
			return usuarioRepository.crearUsuario(new Usuario(nombre, Integer.parseInt(edad)));		
		} catch (Exception e) {
			return "error";
		}
	}

	public boolean eliminarUsuario(String nombreUsuario) {
		Usuario usuario = usuarioRepository.buscarUsuario(nombreUsuario);
		System.out.println(usuario.getNombre()+"sdfsdf");
		if (usuario != null) {
			return usuarioRepository.eliminarUsuario(usuario);

		} else {
			return false;

		}
	}


	public List<Usuario> listarUsuarios() {
		return usuarioRepository.listarUsuarios();
	}
	
	public Object buscarUsuario(String name) {
		Usuario usuario = usuarioRepository.buscarUsuario(name);
		if (usuario != null) {
			return usuario;

		}else {
			return "El usuario no esta en la lista";

		}
	}
	

	public String actualizarUsuario(String nombreUsuario, String nuevoNombre, String nuevaEdad) {
		try {
			int posicion = usuarioRepository.indexUsu(nombreUsuario);
			if (posicion == -1) {
				return "El usuario no existe";
			}

			return usuarioRepository.actualizarUsuario(posicion, new Usuario(nuevoNombre, Integer.parseInt(nuevaEdad)));

		} catch (Exception e) {
			return "error al actualizar, ";
		}
	}
}

