import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatButtonModule} from '@angular/material/button';
import { DataService } from './service/data.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { error } from 'console';

@Component({
  selector: 'app-register-costumer',
  standalone: true,
  imports: [
    MatSlideToggleModule,
    FormsModule, 
    MatFormFieldModule, 
    MatInputModule,
    MatButtonModule
  ],
  templateUrl: './register-costumer.component.html',
  styleUrl: './register-costumer.component.scss'
})
export class RegisterCostumerComponent {

  private _snackBar = inject(MatSnackBar);
  
  constructor(private dataService: DataService) { }
  registrationId: string | undefined;
  data = {
    socialReason: '',
    fantasyName: '',
    document: '',
    phone: '',
    isActive: true
  };

  openSnackBar(message: string, action: string ){
    this._snackBar.open(message, action);
  }
  
  onSubmit() {
    this.dataService.send(this.data).subscribe(
      response => {
        this.openSnackBar(response.message, "fechar")
        this.registrationId = response.id
      }, error => {
        console.log(error)
      }
    )
  }
}
