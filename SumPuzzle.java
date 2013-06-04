


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SumPuzzle
{

    public SumPuzzle()
    {
    }

    public int findSum(Integer[] newdata)
    {
        if(newdata.length == 0)
            return 0;
        int numrows = newdata.length;
        
        int index = 1;
        int sum = newdata[index-1];
       
        int increment = 3;
        
        
        int count=0;
        for(int r = 2; r <= numrows; r++)
        {
           if(count == 2){
        	   count=0;
        	   increment+=2;
           }
           
            index = index + increment ;
            if(index >= newdata.length)
                break;
            sum += newdata[index];
            
            count++;
            System.out.println((new StringBuilder("index :")).append(index).append("sum ").append(sum).toString());
        }

        return sum;
    }

    public static void main(String args[])
    {
    	File file = new File("/Users/predave/workspace/CTX_Trunk/puzzles/src/triangle.txt");
    	List<Integer> data = new ArrayList<Integer>();
    	InputStream fin = null;
    	try {
			fin = new FileInputStream(file);
			BufferedInputStream buf = new BufferedInputStream(fin);
			try {
				String sCurrentLine;
				 
				BufferedReader br = new BufferedReader(new FileReader("/Users/predave/workspace/CTX_Trunk/puzzles/src/triangle.txt"));
	 
				while ((sCurrentLine = br.readLine()) != null) {
					//System.out.println(sCurrentLine);
					String[] inps = sCurrentLine.split(" ");
					for ( int i = 0 ; i < inps.length ; i++){
						//System.out.println(inps[i]);
						data.add(Integer.parseInt(inps[i]));
					}
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally{
    		if(null != fin){
    			try {
					fin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    	Integer[] newdata = data.toArray(new Integer[0]);
    
        
        (new SumPuzzle()).findSum(newdata);
    }
}
