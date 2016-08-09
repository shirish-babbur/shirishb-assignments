package com.webonise.tv;

public interface Componant {
	//adds componants to the tv dynamically
	public void addComponant(String nameOfComponant);
	// returns componants specified by nameOfComponant
	public Componant getComponant(String nameOfComponant);
	
}
