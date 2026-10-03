package com.banco.xyz.model;

public class TransaccionDiaria {
    private String id;
    private String fecha;
    private Double monto;
    private String tipo;
    private Boolean esAnomalia = false;

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
    
    @Override
    public String toString() {
        return "TransaccionDiaria{id='" + id + "'}";
    }
}
