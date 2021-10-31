package com.usa.ciclo3reto.cicloreto.controller;

import com.usa.ciclo3reto.cicloreto.model.Farm;
import com.usa.ciclo3reto.cicloreto.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class FarmController {
    @Autowired
    private FarmService farmService;

    @GetMapping("/all")
    public List<Farm> getAll(){
        return farmService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Farm> getFarm(@PathVariable("id") int id){
        return farmService.getFarm(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm save(@RequestBody Farm farm){
        return farmService.save(farm);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm update(@RequestBody Farm farm){
        return farmService.update(farm);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id") int id){
        return farmService.deleteFarm(id);
    }

}
