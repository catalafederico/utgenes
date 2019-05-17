package main.java.ar.edu.utn.frba.ia.ag.acertijoelfos;

import java.util.ArrayList;
import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Cromosoma extends Individuo {
	private ArrayList<Elfo> elfos;
	private int aptitud = 0;
	private ArrayList<String> nombres = new ArrayList<String>();
	private ArrayList<String> departamentos = new ArrayList<String>();
	private ArrayList<String> coloresDePelo = new ArrayList<String>();
	private ArrayList<String> coloresDeZuecos = new ArrayList<String>();
	private ArrayList<String> trabajos = new ArrayList<String>();
	private ArrayList<String> mascotas = new ArrayList<String>();
	
	
	
	@Override
	public Individuo generarRandom() {
		this.inicializarNombres();
		this.inicializarDepartamentos();
		this.inicializarColoresDePelo();
		this.inicializarColoresDeZuecos();
		this.inicializarTrabajos();
		this.inicializarMascotas();
		
		
		while(!nombres.isEmpty()){
		
			Elfo elfo = new Elfo();
			String nombre = nombres.get((int)Math.random()*nombres.size());
			String departamento = departamentos.get((int)Math.random()*departamentos.size());
			String colorDePelo = coloresDePelo.get((int)Math.random()*coloresDePelo.size());
			String colorDeZuecos = coloresDeZuecos.get((int)Math.random()*coloresDeZuecos.size());
			String trabajo = trabajos.get((int)Math.random()*trabajos.size());
			String mascota = mascotas.get((int)Math.random()*mascotas.size());
			
			elfo.setNombre(nombre);
			elfo.setDepartamento(departamento);
			elfo.setColorDePelo(colorDePelo);
			elfo.setColorDeZuecos(colorDeZuecos);
			elfo.setTrabajo(trabajo);
			elfo.setMascota(mascota);
			
			nombres.remove(nombre);
			departamentos.remove(departamento);
			coloresDePelo.remove(colorDePelo);
			coloresDeZuecos.remove(colorDeZuecos);
			trabajos.remove(trabajo);
			mascotas.remove(mascota);			
			
			this.elfos.add(elfo);
		}
		
		
		//Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("PLATA DEL MONEDERO: " + tengo + "/" + totalDinero);
		
		return this;
	}


	private void inicializarNombres() {
		nombres.add("Sniff");
		nombres.add("Prop");
		nombres.add("Poddy");
		nombres.add("Stump");
		nombres.add("Puk");	
	}


	private void inicializarDepartamentos() {
		departamentos.add("A");
		departamentos.add("B");
		departamentos.add("C");
		departamentos.add("D");
		departamentos.add("E");
	}


	private void inicializarColoresDePelo() {
		coloresDePelo.add("Castaño");
		coloresDePelo.add("Gris");
		coloresDePelo.add("Negro");
		coloresDePelo.add("Pelirrojo");
		coloresDePelo.add("Cano");		
	}


	private void inicializarColoresDeZuecos() {
		coloresDeZuecos.add("Rojos");
		coloresDeZuecos.add("Negros");
		coloresDeZuecos.add("Verdes");
		coloresDeZuecos.add("Blancos");
		coloresDeZuecos.add("SinColor");		
	}


	private void inicializarTrabajos() {
		trabajos.add("Empaquetador");
		trabajos.add("Pintor");
		trabajos.add("Cuidador");
		trabajos.add("Panadero");
		trabajos.add("Carpintero");		
	}


	private void inicializarMascotas() {
		mascotas.add("Gansos");
		mascotas.add("Cerdos");
		mascotas.add("Pato");
		mascotas.add("Gato");
		mascotas.add("Raton");		
	}
	
	public int indicePor(String atributo, String valor){
		
		if(atributo == "Nombre"){
		    
			for (Elfo elfo : this.elfos) {
		        if (elfo.getNombre().equals(valor)) {
		            return this.elfos.indexOf(elfo);
		        }        
			}
		
		}
		
		if(atributo == "Trabajo"){
		    
			for (Elfo elfo : this.elfos) {
		        if (elfo.getTrabajo().equals(valor)) {
		            return this.elfos.indexOf(elfo);
		        }        
			}
		
		}
		
		if(atributo == "ColorDePelo"){
		    
			for (Elfo elfo : this.elfos) {
		        if (elfo.getColorDePelo().equals(valor)) {
		            return this.elfos.indexOf(elfo);
		        }        
			}
		
		}
		
		if(atributo == "ColorDeZuecos"){
		    
			for (Elfo elfo : this.elfos) {
		        if (elfo.getColorDeZuecos().equals(valor)) {
		            return this.elfos.indexOf(elfo);
		        }        
			}
		
		}
		
		if(atributo == "Mascota"){
		    
			for (Elfo elfo : this.elfos) {
		        if (elfo.getMascota().equals(valor)) {
		            return this.elfos.indexOf(elfo);
		        }        
			}
		
		}
		
		return 0;
	}
	
	@Override
	public double aptitud() {
		/*
	•	Sniff tiene zuecos rojos. Hecho.
	•	Prop tiene gansos por mascotas. Hecho.
	•	Poddy es el que empaqueta los regalos. Hecho.
	•	El pintor y Poddy no son vecinos. Hecho.
	•	Stump vive junto al que tiene zuecos rojos. Hecho.
	•	El elfo de pelo castaño cuida de los renos de Sta. Claus. Hecho.
	•	Puk tiene el pelo gris. Hecho.
	•	El elfo de pelo gris vive entre el Sniff y el dueño de un ganso. Hecho.
	•	El de zuecos rojos es vecino de Stump
	•	El de zuecos negros es vecino del de pelo negro.
	•	El elfo panadero vive junto al que tiene cerdos como mascota.
	•	El pelirrojo junto al dueño de unos zuecos verdes.
	•	El dueño de los gansos es vecino del que tiene el pelo negro.
	•	El dueño del pato vive junto al que tiene zuecos blancos.
	•	El de zuecos blancos es vecino del elfo de pelo cano y del de los zuecos rojos.
	•	El de zuecos blancos no es vecino del dueño del gato
	•	El dueño del gato vive junto al carpintero
		*/
		
		//Sniff tiene zuecos rojos
		if(this.elfos.get(this.indicePor("Nombre", "Sniff")).getColorDeZuecos() == "Rojos"){
			this.aptitud += 10;
		}else{
			this.aptitud -= 10;
		}
		
		//Prop tiene gansos por mascotas
		if(this.elfos.get(this.indicePor("Nombre", "Prop")).getMascota() == "Gansos"){
			this.aptitud += 10;
		}else{
			this.aptitud -= 10;
		}
		
		//Poddy es el que empaqueta los regalos
		if(this.elfos.get(this.indicePor("Nombre", "Poddy")).getTrabajo() == "Empaquetador"){
			this.aptitud += 10;
		}else{
			this.aptitud -= 10;
		}
		
		//El pintor y Poddy no son vecinos
		//Primero me fijo si el pintor se encuentra en un extremo para que al hacer
		//el get no me tire error
		if(this.indicePor("Trabajo", "Pintor") == 0){
			
			//El pintor es el primero
			if(this.elfos.get(this.indicePor("Trabajo", "Pintor")+1).getNombre() != "Poddy"){
				this.aptitud += 10;
			} else {
				this.aptitud -= 10;
			}
			
		} else if(this.indicePor("Trabajo", "Pintor") == 5){
			
			//El pintor es el último
			if(this.elfos.get(this.indicePor("Trabajo", "Pintor")-1).getNombre() != "Poddy"){
				this.aptitud += 10;
			} else {
				this.aptitud -= 10;
			}
			
		} else if(this.elfos.get(this.indicePor("Trabajo", "Pintor")+1).getNombre() != "Poddy" && this.elfos.get(this.indicePor("Trabajo", "Pintor")-1).getNombre() != "Poddy"){
			
			//El pintor está en el medio
			this.aptitud += 10;
		
		} else {
			
			this.aptitud -= 10;
			
		}
		
		
		//Stump vive junto al que tiene zuecos rojos.
		//Primero me fijo si Stump se encuentra en un extremo para que al hacer
		//el get no me tire error por pasarme del tamaño de la lista
		if(this.indicePor("Nombre", "Stump") == 0){
			
			//Stump es el primero
			if(this.elfos.get(this.indicePor("Nombre", "Stump")+1).getColorDeZuecos() == "Rojos"){
				this.aptitud += 10;
			} else {
				this.aptitud -= 10;
			}
			
		} else if(this.indicePor("Trabajo", "Pintor") == 5){
			
			//Stump es el último
			if(this.elfos.get(this.indicePor("Nombre", "Stump")-1).getColorDeZuecos() == "Rojos"){
				this.aptitud += 10;
			} else {
				this.aptitud -= 10;
			}
			
		} else if(this.elfos.get(this.indicePor("Nombre", "Stump")+1).getColorDeZuecos() == "Rojos" || this.elfos.get(this.indicePor("Nombre", "Stump")-1).getColorDeZuecos() == "Rojos"){
			
			//Stump está en el medio
			this.aptitud += 10;
		
		} else {
			
			this.aptitud -= 10;
			
		}
		
		//El elfo de pelo castaño cuida de los renos de Sta. Claus
		if(this.elfos.get(this.indicePor("ColorDePelo", "Castaño")).getTrabajo() == "Cuidador"){
			this.aptitud += 10;
		}else{
			this.aptitud -= 10;
		}
		
		//Puk tiene el pelo gris
		if(this.elfos.get(this.indicePor("Nombre", "Puk")).getColorDePelo() == "Gris"){
			this.aptitud += 10;
		}else{
			this.aptitud -= 10;
		}
		
		//El elfo de pelo gris vive entre el Sniff y el dueño de un ganso
		//Me fijo si el de color de pelo gris no está primero o último, no se podría cumplir la condicion de ser así
		if(this.indicePor("ColorDePelo", "Gris") == 0 || this.indicePor("ColorDePelo", "Gris") == 5){
			this.aptitud -= 10;
		} else if((this.elfos.get(this.indicePor("ColorDePelo", "Gris")-1).getNombre() == "Sniff" && this.elfos.get(this.indicePor("ColorDePelo", "Gris")+1).getMascota() == "Gansos") || (this.elfos.get(this.indicePor("ColorDePelo", "Gris")-1).getMascota() == "Gansos" && this.elfos.get(this.indicePor("ColorDePelo", "Gris")+1).getNombre() == "Sniff")){
			this.aptitud += 10;
		}else{
			this.aptitud -= 10;
		}
		
		//El de zuecos rojos es vecino de Stump
		//Primero me fijo si el de zuecos rojos se encuentra en un extremo para que al hacer
		//el get no me tire error
		if(this.indicePor("ColorDeZuecos", "Rojos") == 0){
			
			//El de zuecos rojos es el primero
			if(this.elfos.get(this.indicePor("ColorDeZuecos", "Rojos")+1).getNombre() == "Stump"){
				this.aptitud += 10;
			} else {
				this.aptitud -= 10;
			}
			
		} else if(this.indicePor("ColorDeZuecos", "Rojos") == 5){
			
			//El de zuecos rojos es el último
			if(this.elfos.get(this.indicePor("ColorDeZuecos", "Rojos")-1).getNombre() == "Stump"){
				this.aptitud += 10;
			} else {
				this.aptitud -= 10;
			}
			
		} else if(this.elfos.get(this.indicePor("ColorDeZuecos", "Rojos")+1).getNombre() == "Stump" || this.elfos.get(this.indicePor("ColorDeZuecos", "Rojos")-1).getNombre() == "Stump"){
			
			//El de zuecos rojos está en el medio
			this.aptitud += 10;
		
		} else {
			
			this.aptitud -= 10;
			
		}
		
		
		
		return this.aptitud;
	}
	
	
	

}
