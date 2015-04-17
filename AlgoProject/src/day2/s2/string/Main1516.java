package day2.s2.string;


import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main1516 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		while (true){
			
			String ss=s.nextLine();
			if(ss.equals("END"))break;
			String [] str=ss.split(" ");
			HashMap<String, Integer> ans=new HashMap<String, Integer>();
			for(int i=0;i<str.length;i++){
				if(ans.containsKey(str[i])){
					ans.put(str[i], ans.get(str[i])+1);
				}else{
					ans.put(str[i], 1);
				}
			}
			TreeMap<String, Integer>answer=new TreeMap<String, Integer>(ans);
			// Iterator iteratorKey = answer.keySet( ).iterator( );
		
			for(String a:answer.keySet()){
				System.out.println(a+" : "+answer.get(a));
			}
			s.close();
		}
	}
}
