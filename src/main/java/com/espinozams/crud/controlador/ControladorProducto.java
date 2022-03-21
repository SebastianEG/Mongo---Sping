package com.espinozams.crud.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.espinozams.crud.modelo.Producto;
import com.espinozams.crud.repositorio.RepositorioProducto;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,RequestMethod.DELETE })
@RequestMapping("/api/products")
public class ControladorProducto {

	@Autowired
	private RepositorioProducto repository;

	@PostMapping("/producto")
	public Producto create(@Validated @RequestBody Producto product) {
		return repository.insert(product);
	}

	@GetMapping("/all")
	public List<Producto> readAll() {
		return repository.findAll();
	}

	@PutMapping("/producto/{id}")
	public Producto update(@PathVariable String id, @Validated @RequestBody Producto product) {
		return repository.save(product);
		
	}

	@DeleteMapping("/producto/{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(id);
	}
	
}
