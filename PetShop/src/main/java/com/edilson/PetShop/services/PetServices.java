package com.edilson.PetShop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edilson.PetShop.entities.Pet;
import com.edilson.PetShop.repositories.PetRepository;
import com.edilson.PetShop.services.exceptions.ObjectNotFoundException;

@Service
public class PetServices {

	@Autowired
	private PetRepository repository;
	
	public Pet findById(Long id) {
		Optional<Pet> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado" + id + ", tipo " + Pet.class.getName()));
	}
	
	public List<Pet> findAll(){
		List<Pet> list = repository.findAll();
		return list;
	}

	public Pet create(Pet obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}

	public Pet update(Long id, Pet obj) {
		Pet newObj = findById(id);
		newObj.setNomePet(obj.getNomePet());
		newObj.setNomeTutor(obj.getNomeTutor());
		newObj.setProcedimento(obj.getProcedimento());
		newObj.setAgendamento(obj.getAgendamento());
		return repository.save(newObj);
	}
	
}
