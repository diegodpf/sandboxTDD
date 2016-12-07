package com.farias.enums;

public enum RegimeTributario {
    SIMPLES_NACIONAL("Simples Nacional"),
    LUCRO_PRESUMIDO("Lucro Presumido");

    private String nome;

    RegimeTributario(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
