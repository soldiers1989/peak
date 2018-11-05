package com.masspick.peak.resource.service.impl;

import com.masspick.peak.resource.mapper.SysProductMapper;
import com.masspick.peak.resource.service.IRandomService;
import org.apache.http.client.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by admin on 2018/9/19 0019.
 */
@Service
public class IRandomServiceImpl implements IRandomService {

    /**
     * sysProductMapper
     */
    @Resource
    private SysProductMapper sysProductMapper;

    @Override
    public String getRandom(String param) {
        //根据申请日期  到数据库获取流水号
        String dateStr = DateUtils.formatDate(new Date(), "yyyyMMdd");

        String serialNum = sysProductMapper.serialNum(param);
        char[] ary1 = serialNum.toCharArray();
        char[] ary2 = {'0', '0', '0', '0', '0', '0'};
        System.arraycopy(ary1, 0, ary2, ary2.length - ary1.length, ary1.length);
        String result = new String(ary2);
        return dateStr + result;
    }
}
