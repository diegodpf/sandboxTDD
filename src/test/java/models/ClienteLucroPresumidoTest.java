package models;

import com.farias.enums.RegimeTributario;
import com.farias.models.ClienteLucroPresumido;
import com.farias.models.Imposto;
import com.farias.models.NotaFiscal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ClienteLucroPresumidoTest {
    private ClienteLucroPresumido fixture;

    @Before
    public void setUp() {
        fixture = new ClienteLucroPresumido();
        NotaFiscal n1 = new NotaFiscal();
        n1.setValor(new BigDecimal(10.50));
        fixture.adicionarNotaFiscal(n1);
    }

    @Test
    public void testaRegimeTributario() {
        Assert.assertEquals(RegimeTributario.LUCRO_PRESUMIDO, fixture.getRegimeTributario());
    }

    @Test
    public void testaCalculoImpostoComUmaNotaFiscal() {
        List<Imposto> impostos = fixture.calcularImpostos();
        Assert.assertEquals(new BigDecimal(0.50).setScale(2, RoundingMode.HALF_EVEN),
                impostos.get(0).getValor());
        Assert.assertEquals(new BigDecimal(0.21).setScale(2, RoundingMode.HALF_EVEN),
                impostos.get(1).getValor());
        Assert.assertEquals(new BigDecimal(0.32).setScale(2, RoundingMode.HALF_EVEN),
                impostos.get(2).getValor());
    }

    @Test
    public void testaCalculoImpostoComVariasNotasFiscais() {
        NotaFiscal n2 = new NotaFiscal();
        n2.setValor(new BigDecimal(32.70));
        NotaFiscal n3 = new NotaFiscal();
        n3.setValor(new BigDecimal(68.45));
        fixture.adicionarNotaFiscal(n2);
        fixture.adicionarNotaFiscal(n3);
        List<Imposto> impostos = fixture.calcularImpostos();
        Assert.assertEquals(new BigDecimal(5.36).setScale(2, RoundingMode.HALF_EVEN),
                impostos.get(0).getValor());
        Assert.assertEquals(new BigDecimal(2.23).setScale(2, RoundingMode.HALF_EVEN),
                impostos.get(1).getValor());
        Assert.assertEquals(new BigDecimal(3.35).setScale(2, RoundingMode.HALF_EVEN),
                impostos.get(2).getValor());
    }

}
