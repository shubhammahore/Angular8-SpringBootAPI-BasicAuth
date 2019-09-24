package com.stockmarket.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stockmarket.exception.RecordNotFoundException;
import com.stockmarket.model.Company;
import com.stockmarket.repository.CompanyRepository;

@Service
@Component       
public class CompanyDAO {

	@Autowired
	private CompanyRepository companyRepository;
	
	/* to get All Company List */
	public List<Company> getAllCompany()
    {
        List<Company> companyList = companyRepository.findAll();
         
        if(companyList.size() > 0) {
            return companyList;
        } else {
            return new ArrayList<Company>();
        }
    }
	
	public Company getCompanyById(Long id) throws RecordNotFoundException
    {
        Optional<Company> company = companyRepository.findById(id);
         
        if(company.isPresent()) {
            return company.get();
        } else {
            throw new RecordNotFoundException("No company record exist for given id");
        }
    }
	
	
	/*Create or Update Company */
	public Company createOrUpdateCompany(Company entity) throws RecordNotFoundException
    {
        Optional<Company> company = companyRepository.findById(entity.getId());
         
        if(company.isPresent())
        {
        	Company newEntity = company.get();
            newEntity.setCompanyname(entity.getCompanyname());
            newEntity.setTurnover(entity.getTurnover());
            newEntity.setCEO(entity.getCEO());
            newEntity.setBoardofdirec(entity.getBoardofdirec());
            newEntity.setListedinstock(entity.getCEO());
            newEntity.setSector(entity.getSector());
            newEntity.setAbout(entity.getAbout());
            newEntity.setStockcode(entity.getStockcode());
            newEntity = companyRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = companyRepository.save(entity);
             
            return entity;
        }
    }
	
	
	
	/* to save a Company*/
	
	public Company save(@Valid Company cmp) {
		// TODO Auto-generated method stub
		return companyRepository.save(cmp);
	}

	/* to Delete a Company by ID*/
	public void deleteCompanyById(Long id) throws RecordNotFoundException
    {
        Optional<Company> company = companyRepository.findById(id);
         
        if(company.isPresent())
        {
            companyRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No Company record exist for given id");
        }
    }
	

	
	

}
