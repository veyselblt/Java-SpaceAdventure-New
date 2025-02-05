package pack1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class Draw extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Timer timer;
	
	Ates ates;
	
	public void paint(Graphics g){
		super.paint(g);
		if(Label.oyun == true){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawImage(Label.gorsel, 0, Label.backgroundY1,650,500,null);
		g.drawImage(Label.gorsel, 0, Label.backgroundY2,650,500,null);
		g.drawImage(Label.rocket, Label.rocketX,Label.rocketY,300,150,null);
		
		/////////////////////////////////////////////////////////////////////////////
		
		//Ates draw 1
		if(Label.atesHareketi==0){
			g.drawImage(Label.ates1, Label.rocketX+127,Label.rocketY+70,42,60,null);

		}
		
		//Ates draw 2
		else if(Label.atesHareketi==1){
			g.drawImage(Label.ates2, Label.rocketX+127,Label.rocketY+70,42,60,null);

		}
		
		/////////////////////////////////////////////////////////////////////////////
		
		//KUCUK ASTREO�D ASTREO�D
		
		for(int i=0;i<3;i++){
			g.drawImage(Label.ast, Label.astX[i],Label.astY[i],170,150,null);
		}
		
		
		//BUYUK ASTREO�DPATLAMA
			
		g.drawImage(Label.gifAstreoid, Label.gecici2X, Label.gecici2Y,150,150,null);
		g.drawImage(Label.gifAstreoid, Label.gecici2X+100, Label.gecici2Y-100,150,150,null);
		g.drawImage(Label.gifAstreoid, Label.gecici2X+300, Label.gecici2Y+200,150,150,null);
		
		
		///SAGLIKKKK
		g.setColor(Color.CYAN);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.drawString("Healt : " + Label.toplamSagl�k,5, 30);
				
		if(Label.toplamSagl�k <= 499){
			Label.oyun = false;
		}
		
		
	
		/////////////////////////////////////////////////////////////////////////////
		
		//Explosion

		if(Label.explosionBoolean==true){
			
			for(int i=0;i<=15;i++){
				
				if(Label.explosionAnimation==i){
					
					g.drawImage(Label.explosionArray[i], Label.rocketX+90, Label.rocketY+35,130,120,null);
				}
	
			}
	
			if(Label.explosionAnimation>0 && Label.explosionAnimation <7){
				g.setColor(new Color(250,0,0,45));
				g.fillRect(0, 0, getWidth(), getHeight());
			}
			if(Label.explosionAnimation>7 && Label.explosionAnimation <15){
				g.setColor(new Color(250,0,0,45));
				g.fillRect(0, 0, getWidth(), getHeight());
			}
		}
		/////////////////////////////////////////////////////////////////////////////
		///AStreoid G�FFF and EXPLOS�ON
		/*
		if(Label.astreoidExplosionBoolean == true){
			g.drawImage(Label.gifAstreoid, Label.geciciX, Label.geciciY, 100,100,null);
		}*/
		
		if(Label.astreoidExplosionBoolean == true){
			for(int i=0;i<=9;i++){
				if(Label.astreoidExplosionAnimation == i){
					g.drawImage(Label.astreoidExplosionArray[i], Label.geciciX-40, Label.geciciY-30,150,150,null);
				}
			}
		}
		
		/////////////////////////////////////////////////////////////////////////////
		
		//bullet
		for(Ates ates : Label.atesler){
			try{
				g.drawImage(Label.ates, ates.getAtesX(),ates.getAtesY(), 30, 30,null);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		/////////////////////////////////////////////////////////////////////////////
		//TASSS
		for(int i=0;i<7;i++){
			
			g.drawImage(Label.tas, Label.tasX[i],Label.tasY[i],80,70,null);
			
		}
		
		/////////////////////////////////////////////////////////////////////////////
		repaint();
		}
		
		if(Label.oyun==false){
		
			g.setColor(new Color(250,0,0,50));
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setFont(new Font("Arial",Font.BOLD,25));
			g.setColor(Color.WHITE);
			g.drawString("     GAME OVER ",210, 250);

		}
	}

}
