package models;

import com.farias.db.Impostos;
import com.farias.enums.RegimeTributario;
import com.farias.models.Anexo;
import com.farias.models.ClienteSimplesNacional;
import com.farias.models.Imposto;
import com.farias.models.NotaFiscal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ClienteSimplesNacionalTest {
    private ClienteSimplesNacional fixture;

    @Before
    public void setUp() {
        fixture = new ClienteSimplesNacional();
        NotaFiscal n1 = new NotaFiscal();
        n1.setValor(new BigDecimal(10.50));
        n1.setAnexo(Impostos.getAnexo(2L));
        fixture.adicionarNotaFiscal(n1);
    }

    @Test
    public void testaRegimeTributario() {
        Assert.assertEquals(RegimeTributario.SIMPLES_NACIONAL, fixture.getRegimeTributario());
    }

    @Test
    public void testaAnexos() {
        List<Anexo> anexos = new ArrayList<Anexo>();
        anexos.add(Impostos.getAnexo(1L));
        anexos.add(Impostos.getAnexo(3L));
        fixture.setAnexos(anexos);
        Assert.assertEquals(Impostos.getAnexo(1L), fixture.getAnexos().get(0));
        Assert.assertEquals(Impostos.getAnexo(3L), fixture.getAnexos().get(1));
    }

    @Test
    public void testaDescricaoTipoImposto() {
        List<Imposto> impostos = fixture.calcularImpostos();
        Assert.assertEquals("Simples Nacional", impostos.get(0).getTipo());
    }

    @Test
    public void testaCalculoImpostoComUmaNotaFiscal() {
        List<Imposto> impostos = fixture.calcularImpostos();
        Assert.assertEquals(new BigDecimal(0.89).setScale(2, RoundingMode.HALF_EVEN),
                impostos.get(0).getValor());
    }

    @Test
    public void testaCalculoImpostoComVariasNotasFiscais() {
        NotaFiscal n2 = new NotaFiscal();
        n2.setValor(new BigDecimal(32.70));
        n2.setAnexo(Impostos.getAnexo(1L));
        NotaFiscal n3 = new NotaFiscal();
        n3.setValor(new BigDecimal(68.45));
        n3.setAnexo(Impostos.getAnexo(3L));
        fixture.adicionarNotaFiscal(n2);
        fixture.adicionarNotaFiscal(n3);
        List<Imposto> impostos = fixture.calcularImpostos();
        Assert.assertEquals(new BigDecimal(10.38).setScale(2, RoundingMode.HALF_EVEN),
                impostos.get(0).getValor());
    }

}
