/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasmps.rough;

import java.util.HashMap;

/**
 *
 * @author akhtar
 */
public class Rough {
 
   static HashMap hm1;
    static void  me(String curDate,String preDate){
        HashMap hm2 = new HashMap();
        HashMap hm3 = new HashMap();
        hm2.put("1", hm3);
        System.out.println(hm1);
        hm1 = (HashMap)hm2.get("1");
        System.err.println(hm1);
        
    }
    
    
    public static void main(String djhg[])
    {
        Rough.me("2016:05:17", "2017:05:17");
        
       
    }
    
    
    
}
