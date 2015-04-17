package day2.s3.sort;

public class SelectionSort2 {
	int[] values={20,59,3,45,72,65,20,29,11,15};	
	
	public  void swap(int i, int j){
		int temp=values[i];
		values[i]=values[j];
		values[j]=temp;
	}
	
	public void sort(){
		for(int i=0; i<values.length-1; i++){
			
			int min=values[i];
			int index=i;			
			for(int j=i+1; j<values.length; j++){
				if( min > values[j]){
					min=values[j];
					index=j;
				}
			}
			swap(i,index);
		}
	}
	public void print(){
		for(int v : values ){
			System.out.print(v+" ");
		}
	}
	
	public static void main(String[] args) {
		SelectionSort2 ss=new SelectionSort2();
		ss.sort();
		ss.print();
	}
}
