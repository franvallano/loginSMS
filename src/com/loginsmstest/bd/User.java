package com.loginsmstest.bd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User {
	
	private String nombre;
	private String apellidos;
	private String telefono;
	
	private static List<User> usuarios = User.getUsers();
	
	public User(String nombre, String apellidos, String telefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public static List<User> getUsers() {
		if( usuarios == null ) {
			usuarios = new ArrayList<User>();
			usuarios.add(new User("Felipe", "Gonzalez Perez", "689172619"));
			usuarios.add(new User("Juan", "Fernandez Perez", "689111619"));
		}
		return usuarios;
	}
	
	public static void addUser(User user) {
		usuarios.add(user);
	}
	
	public static User findByTlfn(String tlfn) {
		Iterator<User> it = usuarios.iterator();
		
		while(it.hasNext()) {
			User user = it.next();
			if(user.getTelefono().equals(tlfn))
				return user;
		}
		return null;
	}
	
	public static User findByToken(String token) {
		MobileAccessDTO aux = MobileAccessDTO.findByToken(token);
		if(null != aux) {
			return User.findByTlfn(aux.getTelefono());
		}else
			return null;
		
	}

}
