package blockchainlab.blockchain;

public final class HashedBlock extends HashableBlock {
    public final Hash hash;

    public HashedBlock(HashableBlock block) {
        super(block.coinbase, block.transactions, block.id, block.nonce, block.prevBlockHash);
        this.hash = block.hash();
    }
}
