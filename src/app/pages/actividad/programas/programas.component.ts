import { Component, OnInit } from '@angular/core';
import {ProgramaService} from "../../../providers/services/programa.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {FormModalComponent} from "./form-modal/form-modal.component";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-programas',
  templateUrl: './programas.component.html',
  styleUrls: ['./programas.component.css']
})
export class ProgramasComponent implements OnInit {

  programas: any = [];
  constructor(private programaService: ProgramaService,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getProgramas();
  }

  getProgramas(): void {
    this.programaService.getAll$().subscribe(response => {
      this.programas = response.data || [];
    });
  }

  openModal(): void {
    const modal = this.modalService.open(FormModalComponent, {
      size: 'lg',
      keyboard: false,
      backdrop: 'static'
    });
    modal.componentInstance.title = 'Nuevo';
    modal.result.then(res => {
      if(res.success) {
        /*
        Swal.fire({
          title: 'Programa',
          text: `${res.message}`,
          icon: 'success',
          confirmButtonColor: '#7f264a',
          timer: 1500
        });*/
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Programa',
          text: `${res.message}`,
          showConfirmButton: false,
          timer: 1500
        })
        this.getProgramas();
      }
    }).catch(err => {});
  }
  openModalEdit(item: any): any {
    const modal = this.modalService.open(FormModalComponent, {
      size: 'lg',
      keyboard: false,
      backdrop: 'static'
    });
    modal.componentInstance.proId = item.proId;
    modal.componentInstance.item = item;
    modal.componentInstance.title = 'Modificar';
    modal.result.then(res => {
      if (res.success) {
        this.getProgramas();
        //swal.fire('Empleado',`${res.message}`, 'success')
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
    const ID = item.proId;
    const mensaje = '¿ Desea eliminar? : ' + ' ' + item.proNombre;
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
          this.programaService.delete$(ID).subscribe(data => {
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
              this.getProgramas();
            }
          });
        }
      });
    }
  }


}
