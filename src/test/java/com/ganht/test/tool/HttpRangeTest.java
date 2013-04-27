package com.ganht.test.tool;


import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ganhaitian
 * Date: 13-4-27
 * Time: 下午10:22
 * To change this template use File | Settings | File Templates.
 */
public class HttpRangeTest {


    @Test()
    public void testJettyRangeHeader(){
        HttpClient httpClient = new HttpClient();
        GetMethod get = new GetMethod("http://localhost:8080/rangetest/stdout.log");

        get.addRequestHeader("Range","bytes=100000-");

        int responseCode =  0;

        try {
            responseCode = httpClient.executeMethod(get);
            System.out.println(responseCode);

            for(Header h:get.getResponseHeaders()){
                System.out.println(h.getName()+" : "+h.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
