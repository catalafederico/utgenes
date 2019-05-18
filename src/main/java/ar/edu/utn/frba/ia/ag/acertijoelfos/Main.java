package main.java.ar.edu.utn.frba.ia.ag.acertijoelfos;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Main {
	
	public static void main(String[] args) {
		
		AlgoritmoGenetico acertijoElfos = new AlgoritmoGenetico(new ConfiguracionDefault(), Cromosoma.class);
		
		Individuo cromosoma = acertijoElfos.ejecutar();
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("Individuo final: " + cromosoma.toString());
		
	}

}
