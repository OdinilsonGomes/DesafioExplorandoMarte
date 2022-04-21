/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author DELL14
 */
public class Planalto {
    public static int comprimento;
    public static int largura;
    private int malha=comprimento;    
    public static ArrayList<Sonda> sonda= new ArrayList <Sonda>();
    
    
    public Planalto(int largura, int comprimento) {
            if(largura==comprimento){
                System.err.println("Esse Sistema coriosamente só permite planalto retangular");
            }else{
            this.comprimento = comprimento;
            this.largura = largura;
            }
        
    }

    public Planalto() {
        this.largura=0;
        this.comprimento=0;
        
    }

    
    
    public int getComprimento() {
        return comprimento;
    }

    public int getLargura() {
        return largura;
    }

    public int getMalha() {
        return malha;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setMalha(int malha) {
        this.malha = malha;
    }




}
