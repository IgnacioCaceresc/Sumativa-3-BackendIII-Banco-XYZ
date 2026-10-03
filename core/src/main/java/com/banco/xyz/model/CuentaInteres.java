package com.banco.xyz.model;

public class CuentaInteres {
    private String cuentaId;
    private String nombre;
    private Double saldo;
    private String edad;
    private String tipo;
    private Double saldoFinal;

    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Double getSaldo() { return saldo; }
    public void setSaldo(Double saldo) { this.saldo = saldo; }
    public String getEdad() { return edad; }
    public void setEdad(String edad) { this.edad = edad; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Double getSaldoFinal() { return saldoFinal; }
    public void setSaldoFinal(Double saldoFinal) { this.saldoFinal = saldoFinal; }

    @Override
    public String toString() {
        return "CuentaInteres{cuentaId='" + cuentaId + "'}";
    }
}
