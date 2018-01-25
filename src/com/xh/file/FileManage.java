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
	 * �����ļ�
	 * 
	 * @param file_name
	 *            ��Ҫ���ݵ��ļ�
	 * @param backup_file_path
	 *            �����ļ����ڵ��ļ���
	 * @param backup_file_name
	 *            �����ļ����ļ���
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
	 * �������� ��ǰ�����ݱ����
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
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
	 * �������� ��ǰ�����ݱ����
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @param charsetName
	 *            ���ֱ���
	 * @throws Exception
	 */
	public static void save(String file_path, String file_name, String content,
			String charsetName) throws Exception {
		save(file_path, file_name, content.getBytes(charsetName));
	}

	/**
	 * ׷������
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
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
	 * ׷������
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @param charsetName
	 *            ���ֱ���
	 * @throws Exception
	 */
	public static void add_save(String file_path, String file_name,
			String content, String charsetName) throws Exception {
		add_save(file_path, file_name, content.getBytes(charsetName));
	}

	/**
	 * ��������
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @param stat_index
	 *            ���뿪ʼλ��
	 * @param len
	 *            ���볤��
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
	 * ��������
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @param charsetName
	 *            ���ֱ���
	 * @param stat_index
	 *            ���뿪ʼλ��
	 * @param len
	 *            ���볤��
	 * @throws Exception
	 */
	public static void insert_save(String file_path, String file_name,
			String content, String charsetName, int stat_index, int len)
			throws Exception {
		insert_save(file_path, file_name, content.getBytes(charsetName),
				stat_index, len);
	}

	/**
	 * ��������
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @param stat_index
	 *            ���뿪ʼλ��
	 * @param len
	 *            ���³���
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
	 * ��������
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @param charsetName
	 *            ���ֱ���
	 * @param stat_index
	 *            ���뿪ʼλ��
	 * @param len
	 *            ���³���
	 * @throws Exception
	 */
	public static void update_save(String file_path, String file_name,
			String content, String charsetName, int stat_index, int len)
			throws Exception {
		update_save(file_path, file_name, content.getBytes(charsetName),
				stat_index, len);
	}

	/**
	 * ɾ���ļ�
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
	 * ���Ҷ�Ӧ��׺���ļ�
	 * 
	 * @param file_path
	 *            �ļ����ڵ�·��
	 * @param end_with
	 *            �ļ��ĺ�׺
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
	 * ���ļ�ת��Ϊ������
	 * 
	 * @param file
	 *            �ļ�·��������·����
	 * @return
	 * @throws Exception
	 */
	public static InputStream file2InputStream(String file) throws Exception {
		 if(!isFile(file))
			throw new RuntimeException("file is directory or not exists or null or empty");
		return new FileInputStream(file);
	}
	/**
	 * �Ƿ�Ϊ�ļ�
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
	 * �Ƿ�Ϊ�ļ�
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
