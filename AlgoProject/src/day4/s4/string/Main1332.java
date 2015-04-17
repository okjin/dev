package day4.s4.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class Main1332 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuffer sb = new StringBuffer();
		sb.append(br.readLine());
		//sb.append(br.readLine());
		Vector<Integer> pi = getPrefixSuffix(sb.toString());
		for (int i = pi.size() - 1; i >= 0; i--) {
			if (i != pi.size() - 1)
				bw.append(" ");
			bw.append(String.valueOf(pi.get(i)));
		}
		bw.append("\n");
		bw.flush();
		bw.close();
		br.close();
	}
	public static Vector<Integer> getPrefixSuffix(String string) {
		Vector<Integer> ret = new Vector<Integer>();
		Vector<Integer> pi = getPartialMatch(string);
		int k = pi.size();
		while (k > 0) {
			ret.add(k);
			k = pi.get(k - 1);
		}
		return ret;
	}
	public static Vector<Integer> getPartialMatch(String string){
		int length=string.length(), begin=1, matched=0;
		Vector<Integer> pi=new Vector<Integer>(length);
		for (int i=0; i<length; i++)
			pi.add(0);
		while(begin+matched<length){
			if(string.charAt(begin+matched) == string.charAt(matched)){
				matched++;
				pi.set(begin+matched - 1, matched);
			}else{
				if(matched == 0)
					begin++;
				else{
					begin += matched - pi.get(matched - 1);
					matched = pi.get(matched - 1);
				}
			}
		}
		return pi;
	}
}