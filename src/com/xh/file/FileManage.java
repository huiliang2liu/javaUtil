package com.xh.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.xh.util.StreamManage;

public class FileManage {
	private final static String TAG = FileManage.class.getName();
	/**
	 * 备份文件
	 * 
	 * @param file_name
	 *            需要备份的文件
	 * @param backup_file_path
	 *            备份文件所在的文件夹
	 * @param backup_file_name
	 *            备份文件的文件名
	 * @throws Exception
	 */
	public static void backup(String file_name, String backup_file_path,
			String backup_file_name) throws Exception {
		if (file_name == null || file_name.isEmpty())
			throw new RuntimeException("file name is null or empty");
		if (backup_file_path == null || backup_file_path.isEmpty())
			throw new RuntimeException("backup file path is null or empty");
		if (backup_file_name == null || backup_file_name.isEmpty())
			throw new RuntimeException("backup file name is null or empty");
		File file = new File(file_name);
		File backup_file_path_f = new File(backup_file_path);
		if (!backup_file_path_f.exists())
			synchronized (TAG) {
				if (!backup_file_path_f.exists())
					backup_file_path_f.mkdirs();
			}
		if (!file.exists())
			throw new RuntimeException("file is not exists");
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(backup_file_path + "/"
				+ backup_file_name);
		int len = -1;
		byte[] buff = new byte[1024];
		while ((len = fis.read(buff)) > 0) {
			fos.write(buff, 0, len);
		}
		fos.flush();
		fos.close();
		fis.close();
	}

	/**
	 * 保存数据 以前的数据被清空
	 * 
	 * @param file_path
	 *            保存数据所在的目录
	 * @param file_name
	 *            保存文件的文件名
	 * @param content
	 *            需要保存的内容
	 * @throws Exception
	 */
	public static void save(String file_path, String file_name, byte[] content)
			throws Exception {
		if (file_path == null || file_path.isEmpty())
			throw new RuntimeException("file path is null or empty");
		if (file_name == null || file_name.isEmpty())
			throw new RuntimeException("file name is null or empty");
		if (content == null || content.length == 0)
			throw new RuntimeException("content is null or content length=0");
		File file = new File(file_path);
		if (!file.exists())
			file.mkdirs();
		FileOutputStream fos = new FileOutputStream(file_path + "/" + file_name);
		fos.write(content);
		fos.flush();
		fos.close();
	}

	/**
	 * 
	 * 保存数据 以前的数据被清空
	 * 
	 * @param file_path
	 *            保存数据所在的目录
	 * @param file_name
	 *            保存文件的文件名
	 * @param content
	 *            需要保存的内容
	 * @param charsetName
	 *            文字编码
	 * @throws Exception
	 */
	public static void save(String file_path, String file_name, String content,
			String charsetName) throws Exception {
		save(file_path, file_name, content.getBytes(charsetName));
	}

	/**
	 * 追加数据
	 * 
	 * @param file_path
	 *            保存数据所在的目录
	 * @param file_name
	 *            保存文件的文件名
	 * @param content
	 *            需要保存的内容
	 * @throws Exception
	 */
	public static void add_save(String file_path, String file_name,
			byte[] content) throws Exception {
		if (file_path == null || file_path.isEmpty())
			throw new RuntimeException("file path is null or empty");
		if (file_name == null || file_name.isEmpty())
			throw new RuntimeException("file name is null or empty");
		if (content == null || content.length == 0)
			throw new RuntimeException("content is null or content length=0");
		File file = new File(file_path);
		if (!file.exists())
			file.mkdirs();
		FileOutputStream fos = new FileOutputStream(
				file_path + "/" + file_name, true);
		fos.write(content);
		fos.flush();
		fos.close();
	}

	/**
	 * 
	 * 追加数据
	 * 
	 * @param file_path
	 *            保存数据所在的目录
	 * @param file_name
	 *            保存文件的文件名
	 * @param content
	 *            需要保存的内容
	 * @param charsetName
	 *            文字编码
	 * @throws Exception
	 */
	public static void add_save(String file_path, String file_name,
			String content, String charsetName) throws Exception {
		add_save(file_path, file_name, content.getBytes(charsetName));
	}

	/**
	 * 插入数据
	 * 
	 * @param file_path
	 *            保存数据所在的目录
	 * @param file_name
	 *            保存文件的文件名
	 * @param content
	 *            需要保存的内容
	 * @param stat_index
	 *            插入开始位置
	 * @param len
	 *            插入长度
	 * @throws Exception
	 */
	public static void insert_save(String file_path, String file_name,
			byte[] content, int stat_index, int len) throws Exception {
		if (file_path == null || file_path.isEmpty())
			throw new RuntimeException("file path is null or empty");
		if (file_name == null || file_name.isEmpty())
			throw new RuntimeException("file name is null or empty");
		if (len <= 0)
			throw new RuntimeException("len<=0");
		if (content == null || content.length == 0)
			throw new RuntimeException("content is null or content length=0");
		File file = new File(file_path);
		if (!file.exists())
			file.mkdirs();
		File m_file = new File(file_path + "/" + file_name);
		RandomAccessFile raf = new RandomAccessFile(m_file, "rw");
		int content_len = content.length;
		if (len > content_len)
			len = content_len;
		byte b[] = new byte[len];
		System.arraycopy(content, 0, b, 0, len);
		long file_len = raf.length();
		if (m_file.exists()) {
			raf.seek(stat_index);
			if (file_len > stat_index) {
				byte[] buff = StreamManage
						.inputStream2byte(new FileInputStream(m_file));
				raf.write(b);
				raf.write(buff, stat_index - 1, buff.length);

			} else {
				raf.seek(stat_index);
				raf.write(b);
			}
		} else
			raf.write(b);
	}

	/**
	 * 插入数据
	 * 
	 * @param file_path
	 *            保存数据所在的目录
	 * @param file_name
	 *            保存文件的文件名
	 * @param content
	 *            需要保存的内容
	 * @param charsetName
	 *            文字编码
	 * @param stat_index
	 *            插入开始位置
	 * @param len
	 *            插入长度
	 * @throws Exception
	 */
	public static void insert_save(String file_path, String file_name,
			String content, String charsetName, int stat_index, int len)
			throws Exception {
		insert_save(file_path, file_name, content.getBytes(charsetName),
				stat_index, len);
	}

	/**
	 * 更新数据
	 * 
	 * @param file_path
	 *            保存数据所在的目录
	 * @param file_name
	 *            保存文件的文件名
	 * @param content
	 *            需要保存的内容
	 * @param stat_index
	 *            插入开始位置
	 * @param len
	 *            更新长度
	 * @throws Exception
	 */
	public static void update_save(String file_path, String file_name,
			byte[] content, int stat_index, int len) throws Exception {
		if (file_path == null || file_path.isEmpty())
			throw new RuntimeException("file path is null or empty");
		if (file_name == null || file_name.isEmpty())
			throw new RuntimeException("file name is null or empty");
		if (len <= 0)
			throw new RuntimeException("len<=0");
		if (content == null || content.length == 0)
			throw new RuntimeException("content is null or content length=0");
		File file = new File(file_path);
		if (!file.exists())
			file.mkdirs();
		File m_file = new File(file_path + "/" + file_name);
		RandomAccessFile raf = new RandomAccessFile(m_file, "rw");
		int content_len = content.length;
		if (len > content_len)
			len = content_len;
		byte b[] = new byte[len];
		System.arraycopy(content, 0, b, 0, len);
		raf.seek(stat_index);
		raf.write(b);
		raf.close();
	}

	/**
	 * 更新数据
	 * 
	 * @param file_path
	 *            保存数据所在的目录
	 * @param file_name
	 *            保存文件的文件名
	 * @param content
	 *            需要保存的内容
	 * @param charsetName
	 *            文字编码
	 * @param stat_index
	 *            插入开始位置
	 * @param len
	 *            更新长度
	 * @throws Exception
	 */
	public static void update_save(String file_path, String file_name,
			String content, String charsetName, int stat_index, int len)
			throws Exception {
		update_save(file_path, file_name, content.getBytes(charsetName),
				stat_index, len);
	}

	/**
	 * 删除文件
	 * 
	 * @param path
	 * @return
	 */
	public static boolean deleteAllFilesOfDir(File path) {
		System.out.println(path.getPath());
		if (!path.exists())
			return false;
		if (path.isFile()) {
			path.delete();
			return true;
		}
		File[] files = path.listFiles();
		for (int i = 0; i < files.length; i++) {
			deleteAllFilesOfDir(files[i]);
		}
		path.delete();
		return true;
	}

	/**
	 * 查找对应后缀的文件
	 * 
	 * @param file_path
	 *            文件所在的路径
	 * @param end_with
	 *            文件的后缀
	 * @return
	 */
	public static List<File> select_file(String file_path, String end_with) {
		if (file_path == null || file_path.isEmpty())
			throw new RuntimeException("file_path null or empty");
		if (end_with == null || end_with.isEmpty())
			throw new RuntimeException("file_path null or empty");
		File file = new File(file_path);
		if (!file.exists())
			return null;
		List<File> files = new ArrayList<File>();
		if (file.isDirectory()) {
        File[] f=file.listFiles();
        for (int i = 0; i < f.length; i++) {
        	files.addAll(select_file(f[i].getAbsolutePath(), end_with));
		}
		} else {
			if (file_path.endsWith(end_with))
				files.add(file);
		}
		return files;
	}
	/**
	 * 将文件转换为数据流
	 * 
	 * @param file
	 *            文件路径（绝对路径）
	 * @return
	 * @throws Exception
	 */
	public static InputStream file2InputStream(String file) throws Exception {
		 if(!isFile(file))
			throw new RuntimeException("file is directory or not exists or null or empty");
		return new FileInputStream(file);
	}
	/**
	 * 是否为文件
	 * 
	 * @param file
	 * @return
	 */
	public static boolean isFile(File file) {
		if (file == null || !file.exists() || file.isDirectory())
			return false;
		return true;
	}

	/**
	 * 是否为文件
	 * 
	 * @param file
	 * @return
	 */
	public static boolean isFile(String file) {
		if (file == null || file.isEmpty())
			return false;
		return isFile(new File(file));
	}
}
