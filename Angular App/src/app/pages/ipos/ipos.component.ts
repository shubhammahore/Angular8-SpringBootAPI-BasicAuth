import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ipos',
  templateUrl: './ipos.component.html',
  styleUrls: ['./ipos.component.css']
})
export class IposComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  columnDefs = [
    {headerName: 'Company  Name', field: 'companyname', sortable: true, filter: true,width: 100,editable: true},
    {headerName: 'Stock Exchange', field: 'stockexchange', sortable: true, filter: true,width: 100,editable: true},
    {headerName: 'Price', field: 'price', sortable: true, filter: true,width: 100,editable: true},
    {headerName: 'Totrl Share', field: 'totalshare', sortable: true, filter: true,width: 100,editable: true},
    {headerName: 'Opentime', field: 'opentime', sortable: true, filter: true,width: 100,editable: true},
    {headerName: 'Remarks', field: 'remarks', sortable: true, filter: true,width: 100,editable: true}
];
}
