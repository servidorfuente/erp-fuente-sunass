package erp.realcoresystems.pe.service;

public interface EncriptaKeyService {

	public  String getCifrado(String parametro_key);
	public  String getDescifrado(String parametro_key);
	public  String getKeyGenerado_Cifrado(boolean indicaCifrar);
	public  String getKeyGenerado_Descifrado(boolean indicaDescifrar);
}
