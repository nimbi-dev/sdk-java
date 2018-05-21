package br.com.nimbi.sdk.api;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import br.com.nimbi.sdk.Callable;
import br.com.nimbi.sdk.NimbiClient;

/**
 * Java wrapper for Nimbi API <b>ConectivityTest</b>.
 * 
 * @see <a href="https://nim.bi/api">https://nim.bi/api</a>
 * @author jpmo22
 * 
 */
public class ConnectivityTest extends Callable {

    /**
     * @param client
     *            Defines environment and access key for Nimbi APIs.
     * 
     */
    public ConnectivityTest( final NimbiClient client ) {
        super( client );
    }

    /**
     * @return A JSON representation of the current client basic info.
     * @throws IOException
     *             if any unexpected error occurs.
     */
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
