package Gui;

import java.sql.*;

/**
 *
 * @author martin
 */
public class Base {

    Connection c = null;
    Statement stmt = null;
    ResultSet rsNM = null;
    ResultSet rsM = null;

    public Base() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:elementos.sqlite");
            c.setAutoCommit(false);
            rsNM = stmt.executeQuery("SELECT * FROM NoMetales;");
            rsM = stmt.executeQuery("Select * From Metales;");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public String[] getElementNameArrayNM() {
        String[] arr = new String[64];
        int i = 0;
        try {
            while (this.rsNM.next()) {
                String aux = this.rsNM.getString("Nombre");
                arr[i] = aux;
                i++;
            }
            return arr;
        } catch (SQLException e) {
            String[] err = {"no"};
            return err;
        }
    }

    public String[] getElementNameArrayM() {
        String[] arr = new String[64];
        int i = 0;
        try {
            while (this.rsM.next()) {
                String aux = this.rsM.getString("Nombre");
                arr[i] = aux;
                i++;
            }
            return arr;
        } catch (SQLException e) {
            String[] err = {"no"};
            return err;
        }
    }

    public int[] getElementStatesArrayNM(int id) {
        String strArr = null;
        int[] arr = null;
        try {
            while (this.rsNM.next()) {
                if (rsNM.getInt("ID") == id+1) {
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
            arr = null;
        }
        return arr;
    }

    public int[] getElementStatesArrayM(int id) {
        String strArr = null;
        int[] arr = null;
        try {
            while (this.rsM.next()) {
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
            arr = null;
        }
        return arr;
    }

    public String getElementNomNM(int id) {
        String nom = null;
        try {
            while (this.rsNM.next()) {
                if (rsNM.getInt("ID") == id + 1) {
                    nom = rsNM.getString("Nomencaltura");
                }
            }
        } catch (SQLException e) {
            nom = null;
        }
        return nom;
    }

    public String getElementNomM(int id) {
        String nom = null;
        try {
            while (this.rsM.next()) {
                if (rsM.getInt("ID") == id + 1) {
                    nom = rsM.getString("Nomencaltura");
                }
            }
        } catch (SQLException e) {
            nom = null;
        }
        return nom;
    }
}
