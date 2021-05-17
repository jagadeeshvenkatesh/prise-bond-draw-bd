package org.automation.prisebond;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by shantonu on 5/17/2021
 */
public class ResultParser {
    public static String parse(Document doc){
        String result = "";
        Element message = doc.select(".asteriskRed").first();
        String status = message.wholeText();
        if(status.contains("No match")){
            return status;
        }
        else {
            Element table= doc.select("table").first();
            Elements rows = table.select("tr");
            for (int i = 1; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements cols = row.select("td");
                result = "!!!Congratulation!!!, "+cols.get(0).text()+" NO has won "+cols.get(2).text()+" of BDT "+cols.get(3).text();
            }
            return result;
        }

    }
    public static String parse(HttpEntity entity) throws IOException {
        return parse(Jsoup.parse(EntityUtils.toString(entity)));
    }


}
