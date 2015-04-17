package day3.s3.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// È¸ÀÇ½Ç
public class Main1370 {
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n =s.nextInt();
		ArrayList<Room> list = new ArrayList<Room>();
		for(int i=0; i<n; i++){
			list.add(new Room(s.nextInt(),s.nextInt(),s.nextInt()));
		}
		
		ArrayList<Integer> cnums = new ArrayList<Integer>();
		Collections.sort(list);
		cnums.add(list.get(0).rnum);
		int endt = list.get(0).etime;
		int rooms = 1;
		for(int i=1; i<list.size(); i++){
			if(endt <= list.get(i).stime){
				rooms++;
				endt = list.get(i).etime;
				cnums.add(list.get(i).rnum);
			}
		}
		System.out.println(rooms);
		for(int i: cnums) System.out.print(i+" ");
	}
}

class Room implements Comparable<Room>{
	public int rnum;
	public int stime;
	public int etime;
	public Room(int rnum, int stime, int etime) {
		super();
		this.rnum = rnum;
		this.stime = stime;
		this.etime = etime;
	}
	@Override
	public int compareTo(Room o) {
		int ia = this.etime-o.etime;
		if(ia==0){
			ia = this.stime-o.stime;
		}
		return ia;
	}
}
/*
6
1 1 10
2 5 6
3 13 15
4 14 17
5 8 14
6 3 12

3
2 5 4
*/

/*
9
1 3 5
2 1 4
3 2 13
4 5 9
5 5 7
6 0 6
7 8 11
8 8 12
9 12 14

4
2 5 7 9
*/