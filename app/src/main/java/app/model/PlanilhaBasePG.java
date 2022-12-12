package app.model;

public class PlanilhaBasePG {
	
	private String referencia;
	
	private String dataDocumento;


	public PlanilhaBasePG() {
		
	}

	public PlanilhaBasePG(String referencia, String dataDocumento) {
		this.referencia = referencia;
		this.dataDocumento = dataDocumento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(String dataDocumento) {
		this.dataDocumento = dataDocumento;
	}
	
	
	

}
