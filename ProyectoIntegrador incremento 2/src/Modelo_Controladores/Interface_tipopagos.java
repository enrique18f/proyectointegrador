/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_Controladores;
import Beans.Tipo_Pagos;
import java.util.*;

public interface Interface_tipopagos {
    int agregar_tipopago(Tipo_Pagos t);
    List<Tipo_Pagos> Listadotipopagos ();
    int eliminar (int id);
    int actualizar_tipopago(Tipo_Pagos t);
}
