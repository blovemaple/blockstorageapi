package blove.blockstorage.api;

import java.io.IOException;

/**
 * 块已经存在，因此不能进行某项操作时，抛出此异常。
 * 
 * @author blove
 */
public class BlockAlreadyExistException extends IOException {
	private static final long serialVersionUID = -2785163688472660217L;
	
	private final BlockStorage storage;
	private final String blockType;
	private final String blockId;

	/**
	 * 新建一个实例。
	 * 
	 * @param store
	 *            存储空间
	 * @param blockType
	 *            块类型
	 * @param blockId
	 *            块标识符
	 */
	public BlockAlreadyExistException(BlockStorage store, String blockType,
			String blockId) {
		this.storage = store;
		this.blockType = blockType;
		this.blockId = blockId;
	}

	/**
	 * 返回存储空间。
	 * 
	 * @return
	 */
	public BlockStorage getStorage() {
		return storage;
	}

	/**
	 * 返回块类型。
	 * 
	 * @return
	 */
	public String getBlockType() {
		return blockType;
	}

	/**
	 * 返回块标识符。
	 * 
	 * @return
	 */
	public String getBlockId() {
		return blockId;
	}

}
