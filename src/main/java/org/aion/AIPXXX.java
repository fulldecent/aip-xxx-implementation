package org.aion;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.abi.ABIDecoder;

import java.math.BigInteger;

//TODO: move reference implementation to an INTERFACE and use it as a mixin!
//TODO: Which parts of JavaDoc should be sentences (have periods)?
//TODO: Aion specifies Google Java code style SOURCE https://github.com/aionnetwork/aion/wiki/Aion-Code-Conventions so we should validate
//TODO: we use byte[] and don't use bignumber, is that a problem?
//TODO: need to get 100% coverage and confirm that we have 100% in the travis test
//TODO: reformat this and all other files with Google Java convention

/**
 * Reference implementation for the AIP-010 Non-Fungible Token Standard
 * 
 * It is intended that this class can be inherited for every implementation or extension of AIP-010.
 * 
 * @author William Entriken
 */
public class AIPXXX {

//TODO: this is implementation-specific behavior and should be moved to a mock class that implements a base class and where only the base class is the reference implementation    
    /**
     * This is the deployment function and is responsible for taking parameters passed in using the Aion AVM and then standing up any contract initialization
     */
    static {
        ABIDecoder decoder = new ABIDecoder(Blockchain.getData());
        // FYI, Java specifies that argument lists are evaluated left-to-right https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.7.4
        deploy(
            decoder.decodeOneString(),
            decoder.decodeOneString(),
            decoder.decodeOneString()
        );
    }

//todo: it is expected that Aion toolchain will change and in the future a specific deploy function will be required in order to introspect deployment parameter types (for type safety) see https://github.com/aionnetwork/AVM/issues/401 and update the name of this function if necessary

    /**
     * This is called once during contract deployment
     * @param tokenName This will be returned from aip010Name
     * @param tokenSymbol This will be returned from aip010Symbol
     * @param tokenUriBase This will be used in aip010TokenUri
     */
    private static void deploy(boolean startingFavoriteBool) {
        byte[] key = AIPXXXKeyValueStorage.favoriteBoolKey();
        Blockchain.putStorage(key,
            startingFavoriteBool.toByteArray()
        );
    }

    /**
     * Get the favorite bool
     * @return The boolean
     */
    @Callable
    public static boolean aipXXXGetFavoriteBool() {
        byte[] key = AIPXXXKeyValueStorage.favoriteBoolKey();
        byte[] favoriteBool = Blockchain.getStorage(key);
        return favoriteBool != null
                ? true
                : false;
    }

    /**
     * Set the favorite bool
     * @param favoriteBool new favorite bool
     * @return The boolean
     */
    @Callable
    public static void aipXXXSetFavoriteBool(boolean favoriteBool) {
        byte[] key = AIPXXXKeyValueStorage.favoriteBoolKey();
        Blockchain.putStorage(key,
            favoriteBool.toByteArray()
        );
        AIPXXXEvents.aipXXXFavoriteBoolSet(favoriteBool);
    }

}