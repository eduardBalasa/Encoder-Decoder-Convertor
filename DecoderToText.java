

import java.nio.charset.Charset;

import laborator3.BinaryDecoder;



public class DecoderToText
{
    private DecodeToBinary decoder = null;
    
    public DecoderToText(DecodeToBinary decoder)
    {
        this.decoder = decoder;
    }

    public String decode(byte[] textToDecode)
    {
        String decodedResult = null;
        byte[] decoderResult = null;
        
        decoderResult = decoder.decode(textToDecode);
        decodedResult = new String(decoderResult, Charset.defaultCharset());
        
        return decodedResult;
    }
    
}

