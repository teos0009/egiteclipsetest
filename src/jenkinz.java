import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;




public class jenkinz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			openURL();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void openURL() throws MalformedURLException{
		URL url = new URL("https://ci.jenkins-ci.org/view/All/api/json?pretty=true");
		InputStream in = null;
		String line = "";
		StringBuffer buf1 = new StringBuffer();
		try {
			in = url.openStream();

		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader buff = new BufferedReader(reader);
		// read.toString to see whatis inside
		
        while( buff.readLine() != null){
            System.out.println(buff.readLine());
    }//end while
   
		}//end try
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
