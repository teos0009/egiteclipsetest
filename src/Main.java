import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String thePath = "C:\\@WebSc\\J\\test1\\sampleSmall";
		procFile(thePath);
	}// end main

	public static void procFile(String thePath) {

		String path = thePath;// shin: the sample
								// file to be
								// splitted.

		try {
			File f = new File(path);

			FileWriter fout = new FileWriter("sample_");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String s;
			String tempHold = "";

			int docno = 0;

			// look for sentence enclosed by . ? ! ;
			// use position of punctuation mark as index
			// anyhing before it is sentence, anything after put in tempHold.
			// repeat till end.
			while ((s = br.readLine()) != null) {
				int sentenceLen = s.length();// use as end index to split.
				//System.out.println("lenSTR= "+sentenceLen + " "+s);
				//StringTokenizer itr = new StringTokenizer(s, " \t\n\r\f,.:;?![]'");//ideal case
				String separator = "!?.";//assume simple case
		        StringTokenizer itr = new StringTokenizer( s, separator, true );
                s = s.replaceAll("\"","");//remove double quote
                //9 possible states with 3 param 
                int dot = s.indexOf(".");
				int qns = s.indexOf("?");
				int exc = s.indexOf("!");
				
				//simple case
				if(s.endsWith(".")){
					++docno;
					fout.write(docno+" "+s);
					fout.write("\r\n");
					
				}
				
				else if(s.endsWith("?")){
					++docno;
					fout.write(docno+" "+s);
					fout.write("\r\n");
					
				}
				
				else if(s.endsWith("!")){
					++docno;
					
					fout.write(docno+" "+s);
					fout.write("\r\n");
					
				}
				//end simple case
				
				
				String temp = "";
                while(itr.hasMoreTokens()){
                	String token = itr.nextToken();
                    if ( token.length() == 1 && separator.indexOf( token.charAt( 0 ) ) >= 0 ) {
                        System.out.println( "special char:" + token );
                    }
                    else {
                        System.out.println( "word :" + token );
                        ++docno;
                        fout.write(docno+"XXX"+token);
                        fout.write("\r\n");
                    }                	
          
//                		if(dot>-1){
//                			String a = itr.nextToken(".");
//                			System.out.println("dot=" + a);
//                			fout.write(docno+" "+a);
//        					fout.write("\r\n");
//                			
//                		}
//                		else if (qns > -1){
//                			String a = itr.nextToken("?");
//                			System.out.println("qns=" + a);
//                			fout.write(docno+" "+a);
//        					fout.write("\r\n");
//                		}
//                		else if (exc > -1){
//                			String a = itr.nextToken("!");
//                			System.out.println("exc=" + a);
//                			fout.write(docno+" "+a);
//        					fout.write("\r\n");
//                		}
//                		
//                		
//                		temp = temp + " " + itr.nextToken();
                		
                		       	
                }//end while
                
//                System.out.println("temp="+temp);
//                fout.write(docno+" "+temp);
//				fout.write("\r\n");
//				 BreakIterator iterator =
//			                BreakIterator.getSentenceInstance(Locale.US);
//
//			        int sentences = count(iterator, s);
//			        System.out.println("Number of sentences: " + sentences);
				
//========================================				
//				BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
//				String source = s;
//				iterator.setText(source);
//				int start = iterator.first();
//				for (int end = iterator.next();
//				    end != BreakIterator.DONE;
//				    start = end, end = iterator.next()) {
//				  System.out.println(source.substring(start,end));
//				}
//===============================				
				
//				if (tempHold.compareTo("") == 0) {// do nothing}
//
//				} 
//
//				else if  (tempHold.length()>1) {//got a weird "." after substring op in tempHold
//					System.out.println("TH= "+tempHold+" s="+s);
//					s = tempHold + " " + s;
//					//System.out.println("s-t= "+s); 
//					
//					tempHold = "";//need to clear
//				}
//
//				
//
//				if (s.indexOf(".") != -1) {
//					
//								
//					int endSen = s.indexOf(".");
//					
//					System.out.println("DOT endSen="+endSen+" len= "+sentenceLen);
//					if (endSen == sentenceLen) {// ideal case
//						++docno;
//						s = docno + " " + s;// append docno infront of sentence
//
//						fout.write(s);
//						fout.write("\r\n");
//					} else {
//						++docno;
//						String temp = s.substring(0, endSen+1);
//						System.out.println("the tempStr= "+temp);
//						String remain = s.substring(endSen, sentenceLen);
//						tempHold = remain;
//						
//						if(tempHold.indexOf(".")>-1 && tempHold.length()>2){
//							System.out.println("lonely period detected");
//							tempHold = "";
//						}
//						
//						temp = docno + " " + temp;
//
//						fout.write(temp);
//						fout.write("\r\n");
//						temp = "";
//
//					}// end else
//
//				} 
//				else if (s.indexOf("?") != -1) {
//					
//					int endSen = s.indexOf("?");
//					System.out.println("QNS endSen="+endSen+" len= "+sentenceLen);
//					if (endSen == sentenceLen) {// ideal case
//						++docno;
//						s = docno + " " + s;// append docno infront of sentence
//
//						fout.write(s);
//						fout.write("\r\n");
//					} else {
//						++docno;
//						String temp = s.substring(0, endSen+1);
//						String remain = s.substring(endSen, sentenceLen);
//						tempHold = remain;
//						temp = docno + " " + temp;
//
//						fout.write(temp);
//						fout.write("\r\n");
//
//					}// end else
//
//				} 
//				else if (s.indexOf("!") != -1) {
//					
//					int endSen = s.indexOf("!");
//					System.out.println("EXC endSen="+endSen+" len= "+sentenceLen);
//					if (endSen == sentenceLen) {// ideal case
//						++docno;
//						s = docno + " " + s;// append docno infront of sentence
//
//						fout.write(s);
//						fout.write("\r\n");
//					} else {
//						++docno;
//						String temp = s.substring(0, endSen+1);
//						String remain = s.substring(endSen, sentenceLen);
//						tempHold = remain;
//						temp = docno + " " + temp;
//
//						fout.write(temp);
//						fout.write("\r\n");
//
//					}// end else
//				}
//
//				else if (s.indexOf(";") != -1) {
//			
//					int endSen = s.indexOf(";");
//					System.out.println("SEMC endSen="+endSen+" len= "+sentenceLen);
//					if (endSen == sentenceLen) {// ideal case
//						++docno;
//						s = docno + " " + s;// append docno infront of sentence
//
//						fout.write(s);
//						fout.write("\r\n");
//					} else {
//						++docno;
//						String temp = s.substring(0, endSen+1);
//						String remain = s.substring(endSen, sentenceLen);
//						tempHold = remain;
//						temp = docno + " " + temp;
//
//						fout.write(temp);
//						fout.write("\r\n");
//
//					}// end else
//				}//end else if

			}// end while readline

			// close all
			fr.close();
			fout.close();
		}// end try
		catch (Exception e) {
			System.out.println("Exception: " + e);
		}// end catch
	}//end procFile

    private static int count(BreakIterator bi, String source) {
        int counter = 0;
        try {
			FileWriter fout = new FileWriter("__sample");
			

        bi.setText(source);

        int lastIndex = bi.first();
        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();

            if (lastIndex != BreakIterator.DONE) {
                String sentence = source.substring(firstIndex, lastIndex);
                System.out.println("sentence = " + sentence);
                fout.write(sentence);
                counter++;
            }
        }//end while
        fout.close();
        
        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
        return counter;
    }

}// end class
