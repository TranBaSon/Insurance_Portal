package com.gen.com.Insurance_portal.common;

import java.util.Random;

public class Helpper {

    public static int genCode() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }
}
