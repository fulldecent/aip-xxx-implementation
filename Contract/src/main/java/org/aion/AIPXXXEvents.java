package org.aion;

import avm.Address;
import avm.Blockchain;
import java.math.BigInteger;

public class AIPXXXEvents {

    /**
     * Log event for setting favorite String
     * @param favoriteString New favorite String
     */
    protected static void aipXXXFavoriteStringSet(String favoriteString) {
//TODO: study if the best practice is to use simple event names like this or using fully qualified names like org.aion.   AIP010Events.AIP010Transferred
//TODO: can Java do something like __FUNCTION__ here and if so should we?
        Blockchain.log("AIPXXFavoriteStringSet".getBytes(),
                favoriteString.getBytes(),
                Blockchain.getCaller().toByteArray(),
                new byte[0]);
    }

}
