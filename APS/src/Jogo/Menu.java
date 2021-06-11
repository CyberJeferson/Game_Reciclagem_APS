/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author jeffe
 */
public class Menu extends JFrame {
    Objetos.Personagens Personagem = new Objetos.Personagens();
    Objetos.Cenarios Cena = new Objetos.Cenarios();
    
   ImageIcon Lixeira = new ImageIcon(getClass().getResource(Personagem.getPersonagem(5)));
   ImageIcon LixeiraVerde = new ImageIcon(getClass().getResource(Personagem.getPersonagem(6)));
   ImageIcon LixeiraAzul = new ImageIcon(getClass().getResource(Personagem.getPersonagem(7)));
   ImageIcon LixeiraVermelho = new ImageIcon(getClass().getResource(Personagem.getPersonagem(8)));
   ImageIcon Painel = new ImageIcon(getClass().getResource(Personagem.getPersonagem(9)));
   ImageIcon Fundo =  new ImageIcon(getClass().getResource(Cena.getCenario(0)));
   
   JLabel lTela = new JLabel(Fundo);
   JLabel lPainel = new JLabel();
   JLabel Creditos = new JLabel();
   JLabel lPainel2 = new JLabel();
   JLabel lPainel3 = new JLabel();
   JLabel lPainel4 = new JLabel();
   JButton lLixeira = new JButton(Lixeira);
   JButton lLixeira_Verde = new JButton(LixeiraVerde);
   JButton lLixeira_Azul = new JButton(LixeiraAzul);
   JButton lLixeira_Vermelho = new JButton(LixeiraVermelho);
   //NIVEIS
   JButton Medroso = new JButton();
   JButton CriandoCoragem = new JButton();
   JButton NemEuconsigo = new JButton();
   
   
    //Posição da lixeira amarela.  
    int poslLixeira1X = 330;
    int poslLixeira1Y = 420;
    //Posição da lixeira verde.
    int poslLixeira2X = 80;
    int poslLixeira2Y = 420;
    //Posição da lixeira azul.
    int poslLixeira3X = 80;
    int poslLixeira3Y = 120;
    //Posição da lixeira vermelha.
    int poslLixeira4X = 330;
    int poslLixeira4Y = 120;
    int nivel = 8;
    public Menu(){
        editarMenu();
        editarComponentesMenu();
        Botoes();
    }
    
    public void editarMenu(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        
        setSize(500,700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
    }
    
    public void editarComponentesMenu(){
          lPainel.setBackground(Color.black);
          lPainel2.setBackground(Color.black);
          lPainel3.setBackground(Color.black);
          lPainel4.setBackground(Color.black);
          lPainel.setBounds(340, 440, 197, 197);
       
        lPainel2.setBounds(85, 440, 197, 197);
        lPainel3.setBounds(85, 140, 197, 197);
        lPainel4.setBounds(330, 140, 197, 197);   
          lPainel.setText("METAL");
          lPainel2.setText("VIDRO");
          lPainel3.setText("PAPEL");
          lPainel4.setText(" PLÁSTICO");

          Creditos.setText("APS:Jeferson,Jefferson,Jorge,Vinicius,Vitor");
          lPainel.setForeground(Color.white);
          lPainel2.setForeground(Color.white);
          lPainel3.setForeground(Color.white);
          lPainel4.setForeground(Color.white);
          
          
         Creditos.setForeground(Color.white);
        lLixeira.setBounds(poslLixeira1X, poslLixeira1Y, 56, 82);
        lLixeira_Verde.setBounds(poslLixeira2X, poslLixeira2Y, 56, 82);
        lLixeira_Azul.setBounds(poslLixeira3X, poslLixeira3Y, 56, 82);
        lLixeira_Vermelho.setBounds(poslLixeira4X, poslLixeira4Y, 56, 82);
        Medroso.setBounds(0,350,500,50);
        Medroso.setBackground(Color.cyan);
        Medroso.setText("Fácil");
        lTela.setBounds(0, 0, 500, 700);
        Creditos.setBounds(0, -240, 600, 500);
        add(Creditos);
        add(Medroso);
        add(lPainel);
        add(lPainel2);
        add(lPainel3);
        add(lPainel4);
        add(lLixeira);
        add(lLixeira_Vermelho);
        add(lLixeira_Verde);
        add(lLixeira_Azul);
        add(lTela);



        
        
    }
public void  Botoes(){
    		lLixeira.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Jogo("amarelo",nivel);
                               Menu.this.setVisible(false);
			}
		});
                
                    		lLixeira_Azul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Jogo("azul",nivel);
                               Menu.this.setVisible(false);
			}
		});
                       lLixeira_Verde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Jogo("verde",nivel);
                               Menu.this.setVisible(false);
			}
		});
                        lLixeira_Vermelho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Jogo("vermelho",nivel);
                               Menu.this.setVisible(false);
			}
		});
                                
       		Medroso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                        if(Medroso.getText().equals("Fácil")){
                            nivel = 9;
                            Medroso.setText("Corajoso");    
                            nivel = 12;
                        }
                        else{
                             if(Medroso.getText().equals("Corajoso")){
                                 
                                 Medroso.setText("Tá brincando com a sorte");
                                 nivel = 14;
                             }
                             else{
                                 
                                  if(Medroso.getText().equals ("Tá brincando com a sorte")){
                                      
                                  Medroso.setText("Fácil");
                                 nivel = 8;
                                  }
                             }
                            
                        }
			}
		});
}
    
}
