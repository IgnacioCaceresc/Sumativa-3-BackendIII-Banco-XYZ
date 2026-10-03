package com.banco.xyz.dto;

public class AtmSaldoDto {
    private String cuentaId;
    private Double saldoDisponible;

    public AtmSaldoDto(String cuentaId, Double saldoDisponible) {
        this.cuentaId = cuentaId;
        this.saldoDisponible = saldoDisponible;
    }

    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }
    public Double getSaldoDisponible() { return saldoDisponible; }
    public void setSaldoDisponible(Double saldoDisponible) { this.saldoDisponible = saldoDisponible; }
}
