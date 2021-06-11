package Jogo;
import Efeitos_Sonoros.Tocar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
public class Jogo extends JFrame{
    
    //INSTANCIANDO A CLASSE CENARIOS E PERSONAGENS
   Objetos.Personagens Personagem = new Objetos.Personagens();
   Objetos.Cenarios Cena = new Objetos.Cenarios();
   Animacoes.Animacoes Anim = new Animacoes.Animacoes();
   Efeitos_Sonoros.Tocar Toca = new Efeitos_Sonoros.Tocar();
   
   //NUMERO ALEATORIO
   Random AleatorioLixo = new Random();
   
   //ICONES E IMAGENS DOS OBJETOS
   ImageIcon Lixeira = new ImageIcon(getClass().getResource(Personagem.getPersonagem(1)));
   ImageIcon Coracao = new ImageIcon(getClass().getResource(Personagem.getPersonagem(4)));
   ImageIcon Fundo =  new ImageIcon(getClass().getResource(Cena.getCenario(1)));
   ImageIcon vIPontos =  new ImageIcon(getClass().getResource(Cena.getCenario(1)));
    ImageIcon Laleatorios =  new ImageIcon(getClass().getResource(Cena.getCenario(1)));
    boolean OFim= false;
   //ImageIcon B = new ImageIcon(getClass().getResource(Personagem.getPersonagem(0)));
   
   //NÚMERO DE LIXOS
   int nLixos = 14;
 
   
   //DEFININDO OS OBJETOS COM JLABEL
    
    JLabel lTela = new JLabel(Fundo);
    JLabel lLixeira = new JLabel(Lixeira);
    JLabel Vida = new JLabel(Coracao);
    JLabel seFodeu = new JLabel(Lixeira);
    //JLabel Bonecao = new JLabel(B);
     JLabel Pontos = new JLabel();
     JLabel vPontos = new JLabel();
     JLabel GameOver = new JLabel();
     JLabel cLixos[] = new JLabel[nLixos];
    int level = 0;
    int cPontos = 0;
    
   
   
    //COORDENADAS DOS OBJETOS
    int poslLixeiraX = 330;
    int poslLixeiraY = 500;
    
    
    //VARIAVEIS DO RELOGIO E DE MOVIMENTOS
    public static  int Escolhido = 0;
    int EscoY = 0;
    public static  int Contar =0;
    String getLixo,EscolherCor;
    int Velocidade = 5;

    //INICIARO MOVIMENTO DOS LIXOS
    boolean Comecar = false;
   
   //SENTIDO DO PERSONAGEM COM A LIXEIRA
    int sentido = 0;
    int contarPassos =0;
    boolean Dancar = true;
     int Pcontar = 8;
//VARIAVEIS DE TESTE
     int Perdeu = 4;
     String Cor;
     Icon VerLixoATual ;
     Icon Comparar ;
     String VerLixoATual1 ;
     String Comparar1 ;
     boolean vPerdeu = false;
    // INICIAR JOGO
     int modo;
     
     
    public Jogo(String cor,int modo){
       nLixos = modo;
       JLabel cLixos[] = new JLabel[nLixos];
        Cor = cor;
        DefinirLixos();
        editarJanela();
        editarComponentes();
        addMovimentos();
        InciarRelogio();
        GariParado();
        Toca.Correr();
        Toca.executaSom("/Efeitos_Sonoros/Abertura.wav");
  
            

        
     
    }
    public void criarLixos(int Escolha){
    
    switch(Escolha){
        case 0:
         Contar = 0;
         
        int posicionar = 0;
        while(Contar < (nLixos)){
       int Aleatoriocair = AleatorioLixo.nextInt(200);
      
            
       
        cLixos[Contar].setBounds(posicionar, Aleatoriocair, 100, 100);
        posicionar = posicionar + 30;
        Contar++;
        }
    
        break;
                 case 1:
                     
                    
                     
                  //FAZ O MOVIMENTO DO LIXO PARA BAIXO  
                  if (Escolhido < (nLixos )){
                     
                   cLixos[Escolhido].setBounds( cLixos[Escolhido].getBounds().x, cLixos[Escolhido].getBounds().y + Velocidade, 120, 120);
                   //CONDIÇÕES DE COLISÃO
                    if ((cLixos[Escolhido].getBounds().x > lLixeira.getBounds().x - 30 && cLixos[Escolhido].getBounds().x < lLixeira.getBounds().x + 17) && cLixos[Escolhido].getBounds().y > 460 && cLixos[Escolhido].getBounds().y < 510 ){
                         //ESSA É A HORADA COLISÃO DO LIXO COM A LIXEIRA
             
                         int Lcontar =0;

                         while(Lcontar < 12){
                         vIPontos =  new ImageIcon(getClass().getResource(Cena.getLixos(Lcontar)));
                         vPontos.setIcon(vIPontos);
                          VerLixoATual = cLixos[Escolhido].getIcon();
                          Comparar = vPontos.getIcon();
                          VerLixoATual1 = VerLixoATual.toString().replaceFirst("", "");
                          Comparar1 = Comparar.toString().replaceFirst("", "" );
                      
                           if (VerLixoATual1.equals(Comparar1)){

                               break;
                               
                           }

                          Lcontar ++;   
                         }
                         
                         if (Cor.equals("amarelo") && Lcontar >= 0 && Lcontar <=2){
                               cPontos++;
                               Pontos.setText("Pontos:" + cPontos +" Level:"+level);
                               vPerdeu = false;
                               Toca.Ponto("/Efeitos_Sonoros/Ponto.wav");
                             
                         } 
                         else { 
                             
                             if (Cor.equals("azul") && Lcontar >= 3 && Lcontar <=5){
                             
                               cPontos++;
                               Pontos.setText("Pontos:" + cPontos+" Level:"+level);
                               vPerdeu = false;
                               Toca.Ponto("/Efeitos_Sonoros/Ponto.wav");
                             
                             
                         }
                             else{
                                 
                               if (Cor.equals("vermelho") && Lcontar >= 6 && Lcontar <=8){
                              
                               cPontos++;
                               Pontos.setText("Pontos:" + cPontos+"Level"+level);
                               vPerdeu = false;
                               Toca.Ponto("/Efeitos_Sonoros/Ponto.wav");
                             
                             
                         }
                               else{
                               if (Cor.equals("verde") && Lcontar >= 9 && Lcontar <=11){
                             
                               cPontos++;
                               Pontos.setText("Pontos:" + cPontos +" Level:"+level);
                               vPerdeu = false;
                               Toca.Ponto("/Efeitos_Sonoros/Ponto.wav");
                             
                             
                         }
                               else{
                                   vPerdeu = true;
                                   FimdeJogo();
                                   
                               }
                                   
                                   
                               }
                                 
                                 
                             }
                             
                             
                             
                       }
                         



                         
                         
                        
                          
                           
                          
                          Random gerador = new Random();
                          int NovoLixo =  gerador.nextInt(12);
                          if (cPontos > 10){
                              level  = 1;
                              Velocidade = 20;
                          }
                          else{
                              
                              if (cPontos > 20){
                                  level = 2;
                                  Velocidade =30;
                              }
                              else{
                                  
                                  
                                   if (cPontos > 40){
                                  level = 4;
                                  Velocidade = 40;
                              }
                              }
                              
                              
                             
                          }
          
                         

                         Laleatorios = new ImageIcon(getClass().getResource(Cena.getLixos(NovoLixo)));
                      
                         cLixos[Escolhido].setIcon(Laleatorios);
                         cLixos[Escolhido].setBounds( cLixos[Escolhido].getBounds().x, -100, 120, 120);
                     }
                     else{
                         
                     if (cLixos[Escolhido].getBounds().y > 600){
                            Random gerador = new Random();
                          int NovoLixo = gerador.nextInt(12);
                         Laleatorios = new ImageIcon(getClass().getResource(Cena.getLixos(NovoLixo)));
                        
                         cLixos[Escolhido].setIcon(Laleatorios);
                         cLixos[Escolhido].setBounds( cLixos[Escolhido].getBounds().x, -100, 120, 120);                    
              
                     }

                         
                         
                     }
                   
                   
                    }
                    else {
                       
                         Escolhido = 0;
                      cLixos[Escolhido].setBounds( cLixos[Escolhido].getBounds().x, -100, 120, 120); 
                      
                    }    
                    Pontos.setText("Pontos:" + cPontos +" Level:"+level);
                   Escolhido ++;
    
                  
                 break;
    
   
    }
    
}
    public void addMovimentos(){
        addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
            
            }

            public void keyPressed(KeyEvent e) {
                if   (OFim == false){
                if(e.getKeyCode()==39){
                   Dancar = false;
                    Toca.Ver = 1;
                    if (poslLixeiraX > 399 || poslLixeiraX == 399){
                       poslLixeiraX = 398; 
                    }
                    else{
                    poslLixeiraX += 10;
                 
                   
                    //FOI SOFRIDO MAS CONSEGUI
                    if (sentido == 0){
                        
                        if (contarPassos < 7){
                     Lixeira = new ImageIcon(getClass().getResource(Anim.MoverBoneco(contarPassos, sentido,Cor)));
                     lLixeira.setIcon(Lixeira);
                     contarPassos++;
                    }
                    else{
                        
                       contarPassos = 0;
                    }
                    }
                    
                    else{
                            sentido = 0;
                            contarPassos = 0;
                            //Lixeira = new ImageIcon(getClass().getResource(Anim.MoverBoneco(contarPassos, sentido)));
                    }
                        
                    
   
                    //FOI SOFRIDO MAS CONSEGUI
            repaint();
              
                    }
                    
                }
                if(e.getKeyCode()==37){
                    Dancar = false;
                   Tocar.Ver =1;
                    if (poslLixeiraX < -14 || poslLixeiraX == -14) {
                   poslLixeiraX = -13;  
                  
                   
                }
                    else{
                    poslLixeiraX -= 10;  
                    }
                    
                    
                    
                    //FOI SOFRIDO MAS CONSEGUI
                    if (sentido == 1){
                        
                        if (contarPassos < 7){
                     Lixeira = new ImageIcon(getClass().getResource(Anim.MoverBoneco(contarPassos, sentido,Cor)));
                     lLixeira.setIcon(Lixeira);
                     contarPassos++;
                    }
                    else{
                        
                       contarPassos = 0;
                    }
                    }
                    
                    else{
                            sentido = 1;
                            contarPassos = 0;
                            
                    }
                        
                    
   
                    //FOI SOFRIDO MAS CONSEGUI
                }
            
                
                lLixeira.setBounds(poslLixeiraX, poslLixeiraY, 103, 202);

                   
                //cLixos[0].setBounds(poslLixeiraX + 50, poslLixeiraY, 100, 100);
                //RecarregarComponentes(1);

                
                }
            } 
            public void keyReleased(KeyEvent e) {
             Tocar.Ver =0;
            Dancar = true;
            }
        
    });
    }
    
    public void editarComponentes(){
       
     System.out.println(lTela.getBounds().getSize());
   
        Pontos.setText("Pontos: 0");
        Pontos.setForeground(Color.white);
        Font Fonta = new Font("Stencil", Font.BOLD,14);
        Pontos.setFont(Fonta);
        lTela.setBounds(0, 0, 500, 700);
        lLixeira.setBounds(poslLixeiraX, poslLixeiraY, 103, 202);
        Pontos.setBounds(0, 0, 600, 119);
        Vida.setBounds(410,0,30,30);
        
      
      }
    

    
    public void editarJanela(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
//        criarLixos(0);
      

 RecarregarComponentes(0);
   
 
  
    
         
   

  
 
        
    }

public  void DefinirLixos(){
    
    
        Contar = 0;
        while(Contar < nLixos){
        int numero = AleatorioLixo.nextInt(12);            
        ImageIcon LixoDinamico = new ImageIcon(getClass().getResource(Cena.getLixos(numero)));
        cLixos[Contar] =  new JLabel(LixoDinamico);
        
        Contar++;
        }
   
    
   
   }




     
   public void InciarRelogio(){
    
    
            Timer timer = new Timer();
               criarLixos(0);
        
        final long SEGUNDOS = (5);
        
        TimerTask tarefa = new TimerTask() {
           
            @Override
            public void run() {
                if (OFim == false){
                if (Comecar == false){
                    Contar =0;
                   RecarregarComponentes(1);
                    Comecar = true;
                }
                else{
                 
               criarLixos(1);
              
                    
                }


     
   
 
    //System.out.println("Jogo Funcionando OK");
                
            }
            }
        };
        
        timer.scheduleAtFixedRate(tarefa, 0, SEGUNDOS);
}
   
   
   public void RecarregarComponentes(int Escolha){
  
    switch(Escolha){
        case 0:
        this.add(Vida);
        this.add(lLixeira);
        this.add(Pontos);
        this.add(lTela);
            
            
         break;
        case 1:
        while(Contar < (nLixos)){
        this.add(cLixos[Contar]);
        Contar++;
    }
        this.add(Vida);
        this.add(lLixeira);
        this.add(Pontos);
        this.add(lTela);
        
        
        break;
        case 2:
            
       while(Contar < (nLixos)){
        this.add(cLixos[Contar]);
        Contar++;
    }
        add(GameOver);
        this.add(Vida);
        this.add(lLixeira);
        this.add(Pontos);
        this.add(lTela);
        GameOver.repaint();
        break;
        
        
    }
    
    
       

   }
   
   public void GariParado(){
   
    
            Timer timer = new Timer();
               criarLixos(0);
        
        final long SEGUNDOS = (100);
        
        TimerTask tarefa = new TimerTask() {
           
            @Override
            public void run() {
  if (Dancar = true){
           if (Pcontar < 11){
    
                     Lixeira = new ImageIcon(getClass().getResource(Anim.MoverBoneco(Pcontar, sentido,Cor)));
                     lLixeira.setIcon(Lixeira);
                     
                    }
                     else{
                         Pcontar = 8;
                        
                     }
      
      
      
      
      
  }
  else{
      Pcontar = 8;
      
  }
                

     
   Pcontar++;
 

            }
            
        };
        
        timer.scheduleAtFixedRate(tarefa, 0, SEGUNDOS);
}
   public void FimdeJogo(){
                      if (Perdeu > 2 && vPerdeu == true){
                     Perdeu--;
                     vPerdeu =false;
                   
                     Coracao = new ImageIcon(getClass().getResource(Personagem.getPersonagem(Perdeu)));
                     Vida.setIcon(Coracao);
                     
                     if (Perdeu == 2){    //GAME OVER
                         this.OFim = true;
                         GameOver.setBounds(100,100,500,300);
                       Font Fover = new Font("Stencil", Font.BOLD,37);
                        
                         GameOver.setText("Vai estudar!");
                         GameOver.setFont(Fover);
                         GameOver.setForeground(Color.yellow);
                         RecarregarComponentes(2);
                         
                         Toca.Ponto("/Efeitos_Sonoros/Perdeu.wav");
                         
                     }
                         
                     }
       
       
   }
   
}
