package alllink;

import java.util.ArrayList;
import java.util.List;

public class NotiInvoker {
    private final List<NotificacionCommand> cola = new ArrayList<>();

    public void agregar(NotificacionCommand cmd) {
        cola.add(cmd);
    }

    public void ejecutarTodos() {
        for (NotificacionCommand cmd : cola) cmd.ejecutar();
        cola.clear();
    }
}
