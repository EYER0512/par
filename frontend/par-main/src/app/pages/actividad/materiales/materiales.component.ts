import { Component, OnInit } from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {MaterialesService} from "../../../providers/services/materiales.service";
import Swal from "sweetalert2";
import {FormModalMaterialesComponent} from "./form-modal-materiales/form-modal-materiales.component";


@Component({
  selector: 'app-materiales',
  templateUrl: './materiales.component.html',
  styleUrls: ['./materiales.component.css']
})
export class MaterialesComponent implements OnInit {

  materiales: any=[];
  constructor(private materialesService: MaterialesService,
              private modalService: NgbModal) { }

  ngOnInit(): void {

  }
  filtro(){
this.getMateriales(this.materiales);
  }
  getMateriales(item: any): any {

    this.materialesService.getAll$().subscribe(response => {
      this.materiales = response.data || [];})
  }

  openModal(): void {
    const modal = this.modalService.open(FormModalMaterialesComponent, {
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
          title: 'Materiales',
          text: `${res.message}`,
          showConfirmButton: false,
          timer: 1500
        })
        this.getMateriales(this.materiales);
      }
    })
  }

    openModalEdit(item: any): any {
      const modal = this.modalService.open(FormModalMaterialesComponent, {
        size: 'lg',
        keyboard: false,
        backdrop: 'static'
      });
      modal.componentInstance.taId = item.maId;
      modal.componentInstance.item = item;
      modal.componentInstance.title = 'Modificar';
      modal.result.then(res => {
        if (res.success) {
          Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Material',
            text: `${res.message}`,
            showConfirmButton: false,
            timer: 1300
          });
          this.getMateriales(this.materiales);
        }
      });
    }
    public onDelete(item: any): void {
      const ID = item.taId;
      const mensaje = '¿ Desea eliminar? : ' + ' ' + item.taTema;
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
            this.materialesService.delete$(ID).subscribe(data => {
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
                this.getMateriales(this.materiales);
              }
            });
          }
        });
      }
    }

  }


