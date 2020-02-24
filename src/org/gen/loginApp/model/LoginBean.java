package org.gen.loginApp.model;

public class LoginBean {
	private String user;
	private String password;
	
	public void setUser(String user) {
		this.user=user;
	}
	
	public String getUser() {
		return user;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean validar() {
		boolean valor=false;
		if(user.equals("admin")&&password.equals("123")) {
			valor=true;
		}else {
			valor = false;
		}
		return valor;
	}

}
