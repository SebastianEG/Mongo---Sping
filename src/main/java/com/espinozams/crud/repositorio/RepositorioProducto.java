package com.espinozams.crud.repositorio;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.espinozams.crud.modelo.Producto;

@Repository
public interface RepositorioProducto extends MongoRepository<Producto, String> {
	
	public Optional<Producto> findById(String id);
}
