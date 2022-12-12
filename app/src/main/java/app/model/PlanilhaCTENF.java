package app.model;

public class PlanilhaCTENF {

	
	private String cte;
	private String data;
	
	
	public PlanilhaCTENF() {
		
	}
	
	public PlanilhaCTENF(String cte, String data) {
		this.cte = cte;
		this.data = data;
	}
	public String getCte() {
		return cte;
	}
	public void setCte(String cte) {
		this.cte = cte;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "PlanilhaCTENF [cte=" + cte + ", data=" + data + "]";
	}
	
	
}
