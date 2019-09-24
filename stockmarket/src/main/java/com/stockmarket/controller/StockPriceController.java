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

import com.stockmarket.dao.StockPriceDAO;
import com.stockmarket.exception.RecordNotFoundException;
import com.stockmarket.model.StockPrice;
@RestController
@CrossOrigin(origins = "*" ,allowedHeaders = "*")
@RequestMapping("/stockprice")
public class StockPriceController {
    @Autowired
    StockPriceDAO stockPriceDAO;
    /* to get All Sector List */
    
    @GetMapping
    public ResponseEntity<List<StockPrice>> getAllSector() {
        List<StockPrice> list = stockPriceDAO.getAllStockPrice();
 
        return new ResponseEntity<List<StockPrice>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    /* get a StockPrice by id */ 
    @GetMapping("/{id}")
    public ResponseEntity<StockPrice> getStockPriceById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        StockPrice stockPrice = stockPriceDAO.getStockPriceById(id);
 
        return new ResponseEntity<StockPrice>(stockPrice, new HttpHeaders(), HttpStatus.OK);
    }
    
    /* create OrUpdateEmployee */
    @PostMapping
    public ResponseEntity<StockPrice> createOrUpdateStockPrice(@Valid @RequestBody StockPrice stockPrice)
                                                    throws RecordNotFoundException {
        StockPrice updated = stockPriceDAO.createOrUpdateStockPrice(stockPrice);
        return new ResponseEntity<StockPrice>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public HttpStatus deleteStockPriceById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        stockPriceDAO.deleteStockPriceById(id);
        //return HttpStatus.FORBIDDEN;
        return HttpStatus.OK;
    }
}

