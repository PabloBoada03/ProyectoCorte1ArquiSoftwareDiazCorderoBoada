package alllink;

import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class DatabaseSimulator {
    private static final String PRINCIPALES_FILE = "data/usuarios_principales.json";
    private static final String AUXILIARES_FILE = "data/usuarios_auxiliares.json";
    private static final Gson gson = new Gson();

    public static void guardarPrincipal(UsuarioPrincipal u) {
        List<UsuarioPrincipal> lista = cargarPrincipales();
        lista.add(u);
        guardarEnArchivo(lista, PRINCIPALES_FILE);
    }

    public static void guardarAuxiliar(UsuarioAuxiliar u) {
        List<UsuarioAuxiliar> lista = cargarAuxiliares();
        lista.add(u);
        guardarEnArchivo(lista, AUXILIARES_FILE);
    }

    public static UsuarioPrincipal buscarPrincipal(String nombre) {
        return cargarPrincipales().stream()
                .filter(u -> u.getNombre().equals(nombre))
                .findFirst().orElse(null);
    }

    public static UsuarioAuxiliar buscarAuxiliar(String nombre) {
        return cargarAuxiliares().stream()
                .filter(u -> u.getNombre().equals(nombre))
                .findFirst().orElse(null);
    }

    public static UsuarioAuxiliar obtenerAuxiliarAleatorio() {
        List<UsuarioAuxiliar> lista = cargarAuxiliares();
        if (lista.isEmpty()) return null;
        return lista.get(new Random().nextInt(lista.size()));
    }

    private static <T> void guardarEnArchivo(List<T> lista, String archivo) {
        try (Writer writer = new FileWriter(archivo)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<UsuarioPrincipal> cargarPrincipales() {
        return cargarDesdeArchivo(PRINCIPALES_FILE, new TypeToken<List<UsuarioPrincipal>>() {}.getType());
    }

    private static List<UsuarioAuxiliar> cargarAuxiliares() {
        return cargarDesdeArchivo(AUXILIARES_FILE, new TypeToken<List<UsuarioAuxiliar>>() {}.getType());
    }

    private static <T> List<T> cargarDesdeArchivo(String archivo, java.lang.reflect.Type type) {
        try (Reader reader = new FileReader(archivo)) {
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
