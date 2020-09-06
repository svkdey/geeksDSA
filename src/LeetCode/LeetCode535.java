package LeetCode;

import java.util.HashMap;
import java.util.Random;

public class LeetCode535 {
	public class Codec {
		HashMap<String, String> BigToTiny = null;
		HashMap<String, String> TinyToBig = null;
		String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String BASE = "http://tinyurl.com/";

		public Codec() {
			// TODO Auto-generated constructor stub
			BigToTiny = new HashMap<String, String>();
			TinyToBig = new HashMap<String, String>();
		}

		// Encodes a URL to a shortened URL.
		public String encode(String longUrl) {
			if (longUrl.equals("") || longUrl.isEmpty())
				return null;
			if (BigToTiny.containsKey(longUrl)) {
				return BASE + BigToTiny.get(longUrl);
			}
			StringBuilder key = new StringBuilder();
			do {
				for (int i = 0; i < 6; i++) {
					Random r = new Random();
					int k = r.nextInt(SEED.length());
					key.append(SEED.charAt(k));
				}
			} while (TinyToBig.containsKey(key.toString()));

			TinyToBig.put(key.toString(), longUrl);
			BigToTiny.put(longUrl, key.toString());
			return BASE + key.toString();
		}

		// Decodes a shortened URL to its original URL.
		public String decode(String shortUrl) {
			if (shortUrl == null || shortUrl.isEmpty()) {
				return "";
			}
			String[] shortUrlSplits = shortUrl.split("/");
			return TinyToBig.get(shortUrlSplits[shortUrlSplits.length - 1]);
		}
	}
}
