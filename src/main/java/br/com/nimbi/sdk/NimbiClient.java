package br.com.nimbi.sdk;

/**
 * A client to connect with Nimbi API.
 * 
 * @author jpmo22
 * 
 */
public class NimbiClient {

    /**
     * HTTP Header name for API ID.
     */
    public static final String API_ID = "ClientAPI_ID";

    /**
     * HTTP Header name for API Key.
     */
    public static final String API_KEY = "ClientAPI_Key";

    /**
     * Available environments for Nimbi APIs.
     * 
     * @author jpmo22
     */
    public enum Environment {

        /**
         * Quality and Assurance environment.
         */
        QA( "https://api01-qa.nimbi.net.br" ),

        /**
         * Production environment.
         */
        PRODUCTION( "https://api001.nimbi.com.br" );

        private Environment( final String host ) {
            this.host = host;
        }

        private String host;

        /**
         * @return Environment host.
         */
        public String getHost() {
            return this.host;
        }
    }

    private final String apiId;

    private final String apiKey;

    private final Environment environment;

    /**
     * @param environment
     *            The target environment.
     * @param apiId
     *            The API ID.
     * @param apiKey
     *            The API Key.
     */
    public NimbiClient( final Environment environment, final String apiId, final String apiKey ) {
        super();
        this.environment = environment;
        this.apiId = apiId;
        this.apiKey = apiKey;
    }

    /**
     * @return The API ID.
     */
    public String getApiId() {
        return this.apiId;
    }

    /**
     * @return The API Key.
     */
    public String getApiKey() {
        return this.apiKey;
    }

    /**
     * @return The environment.
     */
    public Environment getEnvironment() {
        return this.environment;
    }

}
