package com.runescape;

import java.math.BigInteger;

public final class Constants {

    public static final String CLIENT_NAME = "Asteria 2.0";
    public static final String CONNECT_HOST = "127.0.0.1";
    public static final int CONNECT_PORT = 43594;
    public static final BigInteger RSA_MODULUS = new BigInteger(
        "94306533927366675756465748344550949689550982334568289470527341681445613288505954291473168510012417401156971344988779343797488043615702971738296505168869556915772193568338164756326915583511871429998053169912492097791139829802309908513249248934714848531624001166946082342750924060600795950241816621880914628143");
    public static final BigInteger RSA_EXPONENT = new BigInteger("65537");
    public static final boolean DECODE_RSA = true;
    public static final int NPC_BITS = 14;
    
    
    private Constants() {}
}
