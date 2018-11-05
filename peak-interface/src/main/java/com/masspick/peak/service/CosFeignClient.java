package com.masspick.peak.service;

import com.masspick.peak.model.dto.COSDTO;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * Created by admin on 2018/7/10 0010.
 */
@RestController
public class CosFeignClient implements CosFeignApi {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CosFeignClient.class);

    /**
     * cosClient
     */
    @Autowired
    private COSClient cosClient;

    @Override
    public Boolean uploadImageToCos(@RequestBody COSDTO cosdto) {
        //String filepath = cosdto.getFilePath();
        File file = cosdto.getFile();
        if (!file.exists()) {
            LOGGER.error("error", "本地文件不存在，请重新操作!");
        }
        PutObjectRequest putObjectRequest = new PutObjectRequest(cosdto.getBucketName(),
                cosdto.getKey(), file);
        try {
            cosClient.putObject(putObjectRequest);
            return true;
        } catch (Exception e) {
            LOGGER.error("error", e);
            return false;
        } finally {
            cosClient.shutdown();
        }
    }
}
