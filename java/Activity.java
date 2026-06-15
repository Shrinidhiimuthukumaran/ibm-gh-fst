package fst;

class Human{
	
	static int hc=0;
	Human(){
		hc++;
	}
	public void walking() {
		System.out.println("walking");
	}
	public void talking() {
		System.out.println("talking");
	}
}

class Boy extends Human{
	
}

class Girl extends Human{
	
}

class Robot{
	static int rc=0;
	
	Robot(){
		rc++;
	}
	public void walking() {
		System.out.println("walking");
	}
	public void talking() {
		System.out.println("talking");
	}
}
public class Activity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boy b1=new Boy();
		Boy b2=new Boy();
		Boy b3=new Boy();
		
		Girl g1=new Girl();
		Girl g2=new Girl();
		Girl g3=new Girl();
	
		Robot r1=new Robot();
		Robot r2=new Robot();
		Robot r3=new Robot();
		
		System.out.println("Human Population:"+ Human.hc);
		System.out.println("Robot Population:"+ Robot.rc);
		

	}

}
