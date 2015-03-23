package cn.com.bugmanger.common.util;


import cn.com.bugmanger.constant.Constant;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ZipUtil {
    private static void createDirectory(String directory, String subDirectory) {
        File fl = new File(directory);
        try {
            if (subDirectory.equals("") && !fl.exists()) {
                fl.mkdir();
            } else if (!subDirectory.equals("")) {
                File subFile = new File(directory + File.separator + subDirectory);
                subFile.mkdir();
            }
        } catch (Exception e) {
            LoggerFactory.getLogger(ZipUtil.class).error(Constant.ERROR, e);
        }
    }

    public static void unZip(String zipFileName, String outputDirectory){
        File newFile = new File(outputDirectory);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
        try {
            ZipFile zipFile = new ZipFile(zipFileName);
            java.util.Enumeration e = zipFile.getEntries();
            ZipEntry zipEntry = null;
            createDirectory(outputDirectory, "");
            while (e.hasMoreElements()) {
                zipEntry = (ZipEntry) e.nextElement();
                if (zipEntry.isDirectory()) {
                    String name = zipEntry.getName();
                    name = name.substring(0, name.length() - 1);
                    File f = new File(outputDirectory + File.separator + name);
                    f.mkdir();
                } else {
                    String fileName = zipEntry.getName();
                    fileName = fileName.replace('\\', '/');
                    if (fileName.contains("/")) {
                        createDirectory(outputDirectory, fileName.substring(0, fileName.lastIndexOf("/")));
                    }
                    File files = new File(outputDirectory + File.separator + zipEntry.getName());
                    files.createNewFile();
                    InputStream in = zipFile.getInputStream(zipEntry);
                    FileOutputStream out = new FileOutputStream(files);
                    byte[] by = new byte[1024];
                    int c;
                    while ((c = in.read(by)) != -1) {
                        out.write(by, 0, c);
                    }
                    out.close();
                    in.close();
                }
            }
            zipFile.close();
        } catch (Exception e) {
            LoggerFactory.getLogger(ZipUtil.class).error(Constant.ERROR, e);
        }
    }
}
