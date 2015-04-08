import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class parspgm
{	

	private String CFG_HOME = null;
	private String HOME = null;
	private String ANT_HOME = null;
	
	public static void Usage() {
		
		System.out.println("Usage : parspgm [file name]");
	}
	
	public static void main(String[] args) throws Exception 
	{
		if (args[0] == null || args[0].equals("")) {
			Usage();			
		}
		new parspgm(args[0]);
	}

	public parspgm(String args)  throws Exception 
	{
		File fview = null;
		String sfile_name = "";
		String sfile_data = "";
		String dfile_data = "";
		String dfile_name = "";
		
		FileOutputStream   fOut = null;
		OutputStreamWriter osr  = null;
		BufferedWriter     bw   = null;
		
		byte[] in_value      = null;
		String in_str		= "";
		
		
		int totalLen = 0;
		byte[] buf = new byte[1024];
		
		InputStream in = null;
		
		int cnt = 0;
		try {
			HOME      = getEnv("HOME");
			
			sfile_name = args;		
			
			RandomAccessFile fin = new RandomAccessFile(sfile_name, "r");
			
			while (true) {
				sfile_data = fin.readLine();
				if (sfile_data.length() < 10) break;
				
				sfile_data = sfile_data.trim();
				++cnt;
				
				/*** 파일에서 소스파일내용을 읽어서 필요한 부분만 변수에 저장 **/
				try {
					RandomAccessFile sfin = new RandomAccessFile(sfile_data, "r");
					int sfin_len = (int)sfin.length();
					
					String tmpstr1 = sfin.readLine();
					String tmpstr2 = sfin.readLine();
					
					byte[] dest_bytes = new byte[(sfin_len - (tmpstr1.length() + tmpstr2.length())) - 1];
					sfin.read(dest_bytes);
					
					dfile_data = new String(dest_bytes);
					sfin.close();
				} catch (Exception e) {
					System.out.println("111111 : " + e.getMessage());
				}
				
				/** 최종 파일에 저장 **/
				try {
					dfile_name  = HOME + File.separator + "work" + File.separator + getCurrentDate();
					dfile_name += File.separator + "genres" + ByteFormater_toString(cnt, 3);
					
					fOut = new FileOutputStream(dfile_name);
					osr  = new OutputStreamWriter(fOut);
					bw   = new BufferedWriter(osr);
					
					bw.write(dfile_data);
				} catch (Exception e) {
					System.out.println("111111 : " + e.getMessage());
				} finally {
					if(bw!=null) try{ bw.close(); } catch (Exception e2) { }
					if(osr!=null) try{ osr.close(); } catch (Exception e2) { }
					if(fOut!=null) try{ fOut.close(); } catch (Exception e2) { }
				}
				
				
			} // while
			
			
			

		}catch(Exception ex){
			System.out.println(ex.getMessage());
			System.exit(-1);
		} 
	} // end jcom
	
	public String getEnv(String envname) throws Exception 
	{
		Properties props = System.getProperties();
		String osName = (String)props.get("os.name");
		Properties p = new Properties();
		Process ps;
		String env = "";
		try
		{
			if ( osName.equals("Windows NT") ||
				 osName.equals("Windows 2000") ||
				 osName.equals("Windows_NT")
				 ) 
			{
				ps = Runtime.getRuntime().exec("cmd /C set");
				p.load(ps.getInputStream());
			} 
			else if ( osName.startsWith("Win") ) 
			{
				ps = Runtime.getRuntime().exec("cmd /C set");
				p.load(ps.getInputStream());
			} 
			else 
			{
				ps = Runtime.getRuntime().exec("/usr/bin/env");
				p.load(ps.getInputStream());
				
			}
			env = (String)p.get(envname);
			if ( env == null ) {
				throw new Exception("환경 변수 " + envname + "가 없음.");
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
		} catch (NullPointerException e) {
			e.printStackTrace(System.err);
		}
		if (env.endsWith("/")) 
			env = env.substring(0, env.length()-1);
		return env;
	}

	public String getCurrentDate()
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(new Date());
	}
	
	public String ByteFormater_toString(int size, int len) {
		String my_str = Integer.toString(size);  
		int set_zero = 0;

		set_zero = len - my_str.length();

		if(set_zero < 0) return null;

		while(set_zero > 0)	{
			my_str = "0" + my_str;
			set_zero--;
		}

		return my_str;
	}
	
} // class
