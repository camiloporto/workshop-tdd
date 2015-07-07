package modulo1.exercicio.desconto;

import java.util.ArrayList;
import java.util.List;

public class CompraBuilder {
	
	private List<Item> items;
	
	public CompraBuilder() {
		this.items = new ArrayList<Item>();
	}
	
	public CompraBuilder com(String nomeProduto, double valor) {
		items.add(new Item(nomeProduto, 1, valor));
		return this;
	}
	
	public Compra constroi() {
		return new Compra(items);
	}

}
