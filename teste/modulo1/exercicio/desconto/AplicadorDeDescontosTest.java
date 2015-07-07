package modulo1.exercicio.desconto;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AplicadorDeDescontosTest {
	
	private AplicadorDeDescontos aplicadorDeDescontos;

	@Before
	public void setUp() {
		aplicadorDeDescontos = new AplicadorDeDescontos();
	}
	
	@Test
	public void deveAplicarDescontoSeTemMacbookEIPhone() {
		Compra compra = new CompraBuilder()
			.com("MACBOOK", 1000.0)
			.com("IPHONE", 500.0)
			.constroi();
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 1275.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}

	
	@Test
	public void deveAplicarDescontoSeTemNotebookEWindowsPhone() {
		Compra compra = new CompraBuilder()
			.com("NOTEBOOK", 1000.0)
			.com("WINDOWS PHONE", 500.0)
			.constroi();
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 1320.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void deveAplicarDescontoSeTemXBox() {
		Compra compra = new CompraBuilder()
			.com("XBOX", 1000.0)
			.constroi();
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 300.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void naoDeveAplicarDescontoSeTotalEntre1000e3000() {
		Compra compra = new CompraBuilder()
			.com("PRODUTO 1", 1200.0)
			.constroi();
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 1200.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void naoDeveAplicarDescontoSeTotalMenorQue1000eTemMaisDe2Itens() {
		Compra compra = new CompraBuilder()
			.com("PRODUTO 1", 200.0)
			.com("PRODUTO 2", 100.0)
			.com("PRODUTO 3", 300.0)
			.constroi();
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 600.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void deveDarDescontoEmComprasAte2ItemsComTotalMenorQue1000() {
		Compra compra = new CompraBuilder()
			.com("PRODUTO 1", 300.0)
			.com("PRODUTO 2", 200.0)
			.constroi();
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 490.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void deveDarDescontoEmComprasAcimaDe3000Com3a5produtos() {
		Compra compra = new CompraBuilder()
			.com("PRODUTO 1", 1000.0)
			.com("PRODUTO 2", 1200.0)
			.com("PRODUTO 3", 1100.0)
			.constroi();
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 3135.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void deveDarDescontoEmComprasAcimaDe3000ComMaisDe5produtos() {
		Compra compra = new CompraBuilder()
			.com("PRODUTO 1", 1000.0)
			.com("PRODUTO 2", 1200.0)
			.com("PRODUTO 3", 1100.0)
			.com("PRODUTO 4", 900.0)
			.com("PRODUTO 5", 500.0)
			.constroi();
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 4418.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void naoDeveAcumularDescontoPorProdutoEValor() {
		Compra compra = new CompraBuilder()
			.com("MACBOOK", 1000.0)
			.com("IPHONE", 1200.0)
			.com("PRODUTO 3", 1100.0)
			.com("PRODUTO 4", 900.0)
			.com("PRODUTO 5", 500.0)
			.constroi();
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 3995.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	

}
