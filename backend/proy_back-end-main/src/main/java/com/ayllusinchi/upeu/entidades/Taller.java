package com.ayllusinchi.upeu.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author etham
 */

@Entity
@Data
@Table(name = "taller")
public class Taller {
    
    @Id
    @Column(name = "ta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taId;
    
    @Column(name = "ta_tema")
    private String taTema;
    
    @Column(name = "ta_desc")
    private String taDesc;
    
    @Column(name = "ta_fecha")
    private String taFecha;
    
    @Column(name = "ta_hora")
    private String taHora;
    
    @Column(name = "ta_hora_academicas")
    private String taHoraAcademicas;
    
    @Column (name = "ta_lugar")
    private String taLugar;
    
    @ManyToOne
    @JoinColumn(name = "pro_id")
    private Programa programa;
    
}
