package sample;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class StatProvider implements StatSupplier {

    @Override
    public Profile get(String company) {

        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-profile?symbol="+company+"&region=US")
                     .header("x-rapidapi-key", "")
                     .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                     .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        assert response != null;
        JSONObject body = response.getBody().getObject();

        String companyName = body.getJSONObject("price").getString("longName");
        String sharePrice = body.getJSONObject("price").getJSONObject("regularMarketPrice").getString("fmt");
        String marketOpen = body.getJSONObject("price").getJSONObject("regularMarketOpen").getString("fmt");
        String previousClose = body.getJSONObject("price").getJSONObject("regularMarketPreviousClose").getString("fmt");
        String volume = body.getJSONObject("price").getJSONObject("regularMarketVolume").getString("fmt");
        String marketCap = body.getJSONObject("price").getJSONObject("marketCap").getString("fmt");
        String marketChange = body.getJSONObject("price").getJSONObject("regularMarketChange").getString("fmt");

        return new Profile(companyName,sharePrice,marketOpen,previousClose,volume,marketCap,marketChange);
    }

    @Override
    public Profile get() {
        return null;
    }
}
