import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class Corrida{

	public static final int SOLICITADA = 0;
    public static final int EM_ANDAMENTO = 1;
    public static final int FINALIZADA = 2;
    public static final int CANCELADA = 3;
    public static final double valorExtra = 5.00;
	
	private Cliente cliente;
	private Veiculos veiculo;
	private String origem;
	private String destino;
	private LocalDateTime dataHoraSolicitacao;
	private LocalDateTime dataHoraOrigem;
	private LocalDateTime dataHoraDestino;
	private int duracaoViagem;
	private double distanciaRealKm;
	private double valorTotal;
	private boolean pagarValorExtra;
	private double valorMotorista;
	private double valorUberLand;
	private int statusCorrida; // 0 - solicitada, 1 - em andamento, 2 - finalizada, 3 - cancelada
	private boolean canceladaPor;
	private String formasPagamento;


	//Construtor

	public Corrida( Cliente cliente, Veiculos veiculo, String origem, String destino, String formasPagamento){

		setCliente(cliente);
		setVeiculo(veiculo);	
		setOrigem(origem);
		setDestino(destino);
		setFormasPagamento(formasPagamento);
		this.dataHoraSolicitacao = LocalDateTime.now();
		this.statusCorrida = SOLICITADA;
	}
	//Getters e Setters
	public Cliente getCliente() {
	 	return cliente;
	}

	 public void setCliente(Cliente cliente) {
	 	if(cliente != null)
	 		this.cliente = cliente;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		if(veiculo !=null)
			this.veiculo = veiculo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		if(origem != null && origem.length() > 0)
			this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		if(destino != null && destino.length() > 0)
			this.destino = destino;
	}
	public LocalDateTime getDataHoraSolicitacao() {
		return dataHoraSolicitacao;
	}
	
	public int getStatusCorrida() {
		return statusCorrida;
	}
	
	public int getDuracaoViagem() {
		return duracaoViagem;
	}
	
	public double getDistaciaRealKm() {
		return distanciaRealKm;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	
	public boolean isPagarValorExtra() {
		return pagarValorExtra;
	}
	public void setPagarValorExtra(boolean pagarValorExtra) {
		if(statusCorrida == SOLICITADA)
			this.pagarValorExtra = pagarValorExtra;
	}
	
	public double getValorMotorista() {
		return valorMotorista;
	}
	public void setValorMotorista(double valorMotorista) {
		this.valorMotorista = valorMotorista;
	}
	public double getValorUberLand() {
		return valorUberLand;
	}
	public void setValorUberLand(double valorUberLand) {
		this.valorUberLand = valorUberLand;
	}
	
	public String getFormasPagamento() {
		return formasPagamento;
	}
	public void setFormasPagamento(String formasPagamento) {
		if (formasPagamento != null && formasPagamento.length()>0)
				this.formasPagamento = formasPagamento;
	}
	

	
	
	//metodos
	public void iniciarCorrida() {
		if (statusCorrida == SOLICITADA) {
			this.statusCorrida = EM_ANDAMENTO;
			this.dataHoraOrigem = LocalDateTime.now();
		}
	}

	public void finalizarCorrida(double distanciaRealKm) {
		if (statusCorrida != EM_ANDAMENTO || distanciaRealKm <= 0)
			return;
		
		this.statusCorrida = FINALIZADA;
		this.dataHoraDestino = LocalDateTime.now();
		duracaoViagem = calcularDuracaoViagem();
		this.distanciaRealKm = distanciaRealKm;
		calcularValorViagem();
		RegrasUberLand.calcularDivisaoCorrida(this);
	}
	
	private int calcularDuracaoViagem() {
		if (dataHoraOrigem != null && dataHoraDestino != null)
			return (int)Duration.between(dataHoraOrigem, dataHoraDestino).toMinutes();
		
		return 0;
	}
		
	public void cancelarCorrida(boolean canceladaPor) {
		if (statusCorrida == SOLICITADA ||statusCorrida == EM_ANDAMENTO) {
			this.statusCorrida = CANCELADA;
			setCanceladaPor(canceladaPor);
		}
	}

	public boolean isCanceladaPorCliente() {
		return statusCorrida == CANCELADA && canceladaPor;
	}
	
	public boolean isCanceladaPorMotorista() {
		return statusCorrida == CANCELADA && !canceladaPor;
	}
	
	public void setCanceladaPor(boolean canceladaPor) {
		if (canceladaPor)
			this.canceladaPor = true; // pelo cliente
		else
			this.canceladaPor = false; // pelo motorista
	}
	
	private void calcularValorViagem () {
		if (pagarValorExtra)
			this.valorTotal = (veiculo.calcularCustoViagem(distanciaRealKm)) + valorExtra;
		else
			this.valorTotal = veiculo.calcularCustoViagem(distanciaRealKm);
	}
	
	public void exibirDadosCorrida(){
		System.out.println("----- Dados da Corrida -----");
		System.out.println("Origem: " + getOrigem());
		System.out.println("Destino: " + getDestino());
		//System.out.println("Data e Hora da Solicitação: " + getDataHoraSolicitacao());
		System.out.println("Status da Corrida: " + getStatusCorrida());
		//System.out.println("cliente: " + cliente.getNome());
		System.out.println("veiculo: " + veiculo.getPlaca());	
		//System.out.println("Motorista: " + veiculo.getMotorista().getNomesocial());
	}

}
