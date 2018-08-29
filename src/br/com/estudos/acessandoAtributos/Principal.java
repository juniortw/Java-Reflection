package br.com.estudos.acessandoAtributos;

public class Principal {
	
	public static void main(String[] args) throws Exception {
		Usuario u = new Usuario(); 
		u.setAtivo(true);
		u.setEmail("ajunior@coddera.com");
		u.setLogin("jr");
		u.setPapael("dev");
		u.setSenha("123");
		
		String xml = GeradorXML.getXML(u); 
		
		System.out.println(xml);
	}

}
