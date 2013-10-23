package blove.blockstorage.api;

/**
 * 当对只读的存储空间进行写操作时抛出此异常。
 * 
 * @author blove
 */
public class ReadOnlyStorageException extends UnsupportedOperationException {
	private static final long serialVersionUID = 7666154250285883344L;

	private final BlockStorage storage;

	/**
	 * 新建一个实例。
	 * 
	 * @param storage
	 *            存储空间
	 */
	public ReadOnlyStorageException(BlockStorage storage) {
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
