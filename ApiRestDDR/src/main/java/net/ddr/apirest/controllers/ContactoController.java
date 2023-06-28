package net.ddr.apirest.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.ddr.apirest.exceptions.GeneralException;
import net.ddr.apirest.models.Contacto;
import net.ddr.apirest.services.ContactoService;


@RestController
@RequestMapping("/contactos")
public class ContactoController {
	
	@Autowired
	private ContactoService contactoService;
	
	
	@GetMapping( path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<Object, Object>> consultarTodos() {
		Map<Object, Object> mapResultado = new HashMap<>();
		ResponseEntity<Map<Object, Object>> respuesta = null;
		try {
			mapResultado=contactoService.consultarTodos();
			respuesta = new ResponseEntity<>(mapResultado, HttpStatus.OK);
		}catch(GeneralException ge) {
			mapResultado.put("mensaje", ge.getMessage());
			respuesta = new ResponseEntity<>(mapResultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}
	
	@GetMapping( path = "/consultarPorId/{idContacto}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Map<Object, Object>> consultarPorId(@PathVariable  Long idContacto ) {
		Map<Object, Object> mapResultado = new HashMap<>();
		ResponseEntity<Map<Object, Object>> respuesta = null;
		try {
			mapResultado=contactoService.consultarPorId(idContacto);
			respuesta = new ResponseEntity<>(mapResultado, HttpStatus.OK);
		}catch(GeneralException ge) {
			mapResultado.put("mensaje", ge.getMessage());
			respuesta = new ResponseEntity<>(mapResultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}
	
	@PostMapping( path = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Map<Object, Object>> guardar(@RequestBody Contacto contacto ) {
		Map<Object, Object> mapResultado = new HashMap<>();
		ResponseEntity<Map<Object, Object>> respuesta = null;
		try {
			mapResultado=contactoService.guardar(contacto);
			respuesta = new ResponseEntity<>(mapResultado, HttpStatus.OK);
		}catch(GeneralException ge) {
			mapResultado.put("mensaje", ge.getMessage());
			respuesta = new ResponseEntity<>(mapResultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}
	
	@PutMapping( path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Map<Object, Object>> actualizar(@RequestBody Contacto contacto ) {
		Map<Object, Object> mapResultado = new HashMap<>();
		ResponseEntity<Map<Object, Object>> respuesta = null;
		try {
			mapResultado=contactoService.actualizar(contacto);
			respuesta = new ResponseEntity<>(mapResultado, HttpStatus.OK);
		}catch(GeneralException ge) {
			mapResultado.put("mensaje", ge.getMessage());
			respuesta = new ResponseEntity<>(mapResultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}
	
	@DeleteMapping( path = "/eliminar/{idContacto}")
	public ResponseEntity<Map<Object, Object>> eliminar(@PathVariable  Long idContacto ) {
		Map<Object, Object> mapResultado = new HashMap<>();
		ResponseEntity<Map<Object, Object>> respuesta = null;
		try {
			mapResultado=contactoService.eliminar(idContacto);
			respuesta = new ResponseEntity<>(mapResultado, HttpStatus.OK);
		}catch(GeneralException ge) {
			mapResultado.put("mensaje", ge.getMessage());
			respuesta = new ResponseEntity<>(mapResultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}
	
	
	
	
}
