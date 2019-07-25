package org.aion;

import avm.Address;
import avm.Blockchain;
import java.math.BigInteger;

public class AIPXXXEvents {

    /**
     * Log event for setting favorite bool
     * @param favoriteBool New favorite bool
     */
    protected static void aipXXXFavoriteBoolSet(boolean favoriteBool) {
//TODO: study if the best practice is to use simple event names like this or using fully qualified names like org.aion.   AIP010Events.AIP010Transferred
//TODO: can Java do something like __FUNCTION__ here and if so should we?
        Blockchain.log("aipXXXFavoriteBoolSet".getBytes(),
                favoriteBool ? new byte[] {0x01} : new byte[] {0x00},
                new byte[0]);
    }
}