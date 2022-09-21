package com.codeclan.whiskey.whiskyservice.controllers;

import com.codeclan.whiskey.whiskyservice.models.Whisky;
import com.codeclan.whiskey.whiskyservice.respositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity getAllWhiskies(){
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/yeared")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(@RequestParam (name = "year") int year){
        return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/regioned")
    public ResponseEntity<List<Whisky>> getWhiskyByRegion(@RequestParam(name = "region") String region){
        return new ResponseEntity<>(whiskyRepository.findWhiskiesByDistilleryRegionIgnoreCase(region), HttpStatus.OK);
    }

}
