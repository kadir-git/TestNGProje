package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    //ConfigurationReader class'ini projemizin her yerinden nesne üretmeden,
    //miras almadan kullanabilecek sekilde tasarlayalim.

    //ststic: program calisir calismaz, bellekte yer tutmaya yarayan keyword
    static Properties properties;

    static {
        //okumak istenen configuration.properties file'inin dosya yolu
        String path = "configuration.properties";

        //dene - hata varsa yakala
        //bu islemi DENE eger hata alirsan, Programi DURDURMA
        try{
            //okumak istenen dosyanin path(adresi)i yazilir
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            //FileInputStream'dan üretilen file dosyasi burada, kullanilabilir
            properties.load(file);
        }catch (Exception e){

        }
    }

    //properties.getProperty("username"); --> yazilirsa manager2 return edilir
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    //ConfigurationReader.getProperty("fb_email") --> hamza@techproed.com

}
