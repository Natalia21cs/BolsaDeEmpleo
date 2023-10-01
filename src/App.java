import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BolsaDeEmpleo {
    private Connection conexion;

    public BolsaDeEmpleo() {
        try {
            // Establecer la conexión con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bolsa_empleo", "usuario", "contraseña");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarAspirante(String cedula, String nombre, int edad, int experiencia, String profesion, String telefono) {
        try {
            // Insertar un nuevo aspirante en la base de datos
            String consulta = "INSERT INTO aspirantes (cedula, nombre, edad, experiencia, profesion, telefono) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, cedula);
            statement.setString(2, nombre);
            statement.setInt(3, edad);
            statement.setInt(4, experiencia);
            statement.setString(5, profesion);
            statement.setString(6, telefono);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> mostrarCedulasAspirantes() {
        List<String> cedulas = new ArrayList<>();
        try {
            // Obtener las cédulas de todos los aspirantes
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT cedula FROM aspirantes");
            while (resultSet.next()) {
                cedulas.add(resultSet.getString("cedula"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cedulas;
    }

    public void mostrarInformacionAspirante(String cedula) {
        try {
            // Obtener la información detallada de un aspirante por cédula
            String consulta = "SELECT * FROM aspirantes WHERE cedula=?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, cedula);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Cédula: " + resultSet.getString("cedula"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Edad: " + resultSet.getInt("edad"));
                System.out.println("Experiencia: " + resultSet.getInt("experiencia"));
                System.out.println("Profesión: " + resultSet.getString("profesion"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
            } else {
                System.out.println("No se encontró un aspirante con esa cédula.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void buscarPorNombre(String nombre) {
        try {
            // Buscar aspirantes por nombre
            String consulta = "SELECT * FROM aspirantes WHERE nombre=?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Cédula: " + resultSet.getString("cedula"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Edad: " + resultSet.getInt("edad"));
                System.out.println("Experiencia: " + resultSet.getInt("experiencia"));
                System.out.println("Profesión: " + resultSet.getString("profesion"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ordenarAspirantesPorExperiencia() {
        try {
            // Ordenar la lista de aspirantes por años de experiencia
            String consulta = "SELECT * FROM aspirantes ORDER BY experiencia DESC";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                System.out.println("Cédula: " + resultSet.getString("cedula"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Edad: " + resultSet.getInt("edad"));
                System.out.println("Experiencia: " + resultSet.getInt("experiencia"));
                System.out.println("Profesión: " + resultSet.getString("profesion"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ordenarAspirantesPorEdad() {
        try {
            // Ordenar la lista de aspirantes por edad
            String consulta = "SELECT * FROM aspirantes ORDER BY edad ASC";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                System.out.println("Cédula: " + resultSet.getString("cedula"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Edad: " + resultSet.getInt("edad"));
                System.out.println("Experiencia: " + resultSet.getInt("experiencia"));
                System.out.println("Profesión: " + resultSet.getString("profesion"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ordenarAspirantesPorProfesion() {
        try {
            // Ordenar la lista de aspirantes por profesión
            String consulta = "SELECT * FROM aspirantes ORDER BY profesion ASC";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                System.out.println("Cédula: " + resultSet.getString("cedula"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Edad: " + resultSet.getInt("edad"));
                System.out.println("Experiencia: " + resultSet.getInt("experiencia"));
                System.out.println("Profesión: " + resultSet.getString("profesion"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultarAspiranteMayorExperiencia() {
        try {
            // Consultar el aspirante con mayor experiencia
            String consulta = "SELECT * FROM aspirantes ORDER BY experiencia DESC LIMIT 1";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);
            if (resultSet.next()) {
                System.out.println("Cédula: " + resultSet.getString("cedula"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Edad: " + resultSet.getInt("edad"));
                System.out.println("Experiencia: " + resultSet.getInt("experiencia"));
                System.out.println("Profesión: " + resultSet.getString("profesion"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
            } else {
                System.out.println("No hay aspirantes registrados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultarAspiranteMasJoven() {
        try {
            // Consultar el aspirante más joven
            String consulta = "SELECT * FROM aspirantes ORDER BY edad ASC LIMIT 1";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);
            if (resultSet.next()) {
                System.out.println("Cédula: " + resultSet.getString("cedula"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Edad: " + resultSet.getInt("edad"));
                System.out.println("Experiencia: " + resultSet.getInt("experiencia"));
                System.out.println("Profesión: " + resultSet.getString("profesion"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
            } else {
                System.out.println("No hay aspirantes registrados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contratarAspirante(String cedula) {
        try {
            // Eliminar un aspirante de la base de datos al contratarlo
            String consulta = "DELETE FROM aspirantes WHERE cedula=?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, cedula);
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("El aspirante con cédula " + cedula + " ha sido contratado.");
            } else {
                System.out.println("No se encontró un aspirante con esa cédula.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarAspirantesExperienciaMenor(int experienciaMinima) {
        try {
            // Eliminar aspirantes que tengan una experiencia menor a cierta cantidad especificada
            String consulta = "DELETE FROM aspirantes WHERE experiencia < ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, experienciaMinima);
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se han eliminado aspirantes con menos de " + experienciaMinima + " años de experiencia.");
            } else {
                System.out.println("No se encontraron aspirantes con menos de " + experienciaMinima + " años de experiencia.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double calcularPromedioEdadAspirantes() {
        double promedioEdad = 0;
        try {
            // Calcular el promedio de edad de los aspirantes
            String consulta = "SELECT AVG(edad) AS promedio FROM aspirantes";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);
            if (resultSet.next()) {
                promedioEdad = resultSet.getDouble("promedio");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promedioEdad;
    }

    public void cerrarConexion() {
        try {
            // Cerrar la conexión a la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BolsaDeEmpleo bolsa = new BolsaDeEmpleo();

        // ASPIRANTES
        bolsa.agregarAspirante("123456", "Juan Pérez", 30, 5, "Ingeniero", "123-456-7890");
        bolsa.agregarAspirante("789012", "Ana López", 25, 3, "Contador", "987-654-3210");

        List<String> cedulas = bolsa.mostrarCedulasAspirantes();
        System.out.println("Cédulas de aspirantes: " + cedulas);

        bolsa.mostrarInformacionAspirante("123456");
        bolsa.mostrarInformacionAspirante("999999"); // Cédula inexistente

        bolsa.buscarPorNombre("Juan Pérez");

        System.out.println("Aspirantes ordenados por experiencia:");
        bolsa.ordenarAspirantesPorExperiencia();

        System.out.println("Aspirantes ordenados por edad:");
        bolsa.ordenarAspirantesPorEdad();

        System.out.println("Aspirantes ordenados por profesión:");
        bolsa.ordenarAspirantesPorProfesion();

        System.out.println("Aspirante con mayor experiencia:");
        bolsa.consultarAspiranteMayorExperiencia();

        System.out.println("Aspirante más joven:");
        bolsa.consultarAspiranteMasJoven();

        bolsa.contratarAspirante("123456");

        bolsa.eliminarAspirantesExperienciaMenor(2);

        double promedioEdad = bolsa.calcularPromedioEdadAspirantes();
        System.out.println("Promedio de edad de los aspirantes: " + promedioEdad);

        // Cerrar la conexión a la base de datos al finalizar
        bolsa.cerrarConexion();
    }
}
