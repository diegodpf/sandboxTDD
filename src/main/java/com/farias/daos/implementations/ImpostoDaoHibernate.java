package com.farias.daos.implementations;

import com.farias.daos.contracts.ImpostoDao;
import com.farias.models.Cliente;
import com.farias.models.Imposto;
import com.farias.utils.Periodo;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Repository
public class ImpostoDaoHibernate extends DaoHibernate<Imposto> implements ImpostoDao {
    ImpostoDaoHibernate() {
        super(Imposto.class);
    }

    public List<Imposto> buscarPorPeriodo(Cliente cliente, Periodo periodo) {
        CriteriaQuery<Imposto> criteria = builder.createQuery(persistedClass);
        Root root = criteria.from(persistedClass);
        criteria.where(builder.equal(root.get("cliente"), cliente),
                builder.between(root.<Date>get("dataReferencia"), periodo.getInicio(), periodo.getFim()));
        manager.createQuery(criteria).getResultList();
        return manager.createQuery(criteria).getResultList();
    }
}
