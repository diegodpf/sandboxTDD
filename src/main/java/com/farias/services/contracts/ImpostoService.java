package com.farias.services.contracts;

import com.farias.daos.contracts.ImpostoDao;
import com.farias.daos.contracts.NotaFiscalDao;
import com.farias.models.Cliente;
import com.farias.models.Imposto;
import com.farias.utils.Periodo;

import java.util.List;

public interface ImpostoService {

    void setDao(ImpostoDao dao);
    List<Imposto> calcularImpostos(Cliente cliente, Periodo periodo);
    List<Imposto> buscarImpostos(Cliente cliente, Periodo periodo);
    public void setNotaFiscalDao(NotaFiscalDao dao);

}
