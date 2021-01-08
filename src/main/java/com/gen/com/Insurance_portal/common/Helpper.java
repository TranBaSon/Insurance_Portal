package com.gen.com.Insurance_portal.common;

import java.util.Random;

public class Helpper {

    public static int genCode() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }

    public static String genContractCode(String prefix) {
        Random r = new Random();
        long numbers = r.nextInt(1_000_000_000)
                + (r.nextInt(90) + 10) * 1_000_000_000L;
        return prefix + numbers;
    }
}
