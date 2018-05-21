package br.com.nimbi.sdk;

import okhttp3.Request;

public class Callable {

    private Request.Builder builder;

    private NimbiClient client;

    private Callable() {

    }

    public Callable( final NimbiClient client ) {
        this.client = client;
        this.builder =
                new Request.Builder().addHeader( NimbiClient.ID, client.getApiId() ).addHeader(
                        NimbiClient.KEY, client.getApiKey() );
    }

    public Request.Builder getBuilder() {
        return this.builder;
    }

    public String getHost() {
        return this.client.getEnvironment().getHost();
    }
}
