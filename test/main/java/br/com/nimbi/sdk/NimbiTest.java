package br.com.nimbi.sdk;

import java.io.IOException;

import okhttp3.Response;

import org.junit.Assert;
import org.junit.Test;

import br.com.nimbi.sdk.NimbiClient.Environment;
import br.com.nimbi.sdk.api.ConnectivityTest;

/**
 * A simple JUnit Test for Java Wrapper Nimbi API.
 * 
 * @author jpmo22
 */
public class NimbiTest extends Assert {

    /**
     * Testing an invalid ClientAPI_ID and ClientAPI_Key call.
     * 
     * @throws IOException
     *             if any unexpected error occurs.
     */
    @Test
    public void testConectivity() throws IOException {

        final NimbiClient client =
                new NimbiClient( Environment.QA, "[some_client_api_id]", "[some_client_api_key]" );

        final ConnectivityTest connectivityTest = new ConnectivityTest( client );
        final Response response = connectivityTest.testConnectivity();
        assertEquals(
                "{\"Errors\":[\"Invalid API Key. ([some_client_api_key])\"],\"StatusCode\":400}",
                response.body().string() );
    }

}
