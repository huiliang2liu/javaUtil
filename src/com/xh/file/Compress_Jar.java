package com.xh.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

public class Compress_Jar {
	/**
	 * 解压文件
	 * 
	 * @param file_name
	 *            文件名
	 * @param zip_file_path
	 *            保存文件目录
	 * @param zip_file_name
	 *            保存文件
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
		File file_z = new File(zip_file);
		if (!file_z.exists())
			throw new RuntimeException("zip file is not exists");
		File file_p = new File(file_path);
		if (!file_p.exists())
			file_p.mkdirs();
		JarInputStream jis = new JarInputStream(new FileInputStream(zip_file));
		ZipEntry ze = null;
		while ((ze = jis.getNextEntry()) != null) {
			if (!ze.isDirectory()) {
				File file = new File(file_path + "/" + ze.getName());
				File file_parent = new File(file.getParent());
				if (!file_parent.exists()) {
					file_parent.mkdirs();
				}
				FileOutputStream fos = new FileOutputStream(file);
				int len = -1;
				byte buf[] = new byte[1024];
				while ((len = jis.read(buf)) > 0) {
					fos.write(buf, 0, len);
				}
				fos.flush();
				fos.close();
				jis.closeEntry();
			}
			System.out.println(ze.getName() + "解压成功");
		}
		System.out.println("结束了");
		jis.close();
	}
}
