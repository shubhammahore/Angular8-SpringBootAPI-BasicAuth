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

import com.stockmarket.dao.CompanyDAO;
import com.stockmarket.exception.RecordNotFoundException;
import com.stockmarket.model.AuthUser;
import com.stockmarket.model.Company;

@RestController
@CrossOrigin()
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	CompanyDAO companyDAO;

	/* Get All Company List */
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany() {
        List<Company> list = companyDAO.getAllCompany();
 
        return new ResponseEntity<List<Company>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public AuthUser validateLogin() {
    	System.out.println("Validating User");
		return new AuthUser("User successfully authenticated");
	}
    
	/* get a Company by id */ 
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	Company company = companyDAO.getCompanyById(id);
 
        return new ResponseEntity<Company>(company, new HttpHeaders(), HttpStatus.OK);
    }
	
    /* create Company */
    @PostMapping
    public ResponseEntity<Company> createOrUpdateCompany(@Valid @RequestBody Company company)
                                                    throws RecordNotFoundException {
    	Company updated = companyDAO.createOrUpdateCompany(company);
        return new ResponseEntity<Company>(updated, new HttpHeaders(), HttpStatus.OK);
    }
	

	

    @DeleteMapping("/{id}")
    public HttpStatus deleteCompanyById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	companyDAO.deleteCompanyById(id);
        return HttpStatus.OK;
    }
	
	
}
