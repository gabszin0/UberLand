import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Corrida{

	// private Cliente cliente;
	private Veiculos veiculo;
	private String origem;
	private String destino;
	private LocalDateTime dataHoraSolicitacao;
	private double distanciaRealKm;
	private double valorTotal;
	private double valorMotorista;
	private double valorUberLand;
	private int statusCorrida; // 0 - solicitada, 1 - em andamento, 2 - finalizada, 3 - cancelada



	//Construtor

	public Corrida( Veiculos veiculo, String origem, String destino, LocalDateTime dataHoraSolicitacao) {

		// setCliente(cliente);
		setVeiculo(veiculo);	
		setOrigem(origem);
		setDestino(destino);
		setDataHoraSolicitacao(dataHoraSolicitacao);
		this.statusCorrida = 0; //Solicitada
	}
	//Getters e Setters
	// public Cliente getCliente() {
	// 	return cliente;
	// }

	// public void setCliente(Cliente cliente) {
	// 	this.cliente = cliente;
	// }

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public LocalDateTime getDataHoraSolicitacao() {
		return dataHoraSolicitacao;
	}
	public void setDataHoraSolicitacao(LocalDateTime dataHoraSolicitacao) {
		this.dataHoraSolicitacao = dataHoraSolicitacao;
	}

	public int getStatusCorrida() {
		return statusCorrida;
	}

	//metodos
	public void iniciarCorrida() {
		if (this.statusCorrida == 0) {
			this.statusCorrida = 1; //Em andamento
		}
	}

	public void finalizarCorrida(String distanciaRealKm, float valorTotal, String valorMotorista, double valorUberLand) {
		if (this.statusCorrida == 1) {
			this.statusCorrida = 2; //Finalizada
			this.distanciaRealKm = 4;
			this.valorTotal = valorTotal;
			this.valorMotorista = 2.8;
			this.valorUberLand = valorUberLand;
			System.out.println("Corrida finalizada com sucesso.");
		}
		else {
			System.out.println("A corrida nao esta em andamento.");
		}
	}
	public void cancelarCorrida() {
		this.statusCorrida = 3; //Cancelada
		System.out.println("Corrida cancelada");
	}


	
	public void setStatusCorrida(int statusCorrida) {
		this.statusCorrida = statusCorrida;
	}


	public void exibirDadosCorrida(){
		System.out.println("----- Dados da Corrida -----");
		System.out.println("Origem: " + getOrigem());
		System.out.println("Destino: " + getDestino());
		System.out.println("Data e Hora da Solicitação: " + getDataHoraSolicitacao());
		System.out.println("Status da Corrida: " + getStatusCorrida());
		//System.out.println("cliente: " + cliente.getNome());
		System.out.println("veiculo: " + veiculo.getPlaca());	
		//System.out.println("Motorista: " + veiculo.getMotorista().getNomesocial());
	}

}
