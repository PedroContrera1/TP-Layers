package ejercicio2.model;
import java.time.MonthDay;

public class MensajeCumpleanos {
    private RegistroDeEmpleados registroDeEmpleados;
    private Notificacion email;
    public MensajeCumpleanos(RegistroDeEmpleados registroDeEmpleados, Notificacion email){
        this.registroDeEmpleados=registroDeEmpleados;
        this.email=email;
    }
    public void enviarSaludos(MonthDay unDiaMes){
        var empleados=this.registroDeEmpleados.empleados();
        for (var empleado : empleados){
            if (empleado.esTuCumple(unDiaMes)){
                this.email.enviarEmail(empleado.email(),"Feliz cumpleanos");
            }
        }
    }
}
