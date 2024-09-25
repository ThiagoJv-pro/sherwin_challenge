import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatButtonModule} from '@angular/material/button';
import { DataService } from './service/data.service';

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

  constructor(private dataService: DataService) { }
  registrationId: string | undefined;
  data = {
    socialReason: '',
    fantasyName: '',
    document: '',
    phone: '',
    isActive: true
  };

  onSubmit() {
    this.dataService.send(this.data).subscribe(
      response => (
        this.registrationId = response.id
      )
    )
  }
}
