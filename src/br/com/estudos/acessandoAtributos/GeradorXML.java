package br.com.estudos.acessandoAtributos;

import java.lang.reflect.Field;

public class GeradorXML {
	
	public static String getXML(Object obj) throws Exception {
		//StringBuilder vai gerar as tags do XML
		StringBuilder sb = new StringBuilder(); 
		
		Class<?> c = obj.getClass(); 
		sb.append("<"+c.getSimpleName()+"> \n");
		
		//Field recuperando todos os atrubutos da classe
		//getDeclaredFields recupera somente o atrubuto declarado na classe 
		for(Field f : c.getDeclaredFields()) {
			sb.append("<"+f.getName()+">");
			//setAccessible acessando atributos privados(acessivel somente na reflexao)
			//SecurityManager pode bloquear o acesso aos atributos
			f.setAccessible(true);
			sb.append(f.get(obj));
			sb.append("</"+f.getName()+"> \n");
		}
		
		sb.append("</"+c.getSimpleName()+"> \n");
		return sb.toString();
	}

}
