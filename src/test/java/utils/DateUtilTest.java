package utils;

import com.farias.utils.DateUtil;
import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testaCriacaoDeDataMesAnoInt() {
        Assert.assertEquals("Thu Dec 01 00:00:00 BRST 2016", DateUtil.criarDataMesAno(12, 2016).toString());
    }

    @Test
    public void testaCriacaoDeDataMesAnoString() {
        Assert.assertEquals("Thu Dec 01 00:00:00 BRST 2016", DateUtil.criarDataMesAno("2016-12").toString());
    }

    @Test
    public void testaCriacaoDeDataHora() {
        Assert.assertEquals("Sun Dec 25 22:48:16 BRST 2016",
                DateUtil.criarDataHora(2016, 12, 25, 22, 48, 16).toString());
    }

    @Test
    public void testaInicioDoMes() {
        Assert.assertEquals("Thu Dec 01 00:00:00 BRST 2016",
                DateUtil.inicioDoMes(DateUtil.criarDataHora(2016, 12, 25, 22, 48, 16)).toString());
    }

    @Test
    public void testaFimDoMes() {
        Assert.assertEquals("Mon Feb 29 23:59:59 BRT 2016",
                DateUtil.fimDoMes(DateUtil.criarDataHora(2016, 2, 25, 22, 48, 16)).toString());
    }

}
