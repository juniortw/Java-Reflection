package br.com.estudos.tiposErros;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		TesteErros obj = new TesteErros(); 
		
		Class clazz = obj.getClass(); 
		
		// vai dar uma exception do tipo NoSuchMethodException 
		// significado: Não conseguiu achar um determinado método ou atributo
		clazz.getMethod("metodo");
		
		// vai dar uma exception do tipo IllegalArgumentException 
		// significado: Os parâmetros passados não são compatíveis com o do método
		Method m1 = clazz.getMethod("metodo", String.class); 
		m1.invoke(obj);
		
		// vai dar uma exception do tipo IllegalAccessException 
		// o metodo tem q ser privado.
		// significado: Não tem permissão apra acessar aquele método
		Method m2 = clazz.getDeclaredMethod("metodo", String.class); 
		m2.invoke(obj, "teste");
		
		// vai dar uma exception do tipo InvocationTargetException 
		// significado: encapsula a excessão "original"
		// o método joga um excessao porem quando chama o getTargetException()
		// ele mostra a excessão original
		Method m3 = clazz.getDeclaredMethod("metodo", String.class); 
		m3.invoke(obj, "teste");
		
		//com esse tray ele pega a exception do médoto
		try {
			Method m4 = clazz.getDeclaredMethod("metodo", String.class); 
			m4.invoke(obj, "teste");			
		} catch (InvocationTargetException ex) {
			// pegando a excessão do metodo RuntimeException
			// dentro do getTargetException
			ex.getTargetException().printStackTrace();
		}
		
	}

}
