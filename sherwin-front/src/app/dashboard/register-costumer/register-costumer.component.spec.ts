import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterCostumerComponent } from './register-costumer.component';

describe('RegisterCostumerComponent', () => {
  let component: RegisterCostumerComponent;
  let fixture: ComponentFixture<RegisterCostumerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegisterCostumerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterCostumerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
