package app.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginFormDTO {

	private String email;
	private String senha;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UsernamePasswordAuthenticationToken convert() {
		// TODO Auto-generated method stub
		return new UsernamePasswordAuthenticationToken(email,senha);
	}
	
	
	
}
