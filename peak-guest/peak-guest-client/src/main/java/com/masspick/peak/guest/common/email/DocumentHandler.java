package com.masspick.peak.guest.common.email;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

/**
 * DocumentHandler
 */
public class DocumentHandler {

    /**
     * configuration
     */
    private Configuration configuration = null;

    /**
     * 构造函数
     */
    public DocumentHandler() {
        configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
//        Map<String, Object> dataMap = new HashMap<>();
//        dataMap.put("no", "12313123");
//        dataMap.put("year", "2018");
//        dataMap.put("month", "12");
//        dataMap.put("day", "21");

//        try {
//            DocumentHandler mdoc = new DocumentHandler();
//            mdoc.createDocArea(null, "E:\\home\\wheel\\contract\\" + "12313123.doc", "contract.ftl");
//        } catch (Exception e) {
//            System.out.println("asas");
//        }
    }


    /**
     * @param dataMap
     * @param outFilePath
     * @param fileName
     * @return byte
     * @throws Exception 异常
     */
    public byte[] createDocArea(Map<String, Object> dataMap, String outFilePath, String fileName) throws Exception {
        //this.configuration.setClassForTemplateLoading(DocumentHandler.class, "D:\\");//第一种模板路径
        System.out.println("---进入createDocArea---");
        //this.configuration.setDirectoryForTemplateLoading(new File("/template/"));//第二种模板路径
        this.configuration.setClassForTemplateLoading(this.getClass(), "/ftl");
        Template t = null;
        File outFile = null;
        byte[] bFile = null;
        try {
            t = this.configuration.getTemplate(fileName, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        outFile = new File(outFilePath);
        File parentPath = outFile.getParentFile();
        if (!parentPath.exists()) {
            parentPath.mkdirs(); //创建临时文件夹
        }
        Writer w = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(outFile);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

            w = new BufferedWriter(osw);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        try {
            t.process(dataMap, w);
            if (outFile != null) {
                FileInputStream fis = new FileInputStream(outFile);
                bFile = new byte[(int) outFile.length()];
                fis.read(bFile);
                fis.close();
            }
            System.out.println("--写入完成---");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            w.close();
            fos.close();
        }
        return bFile;
    }

}
