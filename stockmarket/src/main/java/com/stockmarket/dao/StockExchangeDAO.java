package com.stockmarket.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stockmarket.exception.RecordNotFoundException;
import com.stockmarket.model.StockExchange;
import com.stockmarket.repository.StockExchangeRepository;
@Service
@Component
public class StockExchangeDAO {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;
    
    /* to get All StockExchange List */
    public List<StockExchange> getAllStockExchange()
    {
        List<StockExchange> stockExchangeList = stockExchangeRepository.findAll();
         
        if(stockExchangeList.size() > 0) {
            return stockExchangeList;
        } else {
            return new ArrayList<StockExchange>();
        }
    }
    
    public StockExchange getStockExchangeById(Long id) throws RecordNotFoundException
    {
        Optional<StockExchange> stockExchange = stockExchangeRepository.findById(id);
         
        if(stockExchange.isPresent()) {
            return stockExchange.get();
        } else {
            throw new RecordNotFoundException("No stockExchange record exist for given id");
        }
    }
    
    
    /*Create or Update stockExchange */
    public StockExchange createOrUpdateStockExchange(StockExchange entity) throws RecordNotFoundException
    {
        Optional<StockExchange> stockExchange = stockExchangeRepository.findById(entity.getId());
         
        if(stockExchange.isPresent())
        {
            StockExchange newEntity = stockExchange.get();
            newEntity.setName(entity.getName());
            newEntity.setBrief(entity.getBrief());

            newEntity = stockExchangeRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = stockExchangeRepository.save(entity);
             
            return entity;
        }
    }
    
    /* to Delete a StockExchange by ID*/
    public void deleteStockExchangeById(Long id) throws RecordNotFoundException
    {
        Optional<StockExchange> stockExchange = stockExchangeRepository.findById(id);
         
        if(stockExchange.isPresent())
        {
            stockExchangeRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No StockExchange record exist for given id");
        }
    }
}



