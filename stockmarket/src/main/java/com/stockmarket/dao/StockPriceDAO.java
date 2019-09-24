package com.stockmarket.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stockmarket.exception.RecordNotFoundException;
import com.stockmarket.model.StockPrice;
import com.stockmarket.repository.StockPriceRepository;
@Service
@Component
public class StockPriceDAO {

    @Autowired
    private StockPriceRepository stockPriceRepository;
    
    /* to get All StockPrice List */
    public List<StockPrice> getAllStockPrice()
    {
        List<StockPrice> stockPriceList = stockPriceRepository.findAll();
         
        if(stockPriceList.size() > 0) {
            return stockPriceList;
        } else {
            return new ArrayList<StockPrice>();
        }
    }
    
    public StockPrice getStockPriceById(Long id) throws RecordNotFoundException
    {
        Optional<StockPrice> stockPrice = stockPriceRepository.findById(id);
         
        if(stockPrice.isPresent()) {
            return stockPrice.get();
        } else {
            throw new RecordNotFoundException("No stockPrice record exist for given id");
        }
    }
    
    
    /*Create or Update StockPrice */
    public StockPrice createOrUpdateStockPrice(StockPrice entity) throws RecordNotFoundException
    {
        Optional<StockPrice> stockPrice = stockPriceRepository.findById(entity.getCompanyCode());
         
        if(stockPrice.isPresent())
        {
            StockPrice newEntity = stockPrice.get();
            newEntity.setStockExchange(entity.getStockExchange());
            newEntity.setCurrentPrice(entity.getCurrentPrice());
            newEntity.setDate(entity.getDate());
            newEntity.setTime(entity.getTime());

            newEntity = stockPriceRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = stockPriceRepository.save(entity);
             
            return entity;
        }
    }
    
    /* to Delete a StockPrice by ID*/
    public void deleteStockPriceById(Long id) throws RecordNotFoundException
    {
        Optional<StockPrice> stockPrice = stockPriceRepository.findById(id);
         
        if(stockPrice.isPresent())
        {
            stockPriceRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No stockPrice record exist for given id");
        }
    }
}




