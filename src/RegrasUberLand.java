
public class RegrasUberLand {

	private static final int corridasclientevip = 10;
	
	
	public static Cliente verificarClientevip (Cliente cliente) {
		if (cliente.getQtdecorridas() >= corridasclientevip) {
			return new ClienteVip (cliente);
		}
		return cliente;
		
	}
	
	public static float regraDescontovip(ClienteVip clientevip) {
		if (clientevip.getQtdecorridas() >= 50) {
			return  0.2f;
		}else if (clientevip.getQtdecorridas() >= 30) {
			return  0.15f;
		}else {
			return  0.1f;
		}
		
	}
	
}
