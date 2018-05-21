package br.com.nimbi.sdk;

import okhttp3.Request;

/**
 * A class to enhance all API calls with API keys.
 * 
 * @author jpmo22
 */
public class Callable {

    private final Request.Builder builder;

    private final NimbiClient client;

    /**
     * @param client
     *            The Nimbi client.
     */
    public Callable( final NimbiClient client ) {
        super();
        this.client = client;
        this.builder =
                new Request.Builder().addHeader( NimbiClient.API_ID, this.client.getApiId() )
                        .addHeader( NimbiClient.API_KEY, this.client.getApiKey() );
    }

    /**
     * @return Enhanced request builder with Nimbi client
     */
    public Request.Builder getBuilder() {
        return this.builder;
    }

    /**
     * @return The environment.
     */
    public String getHost() {
        return this.client.getEnvironment().getHost();
    }
}
