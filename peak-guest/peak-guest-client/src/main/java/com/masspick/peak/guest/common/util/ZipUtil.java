package com.masspick.peak.guest.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 将文件夹下面的文件
 * 打包成zip压缩文件
 *
 * @author admin
 */
public class ZipUtil {

    /**
     * BYTE_LENGTH
     */
    private static final int BYTE_LENGTH = 1024 * 10;

    /**
     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
     *
     * @param fileNameList :待压缩的文件
     * @param zipFilePath  :压缩后存放路径
     * @param fileName     :压缩后文件的名称
     * @return boolean
     */
    public static boolean fileToZip(List<String> fileNameList, String zipFilePath, String fileName) {
        boolean flag = false;
        FileInputStream fis;
        BufferedInputStream bis = null;
        FileOutputStream fos;
        ZipOutputStream zos = null;

        if (fileNameList == null || fileNameList.size() == 0) {
            System.out.println("待压缩的文件：" + fileNameList + "不存在.");
        } else {
            try {
                File zipFile = new File(zipFilePath + File.separator + fileName);
                if (zipFile.exists()) {
                    System.out.println(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
                } else {
                    fos = new FileOutputStream(zipFile);
                    zos = new ZipOutputStream(new BufferedOutputStream(fos));

                    byte[] bufs = new byte[BYTE_LENGTH];
                    for (String sourceFileName : fileNameList) {
                        File file = new File(sourceFileName);
                        //创建ZIP实体，并添加进压缩包
                        ZipEntry zipEntry = new ZipEntry(file.getName());
                        zos.putNextEntry(zipEntry);
                        //读取待压缩的文件并写进压缩包里
                        fis = new FileInputStream(file);
                        bis = new BufferedInputStream(fis, BYTE_LENGTH);
                        int read = 0;
                        while ((read = bis.read(bufs, 0, BYTE_LENGTH)) != -1) {
                            zos.write(bufs, 0, read);
                        }
                        flag = true;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                //关闭流
                try {
                    if (null != bis) {
                        bis.close();
                    }
                    if (null != zos) {
                        zos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

//    public static void main(String[] args){
//        List<File> fileList = new ArrayList<>();
//        File file1 = new File("C:\\Users\\Administrator\\Desktop\\营业执照.jpg");
//        File file2 = new File("C:\\Users\\Administrator\\Desktop\\名片.jpg");
//        fileList.add(file1);
//        fileList.add(file2);
//
//        String zipFilePath = "E:\\home\\wheel\\static\\credit";
//        String fileName = "test";
//        boolean flag = ZipUtils.fileToZip(fileList, zipFilePath, fileName);
//        if(flag){
//            System.out.println("文件打包成功!");
//        }else{
//            System.out.println("文件打包失败!");
//        }
//    }

}
