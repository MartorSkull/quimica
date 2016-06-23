/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

/**
 *
 * @author martin
 */
public class Formulas {

    public int[] calcularDos(int estado1, int estado2) {
        int[] cant = {0, 0};
        for (int i = 0; i < 5; i++) {
            for (int e = 0; e < 5; i++) {
                if ((i * estado1) + (e * estado2) == 0) {
                    cant[0] = i;
                    cant[1] = e;
                }
            }
        }
        return cant;
    }
}
