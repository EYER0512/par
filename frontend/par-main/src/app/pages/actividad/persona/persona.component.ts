import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PersonaService } from 'src/app/providers/services/persona.service';
import Swal from 'sweetalert2';
import { FormModalPersonaComponent } from './form-modal-persona/form-modal-persona.component';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css']
})
export class PersonaComponent implements OnInit {

  personas: any =[];
  constructor(private personaService: PersonaService,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getPersona();
  }

  getPersona(): void {
    this.personaService.getAll$().subscribe(response => {
      this.personas = response.data || [];
    });
  }

  openModal(): void {
    const modal = this.modalService.open(FormModalPersonaComponent, {
      size: 'lg',
      keyboard: false,
      backdrop: 'static'
    });
    modal.componentInstance.title = 'Nuevo';
    modal.result.then(res => {
      if(res.success) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Taller',
          text: `${res.message}`,
          showConfirmButton: false,
          timer: 1500
        })
        this.getPersona();
      }
    })
  }
  openModalEdit(item: any): any {
    const modal = this.modalService.open(FormModalPersonaComponent, {
      size: 'lg',
      keyboard: false,
      backdrop: 'static'
    });
    modal.componentInstance.taId = item.peId;
    modal.componentInstance.item = item;
    modal.componentInstance.title = 'Modificar';
    modal.result.then(res => {
      if (res.success) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Taller',
          text: `${res.message}`,
          showConfirmButton: false,
          timer: 1300
        });
        this.getPersona();
      }
    });
  }
  public onDelete(item: any): void {
    const ID = item.peId;
    const mensaje = '¿ Desea eliminar? : ' + ' ' + item.peNombres;
    if (ID) {
      Swal.fire({
        title: 'Se eliminará el registro',
        text: `${mensaje}`,
        backdrop: true,
        //animation: true,
        showCloseButton: true,
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonColor: '#7f264a',
        confirmButtonText: 'Estoy de acuerdo!',
        cancelButtonText: 'Cancelar'
      }).then((result) => {
        if (result.value) {
          this.personaService.delete$(ID).subscribe(data => {
            if (data.success) {
              Swal.fire({
                title: 'Eliminado',
                text: data.message,
                backdrop: true,
                //animation: true,
                showConfirmButton: false,
                confirmButtonColor: '#7f264a',
                timer: 1500,
              });
              this.getPersona();
            }
          });
        }
      });
    }
  }

}
