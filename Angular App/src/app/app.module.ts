import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CollapseModule, BsDropdownModule } from 'ngx-bootstrap';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { BasicAuthHtppInterceptorService } from './services/basic-auth-htpp-interceptor.service';
import { AgGridModule } from 'ag-grid-angular';

import { HomeComponent } from './home/home.component';
import { CompanyComponent } from './pages/company/company.component';
import { SectorComponent } from './pages/sector/sector.component';
import { StockExchangeComponent } from './pages/stock-exchange/stock-exchange.component';
import { IposComponent } from './pages/ipos/ipos.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    LogoutComponent,
    HomeComponent,
    CompanyComponent,
    SectorComponent,
    StockExchangeComponent,
    IposComponent
  ],
  imports: [
    BrowserModule,FormsModule,CollapseModule.forRoot(), BsDropdownModule.forRoot(),
    AppRoutingModule,HttpClientModule,AgGridModule.withComponents([])
  ],
  providers: [{provide:HTTP_INTERCEPTORS, useClass:BasicAuthHtppInterceptorService, multi:true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
