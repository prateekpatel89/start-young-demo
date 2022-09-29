package com.snipers.azure.utils;

public class CommonUtils {
    public static String uniqueId() {
        Long timeId = new Long(System.nanoTime());
        String timeIdString = timeId.toString();
        Double randomId = new Double(Math.floor(Math.random() * 1000D));
        String randomIdString = String.valueOf(randomId.intValue());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(randomIdString);
        stringBuffer.append(timeIdString);
        String generatedId = null;
        try {
            generatedId = stringBuffer.toString();
            if (generatedId.length() >= 19) {
                generatedId = generatedId.substring(0, 18);
            }
        } catch (Exception exception) {

        }
        return generatedId;
    }
}
