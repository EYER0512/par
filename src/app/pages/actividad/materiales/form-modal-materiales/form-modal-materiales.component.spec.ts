import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormModalMaterialesComponent } from './form-modal-materiales.component';

describe('FormModalMaterialesComponent', () => {
  let component: FormModalMaterialesComponent;
  let fixture: ComponentFixture<FormModalMaterialesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormModalMaterialesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormModalMaterialesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
