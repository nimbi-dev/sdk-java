package br.com.nimbi.sdk.api;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import br.com.nimbi.sdk.Callable;
import br.com.nimbi.sdk.NimbiClient;

/**
 * Java wrapper for Nimbi API <b>PurchaseOrder</b>.
 * 
 * @see <a href="https://nim.bi/api">https://nim.bi/api</a>
 * @author jpmo22
 * 
 */
public class PurchaseOrder extends Callable {

    private static final SimpleDateFormat SDF = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss'Z'" );

    /**
     * @param client
     *            Defines environment and access key for Nimbi APIs.
     */
    public PurchaseOrder( final NimbiClient client ) {
        super( client );
    }

    /**
     * @param initialDate
     *            Updated Purchase from the Initial Date until the Final Date
     * @param finalDate
     *            Updated Purchase FinalDate to the Initial Date
     * @param orderStatusId
     *            1=Draft; 2=Pending Approval; 3=Approved - Waiting Accept; 4=Returned; 5=Canceled;
     *            6=Approved - Accepted; 7=Returned - Supplier.
     * @param codeERP
     *            Code ERP.
     * @param offset
     *            Page to be displayed
     * @param queryLimit
     *            Total number of line to be displayed per page
     * @return A JSON representation of a list of Purchase Orders resources.
     * @throws IOException
     *             if any unexpected error occurs.
     */
    public Response getV3( final Date initialDate, final Date finalDate, final int orderStatusId,
            final String codeERP, final int offset, final int queryLimit ) throws IOException {
        final OkHttpClient client = new OkHttpClient();

        final StringBuilder sb =
                new StringBuilder( "/API/rest/PurchaseOrder/v3?offset=" ).append( offset );
        if ( initialDate != null && finalDate != null ) {
            sb.append( "&InitialDate=" ).append( SDF.format( initialDate ) );
            sb.append( "&FinalDate=" ).append( SDF.format( finalDate ) );
        }

        if ( orderStatusId > 0 ) {
            sb.append( "&OrderStatusId=" ).append( orderStatusId );
        }

        if ( codeERP != null && codeERP != "" ) {
            sb.append( "&CodeERP=" ).append( codeERP );
        }

        if ( queryLimit > 0 ) {
            sb.append( "&QueryLimit=" ).append( queryLimit );
        }

        final Request request = getBuilder().url( getHost() + sb.toString() ).get().build();

        final Response response = client.newCall( request ).execute();
        return response;
    }

}
