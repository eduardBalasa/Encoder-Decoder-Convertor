import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Convertor {

	public static void main(String[] args) throws IOException
	{
		 BufferedReader reader = getInputReader();
	     BufferedOutputStream outStream = getOutputStream();
	     
	     BufferedInputStream encText = new BufferedInputStream(new FileInputStream("output.enc"));
	     BufferedWriter decodedStream = new BufferedWriter(new FileWriter("output.dec"));
	        
	        if (reader != null)
	        {
	            if (outStream != null)
	            {
	                
	            	EncoderToText text = new EncoderToText(new EncoderToBinary((byte)128, (byte)255, (byte)130));
	                EncoderTextStream txtStreamEncoder = new EncoderTextStream(reader, text);
	                
	                DecoderToText txtDecoder = new DecoderToText(new DecodeToBinary((byte)128, (byte)255, (byte)130));
	                DecoderTextStream txtStreamDecoder = new DecoderTextStream(encText, txtDecoder);
	                try
	                {
	                    txtStreamEncoder.encode(outStream);
	                    txtStreamDecoder.decode(decodedStream);
	                }
	                catch(IOException e)
	                {
	                    System.out.println("Error stream-encode!" + e.getMessage());
	                }
	                
	                try
	                {                
	                    outStream.close();
	                    decodedStream.close();
	                }
	                catch(IOException e)
	                {
	                    System.out.println("Error close output-stream!" + e.getMessage());
	                }
	            }
	        
	            try
	            {
	                reader.close();
	            }
	            catch(IOException e)
	            {
	                System.out.println("Error input text reader to be closed!" + e.getMessage());
	            }
	        }
	        
	    }
	       

	private static BufferedReader getInputReader()
    {
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader("inputFile.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Input file cannot be opened. " + e.getMessage());
        }
        
        return reader;
    }

	 private static BufferedOutputStream getOutputStream()
	    {
	        BufferedOutputStream outStream = null;
	        try
	        {
	            outStream = new BufferedOutputStream(new FileOutputStream("output.enc"));
	        }
	        catch(FileNotFoundException e)
	        {
	            System.out.println("Cannot open the output file." + e.getMessage());
	        }
	            
	                
	        return outStream;
	    }
	}

