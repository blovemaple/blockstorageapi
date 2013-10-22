package blove.blockstorage.api;

/**
 * 块存储空间的事件。
 * 
 * @author blove
 */
public class BlockStorageEvent {
	/**
	 * 事件类型。
	 * 
	 * @author blove
	 */
	public static enum Type {
		APPEND, DELETE
	}

	private final Type type;
	private final String blockType;
	private final String blockId;

	/**
	 * 新建一个实例。
	 * 
	 * @param type
	 *            事件类型
	 * @param blockType
	 *            块类型
	 * @param blockId
	 *            块标识符
	 */
	public BlockStorageEvent(Type type, String blockType, String blockId) {
		this.type = type;
		this.blockType = blockType;
		this.blockId = blockId;
	}

	/**
	 * 返回事件类型。
	 * 
	 * @return
	 */
	public Type getType() {
		return type;
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
