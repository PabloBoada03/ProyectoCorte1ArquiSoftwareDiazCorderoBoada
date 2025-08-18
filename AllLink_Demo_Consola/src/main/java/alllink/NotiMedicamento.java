package alllink;

public class NotiMedicamento implements NotificacionCommand {
    private final UsuarioPrincipal principal;
    private final UsuarioAuxiliar auxiliar;

    public NotiMedicamento(UsuarioPrincipal principal, UsuarioAuxiliar auxiliar) {
        this.principal = principal;
        this.auxiliar = auxiliar;
    }

    @Override
    public void ejecutar() {
        auxiliar.update(principal.getNombre() + ": Tomé mi medicamento.");
    }
}
