/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import beans.HolaMundoEjbRemote;
import javax.naming.*;

/**
 *
 * @author Johan
 */
public class TestHolaMundoEJB {
    public static void main(String[] args) {
        System.out.println("iniciando llamada al ejb desde el cleinte\n");
        try{
            Context jndi = new InitialContext();
            HolaMundoEjbRemote holaMundoEJB = (HolaMundoEjbRemote) jndi.lookup("java:global/HolaMundoEJB-1.0/HolaMundoEjbImpl");
            int resultado = holaMundoEJB.sumar(5,3);
            System.out.println("resultado de 5+3: "+resultado);
        }catch(NamingException e){
            e.printStackTrace(System.out);
        }
    }
}
