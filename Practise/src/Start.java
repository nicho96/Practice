
public class Start {

	public int x = 0;
	
	public static void main(String[] args){
		
		Start s = new Start();
		Start t = new Start();
		
		s.setX(7);
		t.setX(10);
		
		System.out.println(s.x  + " "  + t.x);
		
	}
	
	public static void something(){
		
	}
	
	public void setX(int y){
		x = y;
	}
	
}
