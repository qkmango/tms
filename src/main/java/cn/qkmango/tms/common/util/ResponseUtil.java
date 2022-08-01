package cn.qkmango.tms.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 响应的工具类工具类
 */
public class ResponseUtil {

    /**
     * 响应json类型数据到前端
     * @param response 响应对象
     * @param message 响应信息（json字符串）
     * @throws IOException
     */
    public static void responseJson(HttpServletResponse response,String message) throws IOException {
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(message);
    }
}
