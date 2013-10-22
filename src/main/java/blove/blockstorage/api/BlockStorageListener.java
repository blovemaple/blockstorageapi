package blove.blockstorage.api;

/**
 * 块存储空间的事件监听器。
 * 
 * @author blove
 */
public interface BlockStorageListener {
	/**
	 * 有块添加时调用此方法。
	 * 
	 * @param event
	 *            事件
	 */
	public void blockAppended(BlockStorageEvent event);

	/**
	 * 有块删除时调用此方法。
	 * 
	 * @param event
	 *            事件
	 */
	public void blockDeleted(BlockStorageEvent event);
}
