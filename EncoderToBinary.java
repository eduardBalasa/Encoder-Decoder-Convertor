


public class EncoderToBinary 
{
    public byte startInterval; //schimbam in shortInt parametrii
    public byte endInterval;
    public byte randomValue;
    
    public EncoderToBinary (byte startRange, byte endRange, byte randValue)
    {
        this.startInterval = startRange;
        this.endInterval = endRange;
        this.randomValue = randValue;
        
    }
    private byte encodeByte(byte inputByte)
    {
        byte retVal = 0;
        int sum = 0;
        int dif = 0;
        int reminder = 0;
        
        sum = inputByte + Byte.toUnsignedInt(randomValue);
        dif = Byte.toUnsignedInt(endInterval) - Byte.toUnsignedInt(startInterval);
        reminder = sum % (dif + 1);
        retVal = (byte)(Byte.toUnsignedInt(startInterval) + reminder);
        
        return retVal;
                
        
    }
    public byte[] encode (byte[] inputData)
    {        
        byte[] outputData = new byte[inputData.length];
        
        for(int i = 0; i < inputData.length; i++)
        {
            outputData[i] = encodeByte(inputData[i]);
        }        
        
        return outputData;             
    }
}
