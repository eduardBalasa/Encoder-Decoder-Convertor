

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;

import DecoderToText;


public class DecoderTextStream 
{
    private DecoderToText decoder;
    private BufferedInputStream binaryReader;
    
    public DecoderTextStream(BufferedInputStream reader, DecoderToText decoder)
    {
        this.decoder = decoder;
        binaryReader = reader;                
    }
    
    public void decode(BufferedWriter outputStream) throws IOException
    {
        String currentLine = null;
        int totalReadData = 0;    
       
        if (totalReadData > 0)
        {
            
            
        }
        outputStream.write(currentLine);
        
        outputStream.flush();
       
    }
}
