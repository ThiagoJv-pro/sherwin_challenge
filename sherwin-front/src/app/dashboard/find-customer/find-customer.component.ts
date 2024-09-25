import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatButtonModule } from '@angular/material/button';
import { DataService } from './service/data.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-find-customer',
  standalone: true,
  imports: [
    MatSlideToggleModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    CommonModule,
  ],
  templateUrl: './find-customer.component.html',
  styleUrls: ['./find-customer.component.scss']
})
export class FindCustomerComponent {
  constructor(private dataService: DataService) { }

  document: string = '';
  responseData: any;
  isDocument: boolean = true; 

  toggle(): void {
    this.isDocument = !this.isDocument; // Alterna entre CNPJ e ID
  }

  formatResponse(response: any): string {
      return JSON.stringify(response, null, 2);
  }

  onSubmit(): void {
    if (this.isDocument) {
      // Busca por CNPJ
      this.dataService.requestByDocument(this.document).subscribe(
        response => {
          this.responseData = response;
        },
        error => {
          console.error('Erro ao buscar por CNPJ:', error);
        }
      );
    } else {
      // Busca por ID
      this.dataService.requestById(this.document).subscribe(
        response => {
          this.responseData = response;
        },
        error => {
          console.error('Erro ao buscar por ID:', error);
        }
      );
    }
  }
}
