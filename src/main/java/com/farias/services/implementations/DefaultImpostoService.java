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

    public void calcularImpostos(Cliente cliente, String anoMes) {
        cliente.setNotasFiscais(notaFiscalDao.buscarPorPeriodo(cliente, DateUtil.criarPeriodoAnoMes(anoMes)));
        for (Imposto imposto : cliente.calcularImpostos()) {
            imposto.setDataReferencia(DateUtil.criarDataMesAno(anoMes));
            dao.save(imposto);
        }
    }

    public List<Imposto> buscarImpostos(Cliente cliente, Periodo periodo) {
        return dao.buscarPorPeriodo(cliente, periodo);
    }

}
