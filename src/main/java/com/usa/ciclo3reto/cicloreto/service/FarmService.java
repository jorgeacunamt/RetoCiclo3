package com.usa.ciclo3reto.cicloreto.service;

import com.usa.ciclo3reto.cicloreto.model.Farm;
import com.usa.ciclo3reto.cicloreto.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmService {
    @Autowired
    private FarmRepository farmRepository;

    public List<Farm> getAll(){
        return farmRepository.getAll();
    }

    public Optional<Farm>  getFarm(int id){
        return farmRepository.getFarm(id);
    }

    public Farm save(Farm farm){
        if (farm.getId()==null){
            return farmRepository.save(farm);
        }else {
            Optional<Farm> tmpFarm=farmRepository.getFarm(farm.getId());
            if(tmpFarm.isEmpty()){
                return farmRepository.save(farm);
            }else  {
                return farm;
            }
        }
    }

    public Farm update(Farm farm){
        if(farm.getId()!=null){
            Optional<Farm> tmpFarm=farmRepository.getFarm(farm.getId());
            if(!tmpFarm.isEmpty()){
                return farmRepository.save(farm);
            }
        }
        return null;
    }

    public boolean deleteFarm(int id){
        Boolean aBoolean=getFarm(id).map(farm -> {
            farmRepository.delete(farm);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
