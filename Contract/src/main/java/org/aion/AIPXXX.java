package org.aion;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.tooling.abi.Initializable;
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

    @Initializable
    private static String startingFavoriteString;

    private static Address owner;
    private static Address newOwner = null;

//TODO: this is implementation-specific behavior and should be moved to a mock class that implements a base class and where only the base class is the reference implementation    
    /**
     * This is the deployment function and is responsible for taking parameters passed in using the Aion AVM and then standing up any contract initialization
     */
    static {
        AIPXXXSetter.aipXXXSetFavoriteString(startingFavoriteString);
        owner = Blockchain.getCaller();
    }

//todo: it is expected that Aion toolchain will change and in the future a specific deploy function will be required in order to introspect deployment parameter types (for type safety) see https://github.com/aionnetwork/AVM/issues/401 and update the name of this function if necessary

    /**
     * Get the favorite String
     * @return The Stringe
     */
    @Callable
    public static String aipXXXGetFavoriteString() {
        return AIPXXXSetter.aipXXXGetFavoriteString();
    }

    /**
     * Set the favorite String
     * @param favoriteString new favorite String
     * @return The Stringean
     */
    @Callable
    public static void aipXXXSetFavoriteString(String favoriteString) {
        AIPXXXSetter.aipXXXSetFavoriteString(favoriteString);
    }

    @Callable
    public static Address aipXXXGetOwner() {
        return owner;
    }

    @Callable
    public static void aipXXXSetOwner(Address newOwnerAddress) {
        onlyOwner();
        newOwner = newOwnerAddress;
    }

    @Callable
    public static void aipXXXAcceptOwnership() {
        onlyNewOwner();
        owner = newOwner;
        newOwner = null;
    }

    private static void onlyOwner() {
        Blockchain.require(Blockchain.getCaller().equals(owner));
    }

    private static void onlyNewOwner() {
        Blockchain.require(Blockchain.getCaller().equals(newOwner));
    }
}