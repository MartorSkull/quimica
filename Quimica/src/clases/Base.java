package clases;

import java.sql.*;
import java.util.ArrayList;

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
        String[] arr = new String[15];
        int i = 0;
        boolean firs = false;
        try {
            while (rsNM.next()) {
                if (firs) {
                    String aux = rsNM.getString("Nombre");
                    arr[i] = aux;
                    i++;
                } else {
                    firs = true;
                }
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
        String[] arr = new String[34];
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

    private int[] getElementColumNM(int id) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM NoMetales;");
        int[] colum = {0, 0};
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("ID") == id) {
                    colum[0] = rsNM.getInt("Columna");
                    colum[1] = rsNM.getInt("IDColum");
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return colum;
    }

    private int[] getElementColumM(int id) throws SQLException {
        ResultSet rsM = stmt.executeQuery("SELECT * FROM Metales;");
        int[] colum = {0, 0};
        try {
            while (rsM.next()) {
                if (rsM.getInt("ID") == id) {
                    colum[0] = rsM.getInt("Columna");
                    colum[1] = rsM.getInt("IDColum");
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return colum;
    }

    public Elemento getElementoCompletoNM(int id, int estado_used) throws SQLException {

        Elemento a;
        a = new Elemento(id,
                this.getElementNameNM(id),
                this.getElementNomNM(id),
                this.getElementStatesArrayNM(id),
                estado_used,
                this.getElementColumNM(id)[0],
                this.getElementColumNM(id)[1],
                this.getElementElenegNM(id));
        return a;
    }

    public Elemento getElementoCompletoM(int id, int estado_used) throws SQLException {

        Elemento a;
        a = new Elemento(id,
                this.getElementNameM(id),
                this.getElementNomM(id),
                this.getElementStatesArrayM(id),
                estado_used,
                this.getElementColumM(id)[0],
                this.getElementColumM(id)[1],
                this.getElementElenegM(id));
        return a;
    }

    public Elemento getElementoCompletoColumNM(int id, int colum, int estado_used) throws SQLException {

        Elemento a;
        a = new Elemento(id,
                this.getElementColumNameNM(colum, id),
                this.getElementColumNomNM(colum, id),
                this.getElementColumStatesArrayNM(colum, id),
                estado_used,
                colum,
                id,
                this.getElementColumElenegNM(colum, id));
        return a;
    }

    public Elemento getElementoCompletoColumM(int id, int colum, int estado_used) throws SQLException {

        Elemento a;
        a = new Elemento(id,
                this.getElementColumNameM(colum, id),
                this.getElementColumNomM(colum, id),
                this.getElementColumStatesArrayM(colum, id),
                estado_used,
                colum,
                id,
                this.getElementColumElenegM(colum, id));
        return a;
    }

    public ArrayList<Elemento> getElementArrayNM() throws SQLException {
        ArrayList<Elemento> arr = new ArrayList();
        boolean firs = false;
        try {
            System.out.println(getElementNameArrayNM().length);
            for (int i = 0; i < getElementNameArrayNM().length; i++) {
                if (firs) {
                    Elemento aux = new Elemento(i,
                            this.getElementNameNM(i),
                            this.getElementNomNM(i),
                            this.getElementStatesArrayNM(i),
                            this.getElementColumNM(i)[0],
                            this.getElementColumNM(i)[1],
                            this.getElementElenegNM(i));
                    arr.add(aux);
                } else {
                    firs = true;
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    public ArrayList<Elemento> getElementArrayM() throws SQLException {
        ArrayList<Elemento> arr = new ArrayList();
        try {
            for (int i = 0; i < this.getElementNameArrayM().length; i++) {
                Elemento aux = new Elemento(i,
                        this.getElementNameM(i),
                        this.getElementNomM(i),
                        this.getElementStatesArrayM(i),
                        this.getElementColumM(i)[0],
                        this.getElementColumM(i)[1],
                        this.getElementElenegM(i));
                arr.add(aux);
            }
        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    public ArrayList<Elemento> getElementColumArrayListNM(int colum) throws SQLException {
        ResultSet rsNM = stmt.executeQuery("SELECT * FROM 'NoMetales';");
        ArrayList<Elemento> arr = new ArrayList();
        try {
            while (rsNM.next()) {
                if (rsNM.getInt("Columna") == colum) {
                    int n = rsNM.getInt("ID");
                    Elemento aux = new Elemento(n,
                            this.getElementNameNM(n),
                            this.getElementNomNM(n),
                            this.getElementStatesArrayNM(n),
                            this.getElementColumNM(n)[0],
                            this.getElementColumNM(n)[1],
                            this.getElementElenegNM(n));
                    arr.add(aux);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }

    public ArrayList<Elemento> getElementColumArrayListM(int colum) throws SQLException {
        ArrayList<Elemento> m = this.getElementArrayM();
        m.iterator()
        ArrayList<Elemento> arr = new ArrayList();
        try {
            while (rsM.next()) {
                if (rsM.getInt("Columna") == colum) {
                    int n = rsM.getInt("ID");
                    Elemento aux = new Elemento(n,
                                                this.getElementNameM(n),
                                                this.getElementNomM(n),
                                                this.getElementStatesArrayM(n),
                                                this.getElementColumM(n)[0],
                                                this.getElementColumM(n)[1],
                                                this.getElementElenegM(n));
                    boolean a = arr.add(aux);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arr;
    }
}
