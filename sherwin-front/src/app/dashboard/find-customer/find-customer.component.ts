import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatButtonModule } from '@angular/material/button';
import { DataService } from './service/data.service';
import { CommonModule } from '@angular/common';
import {MatListModule} from '@angular/material/list';
import {MatIconModule} from '@angular/material/icon';
import {MatTableModule} from '@angular/material/table';
import {MatSnackBar} from '@angular/material/snack-bar';



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
    MatListModule,
    MatIconModule,
    MatTableModule
  ],
  templateUrl: './find-customer.component.html',
  styleUrls: ['./find-customer.component.scss']
})
export class FindCustomerComponent {
  constructor(private dataService: DataService) { }

  private _snackBar = inject(MatSnackBar);
  document: string = '';
  responseData: any;
  isDocument: boolean = true; 



  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action);
  }

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
          this.openSnackBar(error.error, "fechar");
        }
      );
    } else {
      // Busca por ID
      this.dataService.requestById(this.document).subscribe(
        response => {
          this.responseData = response;
        },
        error => {
          this.openSnackBar(error.error, "fechar");
        }
      );
    }
  }
}
