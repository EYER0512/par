import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormModalPersonaComponent } from './form-modal-persona.component';

describe('FormModalPersonaComponent', () => {
  let component: FormModalPersonaComponent;
  let fixture: ComponentFixture<FormModalPersonaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormModalPersonaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormModalPersonaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
