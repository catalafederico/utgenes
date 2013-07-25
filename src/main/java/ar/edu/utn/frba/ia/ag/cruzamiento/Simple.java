package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Simple extends Cruzamiento {
	
	Integer puntoDeCorte;
	CruzamientoBinomialMascaraComplemento cruzamientoAuxiliarMascara;
	
	public Simple(Integer puntoDeCorte) {
		
		if (puntoDeCorte == null) {
			throw new RuntimeException("PuntoDeCorte inválido");
		}
		
		this.puntoDeCorte = puntoDeCorte;
	}
	
	@Override
	protected void cruzar(Individuo padreA, Individuo padreB) {
		
		getCruzamientoAuxiliar(padreA).cruzar(padreA, padreB);
		
	}
	
	private CruzamientoBinomialMascaraComplemento getCruzamientoAuxiliar(Individuo individuo) {
		
		if (this.cruzamientoAuxiliarMascara == null) {
			
			StringBuffer mascara = new StringBuffer();
			
			for (int i = 0; i < this.puntoDeCorte; i++) {
				mascara.append(X);
			}
			
			for (int i = mascara.length(); i < individuo.getClass().getDeclaredFields().length; i++) {
				mascara.append(Y);
			}
			
			this.cruzamientoAuxiliarMascara = new CruzamientoBinomialMascaraComplemento(mascara.toString());
			
		}
		
		return this.cruzamientoAuxiliarMascara;
	}
	
}
