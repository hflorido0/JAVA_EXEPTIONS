package main;

import manager.Manager;

public class Main {

	public static void main(String[] args) {
		//Aqu� nunca han de llegar las excpeciones
		(new Manager()).init();		
	}
}
