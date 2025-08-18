package alllink;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final AuthProvider authProvider = new AuthProvider();

    public static void main(String[] args) {
        while (true) {
            System.out.println("===== Bienvenido a AllLink =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("> ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> registrar();
                case 2 -> login();
                case 3 -> { System.exit(0); }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void registrar() {
        System.out.println("Seleccione tipo de usuario:");
        System.out.println("1. Principal (Adulto Mayor)");
        System.out.println("2. Auxiliar");
        int tipo = Integer.parseInt(sc.nextLine());

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        if (tipo == 1) {
            UsuarioPrincipal u = new UsuarioPrincipal(nombre);
            DatabaseSimulator.guardarPrincipal(u);
            System.out.println("UsuarioPrincipal registrado: " + nombre);
        } else {
            UsuarioAuxiliar u = new UsuarioAuxiliar(nombre);
            DatabaseSimulator.guardarAuxiliar(u);
            System.out.println("UsuarioAuxiliar registrado: " + nombre);
        }
    }

    private static void login() {
        System.out.println("Seleccione tipo de usuario:");
        System.out.println("1. Principal");
        System.out.println("2. Auxiliar");
        int tipo = Integer.parseInt(sc.nextLine());

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        if (tipo == 1) {
            UsuarioPrincipal principal = DatabaseSimulator.buscarPrincipal(nombre);
            if (principal != null) {
                authProvider.setStrategy(principal);
                authProvider.login();
                InterfazSimple.mostrarMenuPrincipal(principal);
            } else System.out.println("Usuario no encontrado.");
        } else {
            UsuarioAuxiliar aux = DatabaseSimulator.buscarAuxiliar(nombre);
            if (aux != null) {
                authProvider.setStrategy(aux);
                authProvider.login();
            } else System.out.println("Usuario no encontrado.");
        }
    }
}
