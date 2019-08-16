package org.aion;

import avm.Address;

import org.aion.avm.core.util.LogSizeUtils;
import org.aion.avm.embed.AvmRule;
import org.aion.avm.userlib.abi.ABIStreamingEncoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AIPXXXTest {

    @Rule
    public AvmRule avmRule = new AvmRule(true);

    private Address owner = avmRule.getPreminedAccount();//Account deploys the token contract.
    private Address contractAddress;
    private BigInteger nAmp = BigInteger.valueOf(1_000_000_000_000_000_000L);


    @Before
    public void deployDapp() {
        ABIStreamingEncoder encoder = new ABIStreamingEncoder();
        byte[] data = encoder.encodeOneString("AIP baby project").toBytes();
        byte[] contractData = avmRule.getDappBytes(AIPXXX.class, data, 1, AIPXXXSetter.class, AIPXXXEvents.class, AIPXXXKeyValueStorage.class);

        AvmRule.ResultWrapper result = avmRule.deploy(owner, BigInteger.ZERO, contractData);
        contractAddress = result.getDappAddress();

        assertEquals(1, result.getTransactionResult().logs.size());
        assertArrayEquals(LogSizeUtils.truncatePadTopic("AIPXXFavoriteStringSet".getBytes()), result.getTransactionResult().logs.get(0).copyOfTopics().get(0));
        assertArrayEquals(LogSizeUtils.truncatePadTopic("AIP baby project".getBytes()), result.getTransactionResult().logs.get(0).copyOfTopics().get(1));
        assertArrayEquals(LogSizeUtils.truncatePadTopic(owner.toByteArray()), result.getTransactionResult().logs.get(0).copyOfTopics().get(2));
        assertArrayEquals(new byte[0], result.getTransactionResult().logs.get(0).copyOfData());

    }

    @Test
    public void testDeployment() {
        AvmRule.ResultWrapper result = avmRule.call(owner, contractAddress, BigInteger.ZERO, new ABIStreamingEncoder().encodeOneString("aipXXXGetFavoriteString").encodeOneAddress(owner).toBytes());
        Assert.assertTrue(result.getReceiptStatus().isSuccess());
        Assert.assertTrue(result.getDecodedReturnData().equals("AIP baby project"));
    }

    @Test
    public void testGetSetGet() {
        Address user = avmRule.getRandomAddress(BigInteger.TEN.multiply(nAmp));

        AvmRule.ResultWrapper result = avmRule.call(user, contractAddress, BigInteger.ZERO, new ABIStreamingEncoder().encodeOneString("aipXXXGetFavoriteString").encodeOneAddress(user).toBytes());
        Assert.assertTrue(result.getReceiptStatus().isSuccess());
        Assert.assertTrue(result.getDecodedReturnData() == null);

        result = avmRule.call(user, contractAddress, BigInteger.ZERO, new ABIStreamingEncoder().encodeOneString("aipXXXSetFavoriteString").encodeOneString("Baby Project!").toBytes());
        Assert.assertTrue(result.getReceiptStatus().isSuccess());
        assertEquals(1, result.getTransactionResult().logs.size());
        assertArrayEquals(LogSizeUtils.truncatePadTopic("AIPXXFavoriteStringSet".getBytes()), result.getTransactionResult().logs.get(0).copyOfTopics().get(0));
        assertArrayEquals(LogSizeUtils.truncatePadTopic("Baby Project!".getBytes()), result.getTransactionResult().logs.get(0).copyOfTopics().get(1));
        assertArrayEquals(LogSizeUtils.truncatePadTopic(user.toByteArray()), result.getTransactionResult().logs.get(0).copyOfTopics().get(2));
        assertArrayEquals(new byte[0], result.getTransactionResult().logs.get(0).copyOfData());

        result = avmRule.call(user, contractAddress, BigInteger.ZERO, new ABIStreamingEncoder().encodeOneString("aipXXXGetFavoriteString").encodeOneAddress(user).toBytes());
        Assert.assertTrue(result.getReceiptStatus().isSuccess());
        Assert.assertTrue(result.getDecodedReturnData().equals("Baby Project!"));

    }

}