package com.example.cravisundaram.parsexml;

/**
 * Created by C RAVI SUNDARAM on 10-06-2015.
 */
public class datastored {
    String city,prec,ncloud;
    String temp,windspeed;
    String humidity,pressure;
    public void setcity(String c)
    {
        this.city=c;
    }
    public void settemp(String t)
    {
        this.temp=t;
    }
    public void setHumidity(String h)
    {
        this.humidity=h;

    }
    public void setPressure(String p)
    {
        this.pressure=p;
    }
    public void setPrec(String p)
    {
        this.prec=p;
    }
    public void setNcloud(String c)
    {
        this.ncloud=c;
    }
    public  void setWindspeed(String w)
    {
        this.windspeed=w;
    }
    public String[] info()
    {
        String[] weather= new String[]{"City : "+city,"Temperature : "+temp+" K","Humidity : "+humidity+" %","Pressure : "+pressure+" hPa","Precipitation : "+prec,"Nature of Cloud : "+ncloud,"Wind Speed : "+windspeed};
        return weather;
    }
}
