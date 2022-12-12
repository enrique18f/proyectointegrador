/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Beans.Reservacion;
import UTIL.MySQLConexion;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class controlador_reservacion implements Modelo_Controladores.Interface_reservacion{

    @Override
    public int registrar_reservacion(Reservacion e) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "Insert into reservacion values(null,?,?,?,?,?,?,?,?,?)";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, e.getId_empleado());
            st.setInt(2, e.getId_cliente());
            st.setString(3, e.getCategoria_habitacion());
            st.setString(4, e.getId_numhabitacion());
            st.setString(5, e.getId_tipopago());
            st.setString(6, e.getFecha_reservacion());
            st.setString(7, e.getFecha_ingreso());
            st.setString(8, e.getFecha_salida());
            st.setDouble(9, e.getMonto_pago());
            resp = st.executeUpdate(); 
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return resp;
    }

    @Override
    public List<Reservacion> ListadoReservacion() {
        List<Reservacion> lis = new ArrayList();
        Connection conn = null;
        try{
          String sql = "select * from reservacion";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Reservacion re=new Reservacion();
                re.setCodigo(rs.getInt(1));
                re.setId_empleado(rs.getString(2));
                re.setId_cliente(rs.getInt(3));
                re.setCategoria_habitacion(rs.getString(4));
                re.setId_numhabitacion(rs.getString(5));
                re.setId_tipopago(rs.getString(6));
                re.setFecha_reservacion(rs.getString(7));
                re.setFecha_ingreso(rs.getString(8));
                re.setFecha_salida(rs.getString(9));
                re.setMonto_pago(rs.getDouble(10));
                
                lis.add(re);
            }
            } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return lis;
    }

    @Override
    public int eliminar_reservacion(int codigo) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "delete from reservacion where codigo= ?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,codigo);
            resp = st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return resp;
    }

    @Override
    public int actualizar_reservacion(Reservacion e) {
                int resp = 0;
        Connection conn = null;
        try {
            String sql = "update reservacion set id_empleado=?,id_cliente=?,categoria_habitacion=?,id_numhabitacion=?,id_tipodepago=?,fecha_reservacion=?,fecha_ingreso=?,fecha_salida=?,monto_pago=? where CODIGO=?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(10, e.getCodigo());
            st.setString(1, e.getId_empleado());
            st.setInt(2, e.getId_cliente());
            st.setString(3, e.getCategoria_habitacion());
            st.setString(4, e.getId_numhabitacion());
            st.setString(5, e.getId_tipopago());
            st.setString(6, e.getFecha_reservacion());
            st.setString(7, e.getFecha_ingreso());
            st.setString(8, e.getFecha_salida());
            st.setDouble(9, e.getMonto_pago());

            resp = st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return resp;
    }
    
    @Override
    public List<Reservacion> BusquedaReservacion(String Reserva) {
       List<Reservacion> lis = new ArrayList();
        Connection conn = null;
        try {
            String sql = "SELECT A.CODIGO,A.ID_CLIENTE,B.NOMBRE,B.APELLIDO FROM reservacion A LEFT JOIN clientes B on  A.ID_CLIENTE = b.DNI where A.CODIGO = ?;";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,Reserva);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Reservacion ap = new Reservacion();
                ap.setCodigo(rs.getInt(1));
                ap.setId_cliente(rs.getInt(2));
                //Se usa el ID EMPLEADO PARA COLOCAR NORMBRE DE CLIENTE PROVISIONAL
                String Nombre = rs.getString(3);
                String Apellido = rs.getString(4);
                ap.setId_empleado(Nombre + " " +Apellido);                
                lis.add(ap);
            }
        } catch (Exception ax) {
            ax.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception a2) {
            }
        }

        return lis;
    }
    
    public void enviarcorreo(String c,String num ,String fecha,String fechain , String fechasa, String monto){
        String Correo="hotelceba@gmail.com";
        
        String correoEnvia = "hotelceba@gmail.com";
        String contrasena = "ydwlgogybovjewjk";
        
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.setProperty("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.port", "587");
        prop.setProperty("mail.smtp.port", "587");
        prop.put("mail.smtp.user", correoEnvia);
        prop.setProperty("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.trust", "*");
        
        Session sesion = Session.getDefaultInstance(prop);
        MimeMessage mail = new MimeMessage(sesion);
        
        try{
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(Correo));
            mail.setSubject("Prueba de Envio Email Java App ");
           
            String htmlcode = contenido(c,num,fecha,fechain,fechasa,monto);
            
            mail.setContent(htmlcode, "text/html");
            
            Transport transporte = sesion.getTransport("smtp");
            
            transporte.connect(correoEnvia, contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            
            transporte.close();
            
            System.out.println("El correo se envio CORRECTAMENTE");
            
            
        }catch (Exception ex){
            System.out.println("ERROR DE ENVIO DE CORREO "+ex);
        }
        
        
    }

    private String contenido(String c,String num ,String fecha,String fechain , String fechasa, String monto) {
        String cliente = c;
        String numhabitacion = num;
        String fechareserva = fecha;
        String fechaingreso = fechain;
        String fechasalida = fechasa;
        String montopagado = monto;
        
        String contenido = 
        "<html>\n" +
        "<head>\n" +
        "\n" +
        "    <style>\n" +
        "        \n" +
        "        body{\n" +
        "            width: 50%;\n" +
        "            margin: auto;\n" +
        "            font-family: 'Lucida Sans';\n" +
        "        }\n" +
        "\n" +
        "        section{\n" +
        "            background-color: aliceblue;\n" +
        "            padding: 50px;\n" +
        "            \n" +
        "        }\n" +
        "\n" +
        "        section h1{\n" +
        "            text-align: center;\n" +
        "        }\n" +
        "        \n" +
        "        section div{\n" +
        "            width: 80%;\n" +
        "            margin: auto;\n" +
        "        }\n" +
        "    </style>\n" +
        "\n" +
        "</head>\n" +
        "\n" +
        "<body>\n" +
        "\n" +
        "    <section >\n" +
        "        <h1>Hotel CEBA</h1>\n" +
        "        <div>\n" +
        "            <h2> Reserva de habitacion realizada</h2>\n" +
        "            <p>\n" +
        "                <h3>Cliente:</h3>\n" +cliente+
        "            </p>\n" +
        "            <p>\n" +
        "                <h3>Numero de Habitacion:</h3> \n" +numhabitacion+
        "            </p>\n" +
        "            <p>\n" +
        "                <h3>Hora de reserva:</h3>\n" +fecha+
        "            </p>\n" +
        "            <p>\n" +
        "                <h3>Fecha de ingreso:</h3>\n" +fechaingreso+
        "            </p>\n" +
        "            <p>\n" +
        "                <h3>Fecha de salida:</h3>\n" +fechasalida+
        "            </p>\n" +
        "            <p>\n" +
        "                <h3>Monto Pagado:</h3>\n" +montopagado+
        "            </p>\n" +
        "        </div>\n" +
        "        \n" +
        "    </section>\n" +
        "\n" +
        "\n" +
        "</body>\n" +
        "</html>";
        
        return contenido;
    }

    
}
