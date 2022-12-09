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
 * @author etham
 */

@Entity
@Data
@Table(name = "persona")
public class Persona {
    
    @Id
    @Column(name = "pe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long peId;
    
    @Column(name = "pe_dni")
    private int peDNI;
    
    @Column(name = "pe_nombres")
    private String peNombres;
    
    @Column(name = "pe_apellido_p")
    private String peApellidoP;
    
    @Column(name = "pe_apellido_m")
    private String peApellidoM;
    
    @Column (name = "pe_fono")
    private int peFono;    
    
    @ManyToOne
    @JoinColumn(name = "tp_id")
    private TipoPersona tipoPersona;
    
    @ManyToOne
    @JoinColumn(name = "ca_id")
    private Carrera carrera;
    
}
