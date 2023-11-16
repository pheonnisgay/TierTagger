package de.cooltechno.tiertagger.mctiers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.UUID;

public class GetTier {

    public String getTier(UUID uuid) {
        try {
            URL url = new URL("https://mctiers.com/api/rankings/" + uuid);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                return "User not found";
            }

            StringBuilder inline = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    inline.append(line);
                }
            }

            JSONParser parser = new JSONParser();
            JSONObject tierData = (JSONObject) parser.parse(inline.toString());

            JSONObject vanillaData = (JSONObject) tierData.get("vanilla");
            long tier = (long) vanillaData.get("tier");
            long pos = (long) vanillaData.get("pos");

            String tierString = pos == 0 ? "HT" : "LT";

            return tierString + tier;
        } catch (MalformedURLException | ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
