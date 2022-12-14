/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayllusinchi.upeu.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author yrenz
 */
@Entity
@Data
@Table(name = "Asistencias")
public class Asistencias {
    
    @Id
    @Column(name = "as_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asId;
    
    @Column(name = "as_Estado")
    private String asEstado;
    
    @ManyToOne
    @JoinColumn( name = "pe_Id")
    private Persona persona;
    
    @ManyToOne
    @JoinColumn (name = "ta_Id")
    private Taller taller;

    public void setCaId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
