package com.encore.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class crawlingTest {
	
	public static void call2() throws IOException {
		URL url = new URL("https://api.bithumb.com/public/ticker/ALL");
		HttpsURLConnection conn = null;
		conn = (HttpsURLConnection)url.openConnection();
		InputStream a = conn.getInputStream();
		InputStreamReader b = new InputStreamReader(a,"UTF-8");
		BufferedReader br = new BufferedReader(b);
		String line = "";
		String result="";
			while((line = br.readLine()) !=null){
				System.out.println(line);
				result+=line;
			}
			JsonParser parser = new JsonParser();
			JsonObject json = new JsonObject();
			JsonElement je = parser.parse(result);
			json= je.getAsJsonObject().getAsJsonObject("data");
			System.out.println(json);
			
			JsonObject json2 = json.getAsJsonObject().getAsJsonObject("BTC");
			System.out.println(json2);
	}
public static void call() throws IOException {
	FileOutputStream a =new FileOutputStream("bithumb.csv", true);
	OutputStreamWriter b = new OutputStreamWriter(a, "MS949");
	
	BufferedWriter bw = new BufferedWriter(b );
	
	Document doc = Jsoup.connect("https://www.bithumb.com/").get();
	Elements rows = doc.body().select("#tableAsset > tbody > tr");

	for(int i=0; i<rows.size(); i++){
		String s = "";
		Elements cols = rows.eq(i).select("td");
		for(Element e:cols) {
		 s += e.select("strong").text()+",";
		}
		bw.write(s);
		bw.newLine();
	}
	bw.close();
	b.close();
	a.close();
}




public static void main(String[] args) throws IOException {
	call();
}
}
