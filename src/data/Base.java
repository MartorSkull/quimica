package data;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author martin
 */
public abstract class Base {

    private static ArrayList<Elemento> metales = new ArrayList();
    private static ArrayList<Elemento> nometales = new ArrayList();
    private static ArrayList[] tabla = {metales, nometales};
    private static final String archivo = "Elementos.al";
    private static FileInputStream fis = null;
    private static ObjectInputStream ois = null;
    private static FileOutputStream fos = null;
    private static ObjectOutputStream oos = null;

    /*
     * Devuelve un arraylist con las ventas en disco
     */
    public static void load() {
        System.out.println("Intentando levantar la lista");
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);

            while (true) {
                tabla = (ArrayList[]) ois.readObject();
            }
        } catch (EOFException e1) {
            //END OF FILE!
            System.out.println("Sale");
        } catch (Exception e2) {
            System.out.println("Error!!!" + e2);
        } finally {
            metales = tabla[0];
            nometales = tabla[1];
            try {
                if (ois != null) {
                    ois.close();
                    ois = null;
                }
                if (fis != null) {
                    fis.close();
                    fis = null;
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar archivo");
            }
        }
    }

    public static ArrayList<Elemento> getTodosMetales() {
        return Base.metales;
    }

    public static ArrayList<Elemento> getTodosNoMetales() {
        return Base.nometales;
    }

    public static ArrayList<Elemento> getMetalesEnColumna(int colum) {
        ArrayList<Elemento> el = new ArrayList();
        for (Elemento i : Base.metales) {
            if (i.getColum() == colum) {
                el.add(i);
            }
        }
        return el;
    }

    public static ArrayList<Elemento> getNoMetalesEnColumna(int colum) {
        ArrayList<Elemento> el = new ArrayList();
        for (Elemento i : Base.nometales) {
            if (i.getColum() == colum) {
                el.add(i);
            }
        }
        return el;
    }

    public static Elemento getMetal(int id) {
        Elemento e = null;
        for (Elemento i : Base.metales) {
            if (i.getId() == id) {
                e = i;
                break;
            }
        }
        return e;
    }

    public static Elemento getNoMetal(int id) {
        Elemento e = null;
        for (Elemento i : Base.nometales) {
            if (i.getId() == id) {
                e = i;
                break;
            }
        }
        return e;
    }

    public static Elemento getMetalEnColumna(int id, int colum) {
        Elemento e = null;
        for (Elemento i : Base.metales) {
            if (i.getIdColum() == id && i.getColum() == colum) {
                e = i;
                break;
            }
        }
        return e;
    }

    public static Elemento getNoMetalEnColumna(int id, int colum) {
        Elemento e = null;
        for (Elemento i : Base.nometales) {
            if (i.getIdColum() == id && i.getColum() == colum) {
                e = i;
                break;
            }
        }
        return e;
    }
}
