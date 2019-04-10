package org.obsrj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "OBSR";
    public static final String coinTicker = "OBSR";
    public static final String coinURIScheme = "obsr"; // guiutil.cpp
    public static final String cryptsyMarketId = "155";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/obsr/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.dash.org/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://test.explorer.dash.org/";

    public static final String DONATION_ADDRESS = "Xdeh9YTLNtci5zSL4DDayRSVTLf299n9jv";  //Hash Engineering donation DASH address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(1 * 60);  //chainparams.cpp 60 seconds per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(1 * 60);  // 60 seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static int testNetSpendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY

    public static final long MAX_COINS = 11250000000L; //chainparams.cpp:  nMaxMoneyOut  Max. Money is calculated by 2x premine value


    public static final long DEFAULT_MIN_TX_FEE = 10000;   // wallet.cpp CFeeRate CWallet::minTxFee = CFeeRate(10000);
    public static final long DUST_LIMIT = 5460; //transaction.h IsDust 5460
    public static final long INSTANTX_FEE = 10000; //0.001 DASH (updated for 12.1)
    public static final boolean feeCanBeRaised = false;

    //
    // obsr 3.1.0.2
    //
    public static final int PROTOCOL_VERSION = 70917;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70916;        //version.h MIN_PEER_PROTO_VERSION_BEFORE_ENFORCEMENT

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000; //block.h MAX_BLOCK_SIZE_LEGACY


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 9567;       //chainparams.cpp CMainParams nDefaultPort
    public static final int TestPort = 29567;     //chainparams.cpp CTestNetParams nDefaultPort

    /** Zerocoin starting block height */
    public static final long TESTNET_ZEROCOIN_STARTING_BLOCK_HEIGHT = 1;//chainparams.cpp  nZerocoinStartHeight  -  our blocks are in version 4 since block 1
    public static final long MAINNET_ZEROCOIN_STARTING_BLOCK_HEIGHT = 1;

    public static final int BIP_44_COIN_TYPE = 7299699;  //776772 https://github.com/satoshilabs/slips/blob/master/slip-0044.md

    //
    //  Production
    //
    public static final int AddressHeader = 115;             // chainparams.cpp PUBKEY_ADDRESS  addresses start with 'W'
    public static final int p2shHeader = 19;             //chainparams.cpp SCRIPT_ADDRESS   script addresses start with '7'
    public static final int privateKeyHeader = 222;     //chainparams.cpp SECRET_KEY
    public static final long PacketMagic = 0xb4a682e9;//chainparams.cpp pchMessageStart

    public static final String genesisTimeString = "Senate Gets F.B.I. Inquiry on Kavanaugh; White House Is ‘Confident’ on Confirmation";
    //Genesis Block Information from chainparams.cpp
    static public long genesisBlockDifficultyTarget = 0x1e0ffff0;          // chainparams.cpp genesis.nBits
    static public long genesisBlockTime = 1538661890L;                       //chainparams.cpp  genesis.nTime
    static public long genesisBlockNonce = 33235910;                         //chainparams.cpp   genesis.nNonce
    static public String genesisHash = "0000070f9c4520b097379c2f6be965a4e3727acf250be9ae420ec6d10d0a02b5";  // chainparams.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "0e36366ad7a4ce0f1979569a95ccd0ca085612d0d48f3aa9daa6262177d3163d"; // chainparams.cpp hashMerkleRoot
    static public int genesisBlockValue = 0;                                                              // chainparams.cpp: txNew.vout[0].nValue
    //chainparams.cpp scriptPubKey
    public static final String genesisTxPubKey = "04079ebf2ae7a2041f67acbaec5b31c72f09fa6b5a4c04a012cf3344ee0475aa43625d6e161d50de26a38ec227cb559eeaf4dbc8138e1c3ea536ddf1607d4d8c7c";

    //chainparams.cpp vSeeds
    static public String[] dnsSeeds = new String[] {
            "main1.seeder.obsr.org",
            "main2.seeder.obsr.org"
    };

    public static int minBroadcastConnections = 3;   //0 for default; we need more peers.

    //
    // TestNet - DASH
    //
    public static final boolean supportsTestNet = true;
    public static final int testnetAddressHeader = 129;             //chainparams.cpp
    public static final int testnetp2shHeader = 19;             //chainparams.cpp
    public static final int testnetPrivateKeyHeader = 239;             //chainparams.cpp
    public static final long testnetPacketMagic = 0x245cfc14;      //

    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0);          // chainparams.cpp genesis.nBits
    static public long testnetGenesisBlockTime = 1538661890;                         //chainparams.cpp  genesis.nTime
    static public long testnetGenesisBlockNonce = (43138716);                         //chainparams.cpp   genesis.nNonce
    public static final String testnetGenesisHash =  "000008c2f02402a0d4df651c0119941e45c9dcae64ec07215088048c3f450db9";





    //useless for spv
    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int height)
    {
        return Coin.valueOf(0);
    }

    public static int subsidyDecreaseBlockCount = 4730400;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //chainparams.cpp bnProofOfWorkLimit  starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "testnet1.seeder.obsr.org",
            "testnet2.seeder.obsr.org",
    };
    //from chainparams.cpp: CAlert::vAlertPubKey
    public static final String SATOSHI_KEY = "044bb16beb766d57f1895700bcf10adc5ae8827dee29b0aa358409a2893a22f5ddbb5f7b2274aef456e4f4afebb5302980ca17054f0adf6843fe5d21d6e39019f7";
    public static final String TESTNET_SATOSHI_KEY = "04d220a8d9b9da1564293ff0f827ee33fa3320b2b20a5169e5d8a1b6171b843e5b00268b7c3700e8b9ce2092091e12ee9507b4de7fc4e297c9053dd344a477d8a3";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "com.obsr.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "com.obsr.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.obsr.unittest";
    public static final String ID_REGTEST = "com.obsr.regtest";

    //chainparams.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put(     0, Sha256Hash.wrap("0000070f9c4520b097379c2f6be965a4e3727acf250be9ae420ec6d10d0a02b5"));
        checkpoints.put(   1492, Sha256Hash.wrap("8da46d9871055be809995d090ad673d749f24fa521dbe1bb02eaf775ed498a06"));
  }

    public static void initTestnetCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put(    0, Sha256Hash.wrap("0x0000070f9c4520b097379c2f6be965a4e3727acf250be9ae420ec6d10d0a02b5"));
     }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "XgxQxd6B8iYgEEryemnJrpvoWZ3149MCkK";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XDtvHyDHk4S3WJvwjxSANCpZiLLkKzoDnjrcRhca2iLQRtGEz1JZ";

}
