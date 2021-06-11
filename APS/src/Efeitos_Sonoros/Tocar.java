package Efeitos_Sonoros;

import static java.lang.Thread.sleep;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


 
public class Tocar {
    public static    int Ver = 0;
    
    public void executaSom(String caminho) {
        try {
            
            //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(caminho).getAbsoluteFile());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(caminho));
            Clip clip = AudioSystem.getClip();
            clip.stop();
            clip.open(audioInputStream);
            FloatControl gainControl =(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f);
            
            
            clip.loop(-1);
            
     
           

            
        } catch (Exception ex) {
            System.out.println("Erro ao executar SOM!");
            ex.printStackTrace();
        }
    }
    
    
    
        public void Efeitos(String Escolha) {
            
            switch(Escolha){
          case "passos":
          try {
            //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(caminho).getAbsoluteFile());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("/Efeitos_Sonoros/passo.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            
              if (clip.isRunning()){
    
    
    
    
               }
               else{
                clip.start();
              }
            
            
        } catch (Exception ex) {
            System.out.println("Erro ao executar SOM!");
            ex.printStackTrace();
        }
                    
           break;
            }
 
    }
  public void Correr(){
   
    
         Timer timer = new Timer();
        
        
        final long SEGUNDOS = (400);
        
        TimerTask tarefa = new TimerTask() {
            
            @Override
            public void run() {
                if (Ver == 0){
                    
                }
                else{
                 
                     Efeitos("passos");
                    
                }
                
            }
            
    
    
};
        timer.scheduleAtFixedRate(tarefa, 0, SEGUNDOS);
               
                }
  
  
      public void Ponto(String caminho) {
        try {
            //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(caminho).getAbsoluteFile());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(caminho));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl gainControl =(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
          //  gainControl.setValue(-5.0f);
            clip.stop();
            clip.start();
        } catch (Exception ex) {
            System.out.println("Erro ao executar SOM!");
            ex.printStackTrace();
        }
    }


}
 


