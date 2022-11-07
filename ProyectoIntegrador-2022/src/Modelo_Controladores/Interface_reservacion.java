package Modelo_Controladores;
import Beans.Reservacion;
import java.util.List;

public interface Interface_reservacion {
    int registrar_reservacion(Reservacion e);
    List<Reservacion> ListadoReservacion ();
    int eliminar_reservacion (int dni);
    int actualizar_reservacion(Reservacion e);
}
