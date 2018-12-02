package erp.realcoresystems.pe.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import erp.realcoresystems.pe.service.EncriptaKeyService;

@Service("encriptaKeyService")
public class EncriptaKeyServiceImpl implements EncriptaKeyService {

	/***Funcion que Encripta***/
	@Override
	public String getCifrado(String parametro_key) {
		String parametro_key_cifrado = null;
		try{
			char car ;
			int carAscii ;
			int semilla=0;
			if(parametro_key!=null){
				parametro_key_cifrado="";
				for(int contador = 0;contador<  parametro_key.length();contador++){
					car = parametro_key.charAt(contador);
					carAscii = (int)car;
					semilla=contador+1;
					carAscii=carAscii+semilla;
					parametro_key_cifrado = parametro_key_cifrado+ ""+(char)(carAscii);					
				}				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return parametro_key_cifrado;
	}

	/***Funci_n que Desencripta***/
	@Override
	public String getDescifrado(String parametro_key) {
		String parametro_key_descifrado = null;
		try{
			char car ;
			int carAscii ;
			int semilla=0;
			if(parametro_key!=null){
				parametro_key_descifrado="";
				for(int contador = 0;contador<  parametro_key.length();contador++){
					car = parametro_key.charAt(contador);
					carAscii = (int)car;
					semilla=contador+1;
					carAscii=carAscii-semilla;
					parametro_key_descifrado = parametro_key_descifrado+ ""+(char)(carAscii);					
				}				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return parametro_key_descifrado;
	}

	@Override
	public String getKeyGenerado_Cifrado(boolean indicaCifrar) {
		String parametro_key = null;
		try{
			/**POR COMPLETAR*/		
			Random rnd = new Random();
			//N_meros entre 0 y 100000 (Osea de 5 d_gitos)
			 int parte1 =(int)(rnd.nextDouble() * 100000 + 0);
			 //AHora car_cteres (5 car_cteres)
			 String parte2cad="abcdf";
			 /*for(int i=0;i<5;i++){
				 //N_mero entre 97 y 122 (c_digo ASCII )
				 int parte2 =(int)(rnd.nextDouble() * 122 + 97);
				 parte2cad = parte2cad+ (char)parte2;
			 }*/
			 parametro_key = parte1+parte2cad;
			//parametro_key = "1234asdf";
			if(indicaCifrar){
				//CIFRAR
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return parametro_key;
	}

	@Override
	public String getKeyGenerado_Descifrado(boolean indicaDescifrar) {
		String parametro_key = null;
		try{
			parametro_key = "1234asdf";
			if(indicaDescifrar){
				//DESCIFRAR
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return parametro_key;
	}

}
