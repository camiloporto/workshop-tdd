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
		Item i1 = new Item("MACBOOK", 1, 1000.0);
		Item i2 = new Item("IPHONE", 1, 500.0);
		Compra compra = new Compra(Arrays.asList(i1, i2));
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 1275.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}

	
	@Test
	public void deveAplicarDescontoSeTemNotebookEWindowsPhone() {
		Item i1 = new Item("NOTEBOOK", 1, 1000.0);
		Item i2 = new Item("WINDOWS PHONE", 1, 500.0);
		Compra compra = new Compra(Arrays.asList(i1, i2));
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 1320.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void deveAplicarDescontoSeTemXBox() {
		Item i1 = new Item("XBOX", 1, 1000.0);
		Compra compra = new Compra(Arrays.asList(i1));
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 300.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void naoDeveAplicarDescontoSeTotalEntre1000e3000() {
		Item i1 = new Item("PRODUTO 1", 1, 1200.0);
		Compra compra = new Compra(Arrays.asList(i1));
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 1200.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void naoDeveAplicarDescontoSeTotalMenorQue1000eTemMaisDe2Itens() {
		Item i1 = new Item("PRODUTO 1", 1, 200.0);
		Item i2 = new Item("PRODUTO 2", 1, 100.0);
		Item i3 = new Item("PRODUTO 3", 1, 300.0);
		Compra compra = new Compra(Arrays.asList(i1, i2, i3));
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 600.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void deveDarDescontoEmComprasAte2ItemsComTotalMenorQue1000() {
		Item i1 = new Item("PRODUTO 1", 1, 300.0);
		Item i2 = new Item("PRODUTO 2", 1, 200.0);
		Compra compra = new Compra(Arrays.asList(i1, i2));
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 490.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void deveDarDescontoEmComprasAcimaDe3000Com3a5produtos() {
		Item i1 = new Item("PRODUTO 1", 1, 1000.0);
		Item i2 = new Item("PRODUTO 2", 1, 1200.0);
		Item i3 = new Item("PRODUTO 3", 1, 1100.0);
		Compra compra = new Compra(Arrays.asList(i1, i2, i3));
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 3135.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void deveDarDescontoEmComprasAcimaDe3000ComMaisDe5produtos() {
		Item i1 = new Item("PRODUTO 1", 1, 1000.0);
		Item i2 = new Item("PRODUTO 2", 1, 1200.0);
		Item i3 = new Item("PRODUTO 3", 1, 1100.0);
		Item i4 = new Item("PRODUTO 4", 1, 900.0);
		Item i5 = new Item("PRODUTO 5", 1, 500.0);
		Compra compra = new Compra(Arrays.asList(i1, i2, i3, i4, i5));
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 4418.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	
	@Test
	public void naoDeveAcumularDescontoPorProdutoEValor() {
		Item i1 = new Item("MACBOOK", 1, 1000.0);
		Item i2 = new Item("IPHONE", 1, 1200.0);
		Item i3 = new Item("PRODUTO 3", 1, 1100.0);
		Item i4 = new Item("PRODUTO 4", 1, 900.0);
		Item i5 = new Item("PRODUTO 5", 1, 500.0);
		Compra compra = new Compra(Arrays.asList(i1, i2, i3, i4, i5));
		
		aplicadorDeDescontos.aplica(compra);
		double valorLiquidoEsperado = 3995.0;
		Assert.assertEquals(valorLiquidoEsperado, compra.getValorLiquido(), 0.005);
		
	}
	

}
