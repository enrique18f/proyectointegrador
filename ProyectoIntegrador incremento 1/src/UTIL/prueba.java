
package UTIL;
import Beans.*;
import Controlador.controlador_cliente;
import Controlador.controlador_categoriaH;
//import beans.*;
//import controlador.negocio2;
public class prueba {

    public static void main(String[] args) {
      MySQLConexion.getConexion();
      controlador_cliente obj=new controlador_cliente();
      obj.adicion_cliente(new Cliente(0,"miguel","bautista", 75487478, 984764484));
      //negocio2 obj=new negocio2();
      
     //obj.AdicionCli(new cliente("74726719", "Gian Marco","Larico Pereyra","san juan de miraflores MZ(s)LT(7)","glp_23@hot","940944083" ));
     //obj.AdicionCli(new cliente("74726720", "Mirian Ariana","Larico Pereyra","san juan de miraflores MZ(s)LT(7)","glp_23@hot","94095687" ));
     //obj.AdicionCli(new cliente("75441046", "Dayana","Arce","villa","darce@hot.com","941913926" ));
     
       //obj.Anula("0001");
  
    //obj.AdicionPro(new producto(1,"polo rojo","M",25,15) );
    //obj.AdicionPro(new producto(2,"polo rosa","XL",5.3,10) );
    //obj.Adicionvent(new Ventas(9999999, "98", "9999999", "12", "12", "2019", 300, 100, 1) );
    
    controlador_categoriaH controlch = new controlador_categoriaH();
    Categoria_Habitacion c = new Categoria_Habitacion();
    c.setDescripcion("Nueva categoria");
    c.setPrecio(Double.parseDouble("240"));
    controlch.insertar(c);
    
    }
    
}
