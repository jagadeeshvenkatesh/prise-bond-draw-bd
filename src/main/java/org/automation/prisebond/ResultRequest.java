package org.automation.prisebond;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shantonu on 5/17/2021
 */
public class ResultRequest {
    private static Document doc;
    private static String no;
    public static String BASE_URL="www.bb.org.bd";
    public static String PATH="/investfacility/prizebond/searchPbond.php";
    public static String USER_AGENT_CHROME="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36";
    public static String ACCEPT= "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9";
    public static String ACCEPT_ENCODING= "gzip, deflate, br";

    public static String check(final String prise_bond_no) throws IOException {
        URL url = new URL("https://"+BASE_URL+PATH+"?txtNumbers="+prise_bond_no);
        doc = Jsoup.parse(url,3000);
        Element message = doc.select(".asteriskRed").first();
        no=prise_bond_no;
        return processResults(message.wholeText());
    }
    private static String processResults(final String status){
        if(status.contains("No match")){
            return status;
        }
        else {
            Element table= doc.select("table").first();
            Elements rows = table.select("tr");
            String result = "";
            for (int i = 1; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements cols = row.select("td");
                result = "!!!Congratulation!!!, "+no+" NO has won "+cols.get(2).text()+" of BDT "+cols.get(3).text();
            }

            return result;
        }
    }
}
