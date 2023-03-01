package com.edilson.PetShop.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edilson.PetShop.entities.Pet;
import com.edilson.PetShop.services.PetServices;

@RestController
@RequestMapping(value = "/pets")
public class PetResources {

	@Autowired
	private PetServices service;
	
	//================FindById=========================FindById=======================FindById========================//
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pet> findById(@PathVariable Long id){
		Pet obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//==============FindAll=====================FindAll========================FindAll================================//
	@GetMapping
	public ResponseEntity<List<Pet>> listAll(){
		List<Pet> list =service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//======================CREATE========================CREATE===================CREATE=============================//
	@PostMapping
	public ResponseEntity<Pet> create(@RequestBody Pet obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	//=======================DELETE=====================DELETE======================DELETE=============================//
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	//===================UPDATE===================UPDATE=================================UPDATE=========================//
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pet> update(@PathVariable Long id, @RequestBody Pet obj){
		Pet newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
}
