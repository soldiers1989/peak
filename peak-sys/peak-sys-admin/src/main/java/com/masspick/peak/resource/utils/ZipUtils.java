package com.masspick.peak.resource.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by admin on 2018/9/19 0019.
 */
public final class ZipUtils {

    /**
     * NUM
     */
    private static final Integer NUM = 1024;

    /**
     * ZipUtils
     */
    private ZipUtils() {
    }

    /**
     * @param srcFile
     * @param zipFile
     * @throws IOException IOException
     */
    public static void doCompress(String srcFile, String zipFile) throws IOException {
        doCompress(new File(srcFile), new File(zipFile));
    }


    /**
     * 文件压缩
     *
     * @param srcFile 目录或者单个文件
     * @param zipFile 压缩后的ZIP文件
     * @throws IOException IOException
     */
    public static void doCompress(File srcFile, File zipFile) throws IOException {
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(zipFile));
            doCompress(srcFile, out);
        } catch (Exception e) {
            throw e;
        } finally {
            out.close();
        }
    }


    /**
     * @param filelName
     * @param out
     * @throws IOException IOException
     */
    public static void doCompress(String filelName, ZipOutputStream out) throws IOException {
        doCompress(new File(filelName), out);
    }

    /**
     * @param file
     * @param out
     * @throws IOException IOException
     */
    public static void doCompress(File file, ZipOutputStream out) throws IOException {
        doCompress(file, out, "");
    }

    /**
     * @param inFile
     * @param out
     * @param dir
     * @throws IOException IOException
     */
    public static void doCompress(File inFile, ZipOutputStream out, String dir) throws IOException {
        if (inFile.isDirectory()) {
            File[] files = inFile.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    String name = inFile.getName();
                    if (!"".equals(dir)) {
                        name = dir + "/" + name;
                    }
                    ZipUtils.doCompress(file, out, name);
                }
            }
        } else {
            ZipUtils.doZip(inFile, out, dir);
        }
    }

    /**
     * @param inFile
     * @param out
     * @param dir
     * @throws IOException IOException
     */
    public static void doZip(File inFile, ZipOutputStream out, String dir) throws IOException {
        String entryName = null;
        if (!"".equals(dir)) {
            entryName = dir + "/" + inFile.getName();
        } else {
            entryName = inFile.getName();
        }
        ZipEntry entry = new ZipEntry(entryName);
        out.putNextEntry(entry);

        int len = 0;
        byte[] buffer = new byte[NUM];
        FileInputStream fis = new FileInputStream(inFile);
        while ((len = fis.read(buffer)) > 0) {
            out.write(buffer, 0, len);
            out.flush();
        }
        out.closeEntry();
        fis.close();
    }

    /*public static void main(String[] args) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> response = restTemplate.getForEntity("https://masspick-1255853614.cos.ap-shanghai" +
                ".myqcloud" +
                ".com/masspick/produc/peak-resource/2018-09-19/bf354b07-2185-4102-9fc4-67036b7a3e2a.png", byte[].class);
        File file = new File("D:/a/1.png");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(response.getBody());
        fos.flush();
        fos.close();
    }*/
}
