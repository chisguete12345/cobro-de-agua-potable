package sistemacheranaguapotable.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionBd {
    private static ConexionBd instancia;
    private Connection conectar = null;

    private ConexionBd() {
        // Constructor privado para el patrón Singleton
    }

    public static ConexionBd obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConexionBd();
        }
        return instancia;
    }

    public Connection conexion() {
        try {
            // Cargar el controlador JDBC (opcional pero recomendable en algunas versiones)
            Class.forName("com.mysql.jdbc.Driver");

            // URL de conexión con el puerto 3306 (puerto predeterminado para MySQL)
            conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/" + Ruta.database,
                Ruta.Usuario,
                Ruta.Contrasenia
   
            );
        

        } catch (Exception e) {
            System.err.println(" hola mundo"+e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conectar;
    }
}

