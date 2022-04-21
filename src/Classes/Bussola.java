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
public class Bussola {
    // A nossa bussola sempre aponta para o norte
    private String polo="N";
    //Norte recebe o numero de 0
    private int id_polo=0;
    
    
    public String consulatar_bussola(String polo,String direcao, int grau){
        // direcao R (direita em ingles)
        // direcao L (esquerda em ingels)
        
        // Pegando o Polo da Sonda e atribuindo um ID ao mesmo
       if(polo.equals("E"))
            id_polo=90;
       if(polo.equals("S")) 
            id_polo=180;
       if(polo.equals("W"))
            id_polo=270;
       if(polo.equals("N"))
            id_polo=0;
        // Posição a direita soma pontos ao polo
       if(direcao.equals("R")){
        // o Polo norte tem dois valores de ID, a Ideia é zerar o polo após os 360 graus 
           if(id_polo>=360) id_polo=0;
           id_polo+=grau;
       }
       // Posicao a Esquerda subtrai os pontos do polo 
       if(direcao.equals("L")){
           if(id_polo<=0) id_polo=360;
           id_polo-=grau;
       }
       // retorna o Polo de acordo ao ID obtido
       if(id_polo==90)
            return "E";
       if(id_polo==180)
            return "S";
       if(id_polo==270)
            return "W";
       if(id_polo==0||id_polo==360)
            return "N";
       else
            return "0";
    }
}
