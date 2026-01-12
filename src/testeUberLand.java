
public class testeUberLand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Motorista m = new Motorista("sergio", "22169293876", "08091981", "Rua Brasil,10", "12345678901", "Sergio");
		
		//m.setStatus(false);
				
		if (m.getStatus() == true) {
			System.out.println("=== DADOS DO MOTORISTA ===");
			System.out.println("Nome: " + m.getNome());
			System.out.println("Nome social: " + m.getNomesocial());
			System.out.println("CPF: " + m.getCpf());
			System.out.println("Data nasc.: " + m.getDataNasc());
			System.out.println("Endereço: " + m.getEnd());
			System.out.println("CNH: " + m.getCnh());
			System.out.println("Ativo: " + m.getStatus());
	}else
		System.out.println("Motorista inativo");

	
	}
}
