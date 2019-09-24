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

import com.stockmarket.dao.IPOsDAO;
import com.stockmarket.exception.RecordNotFoundException;
import com.stockmarket.model.IPOs;

@RestController
@CrossOrigin(origins = "*" ,allowedHeaders = "*")
@RequestMapping("/ipos")
public class IPOsController {

    @Autowired
    IPOsDAO iposDAO;
    /* to get All IPOs List */
    @GetMapping
    public ResponseEntity<List<IPOs>> getAllIPOs() {
        List<IPOs> list = iposDAO.getAllIPOs();
 
        return new ResponseEntity<List<IPOs>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    /* get a IPOs by id */ 
    @GetMapping("/{id}")
    public ResponseEntity<IPOs> getIPOsById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        IPOs iPOs = iposDAO.getIPOsById(id);
 
        return new ResponseEntity<IPOs>(iPOs, new HttpHeaders(), HttpStatus.OK);
    }
    
    /* create Or UpdateEmployee */
    @PostMapping
    public ResponseEntity<IPOs> createOrUpdateIPOs(@Valid @RequestBody IPOs iPOs)
                                                    throws RecordNotFoundException {
        IPOs updated = iposDAO.createOrUpdateIPOs(iPOs);
        return new ResponseEntity<IPOs>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    /* to save an IPOs */
    @PostMapping("/createIPOs")
    public IPOs createEmployee(@Valid @RequestBody IPOs cmp) {
        return iposDAO.save(cmp);
    }
    

    @DeleteMapping("/{id}")
    public HttpStatus deleteIPOsById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        iposDAO.deleteIPOsById(id);
        return HttpStatus.FORBIDDEN;
    }
}



