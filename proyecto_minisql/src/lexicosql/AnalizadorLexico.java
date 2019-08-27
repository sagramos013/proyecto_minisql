/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicosql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sagra
 */
public class AnalizadorLexico {
    public static void main(String[] args) {
        File archivo2 = new File("prueba.out");
        
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo2);            
        
            Reader lector = new BufferedReader(new FileReader("prueba.txt"));
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    resultado += "FIN";
                    escribir.println(resultado);
                    escribir.close();
                    return;
                }
                switch (tokens) {
                    case ERROR:
                        resultado += "Simbolo no definido\n";
                        break;
                    case Identificador:resultado += lexer.lexema + ": Es un " + tokens + "\n";
                        break;
                    case entero: resultado += lexer.lexema + ": Es un " + tokens + "\n";
                        break;
                    case Reservadas:
                        resultado += lexer.lexema + ": Es un " + tokens + "\n";
                        break;
                    case Operador:
                        resultado += lexer.lexema + ": Es un " + tokens + "\n";
                        break;
                    case booleanas:
                        resultado += lexer.lexema + ": Es un " + tokens + "\n";
                        break;    
                    case decimal:
                        resultado += lexer.lexema + ": Es un " + tokens + "\n";
                        break;
                    case cadena:
                        resultado += lexer.lexema + ": Es un " + tokens + "\n";
                        break;
                    default:
                        resultado += "Token: " + tokens + "\n";
                        break;
                }
            }
            
        } catch (FileNotFoundException ex) {} catch (IOException ex) {}
        
        
    }
}
