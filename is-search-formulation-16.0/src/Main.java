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

		// NÚMERO DE SOPORTES
		do {
			System.out.println("Introduzca el número de SOPORTES:\n");
			while (!sc.hasNextInt()) {
				System.out.println("Introduzca un número válido por favor\n");
				sc.next();
			}
			numSoportes = sc.nextInt();
		} while (numSoportes <= 0);

		// NÚMERO DE DISCOS
		do {
			System.out.println("Introduzca el número de DISCOS:\n");
			while (!sc.hasNextInt()) {
				System.out.println("Introduzca un número válido por favor\n");
				sc.next();
			}
			numDiscos = sc.nextInt();
		} while (numDiscos <= 0);

		// SOPORTE INICIAL
		do {
			System.out.println("Introduzca el soporte INICIAL:\n");
			while (!sc.hasNextInt()) {
				System.out.println("Introduzca un número válido por favor\n");
				sc.next();
			}
			soporteInicial = sc.nextInt();
		} while ((soporteInicial < 1) || (soporteInicial > numSoportes));

		// SOPORTE FINAL
		do {
			System.out.println("Introduzca el soporte FINAL (excepto el " + soporteInicial + "):\n");
			while (!sc.hasNextInt()) {
				System.out.println("Introduzca un número válido por favor\n");
				sc.next();
			}
			soporteFinal = sc.nextInt();
		} while ((soporteFinal < 1) || (soporteFinal > numSoportes) || (soporteFinal == soporteInicial));

		sc.close();

		// DATOS INTRODUCIDOS
		System.out.println("Datos introducidos");
		System.out.println("\tNúmero de SOPORTES: " + numSoportes);
		System.out.println("\tNúmero de DISCOS: " + numDiscos);
		System.out.println("\tSoporte INICIAL: " + soporteInicial);
		System.out.println("\tSoporte FINAL: " + soporteFinal);

		soporteInicial = soporteInicial - 1;
		soporteFinal = soporteFinal - 1;
	}

	public static void initProblem() {
		problem = new Problem(numSoportes, numDiscos, soporteInicial, soporteFinal);
		problem.runTest();

	}

}
