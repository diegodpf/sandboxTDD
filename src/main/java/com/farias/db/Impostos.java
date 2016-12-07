package com.farias.db;

import com.farias.models.Anexo;
import com.farias.models.ImpostoLucroPresumido;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Impostos {

    private static Map<Long, Anexo> anexos = new HashMap<Long, Anexo>() {{
        put(1L, new Anexo("Comércio", new BigDecimal(0.06).setScale(3, RoundingMode.HALF_EVEN)));
        put(2L, new Anexo("Indústria", new BigDecimal(0.085).setScale(3, RoundingMode.HALF_EVEN)));
        put(3L, new Anexo("Prestação de Serviços", new BigDecimal(0.11).setScale(3, RoundingMode.HALF_EVEN)));
    }};

    private static Map<Long, ImpostoLucroPresumido> impostosLucroPresumido = new HashMap<Long, ImpostoLucroPresumido>() {{
        put(1L, new ImpostoLucroPresumido("Imposto de Renda", new BigDecimal(0.048).setScale(3, RoundingMode.HALF_EVEN)));
        put(2L, new ImpostoLucroPresumido("ISS", new BigDecimal(0.02).setScale(3, RoundingMode.HALF_EVEN)));
        put(3L, new ImpostoLucroPresumido("Cofins", new BigDecimal(0.03).setScale(3, RoundingMode.HALF_EVEN)));
    }};

    public static Anexo getAnexo(Long id) {
        return anexos.get(id);
    }

    public static ImpostoLucroPresumido getImpostoLucroPresumido(Long id) {
        return impostosLucroPresumido.get(id);
    }

    public static List<ImpostoLucroPresumido> getImpostosLucroPresumido() {
        List<ImpostoLucroPresumido> listaImpostos = new ArrayList<ImpostoLucroPresumido>();
        for (Map.Entry<Long, ImpostoLucroPresumido> impostoLucroPresumido : impostosLucroPresumido.entrySet()) {
            listaImpostos.add(impostoLucroPresumido.getValue());
        }
        return listaImpostos;
    }

}
