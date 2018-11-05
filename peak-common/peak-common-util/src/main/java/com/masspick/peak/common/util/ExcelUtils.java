package com.masspick.peak.common.util;

import com.masspick.peak.common.exception.PeakRuntimeException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/23.
 */
public final class ExcelUtils {

    /**
     * 26个字母
     */
    private static final int CHARACTER_26 = 26;

    /**
     * EXCEL Date 起始年
     */
    private static final int EXCEL_DATE_YEAR_START = 1899;

    /**
     * EXCEL Date 起始月
     */
    private static final int EXCEL_DATE_MONTH_START = 11;

    /**
     * EXCEL Date 起始日
     */
    private static final int EXCEL_DATE_DAY_START = 30;

    /**
     * EMPTY_BYTE
     */
    private static final byte EMPTY_BYTE = 0x30;

    /**
     * 隐藏构造函数
     */
    private ExcelUtils() {
    }

    /**
     * @param cell
     * @return String
     */
    public static String getString(Cell cell) {
        if (cell == null) {
            return null;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.#");

        String cellValue = null;
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case NUMERIC:
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    double d = cell.getNumericCellValue();
                    Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(d);
                    cellValue = DateUtils.format(date);
                } else {
                    cellValue = decimalFormat.format((cell.getNumericCellValue()));
                }
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue = cell.getCellFormula().toString();
                break;
            case BLANK:
            case _NONE:
            case ERROR:
                break;
            default:
                break;
        }
        return cellValue;
    }

    /**
     * @param cell
     * @return Integer
     */
    public static Integer getInt(Cell cell) {
        if (cell == null) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#");

        Integer cellValue = null;
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case NUMERIC:
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    throw new PeakRuntimeException("无效的字段类型");
                } else {
                    cellValue = Double.valueOf(cell.getNumericCellValue()).intValue();
                }
                break;
            case STRING:
                cellValue = Integer.valueOf(cell.getStringCellValue());
                break;
            case BOOLEAN:
            case FORMULA:
            case ERROR:
                throw new PeakRuntimeException("无效的字段类型");
            case BLANK:
            case _NONE:
                break;
            default:
                break;
        }
        return cellValue;
    }

    /**
     * @param cell
     * @return Date
     * @throws ParseException ParseException
     */
    public static Date getDate(Cell cell) throws ParseException {
        if (cell == null) {
            return null;
        }
        Date cellValue = null;
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case NUMERIC:
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    double d = cell.getNumericCellValue();
                    cellValue = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(d);
                } else {
                    Double d = cell.getNumericCellValue();
                    Calendar cal = Calendar.getInstance();
                    cal.set(EXCEL_DATE_YEAR_START, EXCEL_DATE_MONTH_START, EXCEL_DATE_DAY_START, 0, 0, 0);
                    cal.add(Calendar.DATE, d.intValue());
                    cellValue = cal.getTime();
                }
                break;
            case STRING:
                String cellValueStr = cell.getStringCellValue();
                if (!StringUtils.isEmpty(cellValueStr)) {
                    cellValue = DateUtils.parseDateWithDefaultPattern(clearNull(cellValueStr, Charset.forName("UTF-8")));
                }
                break;
            case BOOLEAN:
            case FORMULA:
            case BLANK:
            case _NONE:
            case ERROR:
                break;
            default:
                break;
        }
        return cellValue;
    }


    /**
     * @param cell
     * @return Double
     * @throws ParseException ParseException
     */
    public static Double getDouble(Cell cell) throws ParseException {
        if (cell == null) {
            return null;
        }
        Double cellValue = null;
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case NUMERIC:
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    throw new PeakRuntimeException("无效的字段类型");
                } else {
                    cellValue = cell.getNumericCellValue();
                }
                break;
            case STRING:
                String cellValueStr = cell.getStringCellValue();
                if (!StringUtils.isEmpty(cellValueStr)) {
                    cellValue = Double.valueOf(cellValue);
                }
                break;
            case BOOLEAN:
            case FORMULA:
            case ERROR:
                throw new PeakRuntimeException("无效的字段类型");
            case BLANK:
            case _NONE:
                break;
            default:
                break;
        }
        return cellValue;
    }

    private static String clearNull(String toBeClear, Charset charset) {
        byte[] bytes = toBeClear.getBytes(charset);
        for (int i = 0; i < bytes.length; i++) {
            Byte b = bytes[i];
            if (b == 0x00) {
                bytes[i] = EMPTY_BYTE;
            }
        }
        return new String(bytes, charset).trim();
    }

    /**
     * Excel column index begin 1
     *
     * @param colStr
     * @param length
     * @return int
     */
    public static int excelColStrToNum(String colStr, int length) {
        int num = 0;
        int result = 0;
        for (int i = 0; i < length; i++) {
            char ch = colStr.charAt(length - i - 1);
            num = (int) (ch - 'A' + 1);
            num *= Math.pow(CHARACTER_26, i);
            result += num;
        }
        return result;
    }

    /**
     * Excel column index begin 1
     *
     * @param columnIndex
     * @return String
     */
    public static String excelColIndexToStr(int columnIndex) {
        if (columnIndex <= 0) {
            return null;
        }
        String columnStr = "";
        columnIndex--;
        do {
            if (columnStr.length() > 0) {
                columnIndex--;
            }
            columnStr = ((char) (columnIndex % CHARACTER_26 + (int) 'A')) + columnStr;
            columnIndex = (int) ((columnIndex - columnIndex % CHARACTER_26) / CHARACTER_26);
        } while (columnIndex > 0);
        return columnStr;
    }
}
