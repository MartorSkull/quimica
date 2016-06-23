package Gui;

import java.sql.*;

/**
 *
 * @author martin
 */
public class Base {

    Connection c = null;
    Statement stmt = null;

    public Base() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:elementos.sqlite");
            c.setAutoCommit(false);
            stmt = c.createStatement();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public String[] getElementNameArrayNM() throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM 'NoMetales';");
        String[] arr = new String[64];
        int i = 0;
        try {
            while (rsNM.next()) {
                String aux = rsNM.getString("Nombre");
                arr[i] = aux;
                i++;
            }

        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    public String[] getElementNameArrayM() throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM Metales;");
        String[] arr = new String[64];
        int i = 0;
        try {
            while (rsM.next()) {
                String aux = rsM.getString("Nombre");
                arr[i] = aux;
                i++;
            }
        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    /**
     * Busca y devuelve un array con todos los Estados de oxidacion de un
     * elemento.
     *
     * @param id es el numero que se usa para buscar en la base.
     * @return int[]
     * @throws SQLException la tira si hay algun error, ya sea en la busqueda o
     * volviendo el contador de la base a 0
     */
    public int[] getElementStatesArrayNM(int id) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM 'NoMetales';");
        String strArr = null;
        int[] arr = null;
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("ID") == id + 1) {
                    strArr = rsNM.getString("Estados");
                    break;
                }
                String[] strings = strArr.replace("[", "").replace("]", "").split(", ");
                arr = new int[strings.length];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = Integer.parseInt(strings[i]);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    public int[] getElementStatesArrayM(int id) throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM Metales;");
        String strArr = null;
        int[] arr = null;
        try {
            while (rsM.next()) {
                if (rsM.getInt("ID") == id + 1) {
                    strArr = rsM.getString("Estados");
                    break;
                }
                String[] strings = strArr.replace("[", "").replace("]", "").split(", ");
                arr = new int[strings.length];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = Integer.parseInt(strings[i]);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    public String getElementNomNM(int id) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM 'NoMetales';");
        String nom = null;
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("ID") == id + 1) {
                    nom = rsNM.getString("Nomenclatura");
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return nom;
    }

    public String getElementNomM(int id) throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM Metales;");
        String nom = null;
        try {
            while (rsM.next()) {
                if (rsM.getInt("ID") == id + 1) {
                    nom = rsM.getString("Nomenclatura");
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return nom;
    }

    public String getElementNameNM(int id) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM 'NoMetales';");
        String name = null;
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("ID") == id + 1) {
                    name = rsNM.getString("Nombre");
                }
            }
        } catch (SQLException e) {
            name = null;
        }
        return name;
    }

    public String getElementNameM(int id) throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM Metales;");
        String name = null;
        try {
            while (rsM.next()) {
                if (rsM.getInt("ID") == id + 1) {
                    name = rsM.getString("Nombre");
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return name;
    }

    public String[] getElementColumArrayNM(int colum) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM 'NoMetales';");
        String[] arr = new String[4];
        int i = 0;
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("Columna") == colum) {
                    String aux = rsNM.getString("Nombre");
                    arr[i] = aux;
                    i++;
                }
            }

        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    public String[] getElementColumArrayM(int colum) throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM 'Metales';");
        String[] arr = new String[4];
        int i = 0;
        try {
            while (rsM.next()) {
                if (rsM.getInt("Columna") == colum) {
                    String aux = rsM.getString("Nombre");
                    arr[i] = aux;
                    i++;
                }
            }

        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    public String getElementColumNameNM(int colum, int id) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM NoMetales;");
        String name = null;
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("Columna") == colum) {
                    if (rsNM.getInt("ID") == id + 1) {
                        name = rsNM.getString("Nombre");
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return name;
    }

    public String getElementColumNameM(int colum, int id) throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM Metales;");
        String name = null;
        try {
            while (rsM.next()) {
                if (rsM.getInt("Columna") == colum) {
                    if (rsM.getInt("ID") == id + 1) {
                        name = rsM.getString("Nombre");
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return name;
    }

    public String getElementColumNomNM(int colum, int id) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM 'NoMetales';");
        String nom = null;
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("Columna") == colum) {
                    if (rsNM.getInt("ID") == id + 1) {
                        nom = rsNM.getString("Nomenclatura");
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return nom;
    }

    public String getElementColumNomM(int colum, int id) throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM Metales;");
        String nom = null;
        try {
            while (rsM.next()) {
                if (rsM.getInt("Columna") == colum) {
                    if (rsM.getInt("ID") == id + 1) {
                        nom = rsM.getString("Nomencaltura");
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return nom;
    }

    public int[] getElementColumStatesArrayNM(int colum, int id) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM 'NoMetales';");
        String strArr = null;
        int[] arr = null;
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("Columna") == colum) {
                    if (rsNM.getInt("ID") == id + 1) {
                        strArr = rsNM.getString("Estados");
                        break;
                    }
                }
                String[] strings = strArr.replace("[", "").replace("]", "").split(", ");
                arr = new int[strings.length];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = Integer.parseInt(strings[i]);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    public int[] getElementColumStatesArrayM(int colum, int id) throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM Metales;");
        String strArr = null;
        int[] arr = null;
        try {
            while (rsM.next()) {
                if (rsM.getInt("Columna") == colum) {
                    if (rsM.getInt("ID") == id + 1) {
                        strArr = rsM.getString("Estados");
                        break;
                    }
                }
                String[] strings = strArr.replace("[", "").replace("]", "").split(", ");
                arr = new int[strings.length];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = Integer.parseInt(strings[i]);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }
}
