package com.digitalcode.smartmunue.global;

import com.digitalcode.smartmunue.model.Product;

import java.util.ArrayList;
import java.util.List;

//All classes under the package global will be accessible by All other classes that's why it's named : "global"
public class GlobalData {
    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }
}
