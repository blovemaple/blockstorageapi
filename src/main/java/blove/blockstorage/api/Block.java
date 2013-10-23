package blove.blockstorage.api;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Date;

/**
 * 块。
 * 
 * @author blove
 */
public interface Block {
	/**
	 * 返回块类型。
	 * 
	 * @return
	 * @throws IOException
	 *             出现I/O异常
	 */
	public String getType() throws IOException;

	/**
	 * 返回块标识符。
	 * 
	 * @return
	 * @throws IOException
	 *             出现I/O异常
	 */
	public String getId() throws IOException;

	/**
	 * 返回此块添加的事件。
	 * 
	 * @return
	 * @throws IOException
	 *             出现I/O异常
	 */
	public Date getAppendTime() throws IOException;

	/**
	 * 读取块数据。
	 * 
	 * @param position
	 *            开始读取的位置
	 * @param buf
	 *            读入的缓存
	 * @return 读入的字节数
	 * @throws IOException
	 *             出现I/O异常
	 */
	public int readData(long position, ByteBuffer buf) throws IOException;

	/**
	 * 删除此块。
	 * 
	 * @throws ReadOnlyStorageException
	 *             如果存储空间是只读的
	 * @throws IOException
	 *             出现I/O异常
	 */
	public void delete() throws IOException;

}
