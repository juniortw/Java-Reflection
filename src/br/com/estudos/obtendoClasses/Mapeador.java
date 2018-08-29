package br.com.estudos.obtendoClasses;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Mapeador {
	
	private Map<Class<?>, Class<?>> mapa = new HashMap<>(); 
	
	public void load(String nomeArquivo) throws Exception{
		
		Properties p = new Properties(); 
		p.load(new FileInputStream(nomeArquivo));
		
		for(Object key : p.keySet()) {
			// Metodo forName pega o nome da classe 
			Class<?> interf = Class.forName(key.toString());
			Class<?> impl = Class.forName(p.get(key).toString());
			// Verifica NÃO se é uma interface
			if(!interf.isInterface()) {
				throw new RuntimeException("O tipo "+interf.getName()+" não é uma interface");
				
			}
			
			//isAssignableFrom pergunta se a classe interf NÃO é pai do impl
			if(!interf.isAssignableFrom(impl)) {
				throw new RuntimeException("A classe "+impl.getName()+" não implementa "+interf.getName());
			}
			
			mapa.put(interf, impl);
		}
	}
	
	public Class<?> getImplementacao(Class<?> interf){
		return mapa.get(interf);
	}
	
	// Criando uma instancia de objeto a apartir da classe sem parametros 
	public <E> E getInstancia(Class<E> interf) throws Exception{
		Class<?> impl =  mapa.get(interf);
		return (E) impl.newInstance(); 
	}
	
	// Criando uma instancia de objeto a apartir da classe com parametros
	public <E> E getInstancia(Class<E> interf, Object... params) throws Exception{
		Class<?> impl =  mapa.get(interf);
		
		Class<?>[] tiposConstrutor = new Class<?>[params.length];
		
		for(int i = 0; i < tiposConstrutor.length; i++) {
			tiposConstrutor[i] = params[i].getClass();
		}
		// recupera a classe a partir do construtor
		Constructor<?> c = impl.getConstructor(tiposConstrutor);
		// newInstance retorna o contrutor com parametros
		return (E) c.newInstance(params); 
	}

}
