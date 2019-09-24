package com.stockmarket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.dao.SectorDAO;
import com.stockmarket.exception.RecordNotFoundException;
import com.stockmarket.model.Sector;
@RestController
@CrossOrigin(origins = "*" ,allowedHeaders = "*")
@RequestMapping("/sector")
public class SectorController {
    @Autowired
    SectorDAO sectorDAO;
    /* to get All Sector List */
    @GetMapping
    public ResponseEntity<List<Sector>> getAllSector() {
        List<Sector> list = sectorDAO.getAllSector();
 
        return new ResponseEntity<List<Sector>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    /* get a Sector by id */ 
    @GetMapping("/{id}")
    public ResponseEntity<Sector> getSectorById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        Sector sector = sectorDAO.getSectorById(id);
 
        return new ResponseEntity<Sector>(sector, new HttpHeaders(), HttpStatus.OK);
    }
    
    /* create OrUpdateEmployee */
    @PostMapping
    public ResponseEntity<Sector> createOrUpdateSector(@Valid @RequestBody Sector sector)
                                                    throws RecordNotFoundException {
        Sector updated = sectorDAO.createOrUpdateSector(sector);
        return new ResponseEntity<Sector>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    

    @DeleteMapping("/{id}")
    public HttpStatus deleteSectorById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        sectorDAO.deleteSectorById(id);
        //return HttpStatus.FORBIDDEN;
        return HttpStatus.OK;
    }
}




