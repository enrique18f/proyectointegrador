
package Modelo_Controladores;

import Beans.Habitacion;
import java.util.List;

public interface Interface_habitaciones {
    int adicion_habitacion(Habitacion e);
    List<Habitacion> ListadoHabitacion ();
    int anular_habitacion (int numero_hab);
    int actualizar_habitacion(Habitacion e);
    List<Habitacion> BusquedaHabitacion(int numero_hab);
}
