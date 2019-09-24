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

import com.stockmarket.dao.StockExchangeDAO;
import com.stockmarket.exception.RecordNotFoundException;
import com.stockmarket.model.StockExchange;
@RestController
@CrossOrigin(origins = "*" ,allowedHeaders = "*")
@RequestMapping("/stockexchange")
public class StockExchangeController {

    @Autowired
    StockExchangeDAO stockExchangeDAO;
    /* to get All StockExchange List */
    @GetMapping
    public ResponseEntity<List<StockExchange>> getAllStockExchange() {
        List<StockExchange> list = stockExchangeDAO.getAllStockExchange();
 
        return new ResponseEntity<List<StockExchange>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    /* get a StockExchange by id */ 
    @GetMapping("/{id}")
    public ResponseEntity<StockExchange> getStockExchangeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        StockExchange stockExchange = stockExchangeDAO.getStockExchangeById(id);
 
        return new ResponseEntity<StockExchange>(stockExchange, new HttpHeaders(), HttpStatus.OK);
    }
    
    /* create OrUpdateEmployee */
    @PostMapping
    public ResponseEntity<StockExchange> createOrUpdateStockExchange(@Valid @RequestBody StockExchange stockExchange)
                                                    throws RecordNotFoundException {
        StockExchange updated = stockExchangeDAO.createOrUpdateStockExchange(stockExchange);
        return new ResponseEntity<StockExchange>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    

    @DeleteMapping("/{id}")
    public HttpStatus deleteStockExchangeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        stockExchangeDAO.deleteStockExchangeById(id);
        //return HttpStatus.FORBIDDEN;
        return HttpStatus.OK;
    }
    
}


