package org.automation.prisebond;


import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static org.automation.prisebond.AppProperties.*;

/**
 * Created by shantonu on 5/16/2021
 *
 * GET : https://www.bb.org.bd/investfacility/prizebond/searchPbond.php?txtNumbers=0437535
 */
public class ApacheClient {

    public static String check(final String prise_bond_no) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("https://"+BASE_URL+PATH+"?txtNumbers="+prise_bond_no);
        get.addHeader(HttpHeaders.USER_AGENT,USER_AGENT_CHROME);
        get.addHeader(HttpHeaders.ACCEPT,ACCEPT);
        get.addHeader(HttpHeaders.ACCEPT_ENCODING,ACCEPT_ENCODING);
        CloseableHttpResponse response = client.execute(get);
        return ResultParser.parse(response.getEntity());
    }


}
