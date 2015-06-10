package com.example.cravisundaram.parsexml;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.jar.Attributes;

/**
 * Created by C RAVI SUNDARAM on 10-06-2015.
 */
public class xmlparser extends DefaultHandler {
    datastored d=new datastored();

    public String[] getinfo()
    {
        return d.info();
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if(localName.equals("city"))
        {
            String city=attributes.getValue("name");
            d.setcity(city);

        }
        else if(localName.equals("temperature"))
        {
            String temp=attributes.getValue("value");
            d.settemp(temp);
        }
        else if(localName.equals("humidity"))
        {
            String h=attributes.getValue("value");
            d.setHumidity(h);
        }
        else if(localName.equals("pressure"))
        {
            String p=attributes.getValue("value");
            d.setPressure(p);
        }
        else if(localName.equals("speed"))
        {
            String ws=attributes.getValue("name");
            d.setWindspeed(ws);
        }
        else if(localName.equals("precipitation"))
        {
            String pre=attributes.getValue("mode");
            d.setPrec(pre);
        }
        else if(localName.equals("weather"))
        {
            String nc=attributes.getValue("value");
            d.setNcloud(nc);
        }

    }
}
