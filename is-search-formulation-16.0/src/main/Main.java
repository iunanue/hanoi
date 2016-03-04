package main;

import java.util.Scanner;

import es.deusto.ingenieria.is.search.formulation.Problem;

public class Main {

	private static int numSoportes;
	private static int numDiscos;
	private static int soporteInicial;
	private static int soporteFinal;
	
	private static Problem problem;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\t---TORRES DE HANOI---\n");
		readData();
		initProblem();
	}

	public static void readData() {
		Scanner sc = new Scanner(System.in);

		// N�MERO DE SOPORTES
		do {
			System.out.println("Introduzca el n�mero de SOPORTES:\n");
			while (!sc.hasNextInt()) {
				System.out.println("Introduzca un n�mero v�lido por favor\n");
				sc.next();
			}
			numSoportes = sc.nextInt();
		} while (numSoportes <= 0);

		// N�MERO DE DISCOS
		do {
			System.out.println("Introduzca el n�mero de DISCOS:\n");
			while (!sc.hasNextInt()) {
				System.out.println("Introduzca un n�mero v�lido por favor\n");
				sc.next();
			}
			numDiscos = sc.nextInt();
		} while (numDiscos <= 0);

		// SOPORTE INICIAL
		do {
			System.out.println("Introduzca el soporte INICIAL (0-" + (numSoportes - 1) + "):\n");
			while (!sc.hasNextInt()) {
				System.out.println("Introduzca un n�mero v�lido por favor\n");
				sc.next();
			}
			soporteInicial = sc.nextInt();
		} while ((soporteInicial < 0) || (soporteInicial > (numSoportes - 1)));

		// SOPORTE FINAL
		do {
			System.out.println(
					"Introduzca el soporte FINAL (0-" + (numSoportes - 1) + ", excepto el " + soporteInicial + "):\n");
			while (!sc.hasNextInt()) {
				System.out.println("Introduzca un n�mero v�lido por favor\n");
				sc.next();
			}
			soporteFinal = sc.nextInt();
		} while ((soporteFinal < 0) || (soporteFinal > (numSoportes - 1)) || (soporteFinal == soporteInicial));
		
		sc.close();
		
		//DATOS INTRODUCIDOS
		System.out.println("Datos introducidos");
		System.out.println("\tN�mero de SOPORTES: " + numSoportes);
		System.out.println("\tN�mero de DISCOS: " + numDiscos);
		System.out.println("\tSoporte INICIAL: " + soporteInicial);
		System.out.println("\tSoporte FINAL: " + soporteFinal);
	}
	public static void initProblem()
	{
		problem = new Problem(numSoportes,numDiscos,soporteInicial,soporteFinal);
	}

}