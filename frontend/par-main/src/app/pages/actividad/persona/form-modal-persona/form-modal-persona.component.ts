import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { CarrerasService } from 'src/app/providers/services/carreras.service';
import { PersonaService } from 'src/app/providers/services/persona.service';
import { TipoPersonaService } from 'src/app/providers/services/tipo-persona.service';

@Component({
  selector: 'app-form-modal-persona',
  templateUrl: './form-modal-persona.component.html',
  styleUrls: ['./form-modal-persona.component.css']
})
export class FormModalPersonaComponent implements OnInit {

  @Input() title: any;
  @Input() peId: any;
  @Input() item: any;

  frmPersona!: FormGroup;
  carreras: any = [];
  tipopersona: any = [];
  constructor( public activeModal: NgbActiveModal,
               private formBuilder: FormBuilder,
               private personaService: PersonaService,
               private carrerasService: CarrerasService,
               private tipopersonaService: TipoPersonaService
               ) { }

  Id = document.getElementById('id');

  ngOnInit(): void {
    this.formInit();
    this.getCarreras();
    this.getTipoPersona();
    if(this.item){
      this.updateData()
    }
    console.log(this.item);
  }

  getCarreras(): void {
    this.carrerasService.getAll$().subscribe(response => {
      this.carreras = response.data || [];
    })
  }

  getTipoPersona(): void {
    this.tipopersonaService.getAll$().subscribe(response => {
      this.tipopersona = response.data ||[];
    })
  }

  formInit(): void {
    const controls = {
      peNombres: ['', [Validators.required]],
      peDNI: ['', [Validators.required]],
      peApellidoP: ['', [Validators.required]],
      peApellidoM: ['', [Validators.required]],
      peFono: ['', [Validators.required]],
      tpId: ['',[Validators.required]],
      caId: ['', [Validators.required]],
    };
    this.frmPersona=this.formBuilder.group(controls);
  }

  save(): void {
    let data = Object.assign(this.frmPersona.value, {carrera: {caId: this.frmPersona.value.caId}, tipoPersona:{tpId: this.frmPersona.value.tpId}});
    this.personaService.add$(data).subscribe(response => {
      if (response.success) {
        this.activeModal.close({success: true, message:response.message});
      }
    })
  }

  update(): void{
    let data = Object.assign(this.frmPersona.value, {carrera: {caId: this.frmPersona.value.caId}, tipoPersona:{tpId: this.frmPersona.value.tpId}});
    this.personaService.update$(this.peId, data).subscribe(response => {
      if (response.success) {
        this.activeModal.close({success: true, message:response.message});
      }
    })
  }

  updateData(): void{
    let  data = Object.assign(this.item, { tpId: this.item.tipoPersona.tpId, caId: this.item.carrera.caId});
    this.frmPersona.patchValue(data);
  }

}
