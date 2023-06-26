package com.dev.example.marvelconsumer;

import org.springframework.web.client.RestTemplate;
import com.dev.example.marvelconsumer.models.MarvelData;
import com.dev.example.marvelconsumer.models.MarvelResponse;
import com.dev.example.marvelconsumer.utils.HashUtil;
import com.dev.example.marvelconsumer.utils.HashType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
* @author Mauricio González
* 
*/
public class MarvelApiClient {
    private String baseUrl, apiKey, privateKey, timestamp;
    private Integer limit, offset, characterId;

    private final RestTemplate restTemplate;

    /**
     * @param baseUrl
     * @param apiKey
     * @param privateKey
     * @param timestamp
     */
    public MarvelApiClient(String baseUrl, String apiKey, String privateKey, String timestamp) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.privateKey = privateKey;
        this.timestamp = timestamp;
        this.restTemplate = new RestTemplate();
    }

    /**
     * @param baseUrl
     * @param apiKey
     * @param privateKey
     * @param timestamp
     * @param characterId
     */
    public MarvelApiClient(String baseUrl, String apiKey, String privateKey, String timestamp, int characterId) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.privateKey = privateKey;
        this.timestamp = timestamp;
        this.characterId = characterId;
        this.restTemplate = new RestTemplate();
    }

    /**
     * @param baseUrl
     * @param apiKey
     * @param privateKey
     * @param timestamp
     * @param limit
     * @param offset
     */
    public MarvelApiClient(String baseUrl, String apiKey, String privateKey, String timestamp,
        int limit, int offset) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.privateKey = privateKey;
        this.timestamp = timestamp;
        this.limit = limit;
        this.offset = offset;
        this.restTemplate = new RestTemplate();
    }

    /**
     * @return data response
     * @throws Exception 
     */
    public MarvelData getCharacterData() throws Exception {
        MarvelData response = null;
        try {
            String body = restTemplate.getForObject(buildUrlRequest(), String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            MarvelResponse map = objectMapper.readValue(body, MarvelResponse.class);
            response = map.getData();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return response;
    }

    /**
     * @return full consumer url
     */
    public String buildUrlRequest() {
        String url = this.baseUrl;
        if (this.characterId != null) {
            url = url.concat("/").concat(this.characterId.toString()) +
                "?apikey=" + this.apiKey + "&ts=" + this.timestamp + "&hash=" + generateHash();
        } else {
            url = url + "?apikey=" + this.apiKey + "&ts=" + this.timestamp + "&hash=" + generateHash();
            if (this.limit != null) {
                url = url.concat("&limit=").concat(this.limit.toString());
            }
            if (this.offset != null) {
                url = url.concat("&offset=").concat(this.offset.toString());
            }
        }
        return url;
    }

    /**
     * @return marvel hash
     */
    private String generateHash() {
        return HashUtil.getHash(this.timestamp.concat(this.privateKey)
            .concat(this.apiKey), HashType.MD5);
    }
    
}
