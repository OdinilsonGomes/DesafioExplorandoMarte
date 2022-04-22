/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisem;

import Classes.Planalto;
import Classes.Sonda;
import java.util.Scanner;

/**
 *
 * @author DELL14
 */
public class SISEM {

    /**
     * @param args the command line arguments
     */
    private static int numero_sonda=0;
    private static Planalto planalto = new Planalto();
    private static int linha=1;
    private static int grau_padrao=90, x_padrao=0, y_padrao=0;
    private static String polo_padrao="N", comando_digitado;
    private static String sms_apoio="Centro de Apoio \n H - Ajuda \n P - Imprimir os resultados \n X - Sair \n ";
    
    public static void main(String[] args) {
        // TODO code application logic here
    
        System.out.println("Bem vindo ao Sistema \n"+sms_apoio);
        
        if(criar_planalto())        
            criar_sonda();
       
    }
    
    public static boolean criar_planalto(){
     do{
        try{
            // lendo as coordenadas do planalto
           System.out.println("Digite as cordenadas do Planalto, Ex: 4 7");
           String comando_digitado = Ler_comando(linha);
           String[] cordenada_planalto=comando_digitado.split(" ");
           Planalto planalto = new Planalto(Integer.parseInt(cordenada_planalto[0]),Integer.parseInt(cordenada_planalto[1]));
        }catch(Exception e){
            System.err.println("Cordenadas Incoretas, Tente novamente");
        }
        
        }while ((planalto.getComprimento()*planalto.getLargura())<=0); 
            linha++;
        return true;
    }
    
    public static void criar_sonda() {
        boolean sonda_valida=false;
         do{
            System.out.println("Digite as Coordenadas da "+(numero_sonda+1)*1+"ªSonda, Ex: 5 3 N");
            // Criação de Sonda
            // lendo as coordenandas da sonda
            String comando_digitado=Ler_comando(linha);
            String[] cordenada_sonda=comando_digitado.split(" ");
            // Definindo a Posicao Inicial da Sonda 
            planalto.sonda.add(new Sonda(x_padrao,y_padrao,polo_padrao));
            try{
                sonda_valida=planalto.sonda.get(numero_sonda).mover(Integer.parseInt(cordenada_sonda[0]), Integer.parseInt(cordenada_sonda[1]), cordenada_sonda[2]);
                linha++;
            }catch(Exception e){
                System.err.println("Cordenadas Incoretas, Tente novamente");
            }

            if(sonda_valida){
               instrucao_sonda();
            }
        }while(!sonda_valida);
            
    }
    
    public static  void instrucao_sonda(){
        boolean instrucao_valida;
        String comandos_aceites="MLRPXH",a;
        do{
            instrucao_valida=true;
            System.out.println("Digite as Instruções da "+(numero_sonda+1)*1+"ª Sonda, Ex: MLRMLR");
            // lendo as Instruçoes da sonda
            comando_digitado=Ler_comando(linha);
            // Verificando se a Instruçaõ contem todos os caracteres aceitaveis
            for(int i=0;i<comando_digitado.length();i++){
                a=comando_digitado.charAt(i)+"";
                if(!comandos_aceites.contains(a))
                 instrucao_valida=false;
            }
            if(instrucao_valida)
            for(int i=0;i<comando_digitado.length();i++){
                String instrucao_sonda=""+comando_digitado.charAt(i);
                switch(instrucao_sonda){ 
                    case "L":
                        instrucao_valida=planalto.sonda.get(numero_sonda).girar(instrucao_sonda, grau_padrao);
                    break;
                    case "R":
                        instrucao_valida=planalto.sonda.get(numero_sonda).girar(instrucao_sonda, grau_padrao);
                    break;
                    case "M":
                        instrucao_valida=planalto.sonda.get(numero_sonda).mover(0, 0, instrucao_sonda);
                    break;
                    default:
                        System.err.println(comando_digitado.charAt(i)+" Instrução não reconhecida");
                }
            }
            else
                System.err.println("A instrução contêm caracteres não reconhecidos");
        }while(!instrucao_valida);
            
        linha--;
        numero_sonda++;
        criar_sonda();
    }
    public static void imprimir_resultado() {
        System.out.println("Planalto: "+ planalto.getLargura()+" "+planalto.getComprimento());
        for(int i=0;i<numero_sonda;i++){
           System.out.println((i+1)+"ª Sonda "+planalto.sonda.get(i).getX()+" "+planalto.sonda.get(i).getY()+" "+planalto.sonda.get(i).getPolo()); 
        }
        
    }
    
 public static String Ler_comando(int linha){
     // Incrementando Linha 
     Scanner ler =new Scanner(System.in);
     comando_digitado=ler.nextLine();
     if(comando_digitado.equals("X")){
        System.out.println("Sistema Fechado! Obrigado, volte sempre.");
        System.exit(0);
        return "";
     }if(comando_digitado.equals("P")){
        imprimir_resultado();
        System.exit(0);
        return "";
     }else if(comando_digitado.equals("H")){
        System.out.println(sms_apoio);
        return Ler_comando(linha);
     }else{
        return comando_digitado;
     }
 }

    
}
