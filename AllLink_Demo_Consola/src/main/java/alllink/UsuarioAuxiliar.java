package alllink;

public class UsuarioAuxiliar extends Usuario implements LoginStrategy, Observer {
    public UsuarioAuxiliar(String nombre) {
        super(nombre);
    }

    @Override
    public void login() {
        System.out.println("[UsuarioAuxiliar " + nombre + "]: inició sesión.");
    }

    @Override
    public void update(String mensaje) {
        System.out.println("[UsuarioAuxiliar " + nombre + "]: 1 notificación -> " + mensaje);
    }
}
