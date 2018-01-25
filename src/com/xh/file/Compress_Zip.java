package com.xh.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 
 * ѹ�� ��ѹ�ļ�zip ��ʽ
 */
public class Compress_Zip {
	/**
	 * ѹ���ļ�
	 * 
	 * @param file_name
	 *            ��Ҫѹ�����ļ�
	 * @param zip_file_path
	 *            ѹ�����ļ�����·��
	 * @param zip_file_name
	 *            ѹ�����ļ�������
	 * @throws Exception
	 */
	public static void compress(String file_name, String zip_file_path,
			String zip_file_name) throws Exception {
		if (file_name == null)
			throw new RuntimeException("compress file is null");
		if (file_name.isEmpty())
			throw new RuntimeException("compress file is empty");
		File file = new File(file_name);
		if (!file.exists())
			throw new RuntimeException("compress file is not exists");
		if (zip_file_path == null)
			throw new RuntimeException("zip file path is null");
		if (zip_file_path.isEmpty())
			throw new RuntimeException("zip file path is empty");
		if (zip_file_name == null)
			throw new RuntimeException("zip file name is null");
		if (zip_file_name.isEmpty())
			throw new RuntimeException("zip file name is empty");
		boolean is_zip = file_name.endsWith(".zip");
		File zip_file_path_f = new File(zip_file_path);
		if (!zip_file_path_f.exists())
			zip_file_path_f.mkdirs();
		if (is_zip)
			FileManage.backup(file_name, zip_file_path, zip_file_name);
		else {
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(
					zip_file_path + "/" + zip_file_name));
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				compressByType(files[i], zos, "");
			}
		}
	}

	/**
	 * �ж���Ŀ¼�����ļ����������ͣ��ļ�/�ļ��У�ִ�в�ͬ��ѹ������
	 * 
	 * @param file
	 * @param out
	 * @param basedir
	 */
	private static void compressByType(File file, ZipOutputStream out,
			String basedir) {
		/* �ж���Ŀ¼�����ļ� */
		if (file.isDirectory())
			compressDirectory(file, out, basedir);
		else
			compressFile(file, out, basedir);
	}

	/**
	 * ѹ��һ��Ŀ¼
	 * 
	 * @param dir
	 * @param out
	 * @param basedir
	 */
	private static void compressDirectory(File dir, ZipOutputStream out,
			String basedir) {
		if (!dir.exists()) {
			return;
		}

		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			/* �ݹ� */
			compressByType(files[i], out, basedir + dir.getName() + "/");
		}
	}

	/**
	 * ѹ��һ���ļ�
	 * 
	 * @param file
	 * @param out
	 * @param basedir
	 */
	private static void compressFile(File file, ZipOutputStream out,
			String basedir) {
		if (!file.exists()) {
			return;
		}
		try {
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(file));
			ZipEntry entry = new ZipEntry(basedir + file.getName());
			out.putNextEntry(entry);
			int count;
			byte data[] = new byte[1024];
			while ((count = bis.read(data, 0, 1024)) != -1) {
				out.write(data, 0, count);
			}
			bis.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * ��ѹ�ļ�
	 * 
	 * @param file_name
	 *            �ļ���
	 * @param zip_file_path
	 *            �����ļ�Ŀ¼
	 * @param zip_file_name
	 *            �����ļ�
	 */
	public static void unpack(String zip_file, String file_path)
			throws Exception {
		if (file_path == null)
			throw new RuntimeException("zip file path is null");
		if (file_path.isEmpty())
			throw new RuntimeException("zip file path is empty");
		if (zip_file == null)
			throw new RuntimeException("zip file name is null");
		if (zip_file.isEmpty())
			throw new RuntimeException("zip file name is empty");
		// if (!zip_file.endsWith(".zip"))
		// throw new RuntimeException("zip file is not zip file");
		File file_z = new File(zip_file);
		if (!file_z.exists())
			throw new RuntimeException("zip file is not exists");
		File file_p = new File(file_path);
		if (!file_p.exists())
			file_p.mkdirs();
		ZipInputStream zis = new ZipInputStream(new FileInputStream(zip_file));
		ZipEntry ze = null;
		while ((ze = zis.getNextEntry()) != null) {
			if (!ze.isDirectory()) {
				File file = new File(file_path + "/" + ze.getName());
				File file_parent = new File(file.getParent());
				if (!file_parent.exists()) {
					file_parent.mkdirs();
				}
				FileOutputStream fos = new FileOutputStream(file);
				int len = -1;
				byte buf[] = new byte[1024];
				while ((len = zis.read(buf)) > 0) {
					fos.write(buf, 0, len);
				}
				fos.flush();
				fos.close();
				zis.closeEntry();
			}
			System.out.println(ze.getName() + "��ѹ�ɹ�");
		}
		System.out.println("������");
		zis.close();
	}

	/**
	 * �鿴zip�ļ���Ŀ¼
	 * 
	 * @param zip_file
	 * @throws Exception
	 */
	public static List<String> view(String zip_file) throws Exception {
		if (zip_file == null)
			throw new RuntimeException("zip file name is null");
		if (zip_file.isEmpty())
			throw new RuntimeException("zip file name is empty");
		File file_z = new File(zip_file);
		if (!file_z.exists())
			throw new RuntimeException("zip file is not exists");
		List<String> list = new ArrayList<String>();
		ZipInputStream zis = new ZipInputStream(new FileInputStream(zip_file));
		ZipEntry ze = null;
		while ((ze = zis.getNextEntry()) != null) {
			if (!ze.isDirectory()) {
				list.add(ze.getName());
			}
		}
		return list;
	}

	/**
	 * ����Ŀ¼
	 * 
	 * @param zip_file
	 * @param file_path
	 * @param file_name
	 * @param entry_name
	 * @throws Exception
	 */
	public static void add_zip_entry(String zip_file, String file_path,
			String file_name, String entry_name) throws Exception {
		if (zip_file == null)
			throw new RuntimeException("zip file name is null");
		if (zip_file.isEmpty())
			throw new RuntimeException("zip file name is empty");
		if (file_path == null)
			throw new RuntimeException("zip file name is null");
		if (file_path.isEmpty())
			throw new RuntimeException("zip file name is empty");
		if (file_name == null)
			throw new RuntimeException("zip file name is null");
		if (file_name.isEmpty())
			throw new RuntimeException("zip file name is empty");
		if (entry_name == null)
			throw new RuntimeException("zip file name is null");
		if (entry_name.isEmpty())
			throw new RuntimeException("zip file name is empty");
		File file_z = new File(zip_file);
		if (!file_z.exists())
			throw new RuntimeException("zip file is not exists");
		ZipEntry ze = new ZipEntry(entry_name);
		ze.setSize(0);
		ze.setCompressedSize(0);
		ze.setExtra(null);
		File file = new File(file_path);
		if (!file.exists())
			file.mkdirs();
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(
				file_path + "/" + file_name));
		zos.putNextEntry(ze);
		FileInputStream fis=new FileInputStream("G:/dex2jar/dex2jar.2.0/tool-jar2dex.dex");
		byte[] buff=new byte[1024*1024];
		int len1=-1;
		while ((len1=fis.read(buff))>0) {
			zos.write(buff, 0, len1);
		}
		zos.closeEntry();
		ZipInputStream zis = new ZipInputStream(new FileInputStream(zip_file));
		while ((ze = zis.getNextEntry()) != null) {
			if (!ze.isDirectory()) {
				zos.putNextEntry(ze);
				int len = -1;
				byte[] b = new byte[1024];
				while ((len = zis.read(b)) > 0) {
					zos.write(b, 0, len);
				}
				zos.closeEntry();
				zis.closeEntry();
			}
		}
		zos.flush();
		zos.close();
		zis.close();
	}
}
