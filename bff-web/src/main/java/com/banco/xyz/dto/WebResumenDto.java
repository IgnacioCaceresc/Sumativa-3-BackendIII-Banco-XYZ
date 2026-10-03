package com.banco.xyz.dto;

public class WebResumenDto {
    private String id;
    private String fecha;
    private Double monto;
    private String tipo;
    private Boolean requiereRevision;

    public WebResumenDto(String id, String fecha, Double monto, String tipo, Boolean requiereRevision) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.tipo = tipo;
        this.requiereRevision = requiereRevision;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Boolean getRequiereRevision() { return requiereRevision; }
    public void setRequiereRevision(Boolean requiereRevision) { this.requiereRevision = requiereRevision; }
}
