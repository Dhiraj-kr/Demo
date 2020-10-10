package techgig;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class TestSateliteApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestSateliteApp a = new TestSateliteApp();
		List<Point> points = new ArrayList<Point>();
		
		points.add(a.new Point(2,1));
		points.add(a.new Point(6,6));
		points.add(a.new Point(4,2));
		points.add(a.new Point(2,5));
		points.add(a.new Point(2,6));
		points.add(a.new Point(2,7));
		points.add(a.new Point(3,4));
		points.add(a.new Point(6,1));
		points.add(a.new Point(6,2));
		points.add(a.new Point(2,3));
		points.add(a.new Point(6,3));
		points.add(a.new Point(6,4));
		points.add(a.new Point(6,5));
		points.add(a.new Point(6,7));
		
//		points.add(a.new Point(1,1));
//		points.add(a.new Point(1,100));
//		points.add(a.new Point(100,1));
		long startTime = (new java.util.Date()).getTime();
		int count = getAllLines(points,a);
		System.out.println("\n\n Duration :::"+((new java.util.Date()).getTime()-startTime)+" ms");
		System.out.println("\n\n count:::"+count);
	}

	public static int launchingSatellites(int input1,int input2,String[] input3)
    {
		TestSateliteApp app = new TestSateliteApp();
		List<Point> points = new ArrayList<Point>();
	    for(String str:input3){
	    	String[] cords = str.split("#");
	    	points.add(app.new Point(Integer.parseInt(cords[0]),Integer.parseInt(cords[1])));
	    }
		return getAllLines(points,app);
    }
	
	
	
	
	static final float INFT = 9999999.0f;
	
	class Point implements Comparable<Point>{
		int x;
		int y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
		
		public boolean equals(Object obj){
			Point p = (Point)obj;
			return this.x == p.x && this.y == p.y ? true:false;
		}

		@Override
		public int compareTo(Point p) {
			if(this.x > p.x  || (this.x == p.x && this.y > p.y))
				return 1;
			else if(this.x < p.x  || (this.x == p.x && this.y < p.y))
				return -1;
			else 
				return 0;
		}
		
		public String toString(){
			return "{"+this.x+","+this.y+"}";
		}
	}
	
	//y= mx+c
	class Line{
		
		List<Point> points = new ArrayList<>();
		float m;
		float c;
		
		Line(Point p1,Point p2){
			m = tanget(p1,p2);
			c = intercept(p1,p2);
			points.add(p1);
			points.add(p2);
		}
		
		Line(Point p1,Point p2,float m,float c){
			this.m = m;
			this.c = c;
			points.add(p1);
			points.add(p2);
		}
		
		boolean add(Point p){
			if(points.contains(p))
				return false;
			else{
				Point pt = points.get(0);
				float m = tanget(pt,p);
				float c = intercept(pt,p);
				boolean flag = false;
				if(this.m == m && this.c == c){
					points.add(p);
					flag=true;
				}
				return flag;
			}
		}
		
		public boolean equals(Object obj){
			return this.m == ((Line) obj).m && this.c == ((Line) obj).c;
		}
		
		public String toString(){
			return this.points.toString();
		}
		
	}
	
	public static int getAllLines(List<Point> points,TestSateliteApp a){
		Map<Float,Line> linesMap = new HashMap<Float,Line>();
		Set<Point> processed = new HashSet<Point>();
		for(Point p:points){
			processed.add(p);
			for(Point pt:points){
				
				if(!processed.contains(pt)){
					float m = tanget(p,pt);
					float c = intercept(p,pt);
					Float mc = Float.valueOf(m*c);
					Line l=null;
					if((l=linesMap.get(mc)) == null){
						l=a.new Line(p,pt,m,c);
						linesMap.put(mc,l);
					}else{
						l.add(pt);
					}
					
				}
			}
			
		}
		int maxPoints=0;
		for(Line l:linesMap.values()){
			if(l.points.size()>=3){
				Collections.sort(l.points);
				Point p0 = l.points.get(0);
				Point p1 = l.points.get(1);
				
				int dx = p1.x - p0.x;
				int dy = p1.y - p0.y;
				boolean valid = true;
				for(int i=2;i<l.points.size();i++){
					p0=p1;
					p1=l.points.get(i);
					if((p1.x - p0.x) != dx || (p1.y - p0.y)!=dy){
						valid = false;
						break;
					}
				}
				
				if(valid && maxPoints<l.points.size()){
					maxPoints = l.points.size();
				}
			}
		}
		
		return maxPoints;
	}
	
	public static float tanget(Point p1,Point p2){
		return p1.x==p2.x ?INFT:(float)(p2.y-p1.y)/(p2.x-p1.x);
	}
	
	public static float intercept(Point p1,Point p2){
		return p1.x==p2.x ? p1.x : p1.y-((float)p1.x*(float)(p2.y-p1.y)/(p2.x-p1.x));
	}

}
