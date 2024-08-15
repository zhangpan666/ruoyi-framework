package com.ruoyi.framework.converter;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class StringToDateConverter implements Converter<String, Date> {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT_MINUTE = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMdd = "yyyyMMdd";

    @Override
    public Date convert(String dateStr) {
        Date date = null;
        if (StringUtils.isNotEmpty(dateStr)) {
            try {
                if (dateStr.length() == 10) {
                    date = new SimpleDateFormat(DATE_FORMAT).parse(dateStr);
                } else if (dateStr.length() == 8) {
                    date = new SimpleDateFormat(yyyyMMdd).parse(dateStr);
                } else if (dateStr.length() == 16) {
                    date = new SimpleDateFormat(DATE_TIME_FORMAT_MINUTE).parse(dateStr);
                } else if (dateStr.length() == 19) {
                    date = new SimpleDateFormat(DATE_TIME_FORMAT).parse(dateStr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return date;
    }

}
