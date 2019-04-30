package meghanemiles.midlandstech.xmlapplication;
import android.icu.util.Output;
import android.os.AsyncTask;

import android.widget.Toast;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ParseTask extends AsyncTask<String, Void, ArrayList<Countries>> {
    private MainActivity activity;
    HttpURLConnection httpURLConnection;
    URL url = null;
    Map params = new HashMap<>();


    public ParseTask( MainActivity fromActivity ) {
        activity = fromActivity;
        params.put("messagep", "IST235message");
    }

    protected ArrayList<Countries> doInBackground( String... urls  ) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SAXHandler handler = new SAXHandler();
            url = new URL("https://student.mtc-ist.com/~martin/235/countries.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            StringBuffer requestParams = new StringBuffer();
            connection.setDoOutput(true);

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(requestParams.toString());
            writer.flush();
            connection.connect();
            saxParser.parse( urls[0], handler );
            return handler.getCountries( );
        } catch( Exception e )  {
            Toast.makeText( activity, "Sorry - There was a problem parsing",
                    Toast.LENGTH_LONG ).show( );
            return null;
        }
    }

    protected void onPostExecute ( ArrayList<Countries> returnedCountries ) {
        activity.displayList( returnedCountries );
    }
}
