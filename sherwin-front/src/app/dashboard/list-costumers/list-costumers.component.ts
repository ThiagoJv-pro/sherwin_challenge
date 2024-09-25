import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';  
import { DataService } from './service/data.service';

@Component({
  selector: 'app-list-costumers',
  standalone: true,
  imports: [
    CommonModule,  
    MatSlideToggleModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  templateUrl: './list-costumers.component.html',
  styleUrls: ['./list-costumers.component.scss']
})
export class ListCostumersComponent {
  constructor(private dataService: DataService) {}

  customers: any[] = [];

  onSubmit() {
    this.dataService.requestAll().subscribe(
      (response: any[]) => {
        this.customers = response;
        console.log('Clientes recebidos:', this.customers);
      },
      error => {
        console.error('Erro ao buscar clientes:', error);
      }
    );
  }
}
