import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { CarrerasService } from 'src/app/providers/services/carreras.service';

@Component({
  selector: 'app-form-modal-carrera',
  templateUrl: './form-modal-carrera.component.html',
  styleUrls: ['./form-modal-carrera.component.css']
})
export class FormModalCarreraComponent implements OnInit {

  @Input() title: any;
  @Input() caId: any;
  @Input() item: any;

  frmCarrera!: FormGroup;
  constructor( public activeModal: NgbActiveModal,
                private formBuilder: FormBuilder,
                private carreaService: CarrerasService
                ) { }

  ngOnInit(): void {
    this.formInit();
    if(this.item){
      this.updateData()
    }
    console.log(this.item);
  }

  formInit(): void {
    const controls = {
      caNombre: [''],
      caFacu: ['']
    };
    this.frmCarrera= this.formBuilder.group(controls);
  }

  save(): void {
    this.carreaService.add$(this.frmCarrera.value).subscribe(response => {
      if(response.success) {
        this.activeModal.close({success: true, message: response.message});
      }
    });
  }

  update(): void {
    this.carreaService.update$(this.caId, this.frmCarrera.value).subscribe(response => {
      if(response.success) {
        this.activeModal.close({success: true, message: response.message});
      }
    });
  }
  updateData(): void {
    this.frmCarrera.patchValue(this.item);
  }
}
