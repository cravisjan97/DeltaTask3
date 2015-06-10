package com.example.cravisundaram.parsexml;

import android.app.Activity;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class MainActivity extends Activity {
    ListView lv;
    Thread thread;
    String[] info;
    ArrayAdapter<String> adapter;
    String url = "http://api.openweathermap.org/data/2.5/weather?q=bangalore&mode=xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.listView);
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                try {
                    URL website = new URL(url);
                    SAXParserFactory spf = SAXParserFactory.newInstance();
                    SAXParser sp = spf.newSAXParser();
                    XMLReader xr = sp.getXMLReader();
                    xmlparser x = new xmlparser();
                    xr.setContentHandler(x);

                    xr.parse(new InputSource(website.openStream()));

                    info = x.getinfo();

                    setList(lv, info);
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();

                } catch (ParserConfigurationException e2) {
                    e2.printStackTrace();
                }


            }

        });
        thread.start();
    }
    private void setList(final ListView list,final String[] value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,value);
            list.setAdapter(adapter);
            }
        });
    }
}


