package com.hondent.bafen.cooweather.util;

import android.text.TextUtils;

import com.hondent.bafen.cooweather.db.CoolWeatherDB;
import com.hondent.bafen.cooweather.model.City;
import com.hondent.bafen.cooweather.model.County;
import com.hondent.bafen.cooweather.model.Province;

/**
 * Created by bafen on 2017/1/1.
 */
public class Utility {
    public  synchronized  static boolean handleProvincesResponse(CoolWeatherDB db, String response){
        if(!TextUtils.isEmpty(response)){
            String[] allProvinces = response.split(",");
            if(allProvinces!=null&&allProvinces.length>0){
                for(String p:allProvinces){
                    String[] array = p.split("|");
                    Province province= new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    db.saveProvice(province);
                    return true;
                }
            }
        }
        return false;
    }
    public  synchronized  static boolean handleCitisResponse(CoolWeatherDB db, String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            String[] allCities = response.split(",");
            if(allCities!=null&&allCities.length>0){
                for(String p:allCities){
                    String[] array = p.split("|");
                    City city= new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    db.saveCity(city);
                    return true;
                }
            }
        }
        return false;
    }
    public  synchronized  static boolean handleCountisResponse(CoolWeatherDB db, String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            String[] allCounties = response.split(",");
            if(allCounties!=null&&allCounties.length>0){
                for(String p:allCounties){
                    String[] array = p.split("|");
                    County county= new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    db.saveCounty(county);
                    return true;
                }
            }
        }
        return false;
    }
}
