import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class LLK extends KeyAdapter  implements Runnable, MouseListener,MouseMotionListener
{   
	//定义变量
	int[][] zhens;
	
	int h1;
	int l1;
	int h2;
	int l2;
	int xia;
	
	int[] xianDianx;
	int[] xianDiany;
	int xianDianShu;	
	
	int shiJian;
	
	Image[]  tus;//17
	
    JFrame frame;	
	boolean start;
    Thread timerThread;

    
    LLK()
    {  
		//变量初值
		chuShi();
		
		frame = new JFrame();
        frame.getContentPane().add(new Screen());
        //键盘监听 
        frame.addKeyListener(this);  
        //鼠标监听            
        Container contentPane=frame.getContentPane();
        contentPane.addMouseListener(this);
        contentPane.addMouseMotionListener(this);
        
        frame.setSize(5*2 + 35*14 , 22+ 5*2 +35*10);//窗口大小
        frame.setVisible(true);

        frame.repaint();
    }
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}     
	public void mouseExited(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}  
	
	public void mouseMoved(MouseEvent e){}
	
	//鼠标单敲击   
	public void mouseClicked(MouseEvent e)
	{
		if (e.getButton()==MouseEvent.BUTTON1)
		{
			zuoJian(e.getX(),e.getY());
			if(isYing())
			{
				System.out.println("得分"+shiJian);
				System.exit(0);
			}
		}
		else if(e.getButton()==MouseEvent.BUTTON3)
		{

		}  
		frame.repaint();		  	
	}

    public void keyPressed(KeyEvent evt)
    {
        switch(evt.getKeyCode()) 
        {	
        	case KeyEvent.VK_ENTER:

				break;
			case KeyEvent.VK_ESCAPE:
                start = false;
				System.exit(1);
				break;				
        }

        frame.repaint();
    }

    public void run()
    {
        while(true)
        {
            try
            { 
				timerThread.sleep(10000);
            }
            catch (InterruptedException e)
            {  
				e.printStackTrace();
            }
            
            if(start==false)
                return;
            //定时    
           

            
			shiJianBian();
						
            frame.repaint();
        }
    }

	class Screen extends JComponent
	{   
		public void paint(Graphics g)
		{
			Graphics2D g2d = (Graphics2D)g;
			//画图
			xianShi( g2d,this);
		}
	}

    public static void main(String[] args)
    {
         new LLK();
    }
 //-----------------------------------------------
 	void chuShi()
 	{	
		chuShiShiJian();			
		jiaZaiTu();
		maKuai();
		daLuan();
		chuShiXian();		
 	}  
 	
 	void xianShi(Graphics2D g2d,Screen s)
 	{
	  	xianShiShiJian( g2d,s);
	  	xianShiZhen( g2d,s);
	  	xianShiXuanZhong( g2d,s);		  	
	  	xianShiXian( g2d,s);
 	}
 	
 	boolean isYing()
 	{
		for(int h=1;h<8;h++)
		{
			for(int l=1;l<13;l++)
			{
				if(zhens[h][l]!=0)
				{
					return false;
				}
			}
		} 		
 		return true;	
 	}
 	
 	void zuoJian(int mx,int my)
 	{
 		int mh=pixel2Logic(my);
 		int ml=pixel2Logic(mx); 
 		
 		if(zhens[mh][ml]==0) return;
 		
 		switch(xia)
 		{
 			case 0:
 				zuoYiXia(mh,ml);
 				break;
 			case 1:
 				zuoErXia(mh,ml);
 				break; 			
 			case 2:
 		}
 	}
 	
 	void shiJianBian()
 	{
 		shiJian=shiJian-10;
 		if(shiJian<=0)
 		{
 			System.out.println("输了");
 			System.exit(0);
 		}
 	}
 //------------------------------------------
 	void jiaZaiTu()
 	{
 		tus=new Image[26];
 		for(int i=1;i<26;i++)
 		{
 			tus[i]=new ImageIcon("llk_pic/" + i + ".gif").getImage();
 		}
 	}
 	
 	void maKuai()
 	{
 		zhens=new int[9][14];
 		
 		int zhonglei=1;
 		for(int h=1;h<=7;h++)
 		{
 			for(int k=0;k<3;k=k+1)
 			{
 				for(int ge=1;ge<=4;ge++)
 				{
 					zhens[h][k*4+ge]=(zhonglei - 1) %25+1;
 				}	
 				zhonglei++;	
 			}
 		}
 	} 	
 	
 	void daLuan()
 	{
		for(int ci=0;ci<50;ci++)
		{
			int h1=1 + (int)(Math.random()*7);
			int l1=1 + (int)(Math.random()*12);			
			int h2=1 + (int)(Math.random()*7);
			int l2=1 + (int)(Math.random()*12);
			int tmp=zhens[h1][l1];
			zhens[h1][l1]=zhens[h2][l2];
			zhens[h2][l2]=	tmp;			
		} 		
 	}
 	
 	void chuShiXian()
 	{
		huanYuanXuan();
		
		xianDianx=new int[4];
		xianDiany=new int[4];
		xianDianShu=0;			
 	}
 	
 		
 	void chuShiShiJian()
 	{
		shiJian=200;
		timerThread = new Thread(this);
		timerThread.start();
		start = true;	
 	} 	
 	
 	//
 	void xianShiShiJian(Graphics2D g2d,Screen s)
 	{
 		g2d.setColor(Color.RED);
 		g2d.drawRect(35,35*9,35*12,20);
 		g2d.setColor(Color.BLUE);
 		g2d.fillRect(36,35*9 +1 ,35*12*shiJian/200 - 1,19); 		
 	}
 	
 	void xianShiZhen(Graphics2D g2d,Screen s)
 	{
 		for(int h=1;h<=7;h++)
 		{
 			for(int l=1;l<=12;l++)
 			{
 				g2d.drawImage(tus[ zhens[h][l] ],logic2Pixel(l),logic2Pixel(h),s);
 			}
 		} 		
 	} 	
 			
 	void xianShiXian(Graphics2D g2d,Screen s)
 	{
 	 	if(xianDianShu==0) return;
 	 	
 	 	g2d.setColor(Color.MAGENTA);
 		g2d.drawPolyline(xianDianx,xianDiany,xianDianShu );	
 	}  
 	
 	void xianShiXuanZhong(Graphics2D g2d,Screen s)
 	{
		if(h1==-1) return;
 	 	g2d.setColor(Color.MAGENTA);
 		g2d.drawRect(logic2Pixel(l1)+1,logic2Pixel(h1)+1,35-2,35-2) ;	 	
 		g2d.drawRect(logic2Pixel(l1),logic2Pixel(h1),35,35) ;
 		
		if(h2==-1) return;
 	 	g2d.setColor(Color.MAGENTA);
  		g2d.drawRect(logic2Pixel(l1)+1,logic2Pixel(h1)+1,35-2,35-2) ;	 	
 		g2d.drawRect(logic2Pixel(l2),logic2Pixel(h2),35,35) ; 		
 	}  
 	//
 	
 	int logic2Pixel(int kuaixy)
 	{
 		return 35*kuaixy;	
 	} 
 	
 	int pixel2Logic(int mousexy)
 	{
 		return mousexy/35;
 	} 
 	// 
 	void zuoYiXia(int mh,int ml)
 	{		
 		if(mh<1 || mh>7 || ml<1 || ml>12) return;
		h1=mh;
		l1=ml;		
 		xia=1;					
 	}
 	
 	void zuoErXia(int mh,int ml)
 	{
 		if(mh<1 || mh>7 || ml<1 || ml>12) return;		
		h2=mh;
		l2=ml;		
 		xia=2;
	 		
		if(	h1==-1 ||
	 		h2==h1 && l2==l1 || 
	 		zhens[h1][l1] !=zhens[h2][l2] ||
	 		isLian()==false)
 		{
 			huanYuanXuan();
 		}
 		else
 		{
 			suanXianDian();	
 			xiaoErKuai();	
 			huanYuanXuan();	
 		}	
 	} 	
 	
 	//---------------------------------
 	boolean isLian()
 	{
		return isLianHang() || isLianLie();
 	}
 	 
 	void suanXianDian()
 	{
						
 	}
 	
 	void xiaoErKuai()
 	{
 		zhens[h1][l1]=0;
 		zhens[h2][l2]=0; 
 		xianDianShu=4;  	 			
 	} 
 	
 	void huanYuanXuan()
 	{
 		h1=-1;
		l1=-1;
		h2=-1;
		l2=-1;
		xia=0;
 	}
 	//------------------------------------------
 	boolean isLianHang()
 	{
 		int tmp=zhens[h1][l1];
 		zhens[h1][l1]=0;
 		zhens[h2][l2]=0;
 				
 		int lcong=(l1>l2?l2:l1);
		int ldao=(l1>l2?l1:l2); 
		 		
 		for(int h=0;h<9;h++)
 		{
 			boolean hangLian=true;
 			for(int l=lcong;l<=ldao;l++)
 			{
 				if(zhens[h][l]!=0)
 				{
 					hangLian=false;
 					break;
 				}
 			}
 
 			if(hangLian==false) continue;
 			
  			boolean dian1Lian=true;
  			int hshang=(h1>h?h:h1);
			int hxia=(h1>h?h1:h); 	
 			for(int hh=hshang;hh<=hxia;hh++)
 			{
 				if(zhens[hh][l1]!=0 )
 				{
 					dian1Lian=false;
 					break;
 				}
 			}
  			
  			if(dian1Lian==false) continue;								
 			
 			
  			boolean dian2Lian=true;
  			hshang=(h2>h?h:h2);
			hxia=(h2>h?h2:h); 	
 			for(int hh=hshang;hh<=hxia;hh++)
 			{
 				if( zhens[hh][l2]!=0)
 				{
 					dian2Lian=false;
 					break;
 				}
 			}

  			if(dian2Lian==true) 
  			{
				xianDianx[0]=logic2Pixel(l1)+17;
				xianDiany[0]=logic2Pixel(h1)+17;
				xianDianx[1]=logic2Pixel(l1)+17;
				xianDiany[1]=logic2Pixel(h)+17;				
				xianDianx[2]=logic2Pixel(l2)+17;
				xianDiany[2]=logic2Pixel(h)+17;				
				xianDianx[3]=logic2Pixel(l2)+17;
				xianDiany[3]=logic2Pixel(h2)+17;				
				xianDianShu=4;  				
				return true;
  			}	 			
 		}
 		
 		zhens[h1][l1]=tmp;
 		zhens[h2][l2]=tmp;
 		return false; 		
 	}
 	
 	boolean isLianLie()
 	{
 		int tmp=zhens[h1][l1];
 		zhens[h1][l1]=0;
 		zhens[h2][l2]=0;
 				
 		int hcong=(h1>h2?h2:h1);
		int hdao=(h1>h2?h1:h2); 
		 		
 		for(int l=0;l<14;l++)
 		{
 			boolean lieLian=true;
 			for(int h=hcong;h<=hdao;h++)
 			{
 				if(zhens[h][l]!=0)
 				{
 					lieLian=false;
 					break;
 				}
 			}
 
 			if(lieLian==false) continue;
 			
  			boolean dian1Lian=true;
  			int lshang=(l1>l?l:l1);
			int lxia=(l1>l?l1:l); 	
 			for(int ll=lshang;ll<=lxia;ll++)
 			{
 				if(zhens[h1][ll]!=0 )
 				{
 					dian1Lian=false;
 					break;
 				}
 			}
  			
  			if(dian1Lian==false) continue;								
 			
 			
  			boolean dian2Lian=true;
  			lshang=(l2>l?l:l2);
			lxia=(l2>l?l2:l); 	
  			for(int ll=lshang;ll<=lxia;ll++)
 			{
 				if( zhens[h2][ll]!=0)
 				{
 					dian2Lian=false;
 					break;
 				}
 			}
			
  			if(dian2Lian==true) 
  			{
				xianDianx[0]=logic2Pixel(l1)+17;
				xianDiany[0]=logic2Pixel(h1)+17;
				xianDianx[1]=logic2Pixel(l)+17;
				xianDiany[1]=logic2Pixel(h1)+17;				
				xianDianx[2]=logic2Pixel(l)+17;
				xianDiany[2]=logic2Pixel(h2)+17;				
				xianDianx[3]=logic2Pixel(l2)+17;
				xianDiany[3]=logic2Pixel(h2)+17;				
				xianDianShu=4;  				
				return true;
  			}	 			
 		}
 		
 		zhens[h1][l1]=tmp;
 		zhens[h2][l2]=tmp;
 		return false; 		
 	} 				
}; 


