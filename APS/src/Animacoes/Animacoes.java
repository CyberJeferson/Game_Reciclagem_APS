/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animacoes;

public class Animacoes {
    
   
   public String Pose;
     
    
  public String MoverBoneco(int Mudar, int Sentido, String cor){
       
if (cor == "azul"){
    
    switch(Sentido){
        case 0:
            Pose = "/Img_Objetos/PersonagemAnim/BLUE/" + "BD" + Mudar + ".png";
            break;
        case 1:
            Pose = "/Img_Objetos/PersonagemAnim/BLUE/" + "BE" + Mudar + ".png";
            break;
    }

}
else{
    if (cor == "verde"){
    
    switch(Sentido){
        case 0:
            Pose = "/Img_Objetos/PersonagemAnim/GREEN/" + "GD" + Mudar + ".png";
            break;
        case 1:
            Pose = "/Img_Objetos/PersonagemAnim/GREEN/" + "GE" + Mudar + ".png";
            break;
    }
}
    else{
            if (cor == "vermelho"){
    
    switch(Sentido){
        case 0:
            Pose = "/Img_Objetos/PersonagemAnim/RED/" + "RD" + Mudar + ".png";
            break;
        case 1:
            Pose = "/Img_Objetos/PersonagemAnim/RED/" + "RE" + Mudar + ".png";
            break;
    }
}
            else{
       if (cor == "amarelo"){
    
    switch(Sentido){
        case 0:
            Pose = "/Img_Objetos/PersonagemAnim/YELLOW/" + "YD" + Mudar + ".png";
            break;
        case 1:
            Pose = "/Img_Objetos/PersonagemAnim/YELLOW/" + "YE" + Mudar + ".png";
            break;
    }
}
            }
    }
    

    
       
  
}




























return Pose;  
}
  
}