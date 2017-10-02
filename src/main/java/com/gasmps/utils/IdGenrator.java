package com.gasmps.utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author akhtar
 */

public class IdGenrator {

	public static final int INCREMENT_LOWER_BOUND = 6;
	public static final int INCREMENT_UPPER_BOUND = 16;
	public static final int LONG_ID_LENGTH = 16;
	public static final int SHORT_ID_LENGTH = 10;
	
	
    public IdGenrator() {
    	
	}

    public static synchronized String genrateShortId(String inputId,boolean appendDate) throws Exception {
    return IdGenrator.genrateLongId(inputId, false);
    }
    
    public static synchronized String genrateLongId(String inputId,boolean appendDate) throws Exception {
        if (inputId == null) 
            throw new NullPointerException("Input id is null");
        else if(!validateLength(inputId,appendDate))
        	throw new Exception("Input id validation error");
        
        StringBuffer id =null;
        if(appendDate)
        	id = new StringBuffer(inputId.substring(INCREMENT_LOWER_BOUND, INCREMENT_UPPER_BOUND));
        else
        	id = new StringBuffer(inputId);
        char ch[] = new char[id.length()];
        id.getChars(0, id.length(), ch, 0);
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] == 122) {
                int j = i - 1;
                while (j >= 0) {
                    if ((ch[j] >= 97 && ch[j] < 122) || (ch[j] >= 48 && ch[j] < 57)) {
                        ch[j] = (char) (((int) ch[j]) + 1);
                        break;
                    }
                    if (ch[j] == 57) {
                        ch[j] = 97;
                        break;
                    }
                    j--;
                }
                break;
            }
            if ((ch[i] >= 97 && ch[i] < 122) || (ch[i] >= 48 && ch[i] < 57)) {
                ch[i] = (char) (((int) ch[i]) + 1);
                break;
            } else if (i == 0) {
                ch[ch.length - 1] = 97;
            }
        }
        if(appendDate)
        	return appendDate(new String(ch));
        else 
        	return new String(ch);
    }

    private static boolean validateLength(String id , boolean appendDate) {
    	if (appendDate && id.length() == LONG_ID_LENGTH) 
            return true;
    	else if (id.length() == SHORT_ID_LENGTH) 
            return true;
        else
            return false;
    }

    private static String appendDate(String id) {
        DateFormat formatter = new SimpleDateFormat("ddMMyy");
        return formatter.format(new Date()) + id;
    }

    /*public static void main(String[] args) throws Exception {
        System.out.println(IdGenrator.genrateId("9999999999",false));
    }*/
}
