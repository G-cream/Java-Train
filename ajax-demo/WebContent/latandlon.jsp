<%@page import="javax.json.JsonValue"%>
<%@page import="javax.json.JsonArray"%>
<%@page import="java.io.InputStream"%>
<%@page import="javax.json.JsonObject"%>
<%@page import="javax.json.Json"%>
<%@page import="javax.json.JsonReader"%>
<%@page import="java.io.InputStreamReader" %>
<%@page import="java.net.URL" %>

<%
String cityName = "";
String openWeatherMapKey = "d2556fe61a50b26d9c0fe14fcead7930";
String latitude = request.getParameter("lat");
String longitude = request.getParameter("lon");
String requestString = "https://api.openweathermap.org/data/2.5/find?lat="
        + latitude + "&lon=" + longitude
        + "&cnt=" + "10"
        + "&appid=" + openWeatherMapKey;

InputStreamReader inputReader = null;
JsonReader jReader = null;
try
{
	URL url = new URL(requestString);
	InputStream is = url.openStream();
	inputReader = new InputStreamReader(is);
	jReader = Json.createReader(inputReader);
	
	JsonObject unionObject = jReader.readObject();

	JsonArray cityArray = unionObject.getJsonArray("list");
	String result = "";
	for (int i = 0; i != cityArray.size(); ++i)
	{
		cityName = cityArray.getJsonObject(i).getString("name");
		result += cityName + " ";
	}
	out.println(result);
}
catch(Exception e)
{
	out.println("Invalid Latitude or Longitude!");
}
finally
{
	if(inputReader != null)
		inputReader.close();
	if(jReader != null)
		jReader.close();
}
%>