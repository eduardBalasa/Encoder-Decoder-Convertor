


public class DecodeToBinary 
{
    public byte startInterval;
    public byte endInterval;
    public byte randomValue;
    
    public DecodeToBinary (byte startRange, byte endRange, byte randValue)
    {
        this.startInterval = startRange;
        this.endInterval = endRange;
        this.randomValue = randValue;
        
    }
    
    private byte decodeByte(byte inputByte)
    {
        int temp = 0;
        byte retVal = 0;
        int dif = 0;
        
        dif = Byte.toUnsignedInt(endInterval) - Byte.toUnsignedInt(startInterval);
        temp = (Byte.toUnsignedInt(inputByte) - Byte.toUnsignedInt(startInterval)) ;
        
        while (temp < Byte.toUnsignedInt(randomValue)) 
        {
            temp = (temp + (dif + 1));
        }
        
        retVal = (byte) (temp - Byte.toUnsignedInt(randomValue));
        
        return retVal;
    }
    
    public byte[] decode (byte[] inputData)
    {        
        byte[] outputData = new byte[inputData.length];
        
        for(int i = 0; i < inputData.length; i++)
        {
            outputData[i] = decodeByte(inputData[i]);
        }        
        
        return outputData;             
    }
}
