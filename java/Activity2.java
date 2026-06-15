package fst;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {10, 77, 10, 54, -11, 10};
		System.out.println("result :"+result(nums));

	}
	
	public static boolean result(int[] nums) {

		int sum=0;
		for(int i:nums) {
			if(i==10) {
				sum+=i;
			}
		}
		return sum==30;
	}

}
