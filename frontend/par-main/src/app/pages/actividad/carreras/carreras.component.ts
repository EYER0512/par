import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CarrerasService } from 'src/app/providers/services/carreras.service';
import Swal from 'sweetalert2';
import { FormModalCarreraComponent } from './form-modal-carrera/form-modal-carrera.component';

@Component({
  selector: 'app-carreras',
  templateUrl: './carreras.component.html',
  styleUrls: ['./carreras.component.css']
})
export class CarrerasComponent implements OnInit {

  carreras: any = [];
  constructor(private carreraService: CarrerasService,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getCarreras();
  }

  getCarreras(): void {
    this.carreraService.getAll$().subscribe(response => {
      this.carreras = response.data || [];
    });
  }

  openModal(): void {
    const modal = this.modalService.open(FormModalCarreraComponent, {
      size: 'lg',
      keyboard: false,
      backdrop: 'static'
    });
    modal.componentInstance.title = 'Modal';
    modal.result.then(res => {
      if(res.success) {
        /*
        Swal.fire({
          title: 'Carrera',
          text: `${res.message}`,
          icon: 'success',
          confirmButtonColor: '#7f264a',
          timer: 1500
        });*/
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Carrera',
          text: `${res.message}`,
          showConfirmButton: false,
          timer: 1500
        })
        this.getCarreras();
      }
    }).catch(err => {});
  }
  openModalEdit(item: any): any {
    const modal = this.modalService.open(FormModalCarreraComponent, {
      size: 'lg',
      keyboard: false,
      backdrop: 'static'
    });
    modal.componentInstance.caId = item.caId;
    modal.componentInstance.item = item;
    modal.componentInstance.title = 'Modificar';
    modal.result.then(res => {
      if (res.success) {
        this.getCarreras();
        Swal.fire({
          title: 'Editar',
          text: `${res.message}`,
          icon: 'success',
          confirmButtonColor: '#7f264a',
          timer: 1500
        });
      }
    }).catch(res =>{
    });
  }
  public onDelete(item: any): void {
    const ID = item.caId;
    const mensaje = '¿Desea eliminar? :' +' '+ item.caNombre;
    if (ID) {
      Swal.fire({
        title: 'Se eliminara el registro',
        text: `${mensaje}`,
        backdrop: true,
        showCloseButton: true,
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonColor: '#7f264a',
        confirmButtonText: 'Estoy de acuerdo!',
        cancelButtonText: 'Cancelar'
      }).then((result) => {
        if (result.value) {
          this.carreraService.delete$(ID).subscribe(data => {
            if (data.success) {
              Swal.fire({
                title: 'Eliminado',
                text: data.message,
                icon:'success',
                backdrop: true,
                //animation: true,
                showConfirmButton: false,
                confirmButtonColor: '#7f264a',
                timer: 1500,
              });
              this.getCarreras();
            }
          });
      }  });
  }
}
}
