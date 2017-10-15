import it.melo.GdaxService;
import it.melo.data.Account;

import java.io.IOException;
import java.util.List;

/**
 * Created by melo on 14/10/17.
 */
public class Main {

    public static void main(String[] argv) throws IOException {
        String apiKey="";
        String apiSecret = "";
        String passPhrase ="";
        GdaxService service = new GdaxService(apiKey,apiSecret,passPhrase);
        List<Account> accounts= service.getAccounts();
        for (Account acc :accounts){
            System.out.println(service.getAccountHolds(acc.getId()));
            System.out.println(service.getAccountHistory(acc.getId()).toString());
        }
    }
}
