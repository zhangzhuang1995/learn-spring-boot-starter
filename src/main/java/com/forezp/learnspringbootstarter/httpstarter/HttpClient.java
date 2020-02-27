package com.forezp.learnspringbootstarter.httpstarter;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * @author ZhangZhuang
 * @date 2020/2/27
 * @description
 */
@Getter
@Setter
public class HttpClient {

    private String url;

    public String getHtml() {
        try {
            URL url = new URL(this.url);
            // 打开连接
            URLConnection urlConnection = url.openConnection();
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}
