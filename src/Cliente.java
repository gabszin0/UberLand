
public class Cliente extends Pessoa{
	private String cel;
	private String email;
	private char sexo;
	private String pagamento;
	
		
	public Cliente(String nome, String cpf, String datanasc, String cel, String email, char sexo) {
		super (nome, cpf, datanasc);
		setCel(cel);
		setEmail(email);
		setSexo (sexo);
		setPagamento(null);
	}
	
	public Cliente(String nome, String cpf) {
		super (nome, cpf);
	}
	
	public Cliente() { // construtor default
		super ();
		this.sexo = 'N';	
		this.pagamento = "CARTAO DE CREDITO";
	}
	
	
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		if (cel != null && cel.length() == 11)
			this.cel = cel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
	    if (email != null) {
	        int primeira = email.indexOf('@');
	        int ultima = email.lastIndexOf('@');

	        if (primeira > 0 && primeira == ultima && primeira < email.length() - 1) {
	            this.email = email;
	        }
	    }
	}

	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		sexo = Character.toUpperCase(sexo);
		
		if (sexo == 'M')
			this.sexo = 'M';
		else if (sexo == 'F')
			this.sexo = 'F';
		else
			this.sexo = 'N';
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		if (pagamento == null) {
			this.pagamento = "CARTAO DE CREDITO";
			return;
		}
			
		pagamento = pagamento.toUpperCase();
		
		if (pagamento.equals("PIX"))
			this.pagamento = "PIX";
		else if (pagamento.equals("DINHEIRO"))
			this.pagamento = "DINHEIRO";
		else 
			this.pagamento = "CARTAO DE CREDITO";
	}
	
		
}
