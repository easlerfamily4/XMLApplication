package meghanemiles.midlandstech.xmlapplication;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SAXHandler extends DefaultHandler {
    private boolean validText;
    private String element = "";
    private Countries currentCountry;
    private ArrayList<Countries> countries;

    public SAXHandler( ) {
        validText = false;
        countries = new ArrayList<Countries>( );
    }

    public ArrayList<Countries> getCountries( ) { return countries; }

    public void startElement( String uri, String localName,
                              String startElement, Attributes attributes )
            throws SAXException {
        validText = true;
        element = startElement;
        if( startElement.equals( "country" ) ) // start current item
            currentCountry = new Countries( "", "" );
    }

    public void endElement( String uri, String localName,
                            String endElement ) throws SAXException {
        validText = false;
        if( endElement.equals( "country" ) ) // add current item to items
            countries.add( currentCountry );
    }

    public void characters( char ch [], int start,
                            int length ) throws SAXException {
        if( currentCountry != null && element.equals( "name" ) && validText )
            currentCountry.setName( new String( ch, start, length ) );
        else if( currentCountry != null && element.equals( "population" ) && validText )
            currentCountry.setPopulation( new String( ch, start, length ) );
    }
}
