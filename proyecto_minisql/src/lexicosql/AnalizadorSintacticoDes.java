/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicosql;

import java.util.ArrayList;

/**
 *
 * @author sagra
 */
public class AnalizadorSintacticoDes {
    public static String analisis (ArrayList<String> miLista, ArrayList<Tokens> miToken){
        String valor = "";
        
        if (miLista.get( 0).contains("SELECT")) {//---------------------------------------------------------------------------------------SELECT
            
        }
        else if (miLista.get( 0).contains("INSERT")) {//----------------------------------------------------------------------------------INSERT
            int cant=0;
        }
        else if (miLista.get( 0).contains("UPDATE")) {//----------------------------------------------------------------------------------UPDATE
            miLista.remove(0);//se saca de la lista
            miToken.remove(0);
            if (!miLista.isEmpty()) {
                if (miToken.get(0) == Tokens.IDENTIFICADOR ) {
                    miLista.remove(0);//se saca de la lista
                    miToken.remove(0);
                    if (miLista.isEmpty()) {
                        if (miLista.get( 0).contains("SET") ) {
                            miLista.remove(0);//se saca de la lista
                            miToken.remove(0);
                            do{
                                if (!miLista.isEmpty()) {
                                    if (miToken.get(0) == Tokens.IDENTIFICADOR) {
                                        miLista.remove(0);//se saca de la lista
                                        miToken.remove(0);
                                        if (!miLista.isEmpty()) {
                                           if (miToken.get(0) == Tokens.COMPARADOR && miLista.get(0).contains("=")) {
                                               miLista.remove(0);//se saca de la lista
                                               miToken.remove(0);
                                               if (!miLista.isEmpty()) {
                                                   if (miToken.get(0) == Tokens.STRING || miToken.get(0) == Tokens.BIT  || miToken.get(0) == Tokens.DECIMAL  || miToken.get(0) == Tokens.ENTERO  || miToken.get(0) == Tokens.EXPONENCIAL  || miToken.get(0) == Tokens.IDENTIFICADOR) {
                                                       miLista.remove(0);//se saca de la lista
                                                       miToken.remove(0);
                                                       if (miLista.isEmpty()) {valor="Se esperaba ;"; break;}//si la lista esta vacia entonces da error
                                                   }else{valor="se esperaba un valor";break;}
                                               }else{valor="se esperaba un valor";break;}
                                           }else{valor="se esperaba =";break;}
                                       }{valor="Error. se esperaba =";break;}
                                   }else{valor="Error. se esperaba un IDENTIFICADOR";break;}
                                }
                            }while (miLista.get(0).contains(","));
                            
                            if (miToken.get(0) == Tokens.FINCADENA) {
                                miLista.remove(0);//se saca de la lista
                                miToken.remove(0);
                                //----------------------------------------------------------------------CADENA ACEPTADA
                            }else if(miLista.get(0).contains("WHERE") ){
                                miLista.remove(0);//se saca de la lista
                                miToken.remove(0);
                                do{
                                    if (!miLista.isEmpty()) {
                                        if (miToken.get(0) == Tokens.STRING || miToken.get(0) == Tokens.BIT  || miToken.get(0) == Tokens.DECIMAL  || miToken.get(0) == Tokens.ENTERO  || miToken.get(0) == Tokens.EXPONENCIAL  || miToken.get(0) == Tokens.IDENTIFICADOR) {
                                            miLista.remove(0);//se saca de la lista
                                            miToken.remove(0);
                                            if (!miLista.isEmpty()) {
                                                if (miToken.get(0) == Tokens.COMPARADOR) {
                                                    miLista.remove(0);//se saca de la lista
                                                    miToken.remove(0);
                                                    if (!miLista.isEmpty()) {
                                                        if (miToken.get(0) == Tokens.STRING || miToken.get(0) == Tokens.BIT  || miToken.get(0) == Tokens.DECIMAL  || miToken.get(0) == Tokens.ENTERO  || miToken.get(0) == Tokens.EXPONENCIAL  || miToken.get(0) == Tokens.IDENTIFICADOR) {
                                                            miLista.remove(0);//se saca de la lista
                                                            miToken.remove(0);
                                                            if (!miLista.isEmpty()) {
                                                                if (miToken.get(0) == Tokens.OPERADORL) {
                                                                    miLista.remove(0);//se saca de la lista
                                                                    miToken.remove(0);
                                                                    if (miLista.isEmpty()) { valor="Error. se esperaba";}
                                                                }else{valor="Error. Token no valido";}
                                                            }else{break;}
                                                        }else{valor="Error. se esperava un valor";}
                                                    }else{valor="Error. se esperava un valor";}
                                                }else{valor=" Error. se esperaba una condicion";}
                                            }else{valor="Error. se esperaba una condicion";}
                                        }else{valor="Error. se esperaba un Valor";}
                                    }else{valor="Error.  se esperaba una condicion";}
                                }while(miToken.get(0) == Tokens.FINCADENA && !miLista.isEmpty());
                            }else{valor = "Error.  Se esperaba ;"; }
                        }else{valor="Error. se esperaba SET";}
                    }else{valor = "Error.  Se esperaba un table_name"; }
                }else{valor = "Error.  Se esperaba un table_name"; }
            }else{valor = "Error.  Se esperaba un argumento"; }
        }
        else if (miLista.get( 0).contains("DELETE")) {//---------------------------------------------------------------------------------------DELETE
            miLista.remove(0);//se saca de la lista
            miToken.remove(0);
            if (!miLista.isEmpty()) {
                if (miLista.get(0).contains("FROM")) {
                    miLista.remove(0);//se saca de la lista
                    miToken.remove(0);
                    if (!miLista.isEmpty()) {
                        if (miToken.get(0) == Tokens.IDENTIFICADOR) {
                            miLista.remove(0);//se saca de la lista
                            miToken.remove(0);
                            if (!miLista.isEmpty()) {
                                if (miToken.get(0) == Tokens.FINCADENA) {
                                    miLista.remove(0);//se saca de la lista
                                    miToken.remove(0);
                                //----------------------------------------------------------------------CADENA ACEPTADA
                                }else if(miLista.get(0).contains("WHERE") ){
                                    miLista.remove(0);//se saca de la lista
                                    miToken.remove(0);
                                    do{
                                        if (!miLista.get(0).isEmpty()) {
                                            if (miToken.get(0) == Tokens.STRING || miToken.get(0) == Tokens.BIT  || miToken.get(0) == Tokens.DECIMAL  || miToken.get(0) == Tokens.ENTERO  || miToken.get(0) == Tokens.EXPONENCIAL  || miToken.get(0) == Tokens.IDENTIFICADOR) {
                                                miLista.remove(0);//se saca de la lista
                                                miToken.remove(0);
                                                if (!miLista.isEmpty()) {
                                                    if (miToken.get(0) == Tokens.COMPARADOR) {
                                                        miLista.remove(0);//se saca de la lista
                                                        miToken.remove(0);
                                                        if (!miLista.get(0).isEmpty()) {
                                                            if (miToken.get(0) == Tokens.STRING || miToken.get(0) == Tokens.BIT  || miToken.get(0) == Tokens.DECIMAL  || miToken.get(0) == Tokens.ENTERO  || miToken.get(0) == Tokens.EXPONENCIAL  || miToken.get(0) == Tokens.IDENTIFICADOR) {
                                                                if (!miLista.isEmpty()) {if (!miLista.isEmpty()) {
                                                                    if (miToken.get(0) == Tokens.OPERADORL) {
                                                                        miLista.remove(0);//se saca de la lista
                                                                        miToken.remove(0);
                                                                        if (miLista.isEmpty()) { valor="Error. se esperaba";}
                                                                    }else{valor="Error. Token no valido";}
                                                                }else{break;}
                                                                }
                                                            }else{valor="Error. se esperava un valor";break;}
                                                        }else{valor="Error. se esperava un valor";break;}
                                                    }else{valor=" Error. se esperaba una condicion";break;}
                                                }else{valor="Error. se esperaba una condicion";break;}
                                            }else{valor="Error. se esperaba un Valor";break;}
                                        }else{valor="Error.  se esperaba una condicion"; break;}
                                    }while(miToken.get(0) == Tokens.FINCADENA);
                                }else{valor = "Error.  Se esperaba ;"; }
                            }else{valor="Error se esperaba ;";}
                            
                        }else{valor="Error. se esperaba un table_name";}
                    }else{valor = "Error.  Se esperaba un table_name"; }
                }else{valor = "Error.  Se esperaba palabra reservada FROM"; }
            }else{valor = "Error.  Se esperaba un argumento"; }
        }
        else if (miLista.get( 0).contains("CREATE")) {//----------------------------------------------------------------------------------------CREATE
            
        }
        else if (miLista.get( 0).contains("DROP")) {//--------------------------------------------------------------------------------------------DROP
            miLista.remove(0);//se saca de la lista
            miToken.remove(0);
            if (!miLista.isEmpty()) {
                if (miLista.get(0).contains("TABLE")) {
                    miLista.remove(0);//se saca de la lista
                    miToken.remove(0);
                    if (!miLista.isEmpty()) {
                        if (miToken.get(0) == Tokens.IDENTIFICADOR) {
                            miLista.remove(0);//se saca de la lista
                            miToken.remove(0);
                            if (!miLista.isEmpty()) {
                                if ((miToken.get(0) == Tokens.FINCADENA)){
                                    miLista.remove(0);//se saca de la lista
                                    miToken.remove(0);
                                }else{valor="Error. se esperaba";}
                            }else{valor="Error. se esperaba ;";}
                        }else{valor="Error. se esperaba un table_name";}
                    }else{valor= "Error. se esperaba un table_name";}
                }else{valor= "Error. se esperaba TABLE";}
            }else{valor="Error. se esperaba un argumento";}
        }
        else if (miLista.get( 0).contains("ALTER")) {//------------------------------------------------------------------------------------------ALTER
            miLista.remove(0);//se saca de la lista
            miToken.remove(0);
            if (!miLista.isEmpty()) {
                if (miLista.get(0).contains("TABLE")) {
                    miLista.remove(0);//se saca de la lista
                    miToken.remove(0);
                    if (!miLista.isEmpty()) {
                        if (miToken.get(0) == Tokens.IDENTIFICADOR) {
                            miLista.remove(0);//se saca de la lista
                            miToken.remove(0);
                            if (!miLista.isEmpty()) {
                                switch(miLista.get(0)){
                                case "ADD":
                                    miLista.remove(0);//se saca de la lista
                                    miToken.remove(0);
                                    if (!miLista.isEmpty()) {
                                        if (miToken.get(0) == Tokens.IDENTIFICADOR) {
                                            miLista.remove(0);//se saca de la lista
                                            miToken.remove(0);
                                            if (!miLista.isEmpty()){
                                                if (miLista.get(0).contains("INTEGER") || miLista.get(0).contains("CHAR") || miLista.get(0).contains("INT") || miLista.get(0).contains("BIT")){
                                                    miLista.remove(0);//se saca de la lista
                                                    miToken.remove(0);
                                                    if (!miLista.isEmpty()){
                                                        if (miToken.get(0) == Tokens.FINCADENA) {
                                                            miLista.remove(0);//se saca de la lista
                                                            miToken.remove(0);
                                                        }else{valor="Error. se esperaba ;";}
                                                    }else{valor="Error. se esperaba ;";}
                                                }else{valor="Error. se esperaba data_type";}
                                            }else{valor="Error. se esperaba data_type";}
                                        }else{valor="Error. se esperaba column_name";}
                                    }else{valor="Error. se esperaba column_name";}
                                    break;
                                case "DROP":
                                    miLista.remove(0);//se saca de la lista
                                    miToken.remove(0);
                                    if (!miLista.isEmpty()) {
                                        if (miLista.get(0).contains("COLUMN")) {
                                            miLista.remove(0);//se saca de la lista
                                            miToken.remove(0);
                                            if (!miLista.isEmpty()) {
                                                if (miToken.get(0) == Tokens.IDENTIFICADOR) {
                                                    miLista.remove(0);//se saca de la lista
                                                    miToken.remove(0);
                                                    if (!miLista.isEmpty()){
                                                        if (miLista.get(0).contains("INTEGER") || miLista.get(0).contains("CHAR") || miLista.get(0).contains("INT") || miLista.get(0).contains("BIT")){
                                                            miLista.remove(0);//se saca de la lista
                                                            miToken.remove(0);
                                                            if (!miLista.isEmpty()){
                                                                if (miToken.get(0) == Tokens.FINCADENA) {
                                                                    miLista.remove(0);//se saca de la lista
                                                                    miToken.remove(0);
                                                                }else{valor="Error. se esperaba ;";}
                                                            }else{valor="Error. se esperaba ;";}
                                                        }else{valor="Error. se esperaba data_type";}
                                                    }else{valor="Error. se esperaba data_type";}
                                                }else{valor="Error. se esperaba table_name";}
                                            }else{valor="Error. se esperaba table_name";}
                                        }else{valor="Error. se esperaba COLUMN";}
                                    }else{valor="Error. se esperaba COLUMN";}
                                    break;
                                case "ALTER":
                                     miLista.remove(0);//se saca de la lista
                                    miToken.remove(0);
                                    if (!miLista.isEmpty()) {
                                        if (miLista.get(0).contains("COLUMN")) {
                                            miLista.remove(0);//se saca de la lista
                                            miToken.remove(0);
                                            if (!miLista.isEmpty()) {
                                                if (miToken.get(0) == Tokens.IDENTIFICADOR) {
                                                    miLista.remove(0);//se saca de la lista
                                                    miToken.remove(0);
                                                    if (!miLista.isEmpty()){
                                                        if (miToken.get(0) == Tokens.FINCADENA) {
                                                            miLista.remove(0);//se saca de la lista
                                                            miToken.remove(0);
                                                        }else{valor="Error. se esperaba ;";}
                                                    }else{valor="Error. se esperaba ;";}
                                                }else{valor="Error. se esperaba table_name";}
                                            }else{valor="Error. se esperaba table_name";}
                                        }else{valor="Error. se esperaba COLUMN";}
                                    }else{valor="Error. se esperaba COLUMN";}
                                    break;
                                }
                            }else{valor="Error. se esperaba un argumento";}
                        }else{valor="Error. se esperaba table_name";}
                    }else{valor="Error. se esperaba table_name";}
                }else{valor="Error. se esperaba TABLE";}
            }else{valor="Error. se esperaba TABLE";}
        }
        if (valor=="" && !miLista.isEmpty()) {
            
            valor="Argumento no valido '" + miLista.get(0)+"'";
        }
        if (!miLista.isEmpty()) {
                int fin = miLista.size();
                for (int i = 0; i < fin; i++) {
                    miLista.remove(0);
                    miToken.remove(0);
                }                
            }
        return valor;
    }
}
