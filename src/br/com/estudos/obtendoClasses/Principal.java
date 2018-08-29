package br.com.estudos.obtendoClasses;

import java.util.List;
import java.util.Map;

public class Principal {

	public static void main(String[] args) throws Exception {
		Mapeador m = new Mapeador();

		m.load("classes.props");

		System.out.println(m.getImplementacao(List.class));
		System.out.println(m.getImplementacao(Map.class));

		List l = m.getInstancia(List.class);
		//retorna um instancia de ArrayList
		System.out.println(l.getClass());
		

		InterfaceExemplo i = m.getInstancia(InterfaceExemplo.class, "teste");

		System.out.println(i.getClass());

	}

}
