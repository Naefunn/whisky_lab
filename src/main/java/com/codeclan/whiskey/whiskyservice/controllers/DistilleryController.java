package com.codeclan.whiskey.whiskyservice.controllers;

import com.codeclan.whiskey.whiskyservice.models.Distillery;
import com.codeclan.whiskey.whiskyservice.models.Whisky;
import com.codeclan.whiskey.whiskyservice.respositories.DistilleryRepository;

import com.codeclan.whiskey.whiskyservice.respositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity getAllDistilleries(){
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/regioned")
    public ResponseEntity<List<Distillery>> getDistilleriesByRegion(@RequestParam(name = "region") String region){
        return new ResponseEntity<>(distilleryRepository.findDistilleryByRegionIgnoreCase(region), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/{id}/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskyByDistilleryAndAge(@PathVariable Long id, @RequestParam(name = "age") int age){

        return new ResponseEntity<>(whiskyRepository.findWhiskiesByDistilleryIdAndAge(id, age), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/whiskies")
    public ResponseEntity<List<Distillery>> getDistilleriesByWhiskyAge(@RequestParam(name = "age") int age){
        return new ResponseEntity<>(distilleryRepository.findDistilleryByWhiskiesAge(age), HttpStatus.OK);
    }
}
