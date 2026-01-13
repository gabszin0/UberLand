
public class ClienteVip extends Cliente{

	private final float descontovip;

	public ClienteVip (Cliente cliente) {
		super(cliente.getNome(),cliente.getCpf(),cliente.getDataNasc(),cliente.getCel(),cliente.getEmail(), cliente.getSexo());
		setPagamento(cliente.getPagamento());
		this.descontovip = RegrasUberLand.regraDescontovip(this);
	}

	public float getDescontovip() {
		return descontovip;
	}

		
}
