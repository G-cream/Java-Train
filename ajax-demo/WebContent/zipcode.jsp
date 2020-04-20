<%@page import="java.io.InputStream"%>
<%@page import="javax.json.JsonObject"%>
<%@page import="javax.json.Json"%>
<%@page import="javax.json.JsonReader"%>
<%@page import="java.io.InputStreamReader" %>
<%@page import="java.net.URL" %>

<%
String minTemp = "";
String maxTemp = "";
String cityName = "";
String openWeatherMapKey = "d2556fe61a50b26d9c0fe14fcead7930";
String zipCode = request.getParameter("zip");
String requestString = "https://api.openweathermap.org/data/2.5/weather?zip="
        + zipCode + "," + "us"
        + "&appid=" + openWeatherMapKey;

InputStreamReader inputReader = null;
JsonReader jReader = null;
try
{
	URL url = new URL(requestString);
	InputStream is = url.openStream();
	inputReader = new InputStreamReader(is);
	jReader = Json.createReader(inputReader);
	
	JsonObject weatherObject = jReader.readObject();
	JsonObject mainObject = weatherObject.getJsonObject("main");
	
	minTemp = mainObject.getJsonNumber("temp_min").toString();
	maxTemp = mainObject.getJsonNumber("temp_max").toString();
	cityName = weatherObject.getString("name");
	String result = "min temp: " + minTemp
			+ " max temp: " + maxTemp
			+ " city name: " + cityName;
	out.println(result);
}
catch(Exception e)
{
	out.println("Invalid Zipcode!");
}
finally
{
	if(inputReader != null)
		inputReader.close();
	if(jReader != null)
		jReader.close();
}
%>