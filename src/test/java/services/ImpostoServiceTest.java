package services;

import com.farias.daos.contracts.ImpostoDao;
import com.farias.daos.contracts.NotaFiscalDao;
import com.farias.db.Impostos;
import com.farias.models.*;
import com.farias.services.contracts.ImpostoService;
import com.farias.services.implementations.DefaultImpostoService;
import com.farias.utils.DateUtil;
import com.farias.utils.Periodo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;

public class ImpostoServiceTest {

    private ImpostoService fixture;
    private ImpostoDao mockImpostoDao;
    private NotaFiscalDao mockNotaFiscalDao;

    private Periodo periodo;
    private NotaFiscal n1;
    private NotaFiscal n2;
    private NotaFiscal n3;
    private List<NotaFiscal> notasFiscais;

    @Before
    public void setUp() {
        fixture = new DefaultImpostoService();
        mockImpostoDao = createMock(ImpostoDao.class);
        mockNotaFiscalDao = createMock(NotaFiscalDao.class);
        fixture.setDao(mockImpostoDao);
        fixture.setNotaFiscalDao(mockNotaFiscalDao);

        periodo = DateUtil.criarPeriodoAnoMes("2016-01");
        n1 = new NotaFiscal();
        n1.setValor(new BigDecimal(10.50));
        n1.setAnexo(Impostos.getAnexo(2L));
        n2 = new NotaFiscal();
        n2.setValor(new BigDecimal(32.70));
        n2.setAnexo(Impostos.getAnexo(1L));
        n3 = new NotaFiscal();
        n3.setValor(new BigDecimal(68.45));
        n3.setAnexo(Impostos.getAnexo(3L));
        notasFiscais = new ArrayList<NotaFiscal>() {{
            add(n1);
            add(n2);
            add(n3);
        }};
    }

    @Test
    public void testeCriacaoImpostoSimplesNacional() {
        Cliente cliente = new ClienteSimplesNacional();

        expect(mockNotaFiscalDao.buscarPorPeriodo(cliente, periodo)).andReturn(notasFiscais);
        replay(mockNotaFiscalDao);

        List<Imposto> impostos = fixture.calcularImpostos(cliente, periodo);
        Assert.assertEquals(1, impostos.size());
        Imposto imposto = impostos.get(0);
        Assert.assertEquals(periodo.getInicio(), imposto.getDataReferencia());
        Assert.assertEquals(new BigDecimal(10.38).setScale(2, RoundingMode.HALF_EVEN),
                imposto.getValor());
    }

    @Test
    public void testeCriacaoImpostoLucroPresumido() {
        Cliente cliente = new ClienteLucroPresumido();

        expect(mockNotaFiscalDao.buscarPorPeriodo(cliente, periodo)).andReturn(notasFiscais);
        replay(mockNotaFiscalDao);

        List<Imposto> impostos = fixture.calcularImpostos(cliente, periodo);
        Assert.assertEquals(3, impostos.size());

        Assert.assertEquals(periodo.getInicio(), impostos.get(0).getDataReferencia());
        Assert.assertEquals(new BigDecimal(5.36).setScale(2, RoundingMode.HALF_EVEN),
                impostos.get(0).getValor());

        Assert.assertEquals(periodo.getInicio(), impostos.get(1).getDataReferencia());
        Assert.assertEquals(new BigDecimal(2.23).setScale(2, RoundingMode.HALF_EVEN),
                impostos.get(1).getValor());

        Assert.assertEquals(periodo.getInicio(), impostos.get(2).getDataReferencia());
        Assert.assertEquals(new BigDecimal(3.35).setScale(2, RoundingMode.HALF_EVEN),
                impostos.get(2).getValor());
    }

}
