package alllink;

public class UsuarioPrincipal extends Usuario implements LoginStrategy {
    public UsuarioPrincipal(String nombre) {
        super(nombre);
    }

    @Override
    public void login() {
        System.out.println("[UsuarioPrincipal " + nombre + "]: inició sesión.");
    }

    public void tomarMedicamento(UsuarioAuxiliar aux) {
        System.out.println("[UsuarioPrincipal " + nombre + "]: Tomé mi medicamento.");
        NotificacionCommand cmd = new NotiMedicamento(this, aux);
        NotiInvoker invoker = new NotiInvoker();
        invoker.agregar(cmd);
        invoker.ejecutarTodos();
    }
}
