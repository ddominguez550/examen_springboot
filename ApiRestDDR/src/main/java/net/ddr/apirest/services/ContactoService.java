package net.ddr.apirest.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ddr.apirest.exceptions.GeneralException;
import net.ddr.apirest.models.Contacto;
import net.ddr.apirest.repositories.ContactoRepositorie;
import net.ddr.apirest.vo.ContactoVo;
import net.ddr.apirest.vo.DireccionVo;

@Service
public class ContactoService {
	
	
	@Autowired
	private ContactoRepositorie contactoRepositorie;
	
	public Map<Object, Object> consultarTodos() {
		Map<Object, Object> mapResultado = new HashMap<>();
		List<Contacto> listaContacto=null;
		List<ContactoVo> listaContactoVo = new ArrayList<>();
		
		try {
			listaContacto=(List<Contacto>) contactoRepositorie.findAll();
			for (Contacto contacto : listaContacto) {
				ContactoVo contactoVo = new ContactoVo();
				contactoVo.setIdContacto(contacto.getIdContacto());
				contactoVo.setNombre(contacto.getNombre());
				contactoVo.setApellidoP(contacto.getApellidoP());
				contactoVo.setApellidoM(contacto.getApellidoM());
				contactoVo.setEmail(contacto.getEmail());
				contactoVo.setTelefono(contacto.getTelefono());
				listaContactoVo.add(contactoVo);
			}
		} catch (Exception e) {
			throw new GeneralException("Error al consultar los contactos", e);
		}
		
		mapResultado.put("datos", listaContactoVo);
		
		return mapResultado;
	}
	
	public Map<Object, Object> consultarPorId(Long idContacto) {
		Map<Object, Object> mapResultado = new HashMap<>();
		ContactoVo contactoVo = null;
		DireccionVo direccionVo = null;
		try {
			Contacto contacto = contactoRepositorie.findById(idContacto).orElse(null);
			if (contacto!=null) {
				contactoVo = new ContactoVo();
				contactoVo.setIdContacto(contacto.getIdContacto());
				contactoVo.setNombre(contacto.getNombre());
				contactoVo.setApellidoP(contacto.getApellidoP());
				contactoVo.setApellidoM(contacto.getApellidoM());
				contactoVo.setEmail(contacto.getEmail());
				contactoVo.setTelefono(contacto.getTelefono());
				if(contacto.getDireccion()!=null) {
					direccionVo = new DireccionVo();
					direccionVo.setIdDireccion(contacto.getDireccion().getIdDireccion());
					direccionVo.setCalle(contacto.getDireccion().getCalle());
					direccionVo.setCodigoPostal(contacto.getDireccion().getCodigoPostal());
					direccionVo.setColonia(contacto.getDireccion().getColonia());
					direccionVo.setNumero(contacto.getDireccion().getNumero());
					contactoVo.setDireccionVo(direccionVo);
				}
			}else {
				mapResultado.put("mensaje", "No existe el contacto con id " + idContacto);
			}
		} catch (Exception e) {
			throw new GeneralException("Error al consultar el contacto" , e);
		}
		
		mapResultado.put("datos", contactoVo);
		
		return mapResultado;
	}
	
	public Map<Object, Object> guardar(Contacto contacto){
		Map<Object, Object> mapResultado = new HashMap<>();
		
		try {
			contacto=contactoRepositorie.save(contacto);
			mapResultado.put("mensaje", "contacto con registrado correctamente");
		}catch (Exception e) {
			throw new GeneralException("Error al guardar el contacto", e);
		}
		
		return mapResultado;
		
	}
	
	
	public Map<Object, Object> actualizar(Contacto contacto){
		Map<Object, Object> mapResultado = new HashMap<>();
		
		try {
			contactoRepositorie.save(contacto);
			mapResultado.put("mensaje", "contacto actualizado correctamente" );
		}catch (Exception e) {
			throw new GeneralException("Error al actualizar el contacto", e);
		}
		
		return mapResultado;
	}
	
	public Map<Object, Object> eliminar(Long idContacto){
		Map<Object, Object> mapResultado = new HashMap<>();
		
		try {
			if(contactoRepositorie.findById(idContacto).orElse(null)==null) {
				mapResultado.put("mensaje", "No existe el contacto con id " + idContacto);
			}else {
				contactoRepositorie.deleteById(idContacto);
				mapResultado.put("mensaje", "contacto eliminado correctamente" );
			}
		}catch (Exception e) {
			throw new GeneralException("Error al eliminar el contacto", e);
		}
		
		return mapResultado;
	}

}
