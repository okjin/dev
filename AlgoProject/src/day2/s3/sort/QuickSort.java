package day2.s3.sort;

public class QuickSort {
	int arr[]={20,59,3,45,72,65,22,29,11,15};

	public  void swap(int i, int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	// 정렬해야할 배열과 왼쪽, 오른쪽 시작 위치값을 파라메터로 입력 받는다.
	public void sort( int left, int right){
        if(left < right) {
        	   int pivot = arr[left];
               int i = left+1;
               int j = right;
               while( i < j) {
            	   // 왼쪽으로부터 Pivot보다 큰값을 찾을때까지 이동한다.
            	   	while(i<arr.length && arr[i] <= pivot){
                    	   i++;
                    } 
            	   	//오른쪽으로부터 Pivot보다 작은값을 찾을때까지 이동한다.
            	   	while(j>=0 && arr[j] >= pivot){
                    	   j--;
                    }
            	    // 엇갈리지 않으면 두요소를 Swap
                    if(i<j){ 
                    		swap(i,j);
                    }else{ //찾은 두소요가 겹치거나 엇갈리면 부분작업 종료
                         	break;
                    }
               }
               // pivot을 중심으로 작은값과 큰값으로 분류가 끝났다면 pivot을 가운데로
               arr[left] = arr[j];
               arr[j] = pivot;

               // pivot을 중심으로 왼쪽 영역 퀵정렬 재귀호출
               sort(left, j-1); 
               
               // pivot을 중심으로 오른쪽 영역 재귀
               sort( j+1, right);
        }
	}
	
	public void print(){
		for(int v : arr ){
			System.out.print(v+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		QuickSort ss=new QuickSort();
		ss.print();
		ss.sort(0,9);
		ss.print();
	}
}
 
