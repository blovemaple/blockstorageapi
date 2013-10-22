package blove.blockstorage.api;

/**
 * 块存储空间已关闭的状态下尝试对块进行操作时抛出此异常。
 * 
 * @author blove
 */
public class ClosedBlockStorageException extends IllegalStateException {
	private static final long serialVersionUID = -2947953572809560810L;
	
	private final BlockStorage storage;

	/**
	 * 新建一个实例。
	 * 
	 * @param storage
	 *            存储空间
	 */
	public ClosedBlockStorageException(BlockStorage storage) {
		this.storage = storage;
	}

	/**
	 * 返回存储空间。
	 * 
	 * @return
	 */
	public BlockStorage getStorage() {
		return storage;
	}

}
