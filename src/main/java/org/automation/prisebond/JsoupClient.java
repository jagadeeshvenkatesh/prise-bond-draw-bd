package org.automation.prisebond;

import org.jsoup.Jsoup;
import java.io.IOException;
import java.net.URL;

import static org.automation.prisebond.AppProperties.*;

/**
 * Created by shantonu on 5/17/2021
 */
public class JsoupClient {
    public static String check(final String prise_bond_no) throws IOException {
        URL url = new URL("https://"+BASE_URL+PATH+"?txtNumbers="+prise_bond_no);
       return ResultParser.parse(Jsoup.parse(url,3000));
    }

}
