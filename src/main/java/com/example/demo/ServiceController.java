package com.example.demo;

import static com.example.demo.constant.Constants.*;
import com.example.demo.model.WeatherReport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController

public class ServiceController {

    @RequestMapping(value = "/AjaxForWeatherRestApi", method = RequestMethod.POST)
    Map<String, String> getWhetherData(){

        //logger.info("AJAX call is comming for whether report request !!");

		/*RestTemplate restTemplate = new RestTemplate();
		WeatherReport weather = restTemplate.getForObject(WEATHER_URI,
				WeatherReport.class);
*/
        /* SINCE  Provided API ("http://api.openweathermap.org/data/2.5/weather?q=bangalore&appid=44db6a862fba0b067b1930da0d769e98")
         * is not working we need , I am just providing the json Data in form of a .json file and
         *
         *  */

        //ObjectMapper mapper = new ObjectMapper();
        //WeatherReport weather;
        //try {
        //weather = mapper.readValue(new File("jsonFile.json"), WeatherReport.class);
        RestTemplate restTemplate = new RestTemplate();
        WeatherReport weather = restTemplate.getForObject(WEATHER_URI,
                WeatherReport.class);

        Map<String, String> mapVal = new HashMap<>();
        mapVal.put(NAME, weather.getName());
        mapVal.put(LON, weather.getCoord().getLon().toString());
        mapVal.put(LAT, weather.getCoord().getLat().toString());
        mapVal.put(DESCRIPTION, weather.getWeather().get(0).getDescription());

        return mapVal;

		/*} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/


        //return null;
    }

	/*@RequestMapping(value = "/AjaxForDBData", method = RequestMethod.GET)
	List<Brand> getDBData() {

		logger.info("AJAX call is comming for MongoDB Data request !!");

		return brandRepo.findAll();
	}*/
}
