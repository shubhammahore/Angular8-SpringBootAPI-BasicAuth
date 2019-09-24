import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Company } from 'src/app/model/company';
@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getCompanies() {
    return this.httpClient.get<any>('http://localhost:8080/company');
  }

  public deleteCompany(company) {

    return this.httpClient.delete<Company>("http://localhost:8080/company" + "/" + company.id);
  }

  public createCompany(company) {
    return this.httpClient.post<Company>("http://localhost:8080/company", company);
  }
}
