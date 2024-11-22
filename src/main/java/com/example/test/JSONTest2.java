package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.PayInfoDTO;
import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class JSONTest2 {
    private static final List<String> PAY_RSLT_TYPE = ImmutableList.of("101", "102", "103");

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:\\下载\\新文件 3.json");
        byte[] data = Files.readAllBytes(path);
        String calOutPara = new String(data, "utf-8");
        JSONObject jsonObject = JSON.parseObject(calOutPara);
        JSONArray payInfo = (JSONArray) jsonObject.get("pay_info");
        List<PayInfoDTO> payInfoDTOS = payInfo.toJavaList(PayInfoDTO.class);
        Map<String, List<BigDecimal>> resultMap = payInfoDTOS.stream()
                .filter(payInfoDTO1 -> PAY_RSLT_TYPE.contains(payInfoDTO1.getPayRsltType()))
                .collect(groupingBy(PayInfoDTO::getPayRsltType, mapping(PayInfoDTO::getFeeSumamt, toList())));
        resultMap.forEach((s, bigDecimals1) -> System.out.println(s + ",金额为：" + bigDecimals1.stream().reduce(BigDecimal::add).get()));

    }
}
