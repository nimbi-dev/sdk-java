package br.com.nimbi.sdk.api;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import br.com.nimbi.sdk.Callable;
import br.com.nimbi.sdk.NimbiClient;

public class ConectivityTest extends Callable {

    public ConectivityTest( final NimbiClient client ) {
        super( client );
    }

    public Response testConectivity() throws IOException {
        final OkHttpClient client = new OkHttpClient();

        final Request request =
                getBuilder().get()
                        .url( getHost() + "/API/rest/ConnectivityTest/v1/TestConnectivity" )
                        .build();

        final Response response = client.newCall( request ).execute();
        return response;
    }

}
