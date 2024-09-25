import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCostumersComponent } from './list-costumers.component';

describe('ListCostumersComponent', () => {
  let component: ListCostumersComponent;
  let fixture: ComponentFixture<ListCostumersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListCostumersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListCostumersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
