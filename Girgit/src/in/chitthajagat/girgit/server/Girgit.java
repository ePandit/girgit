package in.chitthajagat.girgit.server;

import net.htmlparser.jericho.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.logging.Logger;

/**
 * Copyright © 2009 Jain, Vipul(drvipuljain@gmail.com) and Kumar, Alok(alok.kumar@gmail.com) under the GNU General Public License (GPL)
 *
 * 
 */

public class Girgit {

		private static HashMap<String, String> नक्शारोमन३ = null;
 private static HashMap<String, String> नक्शारोमन२ = null;
	private static HashMap<String, String> नक्शारोमन१ = null;
	
	private static HashMap<String, String> नक्शाबंग्ला१ = null;
	private static HashMap<String, String> नक्शाउड़िया१ = null;
	private static HashMap<String, String> नक्शातेलुगु१ = null;
	private static HashMap<String, String> नक्शातमिल१ = null;
	private static HashMap<String, String> नक्शाकन्नड़१ = null;
	private static HashMap<String, String> नक्शागुजराती१ = null;
	private static HashMap<String, String> नक्शामलयालम१ = null;
	private static HashMap<String, String> नक्शागुरुमुखी१ = null;
	private static HashMap<String, String> नक्शादेवनागरी१ = null;
	
	private static synchronized void नक्शाबनाओ(String लिपि) {
		
		if (लिपि.equals("en")) {
			चिट्ठा.info("नक्शाबनाओ en में");
			
			if (नक्शारोमन३ == null) {
						चिट्ठा.info("नक्शारोमन३ en में");

				नक्शारोमन३ = new HashMap<String, String>(194);
				int क = 0;
				while(!GirgitRoman.नक्शा३[क][0].equals("")) {
					नक्शारोमन३.put(GirgitRoman.नक्शा३[क][0], GirgitRoman.नक्शा३[क][1]);
					++क;
				}
			}
			

			if (नक्शारोमन२ == null) {
				चिट्ठा.info("नक्शारोमन२ en में");
			
				नक्शारोमन२ = new HashMap<String, String>(1139);
				int क = 0;
				while(!GirgitRoman.नक्शा२[क][0].equals("")) {
					नक्शारोमन२.put(GirgitRoman.नक्शा२[क][0], GirgitRoman.नक्शा२[क][1]);
					++क;
				}
			}
			

			if (नक्शारोमन१ == null) {
				चिट्ठा.info("नक्शारोमन१ en में");

				नक्शारोमन१ = new HashMap<String, String>(104);
				int क = 0;
				while(!GirgitRoman.नक्शा१[क][0].equals("")) {
					नक्शारोमन१.put(GirgitRoman.नक्शा१[क][0], GirgitRoman.नक्शा१[क][1]);
					++क;
				}
	
			}
		} else if (लिपि.equals("bn")) {
			if (नक्शाबंग्ला१ == null) {
				// 898 को हार्डकोड किया है यहाँ
				नक्शाबंग्ला१ = new HashMap<String, String>(898);
				for (int क = 0; क < 898; ++क) {
					नक्शाबंग्ला१.put(GirgitBangla.नक्शा[क][0],
							GirgitBangla.नक्शा[क][1]);
				}
			}
		} else if (लिपि.equals("or")) {
			if (नक्शाउड़िया१ == null) {
				// 904 को हार्डकोड किया है यहाँ
				नक्शाउड़िया१ = new HashMap<String, String>(904);
				for (int क = 0; क < 904; ++क) {
					नक्शाउड़िया१.put(GirgitOriya.नक्शा[क][0],
							GirgitOriya.नक्शा[क][1]);
				}
			}
		}
		else if (लिपि.equals("te")) {
			if (नक्शातेलुगु१ == null) {
				// 882 को हार्डकोड किया है यहाँ
				नक्शातेलुगु१ = new HashMap<String, String>(882);
				for (int क = 0; क < 882; ++क) {
					नक्शातेलुगु१.put(GirgitTelugu.नक्शा[क][0],
							GirgitTelugu.नक्शा[क][1]);
				}
			}
		}else if (लिपि.equals("ta")) {
			if (नक्शातमिल१ == null) {
				// 1102 को हार्डकोड किया है यहाँ, वैसे अब इसकी ज़रूरत नहीं है - अंत सूचक है
				नक्शातमिल१ = new HashMap<String, String>(1102);
				
				/*
				for (int क = 0; क < 1102; ++क) {
					नक्शातमिल१.put(GirgitTamil.नक्शा[क][0],
							GirgitTamil.नक्शा[क][1]);
				}
				*/
				int क = 0;
				while(true) {
					if(GirgitTamil.नक्शा[क][0].equals("")) {
						break;
					}
					चिट्ठा.fine(GirgitTamil.नक्शा[क][0]);
					नक्शातमिल१.put(GirgitTamil.नक्शा[क][0],
							GirgitTamil.नक्शा[क][1]);
					++क;
					
				}
			}
		}else if (लिपि.equals("kn")) {
			if (नक्शाकन्नड़१ == null) {
				// 884 को हार्डकोड किया है यहाँ
				नक्शाकन्नड़१ = new HashMap<String, String>(884);
				for (int क = 0; क < 884; ++क) {
					नक्शाकन्नड़१.put(GirgitKannada.नक्शा[क][0],
							GirgitKannada.नक्शा[क][1]);
				}
			}
		}else if (लिपि.equals("gu")) {
			if (नक्शागुजराती१ == null) {
				// 901 को हार्डकोड किया है यहाँ
				नक्शागुजराती१ = new HashMap<String, String>(901);
				for (int क = 0; क < 901; ++क) {
					नक्शागुजराती१.put(GirgitGujarati.नक्शा[क][0],
							GirgitGujarati.नक्शा[क][1]);
				}
			}
		}else if (लिपि.equals("ml")) {
			if (नक्शामलयालम१ == null) {
				// 883 को हार्डकोड किया है यहाँ
				नक्शामलयालम१ = new HashMap<String, String>(883);
				for (int क = 0; क < 883; ++क) {
					नक्शामलयालम१.put(GirgitMalayalam.नक्शा[क][0],
							GirgitMalayalam.नक्शा[क][1]);
				}
			}
		}else if (लिपि.equals("pa")) {
			if (नक्शागुरुमुखी१ == null) {
				// 944 को हार्डकोड किया है यहाँ
				नक्शागुरुमुखी१ = new HashMap<String, String>(944);
				for (int क = 0; क < 944; ++क) {
					नक्शागुरुमुखी१.put(GirgitGurumukhi.नक्शा[क][0],
							GirgitGurumukhi.नक्शा[क][1]);
				}
			}
		}else if (लिपि.equals("hi")) {
			if (नक्शादेवनागरी१ == null) {
				// 861 को हार्डकोड किया है यहाँ
				नक्शादेवनागरी१ = new HashMap<String, String>(861);
				for (int क = 0; क < 861; ++क) {
					नक्शादेवनागरी१.put(GirgitDevanagari.नक्शा[क][0],
							GirgitDevanagari.नक्शा[क][1]);
				}
			}
		}
	}

	public static void रंगोहटमल(Source स्रोत, OutputDocument बदलू, String लिपि, StringBuilder कुछबदलाहै) {

		for (Iterator<Segment> थैली = स्रोत.getNodeIterator(); थैली.hasNext();) {
			Segment हिस्सा = थैली.next();
			if (हिस्सा instanceof CharacterReference) {
								बदलू.replace(हिस्सा, रंगो(CharacterReference.decode(हिस्सा.toString()), लिपि, कुछबदलाहै));
			} else if (हिस्सा instanceof Tag) {
				//यहाँ पर IMG alt और A title का बदलाव होना चाहिए
			} else {
				बदलू.replace(हिस्सा, रंगो(हिस्सा.toString(), लिपि, कुछबदलाहै));
			}
		}
	}

	private static final Logger चिट्ठा = Logger.getLogger(Girgit.class
			.getName());

	private static void नक्शानापो(StringBuilder नयारंग, int फ़ुट्टा,
			HashMap<String, String> नक्शा, StringBuilder कुछबदलाहै) {
		
		int मूललंबाई = नयारंग.length();

		int शुरुआत = मूललंबाई - फ़ुट्टा;
		while (शुरुआत >= 0) {
			int अंत = शुरुआत + फ़ुट्टा;
			चिट्ठा.fine("नयारंग: [" + नयारंग.toString() + "]" + "शुरुआत [" + शुरुआत + "]" + "अंत [" + अंत +"]" + "मूललंबाई [" + मूललंबाई + "]");
				String बदलनीय = नयारंग.substring(शुरुआत, अंत);
		if(बदलनीय == null){
			चिट्ठा.fine("बदलनीय null है");
		}
				String बदलारंग = null;

			बदलारंग = नक्शा.get(बदलनीय);
			if (बदलारंग == null) {
				चिट्ठा.fine("बदलारंग नहीं है।");
				--शुरुआत;
			} else {
				चिट्ठा.fine("बदलारंग है।");
				नयारंग.replace(शुरुआत, अंत, बदलारंग);
				शुरुआत -= फ़ुट्टा;
				//यहाँ if डालना है। अभी हर बार बदलता है।
				कुछबदलाहै.replace(0, 1, "ह"); 
							
				
			}

		}
	}

	public static String रंगो(String पुरानारंग, String लिपि, StringBuilder कुछबदलाहै) {
		
		नक्शाबनाओ(लिपि);

		StringBuilder नयारंग = new StringBuilder(पुरानारंग);
		
		if (लिपि.equals("en")) {
			चिट्ठा.fine("रोमन रंगो");
			नक्शानापो(नयारंग, 3, नक्शारोमन३, कुछबदलाहै);
	 		नक्शानापो(नयारंग, 2, नक्शारोमन२, कुछबदलाहै);
			नक्शानापो(नयारंग, 1, नक्शारोमन१, कुछबदलाहै);
			if (व्यंजनहै(पुरानारंग.codePointAt(पुरानारंग.length() - 1))
					&& नयारंग.lastIndexOf("a") == (नयारंग.length() - 1)) {
				नयारंग.deleteCharAt(नयारंग.length() - 1);
			}
		} else if (लिपि.equals("bn")) {
			नक्शानापो(नयारंग, 1, नक्शाबंग्ला१, कुछबदलाहै);
		}else if (लिपि.equals("or")) {
			नक्शानापो(नयारंग, 1, नक्शाउड़िया१, कुछबदलाहै);
		}else if (लिपि.equals("te")) {
			नक्शानापो(नयारंग, 1, नक्शातेलुगु१, कुछबदलाहै);
		}else if(लिपि.equals("ta")) {
			नक्शानापो(नयारंग, 1, नक्शातमिल१, कुछबदलाहै);
		}else if(लिपि.equals("kn")) {
			नक्शानापो(नयारंग, 1, नक्शाकन्नड़१, कुछबदलाहै);
		}else if(लिपि.equals("gu")) {
			नक्शानापो(नयारंग, 1, नक्शागुजराती१, कुछबदलाहै);
		}else if(लिपि.equals("ml")) {
			नक्शानापो(नयारंग, 1, नक्शामलयालम१, कुछबदलाहै);
		}else if(लिपि.equals("pa")) {
			चिट्ठा.fine("नक्शानापो के पहले: " + कुछबदलाहै.toString());
			नक्शानापो(नयारंग, 1, नक्शागुरुमुखी१, कुछबदलाहै);
			चिट्ठा.fine("नक्शानापो के बाद: " + कुछबदलाहै.toString());
			
		}else if(लिपि.equals("hi")) {
			नक्शानापो(नयारंग, 1, नक्शादेवनागरी१, कुछबदलाहै);
		}

		// चिट्ठा.warning("पुरानी [" + पुरानारंग + "] नयारंग ["
		// + नयारंग.toString() + "]");

		return नयारंग.toString();

	}

	private static boolean व्यंजनहै(int व) {
		if ((व >= 2325 && व <= 2361) || (व >= 2392 && व <= 2399)
				|| (व >= 2427 && व <= 2431)) {
			return true;
		}
		return false;

	}

}