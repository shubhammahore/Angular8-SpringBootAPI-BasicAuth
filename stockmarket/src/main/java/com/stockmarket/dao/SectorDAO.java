package com.stockmarket.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stockmarket.exception.RecordNotFoundException;
import com.stockmarket.model.Sector;
import com.stockmarket.repository.SectorRepository;

@Service
@Component
public class SectorDAO {

    @Autowired
    private SectorRepository sectorRepository;
    
    /* to get All Sector List */
    public List<Sector> getAllSector()
    {
        List<Sector> sectorList = sectorRepository.findAll();
         
        if(sectorList.size() > 0) {
            return sectorList;
        } else {
            return new ArrayList<Sector>();
        }
    }
    
    public Sector getSectorById(Long id) throws RecordNotFoundException
    {
        Optional<Sector> sector = sectorRepository.findById(id);
         
        if(sector.isPresent()) {
            return sector.get();
        } else {
            throw new RecordNotFoundException("No sector record exist for given id");
        }
    }
    
    
    /*Create or Update sector */
    public Sector createOrUpdateSector(Sector entity) throws RecordNotFoundException
    {
        Optional<Sector> sector = sectorRepository.findById(entity.getId());
         
        if(sector.isPresent())
        {
            Sector newEntity = sector.get();
            newEntity.setName(entity.getName());
            newEntity.setBrief(entity.getBrief());

            newEntity = sectorRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = sectorRepository.save(entity);
             
            return entity;
        }
    }
    
    /* to Delete a Sector by ID*/
    public void deleteSectorById(Long id) throws RecordNotFoundException
    {
        Optional<Sector> sector = sectorRepository.findById(id);
         
        if(sector.isPresent())
        {
            sectorRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No Sector record exist for given id");
        }
    }
    
}





