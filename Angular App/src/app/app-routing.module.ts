import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdService } from './services/auth-gaurd.service';
import { HomeComponent } from './home/home.component';
import { CompanyComponent } from './pages/company/company.component';
const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent,canActivate:[AuthGaurdService] },
  
  { path: 'home', component: HomeComponent,canActivate:[AuthGaurdService] },
  
  { path: 'company', component: CompanyComponent,canActivate:[AuthGaurdService] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
