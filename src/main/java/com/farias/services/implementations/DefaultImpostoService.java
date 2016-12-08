package com.farias.services.implementations;

import com.farias.daos.contracts.ImpostoDao;
import com.farias.daos.contracts.NotaFiscalDao;
import com.farias.models.Cliente;
import com.farias.models.Imposto;
import com.farias.services.contracts.ImpostoService;
import com.farias.utils.DateUtil;
import com.farias.utils.Periodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DefaultImpostoService implements ImpostoService {

    @Autowired
    private ImpostoDao dao;

    @Autowired
    private NotaFiscalDao notaFiscalDao;

    public void setDao(ImpostoDao dao) {
        this.dao = dao;
    }

    public void setNotaFiscalDao(NotaFiscalDao dao) {
        this.notaFiscalDao = dao;
    }

    public List<Imposto> calcularImpostos(Cliente cliente, Periodo periodo) {
        cliente.setNotasFiscais(notaFiscalDao.buscarPorPeriodo(cliente, periodo));
        List<Imposto> impostos = new ArrayList<Imposto>();
        for (Imposto imposto : cliente.calcularImpostos()) {
            imposto.setDataReferencia(periodo.getInicio());
            dao.save(imposto);
            impostos.add(imposto);
        }
        return impostos;
    }

    public List<Imposto> buscarImpostos(Cliente cliente, Periodo periodo) {
        return dao.buscarPorPeriodo(cliente, periodo);
    }

}
