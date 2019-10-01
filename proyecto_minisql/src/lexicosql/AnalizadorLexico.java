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
import java.util.ArrayList;

/**
 *
 * @author sagra
 */
public class AnalizadorLexico {
    
ArrayList<String> miLista;


    public static void main(String[] args) {
        File archivo2 = new File("Diamond.sql.out");
        ArrayList<String> miLista;
        ArrayList<Tokens> miToken;
        miLista = new ArrayList<String>();
        miToken = new ArrayList<Tokens>();
        
        
        int line = 0, column = 0;
        Tokens tokens;
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo2);            
        
            Reader lector = new BufferedReader(new FileReader("otro.sql"));
            Lexer lexer = new Lexer(lector);
            String resultado = "", analisis = "";
            boolean esAlter=false;
            while (true) {
                tokens = lexer.yylex();
                if (tokens == null) {
                    if (!miLista.isEmpty()) {
                        if (miLista.get(0).contains("INSERT") || miLista.get(0).contains("UPDATE") || miLista.get(0).contains("DELETE") || miLista.get(0).contains("CREATE") || miLista.get(0).contains("DROP")) {
                            analisis = AnalizadorSintacticoDes.analisis(miLista,miToken); 
                        } 
                    }
                    resultado += "FIN";
                    escribir.println(resultado);
                    escribir.close();
                    return;
                }
                switch (tokens) {
                    case RESERVADA://pasan solo las palabras reservadas
                        if (!miLista.isEmpty()) {
                            if (miLista.get(0).contains("ALTER")) {
                                if (esAlter) {
                                    if(!miLista.isEmpty()){//ve a hacer el calculo si la lista no esta llena
                                       analisis = AnalizadorSintacticoDes.analisis(miLista,miToken);
                                       resultado += analisis != "" ? analisis + " Linea: " + line + " Columna: " + column + "\n" : "";
                                   }
                                }else{esAlter=true;}
                            } else if (esAlter) {
                                if (miLista.get(0).contains("DROP")) {
                                    if(!miLista.isEmpty()){//ve a hacer el calculo si la lista no esta llena
                                        analisis = AnalizadorSintacticoDes.analisis(miLista,miToken);
                                        resultado += analisis != "" ? analisis + " Linea: " + line + " Columna: " + column + "\n" : "";
                                    }
                                }else{
                                    analisis = "Error. se esperaba argumento";
                                    resultado += analisis != "" ? analisis + " Linea: " + line + " Columna: " + column + "\n" : "";
                                    int fin = miLista.size();
                                    for (int i = 0; i < fin; i++) {
                                        miLista.remove(0);
                                        miToken.remove(0);
                                    } 
                                }   
                            }else{
                                if (lexer.lexeme.contains("SELECT") || lexer.lexeme.contains("INSERT") || lexer.lexeme.contains("UPDATE") || lexer.lexeme.contains("DELETE") || lexer.lexeme.contains("CREATE") || lexer.lexeme.contains("DROP") || lexer.lexeme.contains("ALTER")) {
                                    //resultado += lexer.lexeme + " " + tokens +" " + lexer.line + " " + lexer.column + "\n";
                                    if(!miLista.isEmpty()){//ve a hacer el calculo de 
                                        analisis = AnalizadorSintacticoDes.analisis(miLista,miToken);
                                        resultado += analisis != "" ? analisis + " Linea: " + line + " Columna: " + column + "\n" : "";
                                    }
                                }
                                
                            }
                            
                        }
                        miLista.add(lexer.lexeme.toUpperCase());//Agregamos a la lista y en mayusculas
                        miToken.add(tokens);
                        line = lexer.line + 1;//Se guarada la nueva linea y columan en donde inicia el siguiente token a analizar
                        column = lexer.column;
                        break;
                    default:
                        //resultado += lexer.lexeme + " " + tokens +" " + lexer.line + " " + lexer.column + "\n";
                        miLista.add(lexer.lexeme);
                        miToken.add(tokens);
                        break;
                }
            }
        } catch (FileNotFoundException ex) {} catch (IOException ex) {}
    }
}
