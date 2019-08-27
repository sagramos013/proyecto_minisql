/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicosql;

import java.io.File;

/**
 *
 * @author sagra
 */
public class Principal {
    public static void main(String[] args) {
        String ruta="C:/Users/sagra/Documents/NetBeansProjects/proyecto_minisql/src/lexicosql/lexico.flex";
        generadorLex(ruta);
    }
    public static void generadorLex(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}
