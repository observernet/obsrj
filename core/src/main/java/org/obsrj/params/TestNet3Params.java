/*
 * Copyright 2013 Google Inc.
 * Copyright 2014 Andreas Schildbach
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.obsrj.params;

import org.obsrj.core.CoinDefinition;


import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the testnet, a separate public instance of Bitcoin that has relaxed rules suitable for development
 * and testing of applications and new Bitcoin versions.
 */
public class TestNet3Params extends AbstractBitcoinNetParams {
    public static final int TESTNET_MAJORITY_WINDOW = 100;
    public static final int TESTNET_MAJORITY_REJECT_BLOCK_OUTDATED = 75;
    public static final int TESTNET_MAJORITY_ENFORCE_BLOCK_UPGRADE = 51;

    public TestNet3Params() {
        super();
        id = ID_TESTNET;

        // Genesis hash is

        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        maxTarget = CoinDefinition.proofOfWorkLimit;//Utils.decodeCompactBits(0x1d00ffffL);
        dumpedPrivateKeyHeader = CoinDefinition.testnetPrivateKeyHeader;//128 + CoinDefinition.testnetAddressHeader;
        addressHeader = CoinDefinition.testnetAddressHeader;
        p2shHeader = CoinDefinition.testnetp2shHeader;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        port = CoinDefinition.TestPort;
        packetMagic = CoinDefinition.testnetPacketMagic;
        bip32HeaderPub =  0x3a8061a0; //0x043587cf;
        bip32HeaderPriv = 0x3a805837;  //0x04358394 ;
        genesisBlock.setDifficultyTarget(CoinDefinition.testnetGenesisBlockDifficultyTarget);
        genesisBlock.setTime(CoinDefinition.testnetGenesisBlockTime);
        genesisBlock.setNonce(CoinDefinition.testnetGenesisBlockNonce);
        spendableCoinbaseDepth = CoinDefinition.testNetSpendableCoinbaseDepth;
        subsidyDecreaseBlockCount = CoinDefinition.subsidyDecreaseBlockCount;
        String genesisHash = genesisBlock.getHashAsString();
        System.out.println("testnet genesis tx hash: "+genesisHash);

        if(CoinDefinition.supportsTestNet)
            checkState(genesisHash.equals(CoinDefinition.testnetGenesisHash));
        id = ID_TESTNET;

        zerocoinStartedHeight = CoinDefinition.TESTNET_ZEROCOIN_STARTING_BLOCK_HEIGHT;

        dnsSeeds = CoinDefinition.testnetDnsSeeds;

        addrSeeds = null;


        strSporkKey = CoinDefinition.TESTNET_SATOSHI_KEY;

     //   bip32HeaderPub = 0x043587CF;
     //   bip32HeaderPriv = 0x04358394;

        majorityEnforceBlockUpgrade = TESTNET_MAJORITY_ENFORCE_BLOCK_UPGRADE;
        majorityRejectBlockOutdated = TESTNET_MAJORITY_REJECT_BLOCK_OUTDATED;
        majorityWindow = TESTNET_MAJORITY_WINDOW;

    }

    private static TestNet3Params instance;
    public static synchronized TestNet3Params get() {
        if (instance == null) {
            instance = new TestNet3Params();
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_TESTNET;
    }

}
