package com.lee.jscbpm2.search;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.lee.jscbpm2.sns.Query;

@Service
public class SearchDAO {

private ArrayList<Search> searches;
	
	public void search(Query q, HttpServletRequest req, HttpServletResponse res) {
		try {
			int display = 10;
			String search = q.getSearch();
			String query = URLEncoder.encode(q.getQuery(), "utf-8");
			
			String addr = String.format("https://openapi.naver.com/v1/search/%s.json?query=%s&display=%d", search, query, display);
			URL u = new URL(addr);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("X-Naver-Client-Id", "KFaEaXXnnCsk9cccpwc8"); // 헤더명, 값
			huc.addRequestProperty("X-Naver-Client-Secret", "cLDc7wtI3G");
			
			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = null;

			// 문자열 붙이기
			StringBuffer sb = new StringBuffer();
			
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			String data = sb.toString();
			
			JSONParser jp = new JSONParser();
			// { : JSONObject
			// [ : JSONArray
			JSONObject jo = (JSONObject) jp.parse(data);
			JSONArray ja = (JSONArray) jo.get("items");
			JSONObject items = null;
			searches = new ArrayList<Search>();
			Search s = null;
			
			for (int i = 0; i < ja.size(); i++) {
				s = new Search();
				items = (JSONObject) ja.get(i);
				s.setTitle((String) items.get("title"));
				s.setLink((String) items.get("link"));
				s.setImage((String) items.get("image"));
				if (search.equals("shop")) {
					s.setPrice(Integer.parseInt((String) items.get("lprice")));
				} else if (search.equals("movie")) {
					s.setPrice((int) Math.ceil(Double.parseDouble((String) items.get("userRating"))));
				} else if (search.equals("book")) {
					s.setPrice(Integer.parseInt((String) items.get("price")));
				}
				searches.add(s);
			}
			
			req.setAttribute("r", "검색 완료");
			req.setAttribute("searches", searches);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "검색 실패");
		}
	}
}
