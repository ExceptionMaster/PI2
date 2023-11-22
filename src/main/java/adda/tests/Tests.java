package adda.tests;

import java.util.Scanner;

public class Tests {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
            System.out.println("\nIntroduce el ejercicio a ejecutar:");
            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 2");
            System.out.println("3. Ejercicio 3");
            System.out.println("4. Ejercicio 4");
            System.out.println("5. Salir");

            int opcion = s.nextInt();

            try {
            	switch (opcion) {
                case 1:
                    System.out.println("===== EJERCICIO 1 =====");
                    TestEjercicio1.test();
                    break;
                case 2:
                    System.out.println("===== EJERCICIO 2 =====");
                    TestEjercicio2.test();
                    break;
                case 3:
                    System.out.println("===== EJERCICIO 3 =====");
                    TestEjercicio3.test();
                    break;
                case 4:
                    System.out.println("===== EJERCICIO 4 =====");
                    TestEjercicio4.test();
                    break;
                case 5:
                	System.out.println("Saliendo...");
                	s.close();
                	System.exit(0);
                default:
                    System.out.println("Ejercicio no válido.");
            	}
            } catch(Exception e) {
            	System.out.println("Excepcion: \n" + "    " + e);
            }
        }
	}
}
