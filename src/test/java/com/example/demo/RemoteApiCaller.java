package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RemoteApiCaller {

    public static void main(String[] args) {
        // 远程接口的URL
        String apiUrl = "https://www.baidu.com/s?ie=utf-8&wd=ffff";

        try {
            // 创建URL对象
            URL url = new URL(apiUrl);

            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置请求方法，这里以GET为例
            connection.setRequestMethod("GET");

            // 设置请求头（根据接口要求可能需要设置一些特定的请求头，如授权头、内容类型头等）
            connection.setRequestProperty("Content-Type", "application/json");

            // 获取响应码
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 读取响应内容
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine())!= null) {
                    response.append(inputLine);
                }
                in.close();

                // 输出响应内容
                System.out.println("接口响应内容: " + response.toString());
            } else {
                System.out.println("调用接口失败，响应码: " + responseCode);
            }

            // 关闭连接
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}