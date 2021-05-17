package org.automation.prisebond;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by shantonu on 5/16/2021
 * https://www.bb.org.bd/investfacility/prizebond/searchPbond.php?txtNumbers=0437535
 */
public class App {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> ids = BondNoReader.read();
        for(String id : ids){
            System.out.println(id+" : >>> : "+DrawResultRequest.check(id));
        }
    }
}
