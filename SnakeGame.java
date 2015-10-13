package day25;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame 
{
	//初始化地图长宽
	public static final int WIDTH=35;
	public static final int HEIGH=9;
	Point food;
	
	
	//地图
	private char[][] background=new char[HEIGH][WIDTH];
	//使用单列集合保存蛇节点的所有信息
	LinkedList<Point> snake = new LinkedList<Point>();
	public void initSnake(){
		int  x = WIDTH/2;
		int y = HEIGH/2;
		
		snake.addFirst(new Point(x-1,y));
		snake.addFirst(new Point(x,y));
		snake.addFirst(new Point(x+1,y));
		
	}
	//在地图上显示蛇
	public void showSnake(){
		Point head=snake.getFirst();
		background[head.y][head.x]=('$');
		for(int i=1;i<snake.size();i++){
			Point body=snake.get(i);
			background[body.y][body.x]='#';
		}
		
	}
	//初始化地图
	public void initBackgrpund()
	{
		
		for(int rows=0;rows<background.length ;rows++)
		{
			for(int cols=0;cols<background[rows].length;cols++)
				{
				if(rows==0||rows==(HEIGH-1)||cols==0||cols==(WIDTH-1))	
				background[rows][cols]='*';
				else
					background[rows][cols]=' ';
				}
		}
		//打印地图
	
	
	}
	//显示地图
	

	public void showBackground() {
		for(int rows=0;rows<background.length ;rows++)
		{
			for(int cols=0;cols<background[rows].length;cols++)
			{
				System.out.print(background[rows][cols]);
			}
			System.out.println();
		}
	}
	//生成食物
	
	public void creadFood(){
	
		 Random random=new Random();
		 while(true){
		 int x=random.nextInt(WIDTH);
		 int y = random.nextInt(HEIGH);
		if(background[y][x]!=('*')){
			food=new Point(x,y);
			
			break;}
		}}
	public void showFood(){
		background[food.y][food.x] ='@';
	}
	//蛇向上走
	public  void moveup(){
		//获取原来舌头
		Point head=snake.getFirst();
		//添加信舌头
		snake.addFirst(new Point(head.x,head.y-1));
		//删除舌头
		snake.removeLast();
	}
	public  void movedown(){
		Point head=snake.getFirst();
		snake.addFirst(new Point(head.x,head.y+1));
		snake.removeLast();
	}
	public  void moveleft(){
		Point head=snake.getFirst();
		snake.addFirst(new Point(head.x-1,head.y));
		snake.removeLast();
	}
	public  void moveright(){
		Point head=snake.getFirst();
		snake.addFirst(new Point(head.x+1,head.y));
		snake.removeLast();
	}
	//清屏函数
	public void reflesh(){
		initBackgrpund();
		showSnake();
		showFood();
		showBackground();
        
	}
    public static void clear(){
    	for (int i=0;i<10;i++){
    		System.out.println();
    		System.out.println();
    		System.out.println();
    		System.out.println();
    		System.out.println();
    		System.out.println();
    		System.out.println();
    		System.out.println();
    		System.out.println();
    	}
    }
    
	

	
	public static void main(String[] args) throws InterruptedException {
		SnakeGame snake =new SnakeGame();
		
		snake.initBackgrpund();
		snake.initSnake();
		snake.creadFood();
		snake.showFood();
		for(int i=0;i<3;i++){
			snake.moveup();
			snake.reflesh();
			Thread.sleep(1000);
			clear();
		
		}
	
 //蛇绕着地图转一圈
        for(int i = 0;  i < 5; i++){
            snake.moveright();
            snake.reflesh();
            Thread.sleep(500);
            clear();}

            for(int i = 0;  i < 3; i++){
                snake.movedown();
                snake.reflesh();
                Thread.sleep(500);
                clear();
              
            } for(int i = 0;  i < 3; i++){
                snake.moveleft();
                snake.reflesh();
                Thread.sleep(500);
                clear();
              
            }
        }
  
	}
	
	
	

