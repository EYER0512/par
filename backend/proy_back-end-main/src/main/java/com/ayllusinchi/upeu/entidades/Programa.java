    package com.ayllusinchi.upeu.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author etham
 */

@Entity
@Data
@Table(name = "programa")
public class Programa {
    
    @Id
    @Column(name = "pro_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proId;
    
    @Column(name = "pro_nombre")
    private String proNombre;
    
    @Column (name = "pro_desc")
    private String proDescripcion;

}
