package com.stockmarket.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stockmarket.exception.RecordNotFoundException;
import com.stockmarket.model.IPOs;
import com.stockmarket.repository.IPOsRepository;

@Service
@Component
public class IPOsDAO {

    @Autowired
    private IPOsRepository iposRepository;
    
    /* to get All IPOs List */
    public List<IPOs> getAllIPOs()
    {
        List<IPOs> iPOsList = iposRepository.findAll();
         
        if(iPOsList.size() > 0) {
            return iPOsList;
        } else {
            return new ArrayList<IPOs>();
        }
    }
    
    public IPOs getIPOsById(Long id) throws RecordNotFoundException
    {
        Optional<IPOs> iPOs = iposRepository.findById(id);
         
        if(iPOs.isPresent()) {
            return iPOs.get();
        } else {
            throw new RecordNotFoundException("No iPOs record exist for given id");
        }
    }
    
    
    /*Create or Update iPOs */
    public IPOs createOrUpdateIPOs(IPOs entity) throws RecordNotFoundException
    {
        Optional<IPOs> iPOs = iposRepository.findById(entity.getId());
         
        if(iPOs.isPresent())
        {
            IPOs newEntity = iPOs.get();
            newEntity.setId(entity.getId());
            newEntity.setCompanyname(entity.getCompanyname());
            newEntity.setStockexchange(entity.getStockexchange());
            newEntity.setPrice(entity.getPrice());
            newEntity.setTotalshare(entity.getTotalshare());
            newEntity.setOpentime(entity.getOpentime()); 
            newEntity.setRemarks(entity.getRemarks());
            newEntity = iposRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = iposRepository.save(entity);
             
            return entity;
        }
    }
    
    
    
    /* to save a IPOs*/
    
    public IPOs save(@Valid IPOs ipo) {
        // TODO Auto-generated method stub
        return iposRepository.save(ipo);
    }

    /* to Delete a IPOs by ID*/
    public void deleteIPOsById(Long id) throws RecordNotFoundException
    {
        Optional<IPOs> iPOs = iposRepository.findById(id);
         
        if(iPOs.isPresent())
        {
            iposRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No IPOs record exist for given id");
        }
    }
    

}


