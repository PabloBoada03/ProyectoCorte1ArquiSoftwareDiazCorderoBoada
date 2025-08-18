package alllink;

public class NotiCita implements NotificacionCommand {
    @Override
    public void ejecutar() {
        System.out.println("Notificación: Recordatorio de cita médica.");
    }
}
