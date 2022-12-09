import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { MaterialesService } from 'src/app/providers/services/materiales.service';
import { TallerService } from 'src/app/providers/services/taller.service';

@Component({
  selector: 'app-form-modal-materiales',
  templateUrl: './form-modal-materiales.component.html',
  styleUrls: ['./form-modal-materiales.component.css']
})
export class FormModalMaterialesComponent implements OnInit {

  @Input() title: any;
  @Input() maId: any;
  @Input() item: any;

  frmMateriales!: FormGroup;
  talleres: any = [];
  constructor(
    public activeModal: NgbActiveModal,
    private formBuilder: FormBuilder,
    private materialesService: MaterialesService,
    private tallerService: TallerService
  ) { }

  Id = document.getElementById('id');

  ngOnInit(): void {
    this.formInit();
    this.getTalleres();
    if(this.item){
      this.updateData();
    }
  }

  getTalleres(): void {
    this.tallerService.getAll$().subscribe(response => {
      this.talleres = response.data || [];
    });
  }

  formInit(): void {
    const controls = {
      taId: ['',[Validators.required]],
      malink: ['',[Validators.required]],
    }
    this.frmMateriales= this.formBuilder.group(controls);
  }

  save(): void {
    let data = Object.assign(this.frmMateriales.value, {talleres: {taId: this.frmMateriales.value.taId}});
    this.tallerService.update$(this.maId, data).subscribe(response => {
      if (response.success) {
        this.activeModal.close({success: true, message:response.message});
      }
    });
  }

  update(): void{
    let data = Object.assign(this.frmMateriales.value, {talleres: {taId: this.frmMateriales.value.taId}});
    this.tallerService.update$(this.maId, data).subscribe(response => {
      if (response.success) {
        this.activeModal.close({success: true, message:response.message});
      }
    });
  }

  updateData(): void {
    let data = Object.assign(this.frmMateriales.value, {talleres: {taId: this.frmMateriales.value.taId}});
    this.frmMateriales.patchValue(data);
  }

}
