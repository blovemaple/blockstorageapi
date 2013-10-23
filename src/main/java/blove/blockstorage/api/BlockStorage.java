package blove.blockstorage.api;

import java.io.IOException;
import java.util.Set;

/**
 * 块的存储空间。每个块有一个类型和一个标识符。同一个存储空间中不能存在类型和标识符都相同的两个块。
 * 
 * @author blove
 */
public interface BlockStorage {

	/**
	 * 获取块。如果有多封符合条件的块，则取发送时间最晚的一个。
	 * 
	 * @param type
	 *            类型
	 * @param id
	 *            标识符
	 * @return 块。如果没有则返回null。
	 * @throws IOException
	 *             出现I/O异常
	 */
	public Block fetchBlock(String type, String id) throws IOException;

	/**
	 * 获取一种类型的所有块。
	 * 
	 * @param type
	 *            类型
	 * @return 块集合。如果没有则返回空集合。
	 * @throws IOException
	 *             出现I/O异常
	 */
	public Set<Block> fetchBlocks(String type) throws IOException;

	/**
	 * 添加一个块。
	 * 
	 * @param type
	 *            类型
	 * @param id
	 *            标识符
	 * @param data
	 *            数据
	 * @param replaceAllowed
	 *            是否允许覆盖已有块
	 * @throws ReadOnlyStorageException
	 *             如果存储空间是只读的
	 * @throws BlockAlreadyExistException
	 *             如果块已存在，且replaceAllowed参数为false。
	 * @throws IOException
	 *             出现I/O异常
	 */
	public void appendBlock(String type, String id, byte[] data,
			boolean replaceAllowed) throws IOException;

	/**
	 * 随机产生一个新的块标识符。
	 * 
	 * @return 新标识符
	 * @throws IOException
	 *             出现I/O异常
	 */
	public String randomId() throws IOException;

	/**
	 * 关闭此存储空间。关闭后任何访问方法将抛出ClosedBlockStorageException。
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException;

	/**
	 * 判断此store是否已关闭。
	 * 
	 * @return 如果已关闭，返回true；否则返回false。
	 */
	public boolean isOpen();

	/**
	 * 添加一个事件监听器。
	 * 
	 * @param listener
	 *            监听器
	 */
	public void addListener(BlockStorageListener listener);

	/**
	 * 移除一个事件监听器。
	 * 
	 * @param listener
	 *            监听器
	 */
	public void removeListener(BlockStorageListener listener);

	/**
	 * 返回此存储空间的名称。
	 * 
	 * @return 名称
	 */
	public String name();

	/**
	 * 返回此存储空间是否是只读的。
	 * 
	 * @return 如果是只读的，返回true；如果是可读可写，返回false。
	 */
	public boolean isReadOnly();

	/**
	 * 返回此存储空间的总容量。
	 * 
	 * @return 容量。单位：字节。
	 * @throws IOException
	 *             出现I/O异常
	 */
	public long getTotalSpace() throws IOException;

	/**
	 * 返回此存储空间的剩余可用容量。此容量可能大于未分配容量。
	 * 
	 * @return 可用容量。单位：字节。
	 * @throws IOException
	 *             出现I/O异常
	 */
	public long getUsableSpace() throws IOException;

	/**
	 * 返回此存储空间的未分配容量。
	 * 
	 * @return 可用容量。单位：字节。
	 * @throws IOException
	 *             出现I/O异常
	 */
	public long getUnallocatedSpace() throws IOException;

}
