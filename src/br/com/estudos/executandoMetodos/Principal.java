package br.com.estudos.executandoMetodos;

public class Principal {
	
	public static void main(String[] args) throws Exception {
		Usuario u = new Usuario(); 
		
		u.setEmail("ajunior@coddera.com");
		u.setSenha("012345689");
		u.setLogin("ajunior");
		
		boolean valido = Validador.validarObjeto(u); 
		
		String retorno = valido ? "O objeto � v�lido" : "O objeto � inv�lido";
		
		System.out.println(retorno);
	}

}
