package alllink;

public class NotiEmergencia implements NotificacionCommand {
    @Override
    public void ejecutar() {
        System.out.println("⚠️ Notificación: Emergencia, llamar al 911.");
    }
}
