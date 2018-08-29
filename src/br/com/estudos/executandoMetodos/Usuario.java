package br.com.estudos.executandoMetodos;

public class Usuario {
	
	private String login; 
	private String senha; 
	private String email; 
	private String papael; 
	private Boolean ativo;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPapael() {
		return papael;
	}
	public void setPapael(String papael) {
		this.papael = papael;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	} 
	
	public boolean validarEmail() {
		return email.contains("@");
	}
	
	public boolean validarSenha() {
		return senha.length() > 8;
	}
	
	public boolean validarLogin() {
		return login.length() > 5 && login.length() < 10;
	}
	
}
