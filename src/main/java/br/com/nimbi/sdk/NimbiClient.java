package br.com.nimbi.sdk;

public class NimbiClient {

    public static final String ID = "ClientAPI_ID";

    public static final String KEY = "ClientAPI_Key";

    public enum Environment {

        QA( "https://api01-qa.nimbi.net.br" ),
        PRODUCTION( "https://api001.nimbi.com.br" );

        private Environment( final String host ) {
            this.host = host;
        }

        private String host;

        public String getHost() {
            return this.host;
        }
    }

    private String apiId;

    private String apiKey;

    private Environment environment;

    private NimbiClient() {
        super();
    }

    private NimbiClient( final Environment environment, final String apiId, final String apiKey ) {
        super();
        this.environment = environment;
        this.apiId = apiId;
        this.apiKey = apiKey;
    }

    public String getApiId() {
        return this.apiId;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public Environment getEnvironment() {
        return this.environment;
    }

}
