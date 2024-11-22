package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.PayInfoDTO;
import com.google.common.collect.ImmutableList;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class JSONTest {
    private static final List<String> PAY_RSLT_TYPE = ImmutableList.of("101","102","103");
    public static void main(String[] args) {
        JSONObject jsonObject = JSON.parseObject("{\n" +
                "\t\"policy_path\": {\n" +
                "\t\t\"0\": {\n" +
                "\t\t\t\"effect_date\": \"2018-01-01\",\n" +
                "\t\t\t\"policy_id\": \"511800511800440\",\n" +
                "\t\t\t\"policy_item_code\": \"S001\",\n" +
                "\t\t\t\"policy_item_name\": \"本次应付起付标准\",\n" +
                "\t\t\t\"regale_code\": \"511800511800440\",\n" +
                "\t\t\t\"use_default\": \"\",\n" +
                "\t\t\t\"regale_name\": \"城职通用起付线政策【20221207】\",\n" +
                "\t\t\t\"cond_name\": \"城职通用起付线政策【20221207】\",\n" +
                "\t\t\t\"expire_date\": \"2099-12-31\",\n" +
                "\t\t\t\"center_id\": \"511800\",\n" +
                "\t\t\t\"method_id\": \"\",\n" +
                "\t\t\t\"cond_id\": \"5118005118005643\",\n" +
                "\t\t\t\"policy_type_id\": \"201\"\n" +
                "\t\t},\n" +
                "\t\t\"1\": {\n" +
                "\t\t\t\"effect_date\": \"2018-01-01\",\n" +
                "\t\t\t\"policy_id\": \"511800511800650\",\n" +
                "\t\t\t\"policy_item_code\": \"C001\",\n" +
                "\t\t\t\"policy_item_name\": \"统筹一段\",\n" +
                "\t\t\t\"regale_code\": \"511800511800650\",\n" +
                "\t\t\t\"use_default\": \"\",\n" +
                "\t\t\t\"regale_name\": \"20210810职工住院基本通用条件非单病种\",\n" +
                "\t\t\t\"cond_name\": \"20210810职工住院基本通用条件非单病种\",\n" +
                "\t\t\t\"expire_date\": \"2099-12-31\",\n" +
                "\t\t\t\"center_id\": \"511800\",\n" +
                "\t\t\t\"method_id\": \"\",\n" +
                "\t\t\t\"cond_id\": \"511800511800915\",\n" +
                "\t\t\t\"policy_type_id\": \"202\"\n" +
                "\t\t},\n" +
                "\t\t\"2\": {\n" +
                "\t\t\t\"effect_date\": \"2018-01-01\",\n" +
                "\t\t\t\"policy_id\": \"511800520200131\",\n" +
                "\t\t\t\"policy_item_code\": \"EC01\",\n" +
                "\t\t\t\"policy_item_name\": \"基本医疗超封顶段\",\n" +
                "\t\t\t\"regale_code\": \"511800520200131\",\n" +
                "\t\t\t\"use_default\": \"\",\n" +
                "\t\t\t\"regale_name\": \"政策通用条件（全匹配）\",\n" +
                "\t\t\t\"cond_name\": \"政策通用条件（全匹配）\",\n" +
                "\t\t\t\"expire_date\": \"2099-12-31\",\n" +
                "\t\t\t\"center_id\": \"511800\",\n" +
                "\t\t\t\"method_id\": \"\",\n" +
                "\t\t\t\"cond_id\": \"511800520200110\",\n" +
                "\t\t\t\"policy_type_id\": \"300\"\n" +
                "\t\t},\n" +
                "\t\t\"3\": {\n" +
                "\t\t\t\"effect_date\": \"2018-01-01\",\n" +
                "\t\t\t\"policy_id\": \"511800511800371\",\n" +
                "\t\t\t\"policy_item_code\": \"PL01\",\n" +
                "\t\t\t\"policy_item_name\": \"补充大病第一段\",\n" +
                "\t\t\t\"regale_code\": \"511800511800371\",\n" +
                "\t\t\t\"use_default\": \"\",\n" +
                "\t\t\t\"regale_name\": \"20210810职工非单病种住院条件\",\n" +
                "\t\t\t\"cond_name\": \"20210810职工非单病种住院条件\",\n" +
                "\t\t\t\"expire_date\": \"2023-06-30\",\n" +
                "\t\t\t\"center_id\": \"511800\",\n" +
                "\t\t\t\"method_id\": \"\",\n" +
                "\t\t\t\"cond_id\": \"511800511800769\",\n" +
                "\t\t\t\"policy_type_id\": \"204\"\n" +
                "\t\t},\n" +
                "\t\t\"4\": {\n" +
                "\t\t\t\"effect_date\": \"2018-01-01\",\n" +
                "\t\t\t\"policy_id\": \"511800511800373\",\n" +
                "\t\t\t\"policy_item_code\": \"PL02\",\n" +
                "\t\t\t\"policy_item_name\": \"补充大病第二段\",\n" +
                "\t\t\t\"regale_code\": \"511800511800373\",\n" +
                "\t\t\t\"use_default\": \"\",\n" +
                "\t\t\t\"regale_name\": \"20210810职工非单病种住院条件\",\n" +
                "\t\t\t\"cond_name\": \"20210810职工非单病种住院条件\",\n" +
                "\t\t\t\"expire_date\": \"2023-06-30\",\n" +
                "\t\t\t\"center_id\": \"511800\",\n" +
                "\t\t\t\"method_id\": \"\",\n" +
                "\t\t\t\"cond_id\": \"511800511800769\",\n" +
                "\t\t\t\"policy_type_id\": \"204\"\n" +
                "\t\t},\n" +
                "\t\t\"5\": {\n" +
                "\t\t\t\"effect_date\": \"2018-01-01\",\n" +
                "\t\t\t\"policy_id\": \"511800511800374\",\n" +
                "\t\t\t\"policy_item_code\": \"PL03\",\n" +
                "\t\t\t\"policy_item_name\": \"补充大病第三段\",\n" +
                "\t\t\t\"regale_code\": \"511800511800374\",\n" +
                "\t\t\t\"use_default\": \"\",\n" +
                "\t\t\t\"regale_name\": \"20210810职工非单病种住院条件\",\n" +
                "\t\t\t\"cond_name\": \"20210810职工非单病种住院条件\",\n" +
                "\t\t\t\"expire_date\": \"2023-06-30\",\n" +
                "\t\t\t\"center_id\": \"511800\",\n" +
                "\t\t\t\"method_id\": \"\",\n" +
                "\t\t\t\"cond_id\": \"511800511800769\",\n" +
                "\t\t\t\"policy_type_id\": \"204\"\n" +
                "\t\t},\n" +
                "\t\t\"6\": {\n" +
                "\t\t\t\"effect_date\": \"2018-01-01\",\n" +
                "\t\t\t\"policy_id\": \"511800511800496\",\n" +
                "\t\t\t\"policy_item_code\": \"GB01\",\n" +
                "\t\t\t\"policy_item_name\": \"公务员补充第一段\",\n" +
                "\t\t\t\"regale_code\": \"511800511800496\",\n" +
                "\t\t\t\"use_default\": \"\",\n" +
                "\t\t\t\"regale_name\": \"20210810公务员非病种住院\",\n" +
                "\t\t\t\"cond_name\": \"20210810职工非单病种住院条件\",\n" +
                "\t\t\t\"expire_date\": \"2099-12-31\",\n" +
                "\t\t\t\"center_id\": \"511800\",\n" +
                "\t\t\t\"method_id\": \"\",\n" +
                "\t\t\t\"cond_id\": \"511800511800769\",\n" +
                "\t\t\t\"policy_type_id\": \"205\"\n" +
                "\t\t},\n" +
                "\t\t\"7\": {\n" +
                "\t\t\t\"effect_date\": \"2018-01-01\",\n" +
                "\t\t\t\"policy_id\": \"5118005118006516\",\n" +
                "\t\t\t\"policy_item_code\": \"YB02\",\n" +
                "\t\t\t\"policy_item_name\": \"医疗补助第二段\",\n" +
                "\t\t\t\"regale_code\": \"5118005118006516\",\n" +
                "\t\t\t\"use_default\": \"\",\n" +
                "\t\t\t\"regale_name\": \"医疗救助住院报销条件【职工20221219】\",\n" +
                "\t\t\t\"cond_name\": \"医疗救助住院报销条件【职工20221219】\",\n" +
                "\t\t\t\"expire_date\": \"2022-08-31\",\n" +
                "\t\t\t\"center_id\": \"511800\",\n" +
                "\t\t\t\"method_id\": \"\",\n" +
                "\t\t\t\"cond_id\": \"5118005118005601\",\n" +
                "\t\t\t\"policy_type_id\": \"205\"\n" +
                "\t\t},\n" +
                "\t\t\"8\": {\n" +
                "\t\t\t\"effect_date\": \"2018-01-01\",\n" +
                "\t\t\t\"policy_id\": \"511800520200153\",\n" +
                "\t\t\t\"policy_item_code\": \"BS01\",\n" +
                "\t\t\t\"policy_item_name\": \"冲减段\",\n" +
                "\t\t\t\"regale_code\": \"511800520200153\",\n" +
                "\t\t\t\"use_default\": \"\",\n" +
                "\t\t\t\"regale_name\": \"政策通用条件（全匹配）\",\n" +
                "\t\t\t\"cond_name\": \"政策通用条件（全匹配）\",\n" +
                "\t\t\t\"expire_date\": \"2099-12-31\",\n" +
                "\t\t\t\"center_id\": \"511800\",\n" +
                "\t\t\t\"method_id\": \"\",\n" +
                "\t\t\t\"cond_id\": \"511800520200110\",\n" +
                "\t\t\t\"policy_type_id\": \"206\"\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"pay_info\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 5.16,\n" +
                "\t\t\t\"payRsltType\": \"102\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"XM01ACL238B001010104756\",\n" +
                "\t\t\t\"paySn\": 1,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 9.74,\n" +
                "\t\t\t\"payRsltType\": \"102\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"XB05BBN080B002020101445\",\n" +
                "\t\t\t\"paySn\": 2,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 17.48,\n" +
                "\t\t\t\"payRsltType\": \"102\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"XA03AXJ096B001010201874\",\n" +
                "\t\t\t\"paySn\": 3,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 2.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"001204000040100-120400004-1\",\n" +
                "\t\t\t\"paySn\": 4,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 16.5,\n" +
                "\t\t\t\"payRsltType\": \"101\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"C1603032150000208438\",\n" +
                "\t\t\t\"paySn\": 5,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 6.0,\n" +
                "\t\t\t\"payRsltType\": \"101\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"001107000010000-110700001-4\",\n" +
                "\t\t\t\"paySn\": 6,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 9.4,\n" +
                "\t\t\t\"payRsltType\": \"101\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"C1423130390000107187\",\n" +
                "\t\t\t\"paySn\": 7,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 3.15,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"C1605011940200107203\",\n" +
                "\t\t\t\"paySn\": 8,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 5.67,\n" +
                "\t\t\t\"payRsltType\": \"102\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"C1605011940200107203\",\n" +
                "\t\t\t\"paySn\": 9,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 3.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"001201000030000-120100003\",\n" +
                "\t\t\t\"paySn\": 10,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 2.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002503020010001-250302001-3\",\n" +
                "\t\t\t\"paySn\": 11,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 3.7,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"C1605011940100109013\",\n" +
                "\t\t\t\"paySn\": 12,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 6.66,\n" +
                "\t\t\t\"payRsltType\": \"102\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"C1605011940100109013\",\n" +
                "\t\t\t\"paySn\": 13,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 15.6,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"C0207220540000001754\",\n" +
                "\t\t\t\"paySn\": 14,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 28.08,\n" +
                "\t\t\t\"payRsltType\": \"102\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"C0207220540000001754\",\n" +
                "\t\t\t\"paySn\": 15,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 34.96,\n" +
                "\t\t\t\"payRsltType\": \"102\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"XV08ABD113B002020101749\",\n" +
                "\t\t\t\"paySn\": 16,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 1.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002503020080000-250302008\",\n" +
                "\t\t\t\"paySn\": 17,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 1.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002503060020300-250306002-2\",\n" +
                "\t\t\t\"paySn\": 18,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 5.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002503060080000-250306008\",\n" +
                "\t\t\t\"paySn\": 19,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 11.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002503060130000-250306013\",\n" +
                "\t\t\t\"paySn\": 20,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 36.6,\n" +
                "\t\t\t\"payRsltType\": \"102\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002503060130000-250306013\",\n" +
                "\t\t\t\"paySn\": 21,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 6.5,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002504040150000-250404015\",\n" +
                "\t\t\t\"paySn\": 22,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 18.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002504040110200-250404011-1\",\n" +
                "\t\t\t\"paySn\": 23,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 3.27,\n" +
                "\t\t\t\"payRsltType\": \"101\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"C1423022030001002763\",\n" +
                "\t\t\t\"paySn\": 24,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 1.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002503010170000-250301017\",\n" +
                "\t\t\t\"paySn\": 25,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 2.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002502030650000-250203065\",\n" +
                "\t\t\t\"paySn\": 26,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 5.5,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002504030110000-250403011\",\n" +
                "\t\t\t\"paySn\": 27,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 4.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002504030040001-250403004-1\",\n" +
                "\t\t\t\"paySn\": 28,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 4.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002504030050001-250403005-1\",\n" +
                "\t\t\t\"paySn\": 29,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 4.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002504030060001-250403006-1\",\n" +
                "\t\t\t\"paySn\": 30,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 4.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002504030070001-250403007-1\",\n" +
                "\t\t\t\"paySn\": 31,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 4.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002504030090000-250403009-1\",\n" +
                "\t\t\t\"paySn\": 32,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 3.5,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002504030140000-250403014\",\n" +
                "\t\t\t\"paySn\": 33,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 4.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002504030530000-250403053\",\n" +
                "\t\t\t\"paySn\": 34,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 1.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002504030190000-250403019\",\n" +
                "\t\t\t\"paySn\": 35,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 6.0,\n" +
                "\t\t\t\"payRsltType\": \"101\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"001109000010000-110900001-17\",\n" +
                "\t\t\t\"paySn\": 36,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 2.0,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"001109000010400-110900001-4\",\n" +
                "\t\t\t\"paySn\": 37,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 1.5,\n" +
                "\t\t\t\"payRsltType\": \"103\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002501020350000-250102035\",\n" +
                "\t\t\t\"paySn\": 38,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 132.0,\n" +
                "\t\t\t\"payRsltType\": \"102\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002103000000003-210300001-3\",\n" +
                "\t\t\t\"paySn\": 39,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 100.0,\n" +
                "\t\t\t\"payRsltType\": \"102\",\n" +
                "\t\t\t\"medItemSn\": \"511800G0000014416322\",\n" +
                "\t\t\t\"polItemCode\": \"002103000020000-210300002-3\",\n" +
                "\t\t\t\"paySn\": 40,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 1000.0,\n" +
                "\t\t\t\"payRsltType\": \"000\",\n" +
                "\t\t\t\"medItemSn\": \"0\",\n" +
                "\t\t\t\"polItemCode\": \"S001\",\n" +
                "\t\t\t\"politemName\": \"本次应付起付标准\",\n" +
                "\t\t\t\"paySn\": 41,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 10073.79,\n" +
                "\t\t\t\"payRsltType\": \"000\",\n" +
                "\t\t\t\"medItemSn\": \"0\",\n" +
                "\t\t\t\"polItemCode\": \"C001\",\n" +
                "\t\t\t\"politemName\": \"统筹一段\",\n" +
                "\t\t\t\"paySn\": 42,\n" +
                "\t\t\t\"fundMnyCode\": \"310101\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 1505.28,\n" +
                "\t\t\t\"payRsltType\": \"000\",\n" +
                "\t\t\t\"medItemSn\": \"0\",\n" +
                "\t\t\t\"polItemCode\": \"C001\",\n" +
                "\t\t\t\"politemName\": \"统筹一段\",\n" +
                "\t\t\t\"paySn\": 43,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 1904.08,\n" +
                "\t\t\t\"payRsltType\": \"000\",\n" +
                "\t\t\t\"medItemSn\": \"0\",\n" +
                "\t\t\t\"polItemCode\": \"GB01\",\n" +
                "\t\t\t\"politemName\": \"公务员补充第一段\",\n" +
                "\t\t\t\"paySn\": 44,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 2881.63,\n" +
                "\t\t\t\"payRsltType\": \"000\",\n" +
                "\t\t\t\"medItemSn\": \"0\",\n" +
                "\t\t\t\"polItemCode\": \"YB02\",\n" +
                "\t\t\t\"politemName\": \"医疗补助第二段\",\n" +
                "\t\t\t\"paySn\": 45,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": -4785.71,\n" +
                "\t\t\t\"payRsltType\": \"000\",\n" +
                "\t\t\t\"medItemSn\": \"0\",\n" +
                "\t\t\t\"polItemCode\": \"BS01\",\n" +
                "\t\t\t\"politemName\": \"冲减段\",\n" +
                "\t\t\t\"paySn\": 46,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"00000000\",\n" +
                "\t\t\t\"payFlag\": \"0\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 1000.0,\n" +
                "\t\t\t\"payRsltType\": \"000\",\n" +
                "\t\t\t\"medItemSn\": \"0\",\n" +
                "\t\t\t\"polItemCode\": \"S001\",\n" +
                "\t\t\t\"politemName\": \"本次应付起付标准\",\n" +
                "\t\t\t\"paySn\": 47,\n" +
                "\t\t\t\"fundMnyCode\": \"999998\",\n" +
                "\t\t\t\"feeSn\": \"DEDC_STD\",\n" +
                "\t\t\t\"payFlag\": \"1\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"feeBatch\": 1,\n" +
                "\t\t\t\"feeSumamt\": 87.0,\n" +
                "\t\t\t\"payRsltType\": \"000\",\n" +
                "\t\t\t\"medItemSn\": \"0\",\n" +
                "\t\t\t\"polItemCode\": \"C001\",\n" +
                "\t\t\t\"politemName\": \"统筹一段\",\n" +
                "\t\t\t\"paySn\": 48,\n" +
                "\t\t\t\"fundMnyCode\": \"310101\",\n" +
                "\t\t\t\"feeSn\": \"POOL_PROP_SELFPAY\",\n" +
                "\t\t\t\"payFlag\": \"1\",\n" +
                "\t\t\t\"payDate\": \"2023-11-20 16:08:00\"\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"calcProce_data\": {\n" +
                "\t\t\"_upperLimitFactorValue\": 1000.0,\n" +
                "\t\t\"S001_upperLimitFactorValue\": 1000.0,\n" +
                "\t\t\"S001_999998_000_1_scale\": 100.0,\n" +
                "\t\t\"S001_999998_000_1_scaleFactor\": 100.0,\n" +
                "\t\t\"C001_calcBase\": 11579.07,\n" +
                "\t\t\"C001_upperLimitFactorValue\": 436781.61,\n" +
                "\t\t\"C001_310101_000_1_scale\": 100.0,\n" +
                "\t\t\"C001_310101_000_1_scaleFactor\": 87.0,\n" +
                "\t\t\"C001_999998_000_2_scale\": 100.0,\n" +
                "\t\t\"C001_999998_000_2_scaleFactor\": 100.0,\n" +
                "\t\t\"EC01_calcBase\": 0.0,\n" +
                "\t\t\"PL01_calcBase\": 0.0,\n" +
                "\t\t\"PL01_upperLimitFactorValue\": 0.0,\n" +
                "\t\t\"PL02_calcBase\": 0.0,\n" +
                "\t\t\"PL02_upperLimitFactorValue\": 0.0,\n" +
                "\t\t\"PL03_calcBase\": 0.0,\n" +
                "\t\t\"PL03_upperLimitFactorValue\": 0.0,\n" +
                "\t\t\"GB01_calcBase\": 1904.08,\n" +
                "\t\t\"GB01_320101_000_1_scale\": 100.0,\n" +
                "\t\t\"GB01_320101_000_1_scaleFactor\": 0.0,\n" +
                "\t\t\"GB01_999998_000_2_scale\": 100.0,\n" +
                "\t\t\"GB01_999998_000_2_scaleFactor\": 100.0,\n" +
                "\t\t\"YB02_calcBase\": 2881.63,\n" +
                "\t\t\"YB02_upperLimitFactorValue\": 999999.0,\n" +
                "\t\t\"YB02_610101_000_1_scale\": 100.0,\n" +
                "\t\t\"YB02_610101_000_1_scaleFactor\": 0.0,\n" +
                "\t\t\"YB02_999998_000_2_scale\": 100.0,\n" +
                "\t\t\"YB02_999998_000_2_scaleFactor\": 100.0,\n" +
                "\t\t\"BS01_calcBase\": 4785.71,\n" +
                "\t\t\"BS01_999998_000_1_scale\": -100.0,\n" +
                "\t\t\"BS01_999998_000_1_scaleFactor\": -100.0\n" +
                "\t},\n" +
                "\t\"cum_info\": [],\n" +
                "\t\"cum_elem_data\": {\n" +
                "\t\t\"medBizType\": \"21\",\n" +
                "\t\t\"fixmedinsNo\": \"H51019802819\",\n" +
                "\t\t\"admDate\": \"20211230\",\n" +
                "\t\t\"diseNo\": \"\",\n" +
                "\t\t\"dscgDate\": \"20220101\",\n" +
                "\t\t\"medTrtType\": \"210\"\n" +
                "\t}\n" +
                "}");
        JSONArray payInfo = (JSONArray) jsonObject.get("pay_info");
        List<PayInfoDTO> payInfoDTOS = payInfo.toJavaList(PayInfoDTO.class);
        Map<String, List<BigDecimal>> resultMap = payInfoDTOS.stream()
                .filter(payInfoDTO1 -> PAY_RSLT_TYPE.contains(payInfoDTO1.getPayRsltType()))
                .collect(groupingBy(PayInfoDTO::getPayRsltType, mapping(PayInfoDTO::getFeeSumamt, toList())));
        resultMap.forEach((s, bigDecimals1) -> System.out.println(s + ",金额为：" + bigDecimals1.stream().reduce(BigDecimal::add).get()) );

    }
}
