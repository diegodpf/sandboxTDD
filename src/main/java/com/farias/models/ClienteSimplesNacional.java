package com.farias.models;

import com.farias.enums.RegimeTributario;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ClienteSimplesNacional extends Cliente {
    public ClienteSimplesNacional() {
        super(RegimeTributario.SIMPLES_NACIONAL);
    }

    private List<Anexo> anexos;

    public List<Anexo> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<Anexo> anexos) {
        this.anexos = anexos;
    }

    public List<Imposto> calcularImpostos() {
        Imposto imposto = new Imposto();
        imposto.setCliente(this);
        imposto.setTipo("Simples Nacional");
        BigDecimal valor = BigDecimal.ZERO;
        for (NotaFiscal notaFiscal : this.getNotasFiscais()) {
            valor = valor.add(notaFiscal.getAnexo().getAliquota()
                    .multiply(notaFiscal.getValor())).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
        imposto.setValor(valor);
        return Arrays.asList(imposto);
    }
}
