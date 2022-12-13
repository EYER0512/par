import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AsistenciasService } from 'src/app/providers/services/asistencias.service';
import { PersonaService } from 'src/app/providers/services/persona.service';
import { TallerService } from 'src/app/providers/services/taller.service';

@Component({
  selector: 'app-form-modal-asistencias',
  templateUrl: './form-modal-asistencias.component.html',
  styleUrls: ['./form-modal-asistencias.component.css']
})
export class FormModalAsistenciasComponent implements OnInit {

  @Input() title: any;
  @Input() asId: any;
  @Input() item: any;

  frmAsistencia!: FormGroup;
  talleres: any = [];
  personas: any = [];
  constructor( public activeModal: NgbActiveModal,
               private formBuilder: FormBuilder,
               private personaService: PersonaService,
               private asistenciasService: AsistenciasService,
               private tallerService: TallerService) { }

  ngOnInit(): void {
    this.formInit();
    this.getTalleres();
    this.getPersonas();
    if(this.item){
      this.updateData()
    }
    console.log(this.item);
  }

  getTalleres(): void {
    this.tallerService.getAll$().subscribe(response => {
      this.talleres = response.data || [];
    })
  }

  getPersonas(): void {
    this.personaService.getAll$().subscribe(response => {
      this.personas = response.data || [];
    })
  }

  formInit(): void {
    const controls = {
      asEstado: ['', [Validators.required]],
      peId: ['', [Validators.required]],
      taId: ['', [Validators.required]],

    };
    this.frmAsistencia=this.formBuilder.group(controls);
  }

  save(): void {
    let data = Object.assign(this.frmAsistencia.value, {persona: {peId: this.frmAsistencia.value.peId}, taller: {taId: this.frmAsistencia.value.taId}});
    this.asistenciasService.add$(data).subscribe(response =>{
      if(response.success) {
        this.activeModal.close({success: true, message:response.message});
      }
    })
  }

  update(): void{
    let data = Object.assign(this.frmAsistencia.value, {persona: {peId: this.frmAsistencia.value.peId}, taller: {taId: this.frmAsistencia.value.taId}});
    this.asistenciasService.update$(this.asId, data).subscribe(response => {
      if (response.success) {
        this.activeModal.close({success: true, message:response.message});
      }
    })
  }

  updateData(): void{
    let  data = Object.assign(this.item, { peId: this.item.persona.peId, taId: this.item.taller.taId});
    this.frmAsistencia.patchValue(data);
  }

}
