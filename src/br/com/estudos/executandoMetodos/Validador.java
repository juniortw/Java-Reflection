package br.com.estudos.executandoMetodos;

import java.lang.reflect.Method;

public class Validador {
	
	public static boolean validarObjeto(Object obj) throws Exception {
		boolean resultado = true; 
		//pegando a classe do objeto
		Class<?> clazz = obj.getClass(); 
		
		//Method recupera os métodos de uma classe 
		//getMethods retorno todos os métodos publicos
		//getDeclaredMethods retorno todos os métodos com qualquer tipo de modificador
		for(Method m : clazz.getMethods()) {
			//startsWith busca todos o método começa com esse nome("validar")
			if(m.getName().startsWith("validar") &&
					//getReturnType se o retorno é boolean
					m.getReturnType() == boolean.class &&
						//getParameterTypes é igual a zero
						m.getParameterTypes().length == 0) {
				//invoke invoca o objeto ex:m.invoke(obj, param1, param2)
				//pode chamar o invoke passando somente o obj da classe onde vai instanciar
				// ou passando parametros 
				Boolean retorno = (Boolean) m.invoke(obj);
				resultado = resultado && retorno.booleanValue();
			}
		}
		
		return resultado;
	}
}
