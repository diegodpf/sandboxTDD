package services;

import com.farias.daos.contracts.ImpostoDao;
import com.farias.models.Cliente;
import com.farias.models.ClienteSimplesNacional;
import com.farias.models.Imposto;
import com.farias.services.contracts.ImpostoService;
import com.farias.services.implementations.DefaultImpostoService;
import com.farias.utils.DateUtil;
import com.farias.utils.Periodo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;

public class ImpostoServiceTest {

    private ImpostoService fixture;
    private ImpostoDao mockImpostoDao;

    @Before
    public void setUp() {
        fixture = new DefaultImpostoService();
        mockImpostoDao = createMock(ImpostoDao.class);
        fixture.setDao(mockImpostoDao);
    }

    @Test
    public void testeCriacaoImposto() {
        Cliente cliente = new ClienteSimplesNacional();
        String anoMes = "2016-01";
        Periodo periodo = DateUtil.criarPeriodoAnoMes(anoMes);
        List<Imposto> impostos = new ArrayList<Imposto>() {{ add(new Imposto()); }};
        expect(mockImpostoDao.buscarPorPeriodo(cliente, periodo)).andReturn(impostos);
        replay(mockImpostoDao);
        Assert.assertEquals(impostos, fixture.buscarImpostos(cliente, periodo));
    }

}
