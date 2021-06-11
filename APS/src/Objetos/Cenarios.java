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

public class Cenarios {
    String FundoTela;
    String lLixos;
    
public String getCenario(int ID){
     switch(ID){
         case 0:
             this.FundoTela = "/Img_Cenarios/Tela.jpg";
             break;
         case 1:
               this.FundoTela = "/Img_Cenarios/Cenario2.png";
             break;
         case 2:
             this.FundoTela = "/Img_Cenarios/chao.png";
          
                 break;
                 
                 
         case 3:
             break;

         default:
             break;
     }
   
     
     
  return this.FundoTela;   
 }

public String getLixos(int ID){
   switch(ID){
       case 0: //SMSRELO
          this.lLixos = "/Img_Cenarios/AMARELO/GarrafaTomate.png";
       break;
       case 1:
           this.lLixos = "/Img_Cenarios/AMARELO/LataSardinha.png";
          break;
          
       case 2:
           this.lLixos = "/Img_Cenarios/AMARELO/Latinha.png";
          break;
         //AZUL
       
       case 3:
           this.lLixos = "/Img_Cenarios/AZUL/Caixa.png";
          break;
          
       case 4:
           
           this.lLixos = "/Img_Cenarios/AZUL/Leite.png";
           break;
           
        case 5:
           
           this.lLixos = "/Img_Cenarios/AZUL/papel.png";
           break;
           //VERMELHO
            case 6:
           
           this.lLixos = "/Img_Cenarios/VERMELHO/patinho.png";
           break;
            case 7:
           
           this.lLixos = "/Img_Cenarios/VERMELHO/MCDONALDS.png";
           break;
            case 8:
             
           this.lLixos = "/Img_Cenarios/VERMELHO/garrafa plastico.png";
           break;
              //VERDE
           
            case 9:
           
           this.lLixos = "/Img_Cenarios/VERDE/garrafa-quebrada.png";
           break;
           case 10:
           
           this.lLixos = "/Img_Cenarios/VERDE/garrafa-quebrada2.png";
           break;
           case 11:
           
           this.lLixos = "/Img_Cenarios/VERDE/quebrado.png";
           break;
           //OUTROS
           case 12:
           
           this.lLixos = "/Img_Cenarios/OUTROS/Banana.png";
           break;
           case 13:
           
           this.lLixos = "/Img_Cenarios/OUTROS/maca.png";
           break;
            case 14:
           
           this.lLixos = "/Img_Cenarios/OUTROS/ovo.png";
           break;
           case 15:
           
           this.lLixos = "/Img_Cenarios/OUTROS/Tv.png";
           break;

       default:
           break;
       
       
       
   } 
    
    
    
    
   return this.lLixos; 
}


  
}
