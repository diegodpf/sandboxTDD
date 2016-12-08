package com.farias.models;

import com.farias.enums.RegimeTributario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Cliente extends Entidade {

    private String nome;
    private RegimeTributario regimeTributario;
    private List<NotaFiscal> notasFiscais = new ArrayList<NotaFiscal>();

    public Cliente(RegimeTributario regimeTributario) {
        this.regimeTributario = regimeTributario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RegimeTributario getRegimeTributario() {
        return regimeTributario;
    }

    public List<NotaFiscal> getNotasFiscais() {
        return Collections.unmodifiableList(notasFiscais);
    }

    public void setNotasFiscais(List<NotaFiscal> notasFiscais) {
        this.notasFiscais = notasFiscais;
    }

    public void adicionarNotaFiscal(NotaFiscal notaFiscal) {
        notasFiscais.add(notaFiscal);
    }

    public abstract List<Imposto> calcularImpostos();
}
