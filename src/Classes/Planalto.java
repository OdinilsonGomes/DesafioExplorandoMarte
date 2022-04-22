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
public class Planalto extends Retangulo{

    public static ArrayList<Sonda> sonda= new ArrayList <Sonda>();
    
    
    public Planalto(int largura, int comprimento) {
            if(largura==comprimento){
                System.err.println("Esse Sistema curiosamente só permite planalto retangular");
            }else{
            this.comprimento = comprimento;
            this.largura = largura;
            }
        
    }

    public Planalto() {
        this.largura=0;
        this.comprimento=0;
        
    }

}
