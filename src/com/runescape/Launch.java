package com.runescape;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.runescape.applet.Client;

public final class Launch {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("RS2Logger");
        logger
            .info("RS2 user client - " + Constants.CLIENT_NAME + " - release #317");

        try {
            Client.startup();
        } catch (Exception e) {
            logger.log(Level.SEVERE,
                "Error while starting " + Constants.CLIENT_NAME, e);
            System.exit(0);
        }
    }

    private Launch() {}
}
