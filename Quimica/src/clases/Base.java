package clases;

import java.sql.*;

/**
 *
 * @author martin
 */
public class Base {

    Connection c = null;
    Statement stmt = null;

    /**
     * Inicia la base de datos, en caso de que ocurra un error cerrara el
     * programa
     */
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

    /**
     * Devuelve un Array con todos los nombres de los No Metales, el array esta
     * organizado de la misma forma en la que esta en la tabla
     *
     * @return String[]
     * @throws SQLException en caso de algun error SQL
     */
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

    /**
     * Devuelve todos los nombres de los metales en un Array de string ordenado
     * como esta en la tabla.
     *
     * @return String[]
     * @throws SQLException cuando hay algun error en el SQL
     */
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
     * elemento No Metalico.
     *
     * @param id es el numero que se usa para buscar en la base. Siempre es el
     * valor que devuelve la combobox
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
            }
            String[] strings = strArr.replace("[", "").replace("]", "").split(", ");
            arr = new int[strings.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    /**
     * Busca y devuelve un array con todos los Estados de oxidacion de un
     * elemento Metalico.
     *
     * @param id es el numero que se usa para buscar en la base. Siempre es el
     * valor que devuelve la combobox
     * @return int[]
     * @throws SQLException la tira si hay algun error, ya sea en la busqueda o
     * volviendo el contador de la base a 0
     */
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
            }
            String[] strings = strArr.replace("[", "").replace("]", "").split(", ");
            arr = new int[strings.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    /**
     * Devuelve un String con la nomenclatura de un elemento No Metalico en
     * especifico. Esta funcion se debe usar en conjunto con
     * <code>getElementStatesArrayNM()</code>
     *
     * @param id Este debe ser el que devuelve la combobox
     * @return String
     * @throws SQLException en caso de que haya un error SQL
     */
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

    /**
     * Devuelve un String con la nomenclatura de un elemento Metalico en
     * especifico. Esta funcion se debe usar en conjunto con
     * <code>getElementStatesArrayM()</code>
     *
     * @param id Este debe ser el que devuelve la combobox
     * @return String
     * @throws SQLException en caso de que haya un error SQL
     */
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

    /**
     * Devuelve un String con el nombre de un elemento No Metalico en
     * especifico.
     *
     * @param id Este debe ser el que devuelve la combobox pero solo si se
     * utilizo la funcion getElementStatesArrayM() o su opuesta ya que esta
     * funcion busca segun\ ese id
     * @return String
     * @throws SQLException en caso de que haya un error SQL
     */
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

    /**
     * Devuelve un String con la nomenclatura de un elemento Metalico en
     * especifico.
     *
     * @param id Este debe ser el que devuelve la combobox pero solo si se
     * utilizo la funcion getElementStatesArrayM() o su opuesta ya que esta
     * funcion busca segun\ ese id
     * @return String
     * @throws SQLException en caso de que haya un error SQL
     */
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

    /**
     * busca y devuelve un array con todos los nombres de los elementos No
     * Metalicos en una misma columna en la tabla periodica
     *
     * @param colum Es la columna en la cual buscar los elementos
     * @return String[]
     * @throws SQLException en caso de que ocurra un error SQL
     */
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

    /**
     * busca y devuelve un array con todos los nombres de los elementos
     * Metalicos en una misma columna en la tabla periodica
     *
     * @param colum Es la columna en la cual buscar los elementos
     * @return String[]
     * @throws SQLException en caso de que ocurra un error SQL
     */
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

    /**
     * Busca en la base de datos un elemento No Metalico segun su columna y el
     * id propocionado por la combobox despues de haber cargado los elementos
     * con <code>getElementColumArrayNM</code>
     *
     * @param colum es la Columna en la que se desea buscar
     * @param id Es el id dentro de esa columna
     * @return String
     * @throws SQLException
     */
    public String getElementColumNameNM(int colum, int id) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM NoMetales;");
        String name = null;
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("Columna") == colum) {
                    if (rsNM.getInt("IDCOlum") == id + 1) {
                        name = rsNM.getString("Nombre");
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return name;
    }

    /**
     * Busca en la base de datos un elemento Metalico segun su columna y el id
     * propocionado por la combobox despues de haber cargado los elementos con
     * <code>getElementColumArrayM</code>
     *
     * @param colum es la Columna en la que se desea buscar
     * @param id Es el id dentro de esa columna
     * @return String
     * @throws SQLException
     */
    public String getElementColumNameM(int colum, int id) throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM Metales;");
        String name = null;
        try {
            while (rsM.next()) {
                if (rsM.getInt("Columna") == colum) {
                    if (rsM.getInt("IDColum") == id + 1) {
                        name = rsM.getString("Nombre");
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return name;
    }

    /**
     * Busca la nomenclatura de un elemento No Metalico segun su columna y su id
     * dentro de esa columna que lo proporcionara el mismo index de la combobox
     * siempre y cuando se hayan cargado los elementos con
     * <code>getElementColumArrayNM</code>
     *
     * @param colum Es la columna en la cual se buscara
     * @param id Es el ID Dentro de esa columna
     * @return String
     * @throws SQLException en caso de que se genere un Error SQL
     */
    public String getElementColumNomNM(int colum, int id) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM 'NoMetales';");
        String nom = null;
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("Columna") == colum) {
                    if (rsNM.getInt("IDColum") == id + 1) {
                        nom = rsNM.getString("Nomenclatura");
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return nom;
    }

    /**
     * Busca la nomenclatura de un elemento Metalico segun su columna y su id
     * dentro de esa columna que lo proporcionara el mismo index de la combobox
     * siempre y cuando se hayan cargado los elementos con
     * <code>getElementColumArrayM</code>
     *
     * @param colum Es la columna en la cual se buscara
     * @param id Es el ID Dentro de esa columna
     * @return String
     * @throws SQLException en caso de que se genere un Error SQL
     */
    public String getElementColumNomM(int colum, int id) throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM Metales;");
        String nom = null;
        try {
            while (rsM.next()) {
                if (rsM.getInt("Columna") == colum) {
                    if (rsM.getInt("IDColum") == id + 1) {
                        nom = rsM.getString("Nomenclatura");
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return nom;
    }

    /**
     * Es similar a <code>getElementStatesArrayNM</code> pero esta busca en la
     * columna elegida, junto con con el ID que es proporcionado por la combobox
     * siempre y cuando se le hayan cargado los elementos con
     * <code>getElementColumArrayNM</code>
     *
     * @param colum Es la columna en la que se buscara
     * @param id Es el id dentro de la columna
     * @return int[]
     * @throws SQLException
     */
    public int[] getElementColumStatesArrayNM(int colum, int id) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM 'NoMetales';");
        String strArr = null;
        int[] arr = null;
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("Columna") == colum) {
                    if (rsNM.getInt("IDColum") == id + 1) {
                        strArr = rsNM.getString("Estados");
                        break;
                    }
                }
            }
            String[] strings = strArr.replace("[", "").replace("]", "").split(", ");
            arr = new int[strings.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    /**
     * Es similar a <code>getElementStatesArrayM</code> pero esta busca en la
     * columna elegida, junto con con el ID que es proporcionado por la combobox
     * siempre y cuando se le hayan cargado los elementos con
     * <code>getElementColumArrayM</code>
     *
     * @param colum Es la columna en la que se buscara
     * @param id Es el id dentro de la columna
     * @return int[]
     * @throws SQLException
     */
    public int[] getElementColumStatesArrayM(int colum, int id) throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM Metales;");
        String strArr = null;
        int[] arr = null;
        try {
            while (rsM.next()) {
                if (rsM.getInt("Columna") == colum) {
                    if (rsM.getInt("IDColum") == id + 1) {
                        strArr = rsM.getString("Estados");
                        break;
                    }
                }
            }
            String[] strings = strArr.replace("[", "").replace("]", "").split(", ");
            arr = new int[strings.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    public float getElementElenegNM(int id) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM NoMetales;");
        float eleneg = 0.0f;
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("ID") == id + 1) {
                    eleneg = rsNM.getFloat("Eleneg");
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return eleneg;
    }

    public float getElementElenegM(int id) throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM Metales;");
        float eleneg = 0.0f;
        try {
            while (rsM.next()) {
                if (rsM.getInt("ID") == id + 1) {
                    eleneg = rsM.getFloat("Eleneg");
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return eleneg;
    }

    public float getElementColumElenegNM(int colum, int id) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM NoMetales;");
        float eleneg = 0.0f;
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("Columna") == colum) {
                    if (rsNM.getInt("IDColum") == id + 1) {
                        eleneg = rsNM.getFloat("Eleneg");
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return eleneg;
    }

    public float getElementColumElenegM(int colum, int id) throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM Metales;");
        float eleneg = 0.0f;
        try {
            while (rsM.next()) {
                if (rsM.getInt("Columna") == colum) {
                    if (rsM.getInt("IDColum") == id + 1) {
                        eleneg = rsM.getFloat("Eleneg");
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return eleneg;
    }
}
