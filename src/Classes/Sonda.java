/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Dao.sondaAcao;
import Classes.Bussola;

/**
 *
 * @author DELL14
 */
public class Sonda implements sondaAcao{
    
   private int x,y; 
   // As direcoes podem ser: N,S,E,W
   // A polo inicial da sonda será N(norte)
   private String polo;
   private Bussola bussola =new Bussola();
   
    public Sonda(int x, int y, String polo) {
        this.x = x;
        this.y = y;
        this.polo = polo;
    }

   
    @Override
    public boolean girar(String direcao, int grau) {
        // pegar o polo  
        String polo_futuro = bussola.consulatar_bussola(this.polo,direcao, grau);
        if(!polo_futuro.equals("0")){
            this.polo=polo_futuro;
            return true;
        }
        else{
            System.err.println("Não é possivel girar a Sonda de acordo com as coordenadas");
            return false;
        }
            
    }

    @Override
    public boolean mover(int x, int y, String tipo) {
        String caracter ="MNEWS";
        if(x>Planalto.largura){
            System.err.println("Largura(x) superior a do planalto! Por favor tente com uma coordenada menor");
            return false;
        }else if(y>Planalto.comprimento){
            System.err.println("Comprimento(y) superior a do planalto! Por favor tente com uma coordenada menor");
            return false;
        }else if(!caracter.contains(tipo)){
            System.err.println("O Comando inserido não é valido!");
            return false;
        } else if(tipo.equals("M")){
            if(this.polo.equals("N"))this.y++;            
            if(this.polo.equals("E"))this.x++;
            if(this.polo.equals("S"))this.y--;
            if(this.polo.equals("W"))this.x--;
            return true;
         }else{
            this.x=x;
            this.y=y;
            this.polo=tipo; 
            return true;
        }
    
    }
   
  
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getPolo() {
        return polo;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPolo(String polo) {
        this.polo = polo;
    }

    
   
   
}
