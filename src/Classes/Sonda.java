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
        if(x>Planalto.largura || x<0){
            System.err.println("Largura(x) superior ao Limite do planalto! Digite uma coordenada entre 0-"+Planalto.largura);
            return false;
        }else if(y>Planalto.comprimento || y<0){
            System.err.println("Comprimento(y) superior ao Limite do planalto! Digite uma coordenada entre 0-"+Planalto.comprimento);
            return false;
        }else if(!caracter.contains(tipo)){
            System.err.println("O Comando inserido não é valido!");
            return false;
        } else if(tipo.equals("M")){
            // Apontando para o norte a sonda nao pode ultrapassar o comprimento do planalto
            if(this.polo.equals("N"))if((this.y+1)<=Planalto.comprimento) this.y++; else System.err.println("A Sonda se encontra no limite do Planalto á:"+this.polo);
            // Apontando para o Sul a Sonda nao pode ultrapassar o ponto zero pois é o ponto onde começa o planalto
            if(this.polo.equals("S")) if((this.y-1)>=0) this.y--; else System.err.println("A Sonda se encontra no limite do Planalto á:"+this.polo);
            // Apontando para o Este a coodenada da sonda nao pode exceder a cordenada corespondente a largura do planalto
            if(this.polo.equals("E"))if((this.x+1)<=Planalto.largura) this.x++; else System.err.println("A Sonda se encontra no limite do Planalto á:"+this.polo);
            // Apontando para o West a Sonda nao pode ultrapaçar o ponto 0, pois é o ponto inicial da coordenada do planalto 
            if(this.polo.equals("W")) if((this.x-1)>=0) this.x--; else System.err.println("A Sonda se encontra no limite do Planalto á:"+this.polo);
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
