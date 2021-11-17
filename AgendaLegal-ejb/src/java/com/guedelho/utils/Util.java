/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guedelho.utils;

/**
 *
 * @author rodrigo
 */
public class Util {
    
    public static boolean isEmpit(String texto) {
        return texto == null || texto.isEmpty();
    }
    
    public static boolean isEmpitNumberLong(Long number) {
        return number == null || number == 0;
    }
}
