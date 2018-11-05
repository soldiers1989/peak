package com.masspick.peak.common;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * ExcelUtils
 */
public class ExcelUtils {

    /**
     * MAJOR
     */
    private static final int MAJOR = 2;
    /**
     * MINOR
     */
    private static final int MINOR = 3;
    /**
     * MICRO
     */
    private static final int MICRO = 28;
    /**
     * RANDOM
     */
    private static final int RANDOM = 100000;

    /**
     * Configuration
     */
    private static Configuration configuration = null;
    /**
     * Map
     */
    private static Map<String, Template> allTemplates = null;

    /**
     * ExcelUtils()
     */
    public ExcelUtils() {
        throw new AssertionError();
    }


    /**
     * @param c
     * @param dataMap
     * @param type
     * @param valueName
     * @return File
     * @throws IOException 异常
     */
    public static File createExcel(Class c, Map<?, ?> dataMap, String type, String valueName) throws IOException {
        try {

            configuration = new Configuration(new Version(MAJOR, MINOR, MICRO));
            configuration.setDefaultEncoding("UTF-8");
            configuration.setClassForTemplateLoading(c, "/ftl");
            allTemplates = new HashMap<>();
            allTemplates.put(type, configuration.getTemplate(valueName));
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

        String name = "temp" + (int) (Math.random() * RANDOM) + ".xls";
        File file = new File(name);
        Template template = allTemplates.get(type);
        try {
            Writer w = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
            template.process(dataMap, w);
            w.close();
        } catch (TemplateException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return file;
    }
}
