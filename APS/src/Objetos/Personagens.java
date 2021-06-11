/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;



/**
 *
 * @author Ana
 */
public class Personagens {
    
   String Personagem;
   
   
  
  
 public String getPersonagem(int ID){
     switch(ID){
         case 0:
            Personagem = "/Img_Objetos/PersonagemAnim/e0.png";
             break;
         case 1:
              Personagem = "/Img_Objetos/Gari_Parado_01_Amarelo.png";
             break;
         case 2:
         Personagem = "/Img_Objetos/C0.png";
             break;
         case 3:
         Personagem = "/Img_Objetos/C1.png";
             break;
         case 4:
         Personagem = "/Img_Objetos/C2.png";
             break;
             
           case 5:
         Personagem = "/Img_Objetos/Lixeira_Amarela.png";
             break;
             
           case 6:
         Personagem = "/Img_Objetos/Lixeira_Verde.jpg";
             break;
           case 7:
         Personagem = "/Img_Objetos/Lixeira_Azul.jpg";
             break;
           case 8:
         Personagem = "/Img_Objetos/Lixeira_Vermelho.jpg";
             break;
          case 9:
         Personagem = "/Img_Objetos/Painel.png";
             break;            
         default:
             break;
     }
   
     
     
  return Personagem;   
 }

 
 
    
}
