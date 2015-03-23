package cn.com.bugmanger.common.util;

import cn.com.bugmanger.constant.Constant;
import cn.com.bugmanger.util.NumberUtil;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class FileUtil {

    private FileUtil() {
    }

    /**
     * 创建文件
     *
     * @param name    文件名（需带文件类型）
     * @param content 文件内容
     * @param path    文件保存路径
     */
    public static boolean createFile(String name, String content, String path) {
        try {
            File dir = new File(path);
            if (!dir.exists() && !dir.mkdirs()) {
                return false;
            }
            File file = new File(path + File.separator + name);
            boolean result = file.createNewFile();
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(content);
            output.close();
            return result;
        } catch (IOException e) {
            LoggerFactory.getLogger(FileUtil.class).error(Constant.ERROR, e);
            return false;
        }
    }

    /**
     * 读取文件
     *
     * @param path 文件所在位置
     */
    public static String readFile(String path) {
        File file = new File(path);
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = input.readLine()) != null) {
                content.append(temp).append("\n");
            }
            input.close();
        } catch (IOException e) {
            LoggerFactory.getLogger(FileUtil.class).error(Constant.ERROR, e);
        }
        return content.toString();
    }

    /**
     * 删除文件
     *
     * @param path 文件所在位置
     */
    public static boolean deleteFile(String path) {
        File file = new File(path);
        return file.delete();
    }

    /**
     * 复制文件或文件夹
     *
     * @param oldPath 源文件位置/文件夹目录
     * @param newPath 目标文件夹
     */
    public static boolean copyFolder(String oldPath, String newPath) {
        boolean flag = false;
        try {
            flag = new File(newPath).mkdirs();
            File filePath = new File(oldPath);
            String[] files = filePath.list();
            File temp;
            for (String aFile : files) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + aFile);
                } else {
                    temp = new File(oldPath + File.separator + aFile);
                }
                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + File.separator + temp.getName());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {
                    copyFolder(oldPath + File.separator + aFile, newPath + File.separator + aFile);
                }
            }
        } catch (Exception e) {
            LoggerFactory.getLogger(FileUtil.class).error(Constant.ERROR, e);
        }
        return flag;
    }

    /**
     * 上传文件
     *
     * @param multipartFile multipartFile
     * @param fileName      文件名
     * @param uploadPath    上传路径
     * @return 执行结果
     * @throws java.io.IOException
     */
    public static boolean readWriteFile(MultipartFile multipartFile, String fileName, String uploadPath) throws IOException {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists() && !uploadDir.mkdirs()) {
            return false;
        }
        InputStream is = multipartFile.getInputStream();
        OutputStream os = new FileOutputStream(new File(uploadPath, fileName));
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
        is.close();
        os.close();
        return true;
    }

    /**
     * 删除目录
     *
     * @param delDir 删除目录
     * @return 执行结果
     * @throws java.io.IOException
     */
    public static boolean deleteFiles(File delDir) throws IOException {
        if (delDir.isDirectory()) {
            File[] files = delDir.listFiles();
            if (files != null) {
                for (File aFile : files) {
                    deleteFiles(aFile);
                }
            }
        }
        return delDir.delete();
    }

    /**
     * 获取文件夹大小，单位：字节
     *
     * @param file 要计算大小的文件或文件夹
     * @return size
     */
    public static long getFileOrDirSize(File file) {
        if (file.isFile()) {
            return file.length();
        }
        File[] files = file.listFiles();
        long total = 0;
        if (files != null) {
            for (File child : files) {
                total += getFileOrDirSize(child);
            }
        }
        return total;
    }

    /**
     * 获取文件夹大小，单位：MB
     *
     * @param file 要计算大小的文件或文件夹
     * @return size
     */
    public static String getFileOrDirSizeWithMb(File file) {
        return NumberUtil.round(getFileOrDirSize(file) / 1024.0 / 1024.0, 3) + "MB";
    }

    /**
     * 获取文件夹大小，当文件小于1MB时单位：KB，当文件大于等于1MB时单位：MB
     *
     * @param file 要计算大小的文件或文件夹
     * @return size
     */
    public static String getFileSize(File file) {
        long fileSize = getFileOrDirSize(file);
        if ((fileSize / 1024.0) < 1024.0) {
            return NumberUtil.round(fileSize / 1024.0, 3) + "KB";
        }
        return NumberUtil.round(fileSize / 1024.0 / 1024.0, 3) + "MB";
    }

    /**
     * 获取文件扩展名
     *
     * @param file 文件
     * @return 扩展名
     */
    public static String getExtensionName(File file) {
        String fileName = file.getName();
        if (fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}
