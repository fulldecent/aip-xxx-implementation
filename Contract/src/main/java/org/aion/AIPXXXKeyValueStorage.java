package org.aion;

import avm.Blockchain;
import avm.Address;
import org.aion.avm.userlib.AionBuffer;

//TODO: this file should not be named AIPXXX... because this is the implementation. The implementation should have a different name like nftoken see https://github.com/0xcert/ethereum-erc721/tree/master/src/contracts/tokens

//TODO: THROUGHOUT THIS FILE this is incesure, the StorageSlots.OWNER_BALANCE_MAP.ordinal() may conflict with the same number in a parent class. Instead, we need to use the fully qualified name inside this key. E.g. org.aion.AIP010....StorageSlots.OWNER_BALANCE_MAP

//TODO: note, some ENUMS and methods represent optional methods that are not required to be in the implementation. Let's confirm if Java is smart enough to remove the methods from the runtime if an implementation is not using them. Otherwise we may want to separate the code for performance reasons

public class AIPXXXKeyValueStorage {
    /**
     * Best practice with Aion is to explictly define all storage locations using an enum and then use these enums for all calls to putStorage. This avoids overlapping storage, which is also a vulnerability. Also, use static storage only for recursive call state and configuration options which apply to all onchain transactions. 
     */
    protected enum StorageSlots {
        FAVORITE_STRING
    }

    public static byte[] favoriteStringKey(Address user) {
        return Blockchain.blake2b(AionBuffer.allocate(Integer.BYTES + Address.LENGTH)
                .putInt(StorageSlots.FAVORITE_STRING.hashCode())
                .putAddress(user)
                .getArray());
    }
}
