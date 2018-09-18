package com.example.demo;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.FileItem;
import com.alipay.api.request.ZhimaDataBatchFeedbackRequest;
import com.alipay.api.response.ZhimaDataBatchFeedbackResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","GBK","alipay_public_key","RSA2");
        ZhimaDataBatchFeedbackRequest request = new ZhimaDataBatchFeedbackRequest();
        request.setFileCharset("UTF-8");
        request.setColumns("user_name,user_credentials_type,user_credentials_no,order_no,biz_type,order_status,create_amt,pay_month,gmt_ovd_date,overdue_cnt");
        FileItem File = new FileItem("C:/Downloads/ooopic_963991_7eea1f5426105f9e6069/16365_1271139700.jpg");
        request.setFile(File);
        request.setFileType("json_data");
        request.setRecords("100");
        request.setBizExtParams("{'extparam1':'value1'}");
        request.setPrimaryKeyColumns("order_no,pay_month");
        request.setFileDescription("文件描述信息1");
        ZhimaDataBatchFeedbackResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }

    }

}
