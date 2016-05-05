/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.modelo;

import javax.persistence.Persistence;

/**
 *
 * @author Lupi
 */
public class Principal {
    public static void main(String[] args) {
        Persistence.generateSchema("EMASAPU2", null);
    }
}
