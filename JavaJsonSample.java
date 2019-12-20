import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;


public class JavaJsonSample {
	public static void main(String[] argv) {
		String jsonSample = "{" +
				"	\"daily-values\": {" +
				"		\"total-fat\": {" +
				"			\"units\": \"g\"," +
				"			\"text\": 65," +
				"			\"translated\": 1234567890123456789.5" +
				"		}," +
				"		\"saturated-fat\": {" +
				"			\"units\": \"g\"," +
				"			\"text\": 20" +
				"		}," +
				"		\"cholesterol\": {" +
				"			\"units\": \"mg\"," +
				"			\"text\": 300" +
				"		}," +
				"		\"sodium\": {" +
				"			\"units\": \"mg\"," +
				"			\"text\": 2400" +
				"		}," +
				"		\"carb\": {" +
				"			\"units\": \"g\"," +
				"			\"text\": 300" +
				"		}," +
				"		\"fiber\": {" +
				"			\"units\": \"g\"," +
				"			\"text\": 25" +
				"		}," +
				"		\"protein\": {" +
				"			\"units\": \"g\"," +
				"			\"text\": 50" +
				"		}" +
				"	}," +
				"	\"food\": [" +
				"		{" +
				"			\"name\": \"Avocado Dip\"," +
				"			\"mfr\": \"Sunnydale\"," +
				"			\"serving\": {" +
				"				\"units\": \"g\"," +
				"				\"text\": \"29\"" +
				"			}," +
				"			\"calories\": {" +
				"				\"total\": \"110\"," +
				"				\"fat\": \"100\"" +
				"			}," +
				"			\"total-fat\": \"11\"," +
				"			\"saturated-fat\": \"3\"," +
				"			\"cholesterol\": \"5\"," +
				"			\"sodium\": \"210\"," +
				"			\"carb\": \"2\"," +
				"			\"fiber\": \"0\"," +
				"			\"protein\": \"1\"," +
				"			\"vitamins\": {" +
				"				\"a\": \"0\"," +
				"				\"c\": \"0\"" +
				"			}," +
				"			\"minerals\": {" +
				"				\"ca\": \"0\"," +
				"				\"fe\": \"0\"" +
				"			}" +
				"		}," +
				"		{" +
				"			\"name\": \"Bagels, New York Style\"," +
				"			\"mfr\": \"Thompson\"," +
				"			\"serving\": {" +
				"				\"units\": \"g\"," +
				"				\"text\": \"104\"" +
				"			}," +
				"			\"calories\": {" +
				"				\"total\": \"300\"," +
				"				\"fat\": \"35\"" +
				"			}," +
				"			\"total-fat\": \"4\"," +
				"			\"saturated-fat\": \"1\"," +
				"			\"cholesterol\": \"0\"," +
				"			\"sodium\": \"510\"," +
				"			\"carb\": \"54\"," +
				"			\"fiber\": \"3\"," +
				"			\"protein\": \"11\"," +
				"			\"vitamins\": {" +
				"				\"a\": \"0\"," +
				"				\"c\": \"0\"" +
				"			}," +
				"			\"minerals\": {" +
				"				\"ca\": \"8\"," +
				"				\"fe\": \"20\"" +
				"			}" +
				"		}," +
				"		{" +
				"			\"name\": \"Beef Frankfurter, Quarter Pound\"," +
				"			\"mfr\": \"Armitage\"," +
				"			\"serving\": {" +
				"				\"units\": \"g\"," +
				"				\"text\": \"115\"" +
				"			}," +
				"			\"calories\": {" +
				"				\"total\": \"370\"," +
				"				\"fat\": \"290\"" +
				"			}," +
				"			\"total-fat\": \"32\"," +
				"			\"saturated-fat\": \"15\"," +
				"			\"cholesterol\": \"65\"," +
				"			\"sodium\": \"1100\"," +
				"			\"carb\": \"8\"," +
				"			\"fiber\": \"0\"," +
				"			\"protein\": \"13\"," +
				"			\"vitamins\": {" +
				"				\"a\": \"0\"," +
				"				\"c\": \"2\"" +
				"			}," +
				"			\"minerals\": {" +
				"				\"ca\": \"1\"," +
				"				\"fe\": \"6\"" +
				"			}" +
				"		}," +
				"		{" +
				"			\"name\": \"Chicken Pot Pie\"," +
				"			\"mfr\": \"Lakeson\"," +
				"			\"serving\": {" +
				"				\"units\": \"g\"," +
				"				\"text\": \"198\"" +
				"			}," +
				"			\"calories\": {" +
				"				\"total\": \"410\"," +
				"				\"fat\": \"200\"" +
				"			}," +
				"			\"total-fat\": \"22\"," +
				"			\"saturated-fat\": \"9\"," +
				"			\"cholesterol\": \"25\"," +
				"			\"sodium\": \"810\"," +
				"			\"carb\": \"42\"," +
				"			\"fiber\": \"2\"," +
				"			\"protein\": \"10\"," +
				"			\"vitamins\": {" +
				"				\"a\": \"20\"," +
				"				\"c\": \"2\"" +
				"			}," +
				"			\"minerals\": {" +
				"				\"ca\": \"2\"," +
				"				\"fe\": \"10\"" +
				"			}" +
				"		}," +
				"		{" +
				"			\"name\": \"Cole Slaw\"," +
				"			\"mfr\": \"Fresh Quick\"," +
				"			\"serving\": {" +
				"				\"units\": \"cup\"," +
				"				\"text\": \"1.5\"" +
				"			}," +
				"			\"calories\": {" +
				"				\"total\": \"20\"," +
				"				\"fat\": \"0\"" +
				"			}," +
				"			\"total-fat\": \"0\"," +
				"			\"saturated-fat\": \"0\"," +
				"			\"cholesterol\": \"0\"," +
				"			\"sodium\": \"15\"," +
				"			\"carb\": \"5\"," +
				"			\"fiber\": \"2\"," +
				"			\"protein\": \"1\"," +
				"			\"vitamins\": {" +
				"				\"a\": \"30\"," +
				"				\"c\": \"45\"" +
				"			}," +
				"			\"minerals\": {" +
				"				\"ca\": \"4\"," +
				"				\"fe\": \"2\"" +
				"			}" +
				"		}," +
				"		{" +
				"			\"name\": \"Eggs\"," +
				"			\"mfr\": \"Goodpath\"," +
				"			\"serving\": {" +
				"				\"units\": \"g\"," +
				"				\"text\": \"50\"" +
				"			}," +
				"			\"calories\": {" +
				"				\"total\": \"70\"," +
				"				\"fat\": \"40\"" +
				"			}," +
				"			\"total-fat\": \"4.5\"," +
				"			\"saturated-fat\": \"1.5\"," +
				"			\"cholesterol\": \"215\"," +
				"			\"sodium\": \"65\"," +
				"			\"carb\": \"1\"," +
				"			\"fiber\": \"0\"," +
				"			\"protein\": \"6\"," +
				"			\"vitamins\": {" +
				"				\"a\": \"6\"," +
				"				\"c\": \"0\"" +
				"			}," +
				"			\"minerals\": {" +
				"				\"ca\": \"2\"," +
				"				\"fe\": \"4\"" +
				"			}" +
				"		}," +
				"		{" +
				"			\"name\": \"Hazelnut Spread\"," +
				"			\"mfr\": \"Ferreira\"," +
				"			\"serving\": {" +
				"				\"units\": \"tbsp\"," +
				"				\"text\": \"2\"" +
				"			}," +
				"			\"calories\": {" +
				"				\"total\": \"200\"," +
				"				\"fat\": \"90\"" +
				"			}," +
				"			\"total-fat\": \"10\"," +
				"			\"saturated-fat\": \"2\"," +
				"			\"cholesterol\": \"0\"," +
				"			\"sodium\": \"20\"," +
				"			\"carb\": \"23\"," +
				"			\"fiber\": \"2\"," +
				"			\"protein\": \"3\"," +
				"			\"vitamins\": {" +
				"				\"a\": \"0\"," +
				"				\"c\": \"0\"" +
				"			}," +
				"			\"minerals\": {" +
				"				\"ca\": \"6\"," +
				"				\"fe\": \"4\"" +
				"			}" +
				"		}," +
				"		{" +
				"			\"name\": \"Potato Chips\"," +
				"			\"mfr\": \"Lees\"," +
				"			\"serving\": {" +
				"				\"units\": \"g\"," +
				"				\"text\": \"28\"" +
				"			}," +
				"			\"calories\": {" +
				"				\"total\": \"150\"," +
				"				\"fat\": \"90\"" +
				"			}," +
				"			\"total-fat\": \"10\"," +
				"			\"saturated-fat\": \"3\"," +
				"			\"cholesterol\": \"0\"," +
				"			\"sodium\": \"180\"," +
				"			\"carb\": \"15\"," +
				"			\"fiber\": \"1\"," +
				"			\"protein\": \"2\"," +
				"			\"vitamins\": {" +
				"				\"a\": \"0\"," +
				"				\"c\": \"10\"" +
				"			}," +
				"			\"minerals\": {" +
				"				\"ca\": \"0\"," +
				"				\"fe\": \"0\"" +
				"			}" +
				"		}," +
				"		{" +
				"			\"name\": \"Soy Patties, Grilled\"," +
				"			\"mfr\": \"Gardenproducts\"," +
				"			\"serving\": {" +
				"				\"units\": \"g\"," +
				"				\"text\": \"96\"" +
				"			}," +
				"			\"calories\": {" +
				"				\"total\": \"160\"," +
				"				\"fat\": \"45\"" +
				"			}," +
				"			\"total-fat\": \"5\"," +
				"			\"saturated-fat\": \"0\"," +
				"			\"cholesterol\": \"0\"," +
				"			\"sodium\": \"420\"," +
				"			\"carb\": \"10\"," +
				"			\"fiber\": \"4\"," +
				"			\"protein\": \"9\"," +
				"			\"vitamins\": {" +
				"				\"a\": \"0\"," +
				"				\"c\": \"0\"" +
				"			}," +
				"			\"minerals\": {" +
				"				\"ca\": \"0\"," +
				"				\"fe\": \"0\"" +
				"			}" +
				"		}," +
				"		{" +
				"			\"name\": \"Truffles, Dark Chocolate\"," +
				"			\"mfr\": \"Lyndon's\"," +
				"			\"serving\": {" +
				"				\"units\": \"g\"," +
				"				\"text\": \"39\"" +
				"			}," +
				"			\"calories\": {" +
				"				\"total\": \"220\"," +
				"				\"fat\": \"170\"" +
				"			}," +
				"			\"total-fat\": \"19\"," +
				"			\"saturated-fat\": \"14\"," +
				"			\"cholesterol\": \"25\"," +
				"			\"sodium\": \"10\"," +
				"			\"carb\": \"16\"," +
				"			\"fiber\": \"1\"," +
				"			\"protein\": \"1\"," +
				"			\"vitamins\": {" +
				"				\"a\": \"0\"," +
				"				\"c\": \"0\"" +
				"			}," +
				"			\"minerals\": {" +
				"				\"ca\": \"0\"," +
				"				\"fe\": \"0\"" +
				"			}" +
				"		}" +
				"	]" +
				"}";

		JsonObject dietObject = convertAPIOutputToJson(jsonSample); //Use escape to clean up the invalid json chars

		JsonObject dvObject = dietObject.getJsonObject("daily-values");

		JsonObject totalFat = dvObject.getJsonObject("total-fat");
		System.out.println(totalFat);
		System.out.println("Units   : " + totalFat.getString("units"));
		System.out.println("Text    : " + totalFat.getInt("text"));
		JsonNumber translatedNum = totalFat.getJsonNumber("translated");
		long transLong = translatedNum.longValue();
		double transDouble = translatedNum.doubleValue();
		System.out.println("translatedNum    : " + translatedNum);
		System.out.println("transLong    : " + transLong);
		System.out.println("double    : " + transDouble);
		System.out.println("totalFat    : " + totalFat);

		totalFat = removeProperty(totalFat, "text");
		System.out.println("new1 TF: " + totalFat);

		totalFat = addOrModifyProperty(totalFat, "grams", "100", "String");
		System.out.println("new2 TF: " + totalFat);

		totalFat = addOrModifyProperty(totalFat, "ounces", 2, "int");
		System.out.println("new3 TF: " + totalFat);

		totalFat = addOrModifyProperty(totalFat, "drams", 0.8, "double");
		System.out.println("new4 TF: " + totalFat);

		totalFat = addOrModifyProperty(totalFat, "grains", 0.66, "double");
		System.out.println("new5 TF: " + totalFat);

		System.out.println("DO");
		System.out.println(dietObject);


		JsonArray foodsArr = dietObject.getJsonArray("food");

		System.out.println(foodsArr);


		for (int x = 0; x < foodsArr.size(); x++) {
			//JsonValue is quite useless. Use JsonObject
			JsonValue foodVal = foodsArr.get(x);
			String foodString = foodVal.toString();
			System.out.println(foodString);
			System.out.println(foodVal.getValueType());

			JsonObject food = foodsArr.getJsonObject(x);
			System.out.println(food);
			String name = food.getString("name");
			System.out.println("name " + name);


		}

		// Search for a JSON object by its key.
		System.out.println("===================\nSearch by Key\n===================");
		searchByKey(dietObject, "ca");

		// Search for a JSON objects by depth.
		System.out.println("\n===================\nSearch by Depth\n===================\n");
		searchFullDepth(dietObject);
	}

	private static JsonObject convertAPIOutputToJson(String apiString) {
		//System.out.println("Starting convertAPIOutputToJson");

		JsonReader apiReader = Json.createReader(new StringReader(apiString));
		JsonObject apiObject = apiReader.readObject();
		apiReader.close();

		//System.out.println("Ending convertAPIOutputToJson");
		return apiObject;
	}

	public static JsonObject removeProperty(JsonObject origin, String key) {
		JsonObjectBuilder builder = Json.createObjectBuilder();

		for (Map.Entry<String,JsonValue> entry : origin.entrySet()) {
			if (entry.getKey().equals(key)) {
				continue;
			} else {
				builder.add(entry.getKey(), entry.getValue());
			}
		}       
		return builder.build();
	}

	public static JsonObject addOrModifyProperty(JsonObject origin, String key, Object value, String type) {
		JsonObjectBuilder builder = Json.createObjectBuilder();

		for (Map.Entry<String,JsonValue> entry : origin.entrySet()) {
			if (entry.getKey().equals(key)) {
				continue;
			} else {
				builder.add(entry.getKey(), entry.getValue());
			}
		}

		String stringValue = value.toString();

		if (type.equals("String")) {
			builder.add(key, stringValue);
		}
		else if (type.equals("int")) {
			builder.add(key, Integer.parseInt(stringValue));
		}
		else if (type.equals("double")) {
			builder.add(key, Double.parseDouble(stringValue));
		}

		return builder.build();
	}

	// ========================================================================
	// Main Routines
	// ========================================================================
	public static void searchByKey(JsonObject jsonObj, String key) {
		JsonObject json = getJsonByKey(jsonObj, key);
		String jsonStr = prettyPrint(json);

		System.out.println(jsonStr);
	}

	public static void searchFullDepth(JsonObject jsonObj) {
		JsonArray jsonArr = null;
		int depth = 0;

		do {
			jsonArr = getNestedObjects(jsonObj, depth);
			String jsonStr = prettyPrint(jsonArr);
			System.out.printf("Depth = %d%n%s%s%n%n", depth, "---------", jsonStr);
			depth++;
		} while (jsonArr != null && !jsonArr.isEmpty());
	}

	// ========================================================================
	// Key Search - Search by key
	// ========================================================================
	public static JsonObject getJsonByKey(JsonObject jsonObj, String search) {
		return getJsonByKey(jsonObj, search, 10);
	}

	public static JsonObject getJsonByKey(JsonObject jsonObj, String search, int maxDepth) {
		return getJsonByKey(jsonObj, search, maxDepth, 0);
	}

	/** @private Inner recursive call. */
	private static JsonObject getJsonByKey(JsonObject jsonObj, String search, int maxDepth, int level) {
		if (level < maxDepth && jsonObj != null) {
			Object child = null;

			for (String key : jsonObj.keySet()) {
				child = jsonObj.get(key);

				if (child instanceof JsonObject) {
					if (key.equals(search)) {
						return (JsonObject) child;
					}
				}
			}

			return getJsonByKey((JsonObject) child, search, maxDepth, level + 1);
		}

		return null;
	}

	// ========================================================================
	// Depth Search - Search by depth
	// ========================================================================
	public static JsonArray getNestedObjects(JsonObject jsonObj, int depth) {
		JsonArrayBuilder builder = Json.createArrayBuilder();

		getNestedObjects(jsonObj, builder, depth);

		return builder.build();
	}

	/** @private Inner recursive call. */
	private static void getNestedObjects(JsonObject jsonObj, JsonArrayBuilder builder, int level) {
		if (level == 0) {
			builder.add(jsonObj);
		}

		if (jsonObj != null) {
			for (String key : jsonObj.keySet()) {
				Object child = jsonObj.get(key);

				if (child instanceof JsonObject) {
					getNestedObjects((JsonObject) child, builder, level - 1);
				}
			}
		}
	}

	// ========================================================================
	// Utilities - Read and write
	// ========================================================================



	public static String prettyPrint(JsonStructure json) {
		return jsonFormat(json, JsonGenerator.PRETTY_PRINTING);
	}

	public static String jsonFormat(JsonStructure json, String... options) {
		StringWriter stringWriter = new StringWriter();
		Map<String, Boolean> config = new HashMap<String, Boolean>();

		if (options != null) {
			for (String option : options) {
				config.put(option, true);
			}
		}

		JsonWriterFactory writerFactory = Json.createWriterFactory(config);
		JsonWriter jsonWriter = writerFactory.createWriter(stringWriter);

		jsonWriter.write(json);
		jsonWriter.close();

		return stringWriter.toString();
	}

	//Don't use this on string manually built out, like jsonSample. Only on broken json strings.
	private static String escape(String raw) {
		String escaped = raw;
		escaped = escaped.replace("\\", "\\\\");
		escaped = escaped.replace("\"", "\\\"");
		escaped = escaped.replace("\b", "\\b");
		escaped = escaped.replace("\f", "\\f");
		escaped = escaped.replace("\n", "\\n");
		escaped = escaped.replace("\r", "\\r");
		escaped = escaped.replace("\t", "\\t");
		// TODO: escape other non-printing characters using uXXXX notation
		return escaped;
	}


}
