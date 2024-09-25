import { Component } from '@angular/core';
import { FindCustomerComponent } from './find-customer/find-customer.component';
import { ListCostumersComponent } from './list-costumers/list-costumers.component';
import { RegisterCostumerComponent } from './register-costumer/register-costumer.component';
import { MatFormFieldModule } from '@angular/material/form-field'; // Importar MatFormFieldModule
import { MatInputModule } from '@angular/material/input'; // Importar MatInputModule
import { MatTabsModule } from '@angular/material/tabs';


@Component({
  selector: 'DashboardComponent',
  standalone: true,
  imports: [
    FindCustomerComponent,
    ListCostumersComponent,
    RegisterCostumerComponent,
    MatFormFieldModule,
    MatInputModule,
    MatTabsModule
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

}
