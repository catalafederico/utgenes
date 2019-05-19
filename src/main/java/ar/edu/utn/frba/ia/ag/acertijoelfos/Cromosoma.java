package main.java.ar.edu.utn.frba.ia.ag.acertijoelfos;

import java.util.ArrayList;
import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Cromosoma extends Individuo {
	public ArrayList<Elfo> getElfos() {
		return elfos;
	}


	public void setElfos(ArrayList<Elfo> elfos) {
		this.elfos = elfos;
	}

	public ArrayList<String> getNombres() {
		return nombres;
	}


	public void setNombres(ArrayList<String> nombres) {
		this.nombres = nombres;
	}


	public ArrayList<String> getColoresDePelo() {
		return coloresDePelo;
	}


	public void setColoresDePelo(ArrayList<String> coloresDePelo) {
		this.coloresDePelo = coloresDePelo;
	}


	public ArrayList<String> getColoresDeZuecos() {
		return coloresDeZuecos;
	}


	public void setColoresDeZuecos(ArrayList<String> coloresDeZuecos) {
		this.coloresDeZuecos = coloresDeZuecos;
	}


	public ArrayList<String> getTrabajos() {
		return trabajos;
	}


	public void setTrabajos(ArrayList<String> trabajos) {
		this.trabajos = trabajos;
	}


	public ArrayList<String> getMascotas() {
		return mascotas;
	}


	public void setMascotas(ArrayList<String> mascotas) {
		this.mascotas = mascotas;
	}

	private ArrayList<Elfo> elfos = new ArrayList<Elfo>();
	private ArrayList<String> nombres = new ArrayList<String>();
	//private ArrayList<String> departamentos = new ArrayList<String>();
	private ArrayList<String> coloresDePelo = new ArrayList<String>();
	private ArrayList<String> coloresDeZuecos = new ArrayList<String>();
	private ArrayList<String> trabajos = new ArrayList<String>();
	private ArrayList<String> mascotas = new ArrayList<String>();
		
	@Override
	public Individuo generarRandom() {
		this.inicializarNombres();
		//this.inicializarDepartamentos();
		this.inicializarColoresDePelo();
		this.inicializarColoresDeZuecos();
		this.inicializarTrabajos();
		this.inicializarMascotas();
		
		
		while(!nombres.isEmpty()){
		
			Elfo elfo = new Elfo();
			String nombre = nombres.get((int)(Math.random()*nombres.size()));
			//String departamento = departamentos.get((int)Math.random()*departamentos.size());
			String colorDePelo = coloresDePelo.get((int)(Math.random()*coloresDePelo.size()));
			String colorDeZuecos = coloresDeZuecos.get((int)(Math.random()*coloresDeZuecos.size()));
			String trabajo = trabajos.get((int)(Math.random()*trabajos.size()));
			String mascota = mascotas.get((int)(Math.random()*mascotas.size()));
			
			elfo.setNombre(nombre);
			//elfo.setDepartamento(departamento);
			elfo.setColorDePelo(colorDePelo);
			elfo.setColorDeZuecos(colorDeZuecos);
			elfo.setTrabajo(trabajo);
			elfo.setMascota(mascota);
			
			nombres.remove(nombre);
			//departamentos.remove(departamento);
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


	/*private void inicializarDepartamentos() {
		departamentos.add("A");
		departamentos.add("B");
		departamentos.add("C");
		departamentos.add("D");
		departamentos.add("E");
	}*/

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
	
	@Override
	public boolean esMasAptoQue(Individuo individuo) {
		return this.aptitud() < individuo.aptitud();
	}
	
	@Override
	public String toString() {
		
		return  "(A: " + this.elfos.get(0).getNombre() + ", " + this.elfos.get(0).getColorDePelo() + ", " + this.elfos.get(0).getColorDeZuecos() + ", " + this.elfos.get(0).getTrabajo() + ", " + this.elfos.get(0).getMascota()
				+ "/ B: " + this.elfos.get(1).getNombre() + ", " + this.elfos.get(1).getColorDePelo() + ", " + this.elfos.get(1).getColorDeZuecos() + ", " + this.elfos.get(1).getTrabajo() + ", " + this.elfos.get(1).getMascota()
				+ "/ C: " + this.elfos.get(2).getNombre() + ", " + this.elfos.get(2).getColorDePelo() + ", " + this.elfos.get(2).getColorDeZuecos() + ", " + this.elfos.get(2).getTrabajo() + ", " + this.elfos.get(2).getMascota()
				+ "/ D: " + this.elfos.get(3).getNombre() + ", " + this.elfos.get(3).getColorDePelo() + ", " + this.elfos.get(3).getColorDeZuecos() + ", " + this.elfos.get(3).getTrabajo() + ", " + this.elfos.get(3).getMascota()
				+ "/ E: " + this.elfos.get(4).getNombre() + ", " + this.elfos.get(4).getColorDePelo() + ", " + this.elfos.get(4).getColorDeZuecos() + ", " + this.elfos.get(4).getTrabajo() + ", " + this.elfos.get(4).getMascota()

				+ ") Apto: " + this.aptitud();
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
		int aptitud = 0;/*
	•	Sniff tiene zuecos rojos. Hecho.
	•	Prop tiene gansos por mascotas. Hecho.
	•	Poddy es el que empaqueta los regalos. Hecho.
	•	El pintor y Poddy no son vecinos. Hecho.
	•	Stump vive junto al que tiene zuecos rojos. Hecho.
	•	El elfo de pelo castaño cuida de los renos de Sta. Claus. Hecho.
	•	Puk tiene el pelo gris. Hecho.
	•	El elfo de pelo gris vive entre el Sniff y el dueño de un ganso. Hecho.
	•	El de zuecos rojos es vecino de Stump. Hecho.
	•	El de zuecos negros es vecino del de pelo negro. Hecho.
	•	El elfo panadero vive junto al que tiene cerdos como mascota. Hecho.
	•	El pelirrojo junto al dueño de unos zuecos verdes. Hecho.
	•	El dueño de los gansos es vecino del que tiene el pelo negro. Hecho.
	•	El dueño del pato vive junto al que tiene zuecos blancos. Hecho.
	•	El de zuecos blancos es vecino del elfo de pelo cano y del de los zuecos rojos. Hecho.
	•	El de zuecos blancos no es vecino del dueño del gato. Hecho.
	•	El dueño del gato vive junto al carpintero. Hecho.
		*/
		
		//Sniff tiene zuecos rojos
		if(this.elfos.get(this.indicePor("Nombre", "Sniff")).getColorDeZuecos() == "Rojos"){
			aptitud +=10;
		}else{
			aptitud -=10;
		}
		
		//Prop tiene gansos por mascotas
		if(this.elfos.get(this.indicePor("Nombre", "Prop")).getMascota() == "Gansos"){
			aptitud +=10;
		}else{
			aptitud -=10;
		}
		
		//Poddy es el que empaqueta los regalos
		if(this.elfos.get(this.indicePor("Nombre", "Poddy")).getTrabajo() == "Empaquetador"){
			aptitud +=10;
		}else{
			aptitud -=10;
		}
		
		//El pintor y Poddy no son vecinos
		//Primero me fijo si el pintor se encuentra en un extremo para que al hacer
		//el get no me tire error
		if(this.indicePor("Trabajo", "Pintor") == 0){
			
			//El pintor es el primero
			if(this.elfos.get(1).getNombre() != "Poddy"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.indicePor("Trabajo", "Pintor") == 5){
			
			//El pintor es el último
			if(this.elfos.get(4).getNombre() != "Poddy"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.elfos.get(this.indicePor("Trabajo", "Pintor")+1).getNombre() != "Poddy" && this.elfos.get(this.indicePor("Trabajo", "Pintor")-1).getNombre() != "Poddy"){
			
			//El pintor está en el medio
			aptitud +=10;
		
		} else {
			
			aptitud -=10;
			
		}
		
		
		//Stump vive junto al que tiene zuecos rojos.
		//Primero me fijo si Stump se encuentra en un extremo para que al hacer
		//el get no me tire error por pasarme del tamaño de la lista
		if(this.indicePor("Nombre", "Stump") == 0){
			
			//Stump es el primero
			if(this.elfos.get(1).getColorDeZuecos() == "Rojos"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.indicePor("Nombre", "Stump") == 5){
			
			//Stump es el último
			if(this.elfos.get(4).getColorDeZuecos() == "Rojos"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.elfos.get(this.indicePor("Nombre", "Stump")+1).getColorDeZuecos() == "Rojos" || this.elfos.get(this.indicePor("Nombre", "Stump")-1).getColorDeZuecos() == "Rojos"){
			
			//Stump está en el medio
			aptitud +=10;
		
		} else {
			
			aptitud -=10;
			
		}
		
		//El elfo de pelo castaño cuida de los renos de Sta. Claus
		if(this.elfos.get(this.indicePor("ColorDePelo", "Castaño")).getTrabajo() == "Cuidador"){
			aptitud +=10;
		}else{
			aptitud -=10;
		}
		
		//Puk tiene el pelo gris
		if(this.elfos.get(this.indicePor("Nombre", "Puk")).getColorDePelo() == "Gris"){
			aptitud +=10;
		}else{
			aptitud -=10;
		}
		
		//El elfo de pelo gris vive entre el Sniff y el dueño de un ganso
		//Me fijo si el de color de pelo gris está primero o último, no se podría cumplir la condicion de ser así
		if(this.indicePor("ColorDePelo", "Gris") == 0 || this.indicePor("ColorDePelo", "Gris") == 5){
			aptitud -=10;
		} else if((this.elfos.get(this.indicePor("ColorDePelo", "Gris")-1).getNombre() == "Sniff" && this.elfos.get(this.indicePor("ColorDePelo", "Gris")+1).getMascota() == "Gansos") || (this.elfos.get(this.indicePor("ColorDePelo", "Gris")-1).getMascota() == "Gansos" && this.elfos.get(this.indicePor("ColorDePelo", "Gris")+1).getNombre() == "Sniff")){
			aptitud +=10;
		}else{
			aptitud -=10;
		}
		
		//El de zuecos rojos es vecino de Stump
		//Primero me fijo si el de zuecos rojos se encuentra en un extremo para que al hacer
		//el get no me tire error
		if(this.indicePor("ColorDeZuecos", "Rojos") == 0){
			
			//El de zuecos rojos es el primero
			if(this.elfos.get(1).getNombre() == "Stump"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.indicePor("ColorDeZuecos", "Rojos") == 5){
			
			//El de zuecos rojos es el último
			if(this.elfos.get(4).getNombre() == "Stump"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.elfos.get(this.indicePor("ColorDeZuecos", "Rojos")+1).getNombre() == "Stump" || this.elfos.get(this.indicePor("ColorDeZuecos", "Rojos")-1).getNombre() == "Stump"){
			
			//El de zuecos rojos está en el medio
			aptitud +=10;
		
		} else {
			
			aptitud -=10;
			
		}
		
		//El de zuecos negros es vecino del de pelo negro.
		//Primero me fijo si el de zuecos negros se encuentra en un extremo para que al hacer
		//el get no me tire error
		if(this.indicePor("ColorDeZuecos", "Negros") == 0){
			
			//El de zuecos negros es el primero
			if(this.elfos.get(1).getColorDePelo() == "Negro"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.indicePor("ColorDeZuecos", "Negros") == 5){
			
			//El de zuecos negros es el último
			if(this.elfos.get(4).getColorDePelo() == "Negro"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.elfos.get(this.indicePor("ColorDeZuecos", "Negros")+1).getColorDePelo() == "Negro" || this.elfos.get(this.indicePor("ColorDeZuecos", "Negros")-1).getColorDePelo() == "Negro"){
			
			//El de zuecos negros está en el medio
			aptitud +=10;
		
		} else {
			
			aptitud -=10;
			
		}
		
		//El elfo panadero vive junto al que tiene cerdos como mascota.		
		//Primero me fijo si el panadero se encuentra en un extremo para que al hacer
		//el get no me tire error
		if(this.indicePor("Trabajo", "Panadero") == 0){
			
			//El panadero es el primero
			if(this.elfos.get(1).getMascota() == "Cerdos"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.indicePor("Trabajo", "Panadero") == 5){
			
			//El panadero es el último
			if(this.elfos.get(4).getMascota() == "Cerdos"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.elfos.get(this.indicePor("Trabajo", "Panadero")+1).getMascota() == "Cerdos" || this.elfos.get(this.indicePor("Trabajo", "Panadero")-1).getMascota() == "Cerdos"){
			
			//El panadero está en el medio
			aptitud +=10;
		
		} else {
			
			aptitud -=10;
			
		}
		
		//El pelirrojo junto al dueño de unos zuecos verdes.
		//Primero me fijo si el pelirrojo se encuentra en un extremo para que al hacer
		//el get no me tire error
		if(this.indicePor("ColorDePelo", "Pelirrojo") == 0){
			
			//El pelirrojo es el primero
			if(this.elfos.get(1).getColorDeZuecos() == "Verdes"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.indicePor("ColorDePelo", "Pelirrojo") == 5){
			
			//El pelirrojo es el último
			if(this.elfos.get(4).getColorDeZuecos() == "Verdes"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.elfos.get(this.indicePor("ColorDePelo", "Pelirrojo")+1).getColorDeZuecos() == "Verdes" || this.elfos.get(this.indicePor("ColorDePelo", "Pelirrojo")-1).getColorDeZuecos() == "Verdes"){
			
			//El pelirrojo está en el medio
			aptitud +=10;
		
		} else {
			
			aptitud -=10;
			
		}
		
		//El dueño de los gansos es vecino del que tiene el pelo negro.
		//Primero me fijo si el dueño de los gansos se encuentra en un extremo para que al hacer
		//el get no me tire error
		if(this.indicePor("Mascota", "Gansos") == 0){
			
			//El dueño de los gansos es el primero
			if(this.elfos.get(1).getColorDePelo() == "Negro"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.indicePor("Mascota", "Gansos") == 5){
			
			//El dueño de los gansos es el último
			if(this.elfos.get(4).getColorDePelo() == "Negro"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.elfos.get(this.indicePor("Mascota", "Gansos")+1).getColorDePelo() == "Negro" || this.elfos.get(this.indicePor("Mascota", "Gansos")-1).getColorDePelo() == "Negro"){
			
			//El dueño de los gansos está en el medio
			aptitud +=10;
		
		} else {
			
			aptitud -=10;
			
		}
		
		//El dueño del pato vive junto al que tiene zuecos blancos.
		//Primero me fijo si el dueño del pato se encuentra en un extremo para que al hacer
		//el get no me tire error
		if(this.indicePor("Mascota", "Pato") == 0){
			
			//El dueño del pato es el primero
			if(this.elfos.get(1).getColorDeZuecos() == "Blancos"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.indicePor("Mascota", "Pato") == 5){
			
			//El dueño del pato es el último
			if(this.elfos.get(4).getColorDeZuecos() == "Blancos"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.elfos.get(this.indicePor("Mascota", "Pato")+1).getColorDeZuecos() == "Blancos" || this.elfos.get(this.indicePor("Mascota", "Pato")-1).getColorDeZuecos() == "Blancos"){
			
			//El dueño del pato está en el medio
			aptitud +=10;
		
		} else {
			
			aptitud -=10;
			
		}
		
		//El de zuecos blancos es vecino del elfo de pelo cano y del de los zuecos rojos.
		//Me fijo si el de color de zuecos blancos no está primero o último, no se podría cumplir la condicion de ser así
		if(this.indicePor("ColorDeZuecos", "Blancos") == 0 || this.indicePor("ColorDeZuecos", "Blancos") == 5){
			aptitud -=10;
		} else if((this.elfos.get(this.indicePor("ColorDeZuecos", "Blancos")-1).getColorDePelo() == "Cano" && this.elfos.get(this.indicePor("ColorDeZuecos", "Blancos")+1).getColorDeZuecos() == "Rojos") || (this.elfos.get(this.indicePor("ColorDeZuecos", "Blancos")-1).getColorDeZuecos() == "Rojos" && this.elfos.get(this.indicePor("ColorDeZuecos", "Blancos")+1).getColorDePelo() == "Cano")){
			aptitud +=10;
		}else{
			aptitud -=10;
		}
		
		//El de zuecos blancos no es vecino del dueño del gato
		//Primero me fijo si el de zuecos blancos se encuentra en un extremo para que al hacer
		//el get no me tire error
		if(this.indicePor("ColorDeZuecos", "Blancos") == 0){
			
			//El de zuecos blancos es el primero
			if(this.elfos.get(1).getMascota() != "Gato"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.indicePor("ColorDeZuecos", "Blancos") == 5){
			
			//El de zuecos blancos es el último
			if(this.elfos.get(4).getMascota() != "Gato"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.elfos.get(this.indicePor("ColorDeZuecos", "Blancos")+1).getMascota() != "Gato" && this.elfos.get(this.indicePor("ColorDeZuecos", "Blancos")-1).getMascota() != "Gato"){
			
			//El de zuecos blancos está en el medio
			aptitud +=10;
		
		} else {
			
			aptitud -=10;
			
		}
		
		//El dueño del gato vive junto al carpintero
		//Primero me fijo si el dueño del gato se encuentra en un extremo para que al hacer
		//el get no me tire error
		if(this.indicePor("Mascota", "Gato") == 0){
			
			//El dueño del gato es el primero
			if(this.elfos.get(1).getTrabajo() == "Carpintero"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.indicePor("Mascota", "Gato") == 5){
			
			//El dueño del gato es el último
			if(this.elfos.get(4).getTrabajo() == "Carpintero"){
				aptitud +=10;
			} else {
				aptitud -=10;
			}
			
		} else if(this.elfos.get(this.indicePor("Mascota", "Gato")+1).getTrabajo() == "Carpintero" || this.elfos.get(this.indicePor("Mascota", "Gato")-1).getTrabajo() == "Carpintero"){
			
			//El dueño del gato está en el medio
			aptitud +=10;
		
		} else {
			
			aptitud -=10;
			
		}
		
		return aptitud;
	}
}
