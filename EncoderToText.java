

import EncoderToBinary;

public class EncoderToText
{
    private EncoderToBinary encoder = null;
    
    public EncoderToText(EncoderToBinary encoder)
    {
        this.encoder = encoder;
    }

    public byte[] encode(String textToEncode)
    {
        byte[] encodedResult = null;
        
        encodedResult = encoder.encode(textToEncode.getBytes());
        
        return encodedResult;
    }
    
}

