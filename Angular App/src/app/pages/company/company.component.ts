import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {
  getCompanyList:boolean=false;
  rowData:any;

  constructor(private companyService:CompanyService) {
    
   }

   onClickSubmit(){
    this.rowData=this.companyService.getCompanies()
    this.getCompanyList=true;
   
   }

   OnRegister(postData){
     this.companyService.createCompany(postData)
    .subscribe(posts=>{
      console.log(posts);
      console.log("Registered Success");
     
      this.onClickSubmit()
      alert("Registered Success")
      this.ngOnInit();
    })
  }
  ngOnInit() {  
  }

  columnDefs = [
    {headerName: 'Company  Name', field: 'companyname', sortable: true, filter: true,width: 100,editable: true},
    {headerName: 'Turn Over', field: 'turnover', sortable: true, filter: true,width: 100,editable: true},
    {headerName: 'Board of director', field: 'boardofdirec', sortable: true, filter: true,width: 100,editable: true},
    {headerName: 'Listed in stock', field: 'listedinstock', sortable: true, filter: true,width: 100,editable: true},
    {headerName: 'Sector', field: 'sector', sortable: true, filter: true,width: 100,editable: true},
    {headerName: 'About', field: 'about', sortable: true, filter: true,width: 100,editable: true},
    {headerName: 'Stockcode', field: 'stockcode', sortable: true, filter: true,width: 100,editable: true},
    {headerName: 'CEO', field: 'ceo', sortable: true, filter: true,width: 100,editable: true},
];

}
