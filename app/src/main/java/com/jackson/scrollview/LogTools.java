/**
 * @Project: ForcetechPlatform_5.0.2
 * @File: LogUtil.java
 * @Package: com.frocetech.tools
 * @Description: 封装请求接口，封装常用工具类，封装常用的功能，做成jar形式，方便管理，以及版本升级。
 * @Author: json_zhong@sina.com
 * @Date: 2014年7月24日-下午3:33:34
 * @CopyRight: ©2014年7月24日 北京原理创新科技有限公司. All rights reserved.
 * @Version: V1.0
 */

package com.jackson.scrollview;

import android.annotation.SuppressLint;
import android.util.Log;

/**
 * @ClassName: LogUtil
 * @Package: com.frocetech.tools
 * @Description: 日志打印工具类
 * @Date: 2014年7月24日-下午3:34:36
 * @Version: V1.0
 */
public final class LogTools {
    /** @Fileds: logSwitch:日志打印开关，true表示打开， false表示关闭，发布版本时须关闭日志打印 */
    private static boolean logSwitch = true;
    /** @Fileds: TAG:日志打印标志 */
    private static final String TAG = "LogTools";
    /** @Fileds: Content_Format:日志格式 */
    private static final String Content_Format = "%s.%s:%d";

    /**
     * @MethodName: setLogSwitch
     * @Description: 设置日志开关
     * @param logSwitch
     *            打印开关
     * @Return: void
     * @Exception
     */
    public static void setLogSwitch(boolean logSwitch) {
        LogTools.logSwitch = logSwitch;
    }

    /**
     * @MethodName: getCurrentStackTraceElement
     * @Description: 获取当前log打印在堆栈中的信息
     * @Params: void
     * @Return: StackTraceElement
     * @Exception
     */
    public static StackTraceElement getCurrentStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];
    }

    /**
     * @MethodName: getContent
     * @Description: 获取日志内容
     * @Params: stack 堆栈信息实体
     * @Return: String 内容格式为 TAG:包名。类名:行数
     * @Exception
     */
    @SuppressLint("DefaultLocale")
    private static String getContent(StackTraceElement stack) {
        return String.format(Content_Format, stack.getClassName(),
                stack.getMethodName(), stack.getLineNumber());
    }

    private static String getTag(StackTraceElement stack) {
        return stack.getClassName();
    }

    /**
     * @MethodName: v
     * @Description: 打印debug日志
     * @param msg
     *            需要打印的信息
     * @Return: void
     * @Exception
     */
    public static void v(String msg) {
        if (logSwitch) {
            Log.v(getTag(getCurrentStackTraceElement()), "M***" + msg
                    + "\nW***" + getContent(getCurrentStackTraceElement()));
        }
    }

    /**
     * @MethodName: v
     * @Description: 打印v日志
     * @param msg
     *            提示信息
     * @param tr
     *            异常
     * @Return: void
     * @Exception
     */
    public static void v(String msg, Throwable tr) {
        if (logSwitch) {
            Log.v(getTag(getCurrentStackTraceElement()), "M***" + msg
                    + "\nW***" + getContent(getCurrentStackTraceElement()), tr);
        }
    }

    /**
     * @MethodName: v
     * @Description: 打印日志
     * @param tr
     *            异常
     * @Return: void
     * @Exception
     */

    public static void v(Throwable tr) {
        if (logSwitch) {
            Log.v(getTag(getCurrentStackTraceElement()), "W***"
                    + getContent(getCurrentStackTraceElement()), tr);
        }
    }

    /**
     * @MethodName: d
     * @Description: 打印debug日志
     * @param msg
     *            需要打印的信息
     * @Return: void
     * @Exception
     */
    public static void d(String msg) {
        if (logSwitch) {
            Log.d(getTag(getCurrentStackTraceElement()), "M***" + msg
                    + "\nW***" + getContent(getCurrentStackTraceElement()));
        }
    }

    /**
     * @MethodName: d
     * @Description: 打印debug日志
     * @param msg
     *            提示信息
     * @param tr
     *            异常
     * @Return: void
     * @Exception
     */
    public static void d(String msg, Throwable tr) {
        if (logSwitch) {
            Log.d(getTag(getCurrentStackTraceElement()), "M***" + msg
                    + "\nW***" + getContent(getCurrentStackTraceElement()), tr);
        }
    }

    /**
     * @MethodName: d
     * @Description: 打印debug日志
     * @param tr
     *            异常
     * @Return: void
     * @Exception
     */

    public static void d(Throwable tr) {
        if (logSwitch) {
            Log.d(getTag(getCurrentStackTraceElement()), "W***"
                    + getContent(getCurrentStackTraceElement()), tr);
        }
    }

    /**
     * @MethodName: i
     * @Description: 打印debug日志
     * @param msg
     *            需要打印的信息
     * @Return: void
     * @Exception
     */
    public static void i(String msg) {
        if (logSwitch) {
            Log.i(getTag(getCurrentStackTraceElement()), "M***" + msg
                    + "\nW***" + getContent(getCurrentStackTraceElement()));
        }
    }

    /**
     * @MethodName: i
     * @Description: 打印日志
     * @param msg
     *            提示信息
     * @param tr
     *            异常
     * @Return: void
     * @Exception
     */
    public static void i(String msg, Throwable tr) {
        if (logSwitch) {
            Log.i(getTag(getCurrentStackTraceElement()), "M***" + msg
                    + "\nW***" + getContent(getCurrentStackTraceElement()), tr);
        }
    }

    /**
     * @MethodName: i
     * @Description: 打印日志
     * @param tr
     *            异常
     * @Return: void
     * @Exception
     */

    public static void i(Throwable tr) {
        if (logSwitch) {
            Log.i(getTag(getCurrentStackTraceElement()), "W***"
                    + getContent(getCurrentStackTraceElement()), tr);
        }
    }

    /**
     * @MethodName: w
     * @Description: 打印日志
     * @param msg
     *            需要打印的信息
     * @Return: void
     * @Exception
     */
    public static void w(String msg) {
        if (logSwitch) {
            Log.w(getTag(getCurrentStackTraceElement()), "M***" + msg
                    + "\nW***" + getContent(getCurrentStackTraceElement()));
        }
    }

    /**
     * @MethodName: w
     * @Description: 打印日志
     * @param msg
     *            提示信息
     * @param tr
     *            异常
     * @Return: void
     * @Exception
     */
    public static void w(String msg, Throwable tr) {
        if (logSwitch) {
            Log.w(getTag(getCurrentStackTraceElement()), "M***" + msg
                    + "\nW***" + getContent(getCurrentStackTraceElement()), tr);
        }
    }

    /**
     * @MethodName: w
     * @Description: 打印日志
     * @param tr
     *            异常
     * @Return: void
     * @Exception
     */

    public static void w(Throwable tr) {
        if (logSwitch) {
            Log.w(getTag(getCurrentStackTraceElement()),
                    "W***" + getContent(getCurrentStackTraceElement()), tr);
        }
    }

    /**
     * @MethodName: e
     * @Description: 打印日志
     * @param msg
     *            需要打印的信息
     * @Return: void
     * @Exception
     */
    public static void e(String msg) {
        if (logSwitch) {
            Log.e(getTag(getCurrentStackTraceElement()),
                    "M***" + msg
                            + "\nW***" + getContent(getCurrentStackTraceElement()));
        }
    }


    /**
     * @MethodName: e
     * @Description: 打印日志
     * @param msg
     *            提示信息
     * @param tr
     *            异常
     * @Return: void
     * @Exception
     */
    public static void e(String msg, Throwable tr) {
        if (logSwitch) {
            Log.e(getTag(getCurrentStackTraceElement()),
                    "M***" + msg
                            + "\nW***" + getContent(getCurrentStackTraceElement()), tr);
        }
    }


    /**
     * @MethodName: e
     * @Description: 打印debug日志
     * @param tr
     *            异常
     * @Return: void
     * @Exception
     */

    public static void e(Throwable tr) {
        if (logSwitch) {
            Log.e(getTag(getCurrentStackTraceElement()),
                    "W***" + getContent(getCurrentStackTraceElement()), tr);
        }
    }

    /**
     * @MethodName: println
     * @Description: println打印信息
     * @param priority
     *            优先级
     * @param msg
     *            提示信息
     * @Return: void
     * @Exception
     */
    public static void println(int priority, String msg) {
        if (logSwitch) {
            println(priority, getTag(getCurrentStackTraceElement()),
                    "M***" + msg
                            + "\nW***" + getContent(getCurrentStackTraceElement()));
        }
    }

    /**
     * @MethodName: println
     * @Description: println打印信息
     * @param priority
     *            优先级
     * @param msg
     *            提示信息
     * @param TAG
     *            日志标记
     * @Return: void
     * @Exception
     */

    public static void println(int priority, String TAG, String msg) {
        if (logSwitch) {
            Log.println(priority, getTag(getCurrentStackTraceElement()),
                    "M***" + msg
                            + "\nW***" + getContent(getCurrentStackTraceElement()));
        }
    }

    /**
     * @MethodName: isLoggable
     * @Description: 控制显示规格
     * @param level
     *            显示最低级别
     * @Return: void
     * @Exception
     */

    public static void isLoggable(int level) {
        isLoggable(TAG, level);
    }

    /**
     * @MethodName: isLoggable
     * @Description: 控制某个TAG的显示规格
     * @param TAG
     *            日志标志
     * @param level
     *            日志打印的最低级别
     * @Return: void
     * @Exception
     */

    public static void isLoggable(String TAG, int level) {
        if (logSwitch) {
            Log.isLoggable(TAG, level);
        }
    }
}
