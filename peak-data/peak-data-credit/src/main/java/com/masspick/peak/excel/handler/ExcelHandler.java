package com.masspick.peak.excel.handler;

import com.masspick.peak.excel.ErrorLog;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 * @param <T>
 */
public interface ExcelHandler<T> {
    /**
     * @param sheet
     * @param startRowNum
     * @param startCellNum
     * @param errorLogList
     * @return <T>
     */
    T handle(Sheet sheet, int startRowNum, int startCellNum, List<ErrorLog> errorLogList);
}
