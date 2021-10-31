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
            Optional<Farm> e=farmRepository.getFarm(farm.getId());
            if(!e.isEmpty()){
                if(farm.getName()!=null){
                    e.get().setName(farm.getName());
                }
                if(farm.getDescription()!=null){
                    e.get().setDescription(farm.getDescription()); ;
                }
                if(farm.getCategory() !=null){
                    e.get().setCategory(farm.getCategory());
                }
                if(farm.getMessages()!=null){
                    e.get().setMessages(farm.getMessages());
                }
                if(farm.getAddress()!=null){
                    e.get().setAddress(farm.getAddress());
                }
                if(farm.getExtension()!=null){
                    e.get().setExtension(farm.getExtension());
                }
                if(farm.getReservations()!=null){
                    e.get().setReservations(farm.getReservations());
                }
                farmRepository.save(e.get());
                return e.get();
            }else{
                return farm;
            }
        }else{
            return farm;
        }
    }

    public boolean deleteFarm(int id){
        Boolean aBoolean=getFarm(id).map(farm -> {
            farmRepository.delete(farm);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
