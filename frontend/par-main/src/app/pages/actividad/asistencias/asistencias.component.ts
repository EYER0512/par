import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AsistenciasService } from 'src/app/providers/services/asistencias.service';
import Swal from 'sweetalert2';
import { FormModalAsistenciasComponent } from './form-modal-asistencias/form-modal-asistencias.component';

@Component({
  selector: 'app-asistencias',
  templateUrl: './asistencias.component.html',
  styleUrls: ['./asistencias.component.css']
})
export class AsistenciasComponent implements OnInit {

  asistencias: any = [];
  constructor(private asistenciasService: AsistenciasService,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getAsistencias();
  }

  getAsistencias(): void {
    this.asistenciasService.getAll$().subscribe(response =>{
      this.asistencias = response.data || [];
    });
  }

  openModal(): void {
    const modal = this.modalService.open(FormModalAsistenciasComponent, {
      size: 'lg',
      keyboard: false,
      backdrop: 'static'
    });
    modal.componentInstance.title = 'Registro';
    modal.result.then(res => {
      if(res.success) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Asistencia',
          text: `${res.message}`,
          showConfirmButton: false,
          timer: 1500
        })
        this.getAsistencias();
      }
    }).catch(err => {});
  }

  openModalEdit(item: any): any {
    const modal = this.modalService.open(FormModalAsistenciasComponent, {
      size: 'lg',
      keyboard: false,
      backdrop: 'static'
    });
    modal.componentInstance.asId = item.asId;
    modal.componentInstance.item = item;
    modal.componentInstance.title = 'Modificar';
    modal.result.then(res => {
      if (res.success) {
        this.getAsistencias();
        Swal.fire({
          title: 'Editar',
          text: `${res.message}`,
          icon: 'success',
          confirmButtonColor: '#7f264a',
          timer: 1500
        });
      }
    }).catch(res => {
    });
  }

  public onDelete(item: any): void {
    const ID = item.asId;
    const mensaje = '¿ Desea eliminar? : ' + ' ' + item.asistencias.asEstado;
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
          this.asistenciasService.delete$(ID).subscribe(data => {
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
              this.getAsistencias();
            }
          });
        }
      });
    }
  }

}
