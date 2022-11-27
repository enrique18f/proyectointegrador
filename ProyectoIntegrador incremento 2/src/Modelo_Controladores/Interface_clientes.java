/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_Controladores;
import Beans.*;
import java.util.*;

public interface Interface_clientes {
    int adicion_cliente(Cliente e);
    List<Cliente> ListadoCliente ();
    int anular_cliente (int dni);
    int actualizar_cliente(Cliente e);
    List<Cliente> BusquedaCliente (int dni);
}
