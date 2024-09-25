import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router'; 
import {provideHttpClient, withFetch } from '@angular/common/http';
import { MatTabsModule } from '@angular/material/tabs'; 
import { FindCustomerComponent } from './dashboard/find-customer/find-customer.component';
import { ListCostumersComponent } from './dashboard/list-costumers/list-costumers.component';
import { RegisterCostumerComponent } from './dashboard/register-costumer/register-costumer.component';

@NgModule({

  imports: [
    BrowserModule,
    RouterModule.forRoot([]),   
    MatTabsModule,
    FindCustomerComponent,
    ListCostumersComponent,
    RegisterCostumerComponent,
  ],
  providers: [provideHttpClient(withFetch())],
  bootstrap: []
})
export class AppModule { }
