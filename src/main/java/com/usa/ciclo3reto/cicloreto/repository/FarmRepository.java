package com.usa.ciclo3reto.cicloreto.repository;

import com.usa.ciclo3reto.cicloreto.crudRepository.FarmCrudRepository;
import com.usa.ciclo3reto.cicloreto.model.Farm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FarmRepository {
    @Autowired
    private FarmCrudRepository farmCrudRepository;

    public List<Farm> getAll(){
        return(List<Farm>) farmCrudRepository.findAll();
    }

    public Optional<Farm> getFarm(int id){
        return farmCrudRepository.findById(id);
    }

    public Farm save(Farm farm){
        return farmCrudRepository.save(farm);
    }

    public void delete(Farm farm){
        farmCrudRepository.delete(farm);
    }

}
