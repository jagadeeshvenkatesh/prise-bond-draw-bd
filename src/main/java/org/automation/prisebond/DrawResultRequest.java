package org.automation.prisebond;


import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by shantonu on 5/16/2021
 *
 * GET : https://www.bb.org.bd/investfacility/prizebond/searchPbond.php?txtNumbers=0437535
 */
public class DrawResultRequest {
    public static String BASE_URL="www.bb.org.bd";
    public static String PATH="/investfacility/prizebond/searchPbond.php";
    public static String USER_AGENT_CHROME="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36";
    public static String ACCEPT= "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9";
    public static String ACCEPT_ENCODING= "gzip, deflate, br";
    public static String check(final String prise_bond_no) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("https://"+BASE_URL+PATH+"?txtNumbers="+prise_bond_no);
        get.addHeader(HttpHeaders.USER_AGENT,USER_AGENT_CHROME);
        get.addHeader(HttpHeaders.ACCEPT,ACCEPT);
        get.addHeader(HttpHeaders.ACCEPT_ENCODING,ACCEPT_ENCODING);
        CloseableHttpResponse response = client.execute(get);
        return EntityUtils.toString(response.getEntity());
    }

}
