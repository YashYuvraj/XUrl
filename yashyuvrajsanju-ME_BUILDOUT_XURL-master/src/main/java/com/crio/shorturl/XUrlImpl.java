package com.crio.shorturl;
import java.util.*;
public class XUrlImpl implements XUrl
{
    Map<String,String> longToShort;
    Map<String,Integer> count;

    public XUrlImpl()
    {
        longToShort=new HashMap<>();
        count=new HashMap<>();
    }

    public String registerNewUrl(String longUrl)
    {
      if(longToShort.containsKey(longUrl))
      return longToShort.get(longUrl);
      else
      {
        String res="http://short.url/";
        res+=getAlphaNumericString(9);
        longToShort.put(longUrl,res);
      }
      return longToShort.get(longUrl);
    }

    public String registerNewUrl(String longUrl, String shortUrl)
    {
      if(longToShort.containsValue(shortUrl))
      return null;
      else
      {
        longToShort.put(longUrl,shortUrl);
      }
      return shortUrl;
    }

    public String getUrl(String shortUrl)
    {
      if(longToShort.containsValue(shortUrl))
    {
      for(Map.Entry<String,String> entry: longToShort.entrySet())
      {
        if(entry.getValue().equals(shortUrl))
        {
          count.put(entry.getKey(),count.getOrDefault(entry.getKey(), 0)+1);
          return entry.getKey();
        }
      }
    }
    return null;
    }

    public Integer getHitCount(String longUrl)
    {
      if(count.containsKey(longUrl))
       return count.get(longUrl);
       return 0;
    }

    public String delete(String longUrl)
    {
      String st=longToShort.get(longUrl);
      longToShort.remove(longUrl);
      return st;
    }


 public String getAlphaNumericString(int n)
 {
  // chose a Character random from this String
  String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
         + "0123456789"
         + "abcdefghijklmnopqrstuvxyz";
  // create StringBuffer size of AlphaNumericString
  StringBuilder sb = new StringBuilder(n);
 
  for (int i = 0; i < n; i++) {
 
   // generate a random number between
   // 0 to AlphaNumericString variable length
   int index
    = (int)(AlphaNumericString.length()
      * Math.random());
 
   // add Character one by one in end of sb
   sb.append(AlphaNumericString
      .charAt(index));
  }
  return sb.toString();
}
}