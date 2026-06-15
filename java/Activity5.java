package fst;

abstract class Book{
	String title;
	
	abstract void setTitle(String title);
	
	String getTitle() {
		return title;
	}
	
}

class MyBook extends Book{
	public void setTitle(String s) {
		title=s;
	}
}

public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String title="Harry Potter and the Order of Pheonix";
		Book newNovel=new MyBook();
		newNovel.setTitle(title);
		System.out.println("title:"+newNovel.getTitle());
		

	}

}
