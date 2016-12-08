package com.farias.models;

import com.farias.db.Impostos;
import com.farias.enums.RegimeTributario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClienteLucroPresumido extends Cliente {
    public ClienteLucroPresumido() {
        super(RegimeTributario.LUCRO_PRESUMIDO);
    }

    public List<Imposto> calcularImpostos() {
        List<Imposto> impostos = new ArrayList<Imposto>();
        for (ImpostoLucroPresumido tipoImposto : Impostos.getImpostosLucroPresumido()) {
            Imposto imposto = new Imposto();
            imposto.setCliente(this);
            imposto.setNotasFiscais(this.getNotasFiscais());
            BigDecimal valor = BigDecimal.ZERO;
            imposto.setTipo(tipoImposto.toString());
            for (NotaFiscal notaFiscal : getNotasFiscais()) {
                valor = valor.add(tipoImposto.getAliquota()
                        .multiply(notaFiscal.getValor()));
            }
            imposto.setValor(valor);
            impostos.add(imposto);
        }
        return impostos;
    }
}
