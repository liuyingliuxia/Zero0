package com.lolinico.technical.open.request;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Xml;

import com.steelbar.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/16.
 */
public class PullUtils {

    public static PullUtils pullUtils;
    private final String API_CONFIG = "ApiService_Config.xml";

    public static PullUtils getInstance() {
        if (pullUtils == null) {
            pullUtils = new PullUtils();
        }
        return pullUtils;
    }

    //读取XML
    public String getHttpParams(Context context, String key, String ExtendedValue) {
        String result = readFromAssets(context, API_CONFIG);
        ByteArrayInputStream inStream = new ByteArrayInputStream(result.getBytes());
        XmlPullParser parser = Xml.newPullParser();
        String value = "";
        try {
            parser.setInput(inStream, "UTF-8");
            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT://文档开始事件,可以进行数据初始化处理
                        break;
                    case XmlPullParser.START_TAG://开始元素事件
                        String name = parser.getName();
                        if (name.equals(key)) {
                            if (parser.getAttributeCount() > 0 && parser.getAttributeValue(0) != null) {
                                String extendedV = parser.getAttributeValue(0);
                                if (ExtendedValue.equals(extendedV)) {
                                    value = parser.nextText().toString();
                                }
                            } else {
                                value = parser.nextText().toString();
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG://结束元素事件
                        if (parser.getName().equalsIgnoreCase("Config")) {
                        }
                        break;
                }
                eventType = parser.next();
            }
            inStream.close();
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    private String readFromAssets(Context context, String fileName) {
        String txt = "";
        try {
            InputStream is = context.getAssets().open(fileName);
            txt = readTextFrom(is);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return txt;
    }

    private static String readTextFrom(InputStream is) throws Exception {
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer("");
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public List readXMLValues(Context context, int redId, String tag) {
        List<Object> objectList = new ArrayList<>();
        XmlResourceParser xrp = context.getResources().getXml(redId);
        try {
            while (xrp.getEventType() != XmlResourceParser.END_DOCUMENT) {
                if (xrp.getEventType() == XmlResourceParser.START_TAG) {
                    String tagName = xrp.getName();
                    if (tagName.equals(tag)) {
                        objectList.add(xrp.nextText());
                    }
                }
                xrp.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectList;
    }
}
