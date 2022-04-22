/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author DELL14
 */
public class Retangulo {
    protected static int comprimento;
    protected static int largura;

    
    
    public Retangulo() {
    
    }

    public static int getComprimento() {
        return comprimento;
    }

    public static int getLargura() {
        return largura;
    }

    public static void setComprimento(int comprimento) {
        Retangulo.comprimento = comprimento;
    }

    public static void setLargura(int largura) {
        Retangulo.largura = largura;
    }
    
    
}
