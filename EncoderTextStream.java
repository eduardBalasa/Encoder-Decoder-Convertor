

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;

import EncoderToText;


public class EncoderTextStream 
{
    private EncoderToText encoder;
    private BufferedReader textReader;
    
    public EncoderTextStream(BufferedReader reader, EncoderToText encoder)
    {
        this.encoder = encoder;
        textReader = reader;                
    }
    
    public void encode(BufferedOutputStream outputStream) throws IOException
    {
        String currentLine = null;
        
        while ((currentLine = textReader.readLine()) != null)
        {
            byte[] encodedData = encoder.encode(currentLine);
            outputStream.write(encodedData);
        }
        outputStream.flush();
        
    }
}
