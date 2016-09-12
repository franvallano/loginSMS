package com.loginsmstest.bd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MobileAccessDTO {

	private String telefono;
	private boolean confirmado;
	
	private static Map<String, MobileAccessDTO> auxiliares = MobileAccessDTO.getAuxiliares();
	
	public MobileAccessDTO(String telefono, boolean confirmado) {
		this.telefono = telefono;
		this.confirmado = confirmado;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean isConfirmado() {
		return confirmado;
	}
	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	
	public static Map<String, MobileAccessDTO> getAuxiliares() {
		if(auxiliares == null) {
			auxiliares = new HashMap<String, MobileAccessDTO>();
		}
		return auxiliares;
	}
	
	public static void addAuxiliar(String token, MobileAccessDTO aux) {
		auxiliares.put(token, aux);
	}
	
	public static MobileAccessDTO findByToken(String token) {
		return auxiliares.get(token);
	}
	
}
