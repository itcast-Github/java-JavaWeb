import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ElsFk extends KeyAdapter  implements Runnable
{   
	
	boolean start=false;

    JFrame frame;
    Thread timerThread;
	//定义变量
	int[][]  shis;
	int[][]  luos;
	int[][]  lins;	
	int fen;
	int ju;
	int zhuanh;
	int zhuanl;	
	
    ElsFk()
    {  
		//变量初始值
		chuShi();
		xinKuai();
		
		frame = new JFrame();
        frame.getContentPane().add(new Screen());
        frame.addKeyListener(this);

        //窗口大小
        frame.setSize(10*30 + 2*5 +100,20*30 + 22 +2*5 );
        frame.setVisible(true);
        frame.repaint();
    }

    public void keyPressed(KeyEvent evt)
    {
        switch(evt.getKeyCode()) 
        {	
			case KeyEvent.VK_ENTER:
				timerThread = new Thread(this);
				timerThread.start();
				start=true;
				break;
			case KeyEvent.VK_ESCAPE:
                start=false;
				System.exit(1);
				break;
			case KeyEvent.VK_LEFT:
				if(isZuoChuJie()==false && isZuoDang()==false)
				{
					zuoDong();					
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(isYouChuJie()==false && isYouDang()==false)
				{			
					youDong();
				}
				break;
			case KeyEvent.VK_DOWN:
				if(isXiaChuJie()==false &&  isXiaDang()==false)
				{			
					xiaDong();
				}
				break;
			case KeyEvent.VK_UP:
				if(isZhuanChuJie()==false &&  isZhuanDang()==false)
				{			
					zhuanDong();
				}		
				break;
        }

        frame.repaint();
    }

    public void run()
    {
        while(true)
        {
            try
            {   timerThread.sleep(300);//时间间隔  1000  1s
            }
            catch (InterruptedException e)
            {   e.printStackTrace();
            }
            
            if(start==false)
                return;

			//定时
			if(isXiaChuJie()==false &&  isXiaDang()==false)
			{
				xiaDong();				
			}
			else
			{
				heBing();
				int h=xiaoHang();
				deFen(h);
				
				if(isSi()==true)
				{
					System.exit(0);
				}
				
				xinKuai();
			}			
        	frame.repaint();
        }
    }

	class Screen extends JComponent
	{   
		public void paint(Graphics g)
		{
			Graphics2D g2d = (Graphics2D)g;
			//画图
			xianShi(g2d);
		}
	}

    public static void main(String[] args)
    {
         new ElsFk();
    }
    
    //-------------------------------------------------------------
    
    void chuShi()
    {
	  	shis=new int[20][10];
		luos=new int[20][10];
		lins=new int[20][10];		
		fen=0;
		ju=1;
		zhuanh=0;
		zhuanl=4;	  	
    }
    
    void xianShi(Graphics2D g2d)
    {
    	g2d.setColor(Color.BLUE);
    	xianShiKuang(g2d);
    	g2d.setColor(Color.RED);
    	xianShiZhengLuo(g2d);
		g2d.setColor(Color.GREEN);
    	xianShiLuoShi(g2d);
    }
    
    
    void zuoDong()
    {
    	zhuanl--;
    	for(int h=0;h<20;h++)
    	{
    		for(int l=0+1;l<10;l++)
    		{
    			luos[h][l-1]=luos[h][l];
    		}
    	}
    	
     	for(int h=0;h<20;h++)
    	{
    		luos[h][9]=0;
    	}   		
    }
     
    void youDong()
    {
    	zhuanl++;    	
    	for(int h=0;h<20;h++)
    	{
    		for(int l=9-1;l>=0;l--)
    		{
    			luos[h][l+1]=luos[h][l];
    		}
    	}
    	
     	for(int h=0;h<20;h++)
    	{
    		luos[h][0]=0;
    	}      	
    }  
     
    void xiaDong()
    {
    	zhuanh++;     	
    	for(int h=19-1;h>=0;h--)
    	{
    		for(int l=0;l<10;l++)
    		{
    			luos[h+1][l]=luos[h][l];
    		}
    	}
    	
		for(int l=0;l<10;l++)
		{
			luos[0][l]=0;
		}    		
    }
     
    void zhuanDong()
    {
        for(int h=0;h<20;h++)
    	{
    		for(int l=0;l<10;l++)
    		{
    			if(luos[h][l]==1)
    			{
     				int xinl=zhuanl+zhuanh-h;     				
    				int xinh=zhuanh-zhuanl+l;
  			
   					lins[xinh][xinl]=1;
    			}
    		}
    	}   
    	
        for(int h=0;h<20;h++)
    	{
    		for(int l=0;l<10;l++)
    		{  			
   				luos[h][l]=lins[h][l];
   				lins[h][l]=0;
    		}
    	}     		
    } 
    
    void heBing()
    {
    	for(int h=0;h<20;h++)
    	{
    		for(int l=0;l<10;l++)
    		{
    			if(luos[h][l]==1)
    			{
    				shis[h][l]=1;
    				luos[h][l]=0;
    			}
    		}
    	}      	
    }   
    
    int xiaoHang()
    {
    	int hangshu=0;
    	
    	for(int h=19;h>=0;h--)
    	{
    		//ji ge 1
    		int n=0;
    		for(int l=0;l<10;l++)
    		{
    			n=n+shis[h][l];
    		}
    		//man chuan
    		if(n==10)
    		{
    			hangshu++;
    			for(int ch=h-1;ch>=0;ch--)
    			{
		    		for(int cl=0;cl<10;cl++)
		    		{
		    			shis[ch+1][cl]=shis[ch][cl];
		    		}  
    			}
				h++;
    		}
    	}
    	return hangshu;	
    }   
    
    void deFen(int hang)
    {
    	switch(hang)
    	{
    		case 1:
    			fen=fen+1000;
    			break;
    		case 2:
    			fen=fen+3000;
    			break;    			
    		case 3:
    			fen=fen+6000;
    			break;    			
    		case 4:
    			fen=fen+10000;
    			break;    				
    	}
    }
    
    void xinKuai()
    {
    	zhuanh=0;
    	zhuanl=4;
    	int zhong=(int)(Math.random()*7) 	;
   		switch(zhong)
   		{
   			case 0:
   				luos[0][3]=1;	luos[0][4]=1;	luos[0][5]=1;	luos[0][6]=1;
   				luos[1][3]=0;	luos[1][4]=0;	luos[1][5]=0;	luos[1][6]=0;   				
   				break;
   			case 1:
   				luos[0][3]=1;	luos[0][4]=1;	luos[0][5]=1;	luos[0][6]=0;
   				luos[1][3]=0;	luos[1][4]=1;	luos[1][5]=0;	luos[1][6]=0;   				
   				break;  
   			case 2:
   				luos[0][3]=1;	luos[0][4]=1;	luos[0][5]=0;	luos[0][6]=0;
   				luos[1][3]=0;	luos[1][4]=1;	luos[1][5]=1;	luos[1][6]=0;   				
   				break;    				
   			case 3:
   				luos[0][3]=0;	luos[0][4]=1;	luos[0][5]=1;	luos[0][6]=0;
   				luos[1][3]=1;	luos[1][4]=1;	luos[1][5]=0;	luos[1][6]=0;   				
   				break;    				 				
   			case 4:
   				luos[0][3]=0;	luos[0][4]=1;	luos[0][5]=1;	luos[0][6]=0;
   				luos[1][3]=0;	luos[1][4]=1;	luos[1][5]=1;	luos[1][6]=0;   				
   				break;
   			case 5:
   				luos[0][3]=1;	luos[0][4]=1;	luos[0][5]=1;	luos[0][6]=0;
   				luos[1][3]=1;	luos[1][4]=0;	luos[1][5]=0;	luos[1][6]=0;   				
   				break;   		
			case 6:
   				luos[0][3]=1;	luos[0][4]=1;	luos[0][5]=1;	luos[0][6]=0;
   				luos[1][3]=0;	luos[1][4]=0;	luos[1][5]=1;	luos[1][6]=0;   				
   				break;   	
   		}
    }
    
    boolean isSi()
    {
    	for(int l=0;l<10;l++)
    	{
    		if(shis[0][l]==1)
    		{
    			return true;
    		}
    	}
    	return false;  	
    }
    
 //------------------------------------------------------------------------------------  
 	     
    void xianShiKuang(	Graphics2D g2d)
    {
    	g2d.drawRect(0,0,10*30,20*30);
    	g2d.drawString(fen+"" ,320,100); 
     	g2d.drawString(ju+"" ,320,200);    	   		
    }
      
    void xianShiZhengLuo(Graphics2D g2d)
    {
    	for(int h=0;h<20;h++)
    	{
    		for(int l=0;l<10;l++)
    		{
    			if(luos[h][l]==1)
    			{

        			g2d.fillRect(l*30 ,h*30 ,28,28);				
    			}
    		}
    	}	
    }  
    
    void xianShiLuoShi(Graphics2D g2d)
    {
    	for(int h=0;h<20;h++)
    	{
    		for(int l=0;l<10;l++)
    		{
    			if(shis[h][l]==1)
    			{
        			g2d.fillRect(l*30 ,h*30 ,28,28);				
    			}
    		}
    	}	    	
    }  
    
    boolean isZuoChuJie()
    {
   		for(int h=0;h<20;h++)
   		{
   			if(luos[h][0]==1)
   			{
   				return true;
   			}
   		}
   		return false;    	
    }
    
    boolean isZuoDang()
    {
       	for(int h=0;h<20;h++)
    	{
    		for(int l=1+0;l<10;l++)
    		{
    			if(shis[h][l-1]==1 && luos[h][l]==1)
    			{
        			return true;		
    			}
    		}
    	}   		
    	return false;  	
    } 
       
    boolean isYouChuJie()
    {
   		for(int h=0;h<20;h++)
   		{
   			if(luos[h][9]==1)
   			{
   				return true;
   			}
   		}
   		return false;  	
    } 
       
    boolean isYouDang()
    {
        for(int h=0;h<20;h++)
    	{
    		for(int l=0;l<10-1;l++)
    		{
    			if(shis[h][l+1]==1 && luos[h][l]==1)
    			{
        			return true;		
    			}
    		}
    	} 	
  		return false;    	
    } 
     
    boolean isZhuanChuJie()
    {
        for(int h=0;h<20;h++)
    	{
    		for(int l=0;l<10;l++)
    		{
    			if(luos[h][l]==1)
    			{
 	    			int xinh=zhuanh-zhuanl+l;
	    			int xinl=zhuanl+zhuanh-h;    			
	    			if(xinh<0 || xinh>=20 || xinl<0 || xinl>=10 )
	    			{
	        			return true;		
	    			}   				
    			}
    		}
    	} 	  	
  		return false;    	
    } 
           
    boolean isZhuanDang()
    {
        for(int h=0;h<20;h++)
    	{
    		for(int l=0;l<10;l++)
    		{
    			if(luos[h][l]==1)
    			{
	    			int xinh=zhuanh-zhuanl+l;
	    			int xinl=zhuanl+zhuanh-h;    			
	    			if(  shis[xinh][xinl]==1)
	    			{
	        			return true;		
	    			}    				
    			}
    		}
    	}    		
   		return false;   	
    }  
      
    boolean isXiaChuJie()
    {
   		for(int l=0;l<10;l++)
   		{
   			if(luos[19][l]==1)
   			{
   				return true;
   			}
   		}
   		return false;   	
    } 
       
    boolean isXiaDang()
    {
      	for(int h=0;h<20-1;h++)
    	{
    		for(int l=0;l<10;l++)
    		{
    			if(shis[h+1][l]==1 && luos[h][l]==1)
    			{
        			return true;		
    			}
    		}
    	}		
  		return false;  	
    }        
}; 


