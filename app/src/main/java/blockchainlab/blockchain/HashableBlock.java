package blockchainlab.blockchain;

import java.nio.charset.StandardCharsets;
import com.google.common.hash.Hashing;

public class HashableBlock extends Block {
    public final int nonce;

    public HashableBlock(Block block, int nonce) {
        super(block.coinbase, block.data, block.id, block.prevBlockHash);
        this.nonce = nonce;
    }

    public HashableBlock(Coinbase coinbase, String data, int id, int nonce, Hash prevBlockHash) {
        super(coinbase, data, id, prevBlockHash);
        this.nonce = nonce;
    }

    @Override
    public final String toString() {
        // TODO: auto get all object data with reflection
        return "[#]" + this.id + "[?]" + this.nonce + "[@]" + this.coinbase.toString() + "[@@]" + this.data + "[#<-#]"
                + this.prevBlockHash;
    }

    public final Hash hash() {
        return new Hash(Hashing.sha256()
                .hashString(this.toString(), StandardCharsets.UTF_8)
                .toString());
    }
}
