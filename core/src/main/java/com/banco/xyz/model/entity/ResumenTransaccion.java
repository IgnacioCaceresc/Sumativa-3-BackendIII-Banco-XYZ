package com.banco.xyz.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "resumen_transacciones")
public class ResumenTransaccion {

    @Id
    private String id;

    private String fecha;
    private Double monto;
    private String tipo;
    
    @Column(name = "es_anomalia")
    private Boolean esAnomalia;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Boolean getEsAnomalia() { return esAnomalia; }
    public void setEsAnomalia(Boolean esAnomalia) { this.esAnomalia = esAnomalia; }
}
