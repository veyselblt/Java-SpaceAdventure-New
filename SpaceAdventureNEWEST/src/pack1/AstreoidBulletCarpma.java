package pack1;

import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class AstreoidBulletCarpma {
	
	Timer timer;
	
	
	public AstreoidBulletCarpma(){
		
		timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				
				Iterator<Ates> it = Label.atesler.iterator();
				
				while(it.hasNext()){
					Ates ates = it.next();
					for(int i=0;i<3;i++){
						
						try{
							if(ates.getAtesX() >= Label.astX[i] -5 && ates.getAtesX() <= Label.astX[i]+120&&
									ates.getAtesY() >=Label.astY[i]-50 && ates.getAtesY() <= Label.astY[i] +60){
								
								Label.kulland�g�mDeger++;
								Label.astreoideCarpmaBuyuk = true;
								
							
								if(Label.kulland�g�mDeger==4){
									Label.gecici2X = Label.astX[i];
									Label.gecici2Y = Label.astY[i];
					
									Label.astY[i]=-1000;
									Label.kulland�g�mDeger=0;
								}
								
								if(Label.astreoideCarpmaBuyuk == true){
									Label.toplamSagl�k += Label.sagl�kArtt�rma;
								}
								
								//Label.kulland�g�mDeger--;
							

							}
						}
						catch(Exception e){
							
						}
						
					}
					
				}
				
				
			}
			
			
			
			
		}, 0, 50);
		

		
	}

}
