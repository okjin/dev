package day2.s3.sort;

public class QuickSort {
	int arr[]={20,59,3,45,72,65,22,29,11,15};

	public  void swap(int i, int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	// �����ؾ��� �迭�� ����, ������ ���� ��ġ���� �Ķ���ͷ� �Է� �޴´�.
	public void sort( int left, int right){
        if(left < right) {
        	   int pivot = arr[left];
               int i = left+1;
               int j = right;
               while( i < j) {
            	   // �������κ��� Pivot���� ū���� ã�������� �̵��Ѵ�.
            	   	while(i<arr.length && arr[i] <= pivot){
                    	   i++;
                    } 
            	   	//���������κ��� Pivot���� �������� ã�������� �̵��Ѵ�.
            	   	while(j>=0 && arr[j] >= pivot){
                    	   j--;
                    }
            	    // �������� ������ �ο�Ҹ� Swap
                    if(i<j){ 
                    		swap(i,j);
                    }else{ //ã�� �μҿ䰡 ��ġ�ų� �������� �κ��۾� ����
                         	break;
                    }
               }
               // pivot�� �߽����� �������� ū������ �з��� �����ٸ� pivot�� �����
               arr[left] = arr[j];
               arr[j] = pivot;

               // pivot�� �߽����� ���� ���� ������ ���ȣ��
               sort(left, j-1); 
               
               // pivot�� �߽����� ������ ���� ���
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
 
