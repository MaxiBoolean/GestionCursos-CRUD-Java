package Main;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Main {

    //Atributos de conexión
    private Connection conectar = null;

    private final String contrasena = "root";

    private final String usuario = "root";

    private final String db = "cohorte2";

    private final String ip = "localhost";

    private final String puerto = "3306";

    private final String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + db;

    public Connection establecerConeccion() {
        try {
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            //JOptionPane.showMessageDialog(null, "Se conectó correctamente");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos" + e.toString());
        }
        return conectar;
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.establecerConeccion();
    }
}
