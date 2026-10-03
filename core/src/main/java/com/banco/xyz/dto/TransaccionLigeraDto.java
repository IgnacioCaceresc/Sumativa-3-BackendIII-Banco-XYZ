package com.banco.xyz.dto;

public class TransaccionLigeraDto {
    private String id;
    private Double monto;
    private String tipo;

    public TransaccionLigeraDto(String id, Double monto, String tipo) {
        this.id = id;
        this.monto = monto;
        this.tipo = tipo;
    }

    // Getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
