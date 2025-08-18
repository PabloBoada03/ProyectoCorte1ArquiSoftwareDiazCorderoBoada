package alllink;

import java.util.Scanner;

public class InterfazSimple {
    private static final Scanner sc = new Scanner(System.in);

    public static void mostrarMenuPrincipal(UsuarioPrincipal principal) {
        while (true) {
            System.out.println("Menú Principal:");
            System.out.println("1. Tomar medicamento");
            System.out.println("2. Volver al inicio");
            System.out.print("> ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    UsuarioAuxiliar aux = DatabaseSimulator.obtenerAuxiliarAleatorio();
                    if (aux != null) principal.tomarMedicamento(aux);
                    else System.out.println("No hay auxiliares registrados.");
                }
                case 2 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
