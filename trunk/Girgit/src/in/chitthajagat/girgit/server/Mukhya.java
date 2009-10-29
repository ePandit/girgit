package in.chitthajagat.girgit.server;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.net.*;
import java.util.*;
import net.htmlparser.jericho.*;
import java.util.logging.Logger;

import com.google.appengine.api.urlfetch.*;

/**
 * Copyright © 2009 Jain, Vipul(drvipuljain@gmail.com) and Kumar,
 * Alok(alok.kumar@gmail.com) under the GNU General Public License (GPL)
 * 
 * 
 */

public class Mukhya extends HttpServlet {
	final Logger चिट्ठा = Logger.getLogger(Mukhya.class.getName());
	private boolean पहलीबारहै = true;

	// static ArrayList<String> सिवाय = null;
	public void doGet(HttpServletRequest अर्ज़ी, HttpServletResponse जवाब)
			throws ServletException, IOException {
		जवाब.setContentType("text/html");
		जवाब.setCharacterEncoding("UTF-8");

		PrintWriter लेखनी = जवाब.getWriter();
		
		पहलीबार();
		
		String बैरा = अर्ज़ी.getServerName();

		String लिपि = लिपि_लाओ(बैरा);

		if(लिपि.equals("")) {
			जवाब.setStatus(404);
			लेखनी
					.println("<html><head><title>404 - Page not found</title></head><body><h1>404 - Page not found</h1><p>Girgit: Unable to determine target script. Please choose the correct options via the home page.</p><p><a href=\"" + GirgitParimaan.यूआरऍलमुख्य() + "\">Retry</a></p></body></html>");
			return;
		}
String ग्राहकनाम = अर्ज़ी.getHeader("User-Agent");
boolean पुर्ज़ाहै = पुर्ज़ाहै(ग्राहकनाम);
if(पुर्ज़ाहै){
	जवाब.setStatus(503);
	जवाब.setHeader("Retry-After", "86400");
	लेखनी.println("<html><head><title>503 Service Unavailable</title></head><body><h1>503 Service Unavailable</h1><p>Please retry after 24 hours</p></body></html>");
return;
}

		String मूलपथ = अर्ज़ी.getPathInfo();
		String परिमाण = अर्ज़ी.getQueryString();
//String मूलपता = null;
		// मूल दस्तावेज़ लाओ
		try {
			
			String बदलामूल = null;
			चिट्ठा.info(मूलपथ);
			StringBuilder बदली = new StringBuilder(मूलपथ);
			if (मूलपथ.startsWith("/http://")) {
				बदली.replace(0, "/http://".length(), "");
			} else if (मूलपथ.startsWith("/https://")) {
				बदली.replace(0, "/https://".length(), "");
			} else if (मूलपथ.startsWith("/")) {
				बदली.replace(0, "/".length(), "");
			}
			if (परिमाण != null) {
				बदली.append("?" + परिमाण);
			}
			चिट्ठा.info("पुनः के पहले [" + बदली.toString() + "]");
	//		मूलपता = बदली.toString();
			boolean पुनःहै = false;
			do {
				if (बदली.toString().startsWith(GirgitParimaan.यूआरऍलउड़िया())) {
					बदली.replace(0, GirgitParimaan.यूआरऍलउड़ियालंबाई() + 1, "");
					पुनःहै = true;
				} else if (बदली.toString()
						.startsWith(GirgitParimaan.यूआरऍललातिनी())) {
					बदली.replace(0, GirgitParimaan.यूआरऍललातिनीलंबाई() + 1, "");
					पुनःहै = true;
				} else if (बदली.toString()
						.startsWith(GirgitParimaan.यूआरऍलबंग्ला())) {
					बदली.replace(0, GirgitParimaan.यूआरऍलबंग्लालंबाई() + 1, "");
					पुनःहै = true;
				} else if (बदली.toString()
						.startsWith(GirgitParimaan.यूआरऍलगुजराती())) {
					बदली.replace(0, GirgitParimaan.यूआरऍलगुजरातीलंबाई() + 1, "");
					पुनःहै = true;
				} else if (बदली.toString()
						.startsWith(GirgitParimaan.यूआरऍलदेवनागरी())) {
					बदली.replace(0, GirgitParimaan.यूआरऍलदेवनागरीलंबाई() + 1, "");
					पुनःहै = true;
				} else if (बदली.toString()
						.startsWith(GirgitParimaan.यूआरऍलमलयालम())) {
					बदली.replace(0, GirgitParimaan.यूआरऍलमलयालमलंबाई() + 1, "");
					पुनःहै = true;
				} else if (बदली.toString()
						.startsWith(GirgitParimaan.यूआरऍलगुरुमुखी())) {
					बदली.replace(0, GirgitParimaan.यूआरऍलगुरुमुखीलंबाई() + 1, "");
					पुनःहै = true;
				} else if (बदली.toString()
						.startsWith(GirgitParimaan.यूआरऍलतमिल())) {
					बदली.replace(0, GirgitParimaan.यूआरऍलतमिललंबाई() + 1, "");
					पुनःहै = true;
				} else if (बदली.toString()
						.startsWith(GirgitParimaan.यूआरऍलतेलुगु())) {
					बदली.replace(0, GirgitParimaan.यूआरऍलतेलुगुलंबाई() + 1, "");
					पुनःहै = true;
				} else if (बदली.toString()
						.startsWith(GirgitParimaan.यूआरऍलकन्नड़())) {
					बदली.replace(0, GirgitParimaan.यूआरऍलकन्नड़लंबाई() + 1, "");
					पुनःहै = true;
				} else {
					break;
				}

			} while (पुनःहै == true);

			बदलामूल = बदली.toString();
			चिट्ठा.info("पुनः के बाद [" + बदलामूल + "]");

			if (पुनःहै == true) {
				//यह ठीक से नहीं हुआ है, और नीचे sendRedirect में भी इसे करना है
				/*
				if(बदलामूल.equals(मूलपता)){
					जवाब.setStatus(HttpURLConnection.HTTP_FORBIDDEN);
					लेखनी.println("<html><head><title>" 
							+ HttpURLConnection.HTTP_FORBIDDEN 
							+ " Forbidden</title></head><body><h1>" +
							+ HttpURLConnection.HTTP_FORBIDDEN
							+ " Forbidden</h1><p>Girgit: The requested url is redirecting to the same url. Please check if you: <ul><li>mistyped the url. Check the spelling and retry.</li></ul></p><p><a href=\"" + GirgitParimaan.यूआरऍलमुख्य() + "http://girgit.chitthajagat.in\">Retry</a></p></body></html>");
					return;
				}
				*/
				जवाब.sendRedirect("/" + बदलामूल);
				return;
			}
			StringBuilder डोमेन = null;
			int ल = बदली.indexOf("/");
			if(ल == -1) {  // र ही डोमेन है
				डोमेन = new StringBuilder(बदली);
			} else { //पहले "/" के पहले का माल उठा लो
				डोमेन = new  StringBuilder(बदली.substring(0, ल));
			}
			if(डोमेनअवैधहै(डोमेन)){
				जवाब.setStatus(404);
				लेखनी
				.println("<html><head><title>404 - Page not found</title></head><body><h1>404 - Page not found</h1><p>Girgit: The requested domain is invalid. Please check if you: <ul><li>mistyped the url. Check the spelling and retry.</li></ul></p><p><a href=\"" + GirgitParimaan.यूआरऍलमुख्य() + "http://girgit.chitthajagat.in\">Retry</a></p></body></html>");
				return;
			}
					if(डोमेनअवरोधितहै(डोमेन)){
				जवाब.setStatus(HttpURLConnection.HTTP_NOT_FOUND);
				लेखनी
				.println("<html><head><title>" 
						+ HttpURLConnection.HTTP_NOT_FOUND 
						+ " Page not found</title></head><body><h1>"
						+ HttpURLConnection.HTTP_NOT_FOUND
						+ " Page not found</h1><p>Girgit: The requested domain is blocked. Please check if you: <ul><li>mistyped the url. Check the spelling and retry.</li><li>Are transliterate a page that contains text. Girgit cannot provide meaningful output for non-text pages like images.</li></ul></p><p><a href=\"" + GirgitParimaan.यूआरऍलमुख्य() + "http://girgit.chitthajagat.in\">Retry</a></p></body></html>");
				return;
			}
			
			// URL यूआरऍल = यूआरऍल_लाओ(अर्ज़ी);
			if (अनिच्छासूचीमेंहै(बदली)) {
				जवाब.setStatus(404);
				लेखनी
						.println("<html><head><title>404 Page not found</title></head><body><h1>404 - Page not found</h1><p>Girgit: The owners of this website have requested that this their site should not be available via Girgit. You can try transliterating another URL.</p><p><a href=\"http://girgit.chitthajagat.in\">Retry</a></p></body></html>");

				// जवाब.sendError(404, "");
				return;
			}
			if(पथअवरोधितहै(बदली)){
				जवाब.setStatus(HttpURLConnection.HTTP_NOT_FOUND);
				लेखनी
						.println("<html><head><title>"
								+ HttpURLConnection.HTTP_NOT_FOUND
								+ " Not Found</title></head><body><h1>"
								+ HttpURLConnection.HTTP_NOT_FOUND
								+ " Not Found</h1><p>Girgit: Unsupported file extension. You can try transliterating another URL.</p><p><a href=\"" +
								GirgitParimaan.यूआरऍलमुख्य()
								+"\">Retry</a></p></body></html>");

				// जवाब.sendError(404, "");
				return;
				
			}

			URL यूआरऍल = new URL("http://" + बदली.toString());
			URLConnection जुड़ाव = null; //try के बाहर, ताकि जेरिचो को मिल जाए
	HttpURLConnection हटटपजुड़ाव = null;
			try {

				 जुड़ाव = यूआरऍल.openConnection();
				चिट्ठा.info("कनेक्शन खुला");

				if (जुड़ाव instanceof HttpURLConnection) {
					
					हटटपजुड़ाव = (HttpURLConnection) जुड़ाव;
					हटटपजुड़ाव.setConnectTimeout(10000); //दस सेकिंड
					हटटपजुड़ाव.setInstanceFollowRedirects(false);
					हटटपजुड़ाव.setRequestMethod("GET");
					चिट्ठा.info("हटटपजुड़ाव जुड़ने जा रहा है");
									
					हटटपजुड़ाव.connect();
					चिट्ठा.info("हटटपजुड़ाव जुड़ा");
					int परिणाम = हटटपजुड़ाव.getResponseCode();
					if (परिणाम >= HttpServletResponse.SC_MULTIPLE_CHOICES /* 300 */
							&& परिणाम < HttpServletResponse.SC_BAD_REQUEST /* 400 */) {
						String नयापता = हटटपजुड़ाव.getHeaderField("Location");
						
						चिट्ठा.info("परिणाम [" + परिणाम + "]");
						if (नयापता != null) {
							चिट्ठा.info("नयापता [" + नयापता + "]");
							StringBuilder पुनः = new StringBuilder(नयापता);
							if (नयापता.startsWith("http://")) {
								पुनः.replace(0, "http://".length(), "http://"
										+ अर्ज़ी.getServerName() + "/");
							} else if (नयापता.startsWith("https://")) {
								पुनः.replace(0, "https://".length(), "http://"
										+ अर्ज़ी.getServerName() + "/");
							}
							चिट्ठा.info("पुनर्निर्देशन कड़ी है ["
									+ पुनः.toString() + "], सेवक से आया था ["
									+ नयापता + "]");
						
							जवाब.sendRedirect(पुनः.toString());
							return;
							// URL नयायूआरऍल = new URL(नयापता);
							// return नयायूआरऍल;
						}
					} else if (परिणाम >= HttpServletResponse.SC_BAD_REQUEST /*
																			 * >=
																			 * 400
																			 */
					) {
						जवाब.setStatus(HttpServletResponse.SC_NOT_FOUND);
						लेखनी
								.println("<html><head><title>"
										+ HttpServletResponse.SC_NOT_FOUND
										+ "</title></head><body><h1>"
										+ HttpServletResponse.SC_NOT_FOUND
										+ " Error While Connecting to URL.</h1><p>Girgit: Could not connect to desired URL. You might want to:<ul><li>check the spelling of the URL.</li><li>retry after some time.</li></ul></p><p><a href=\"http://girgit.chitthajagat.in\">Retry</a></p></body></html>");
						return;
					}
					//Content-Type की जाँच यहाँ करें
					String सामग्रीप्रकार = हटटपजुड़ाव.getContentType();
					/**
					 * पूरी सूची यहाँ है - http://www.iana.org/assignments/media-types/
					 */
					if(सामग्रीप्रकार != null 
							&& !सामग्रीप्रकार.startsWith("text")
							&& !(सामग्रीप्रकार.startsWith("application/") && सामग्रीप्रकार.endsWith("xml"))){
						जवाब.setStatus(HttpServletResponse.SC_NOT_FOUND);
						लेखनी
								.println("<html><head><title>"
										+ HttpServletResponse.SC_NOT_FOUND
										+ "</title></head><body><h1>"
										+ HttpServletResponse.SC_NOT_FOUND
										+ " Invalid content type.</h1><p>Girgit: This content type is not supported. Only html pages and xml feeds can be transliterated.</p><p><a href=\"http://girgit.chitthajagat.in\">Retry</a></p></body></html>");
						return;
						
					}
					
				}
			} catch (IOException अपवाद) {

				
				जवाब.setStatus(500);
				लेखनी
						.println("<html><head><title>500 Internal Server Error</title></head><body><h1>500 Internal Server Error</h1><p>Girgit: Could not connect to desired URL in 10 seconds. You might want to:<ul><li>check the spelling of the URL.</li><li>retry after some time.</li><li>report the issue to girgit at chitthajagat dot in</li></ul></p><p><a href=\"http://girgit.chitthajagat.in\">Retry</a></p></p><p>If you are the server admin, the error logs are available via the control panel.</p></body></html>");
				चिट्ठा.warning(अपवाद.toString());
				अपवाद.printStackTrace(System.out);
				return;

			}

			चिट्ठा.info("स्रोत बनने वाला है");

			Source स्रोत = new Source(हटटपजुड़ाव);
			चिट्ठा.info("स्रोत बन गया");

			स्रोत.fullSequentialParse();
			चिट्ठा.info("स्रोत भंजन बन गया");

			OutputDocument बदलू = new OutputDocument(स्रोत);
			चिट्ठा.info("बदलू बन गया");

	/*	इसकी ज़रूरत नहीं है, इसे अब गिरगिट.रंगोहटमल में ही किया जाएगा
			Bandar वानर = new Bandar(स्रोत, बदलू);
			String साफ़_दस्तावेज़ = वानर.जूँनिकालो();

		
			Source साफ़स्रोत = new Source(साफ़_दस्तावेज़);
			साफ़स्रोत.fullSequentialParse();
			OutputDocument नयाबदलू = new OutputDocument(साफ़स्रोत);

			Doodhwala दूधिया = new Doodhwala(साफ़स्रोत, नयाबदलू);
	*/
			Doodhwala दूधिया = new Doodhwala(स्रोत, बदलू);
			
			चिट्ठा.info("दूधिया बन गया");
			दूधिया.कड़ीमेंमिलाओ(पानीलाओ(लिपि), यूआरऍल.getHost(),
					चीनीलाओ(यूआरऍल), GirgitParimaan.सिवाय());

			दूधिया.चीनीडालो(यूआरऍल.getHost(), HTMLElementName.IMG, "src");
			दूधिया.चीनीडालो(यूआरऍल.getHost(), HTMLElementName.LINK, "href");
			दूधिया.चीनीडालो(यूआरऍल.getHost(), HTMLElementName.SCRIPT, "src");

			/*
			Source सीऍसऍसस्रोत = new Source(नयाबदलू.toString());
*/
			Source सीऍसऍसस्रोत = new Source(बदलू.toString());

			सीऍसऍसस्रोत.fullSequentialParse();
			OutputDocument सीऍसऍसबदलू = new OutputDocument(सीऍसऍसस्रोत);
			Doodhwala दूधियासीऍसऍस = new Doodhwala(सीऍसऍसस्रोत, सीऍसऍसबदलू);
			चिट्ठा.info("दूधियासीऍसऍस बन गया");

			दूधियासीऍसऍस.सीऍसऍसबदलो(यूआरऍल.getHost());
			// System.out.println("dudhiya paar");

			// हटमल से सादा पाठ निकाल के गिरगिट को बुला के रंग बदलो

			// बदला दस्तावेज़ लिखो
			StringBuilder कुछबदलाहै = new StringBuilder("न");
			Girgit.रंगोहटमल(सीऍसऍसस्रोत, सीऍसऍसबदलू, लिपि, कुछबदलाहै);

			चिट्ठा.info(कुछबदलाहै.toString());
			if (कुछबदलाहै.toString().equals("न")) {
				चिट्ठा.warning("लिप्यंतरण के लिए माल नहीं");
				जवाब.setStatus(404);
				लेखनी
						.println("<html><head><title>404 - Page not found</title></head><body><h1>404 - Page not found</h1><p>Girgit: This page has nothing to transliterate. Please check if you: <ul><li>mistyped the url. Check the spelling and retry.</li><li>were trying to transliterate a page that's already in the target language.</li><li>were trying to transliterate a page with no indic content. The source page has to have indic content for Girgit to have meaningful results.</li></ul></p><p><a href=\"http://girgit.chitthajagat.in\">Retry</a></p></body></html>");
				// जवाब.sendError(404,
				// "Girgit: This page has nothing to transliterate.");
				return;
			}

			Source रंगास्रोत = new Source(सीऍसऍसबदलू.toString());
			OutputDocument रंगाबदलू = new OutputDocument(रंगास्रोत);
			Doodhwala दूधियारंगा = new Doodhwala(रंगास्रोत, रंगाबदलू);
			चिट्ठा.info("दूधियारंगा बन गया");

			दूधियारंगा.परिचयडालो(परिचयलाओ(यूआरऍल));
			दूधियारंगा.रोबोटडालो();
			लेखनी.println(रंगाबदलू.toString());
		} catch (Exception अपवाद) {
			जवाब.setStatus(500);
			लेखनी
					.println("<html><head><title>500 Internal Server Error</title></head><body><h1>500 Internal Server Error</h1><p>Girgit: Could not connect to desired URL. You might want to:<ul><li>check the spelling of the URL.</li><li>retry after some time.</li><li>report the issue to girgit at chitthajagat dot in</li></ul></p><p><a href=\"http://girgit.chitthajagat.in\">Retry</a></p></p><p>If you are the server admin, the error logs are available via the control panel.</p></body></html>");
			चिट्ठा.warning(अपवाद.toString());
			अपवाद.printStackTrace(System.out);
		}

	}

	private synchronized void पहलीबार() {
		if(पहलीबारहै){
		GirgitParimaan.जमाओयूआरऍलउड़िया(getInitParameter("orurl"));
		GirgitParimaan.जमाओयूआरऍललातिनी(getInitParameter("enurl"));
		GirgitParimaan.जमाओयूआरऍलकन्नड़(getInitParameter("knurl"));
		GirgitParimaan.जमाओयूआरऍलगुजराती(getInitParameter("guurl"));
		GirgitParimaan.जमाओयूआरऍलगुरुमुखी(getInitParameter("paurl"));
		GirgitParimaan.जमाओयूआरऍलतमिल(getInitParameter("taurl"));
		GirgitParimaan.जमाओयूआरऍलतेलुगु(getInitParameter("teurl"));
		GirgitParimaan.जमाओयूआरऍलदेवनागरी(getInitParameter("hiurl"));
		GirgitParimaan.जमाओयूआरऍलबंग्ला(getInitParameter("bnurl"));
		GirgitParimaan.जमाओयूआरऍलमलयालम(getInitParameter("mlurl"));
		GirgitParimaan.जमाओयूआरऍलमुख्य(getInitParameter("mukhyaurl"));
		GirgitParimaan.जमाओसिवाय();
		पहलीबारहै = false;
		}
		return;
	}
private boolean पुर्ज़ाहै(String र) {
	
	if(र != null &&
			(र.contains("Ask Jeeves/Teoma")
					||
					र.contains("discobot")
					||
					र.contains("DotBot")
					||
					र.contains("Exabot")
					||
					र.contains("Feedjit")
					||
					र.contains("GurujiBot")
					||
					र.contains("heritrix")
					||
					र.contains("http://domino.research.ibm.com/comm/research_projects.nsf/pages/sai-crawler.callingcard.html")
					||
					र.contains("ia_archiver")
					||
					र.contains("KaloogaBot")
					||
					र.contains("MJ12bot")
					||
					र.contains("MLBot")
					||
					र.contains("msnbot")
					||
					र.contains("S2Bot")
					||
					र.contains("SeznamBot")
					||
					र.contains("Snapbot")
					||
					र.contains("Speedy Spider (http://www.entireweb.com/about/search_tech/speedy_spider/")
					||
					र.contains("temaseek.com/Nutch-1.0")
					||
					र.contains("Twiceler-0.9")
					||
					र.contains("u_tch-princeton")
					||
					र.contains("WebRankSpider")
					||
					र.contains("xrss")
					||
					र.contains("yacybot")
					||
					र.contains("Yahoo! Slurp")
					||
					र.contains("Yahoo-MMCrawler")
					||
					र.contains("Yahoo-Test")
					||
					र.contains("Yandex")
					)
					
			) {
		return true;
	}
	return false;
}

private boolean डोमेनअवरोधितहै(StringBuilder डोमेन) {
	if(
			डोमेन.equals("bp1.blogger.com") ||
			डोमेन.equals("bp0.blogger.com") ||
			डोमेन.equals("bp3.blogger.com") ||
			डोमेन.equals("lh3.ggpht.com") ||
			डोमेन.equals("lh4.ggpht.com") ||
			डोमेन.equals("lh5.ggpht.com") ||
			डोमेन.equals("lh6.ggpht.com")			) {
		return true;
	}
		
	return false;
}

private boolean पथअवरोधितहै(StringBuilder पथ){
	int पथांत = पथ.indexOf("?");
	String केवलपथ = null;
	if(पथांत == -1) {
		केवलपथ = पथ.toString();
	} else {
		केवलपथ = पथ.substring(0, पथांत);
	}

	if(
			केवलपथ.endsWith(".png") ||
			केवलपथ.endsWith(".PNG") ||
			केवलपथ.endsWith(".jpg") ||
			केवलपथ.endsWith(".JPG") ||
			केवलपथ.endsWith(".gif") ||
			केवलपथ.endsWith(".GIF") ||
			केवलपथ.endsWith(".bmp") ||
			केवलपथ.endsWith(".BMP") ||
			केवलपथ.endsWith(".exe") ||
			केवलपथ.endsWith(".jpeg") ||
			केवलपथ.endsWith(".JPEG") ||
			केवलपथ.endsWith(".exe") ||
			केवलपथ.endsWith(".EXE") ||
			केवलपथ.endsWith(".swf") ||
			केवलपथ.endsWith(".SWF") ||
			केवलपथ.endsWith(".mp3") ||
			केवलपथ.endsWith(".MP3") ||
			केवलपथ.endsWith(".css") ||
			केवलपथ.endsWith(".CSS") ||
			केवलपथ.endsWith(".js") ||
			केवलपथ.endsWith(".JS") ||
			केवलपथ.endsWith(".pdf") ||
			केवलपथ.endsWith(".PDF") ||
			केवलपथ.endsWith(".doc") ||
			केवलपथ.endsWith(".DOC") ||
			केवलपथ.endsWith(".ppt") ||
			केवलपथ.endsWith(".PPT") ||
			केवलपथ.endsWith(".xls") ||
			केवलपथ.endsWith(".XLS") ||
			केवलपथ.endsWith(".docx") ||
			केवलपथ.endsWith(".DOCX") ||
			केवलपथ.endsWith(".pptx") ||
			केवलपथ.endsWith(".PPTX") ||
			केवलपथ.endsWith(".xlsx") ||
			केवलपथ.endsWith(".XLSX")

			
			) {
		return true;
	}

	
	return false;
}

private boolean डोमेनअवैधहै(StringBuilder डोमेन) {
	int लंबाई =  डोमेन.length();
	//डोमेन के आखिरी बिंदु कहाँ है
	int  व = डोमेन.lastIndexOf(".");
	if(व == -1 || व == लंबाई -1 || व == लंबाई - 2){
		//बिंदी ही नहीं है

		//बिंदी अंत में है या बिंदी के बाद एक ही अक्षर है

		return true; 
	}
	//सर्वोच्च स्तरीय डोमेन लाओ
	String स = डोमेन.substring(व, लंबाई);
	if(
	स.equals(".pdf") ||
	स.equals(".txt") ||
	स.equals(".png") ||
	स.equals(".jpg") ||
	स.equals(".jpeg") ||
	स.equals(".bmp") ||
	स.equals(".svg") ||
	स.equals(".doc") ||
	स.equals(".html") ||
	स.equals(".htm") ||
	स.equals(".xml") ||
	स.equals(".shtml") ||
	स.equals(".php") ||
	स.equals(".asp") ||
	स.equals(".docx") ||
	स.equals(".xls") ||
	स.equals(".xlsx") ||
	स.equals(".ppt") ||
	स.equals(".pptx") ||
	स.equals(".odt") ||
	स.equals(".pdf") 
	) {
		return true;
	}	
	
	return false;
}
	
	private String परिचयलाओ(URL यूआरऍल) {
		return "<div>Online TransLiteration by <a href=\"http://"
				+ GirgitParimaan.यूआरऍलमुख्य() + "\">"
				+ GirgitParimaan.यूआरऍलमुख्य() + "</a>, of <a href=\""
				+ यूआरऍल.toString()

				+ "\">" + यूआरऍल.toString() + "</a> <a href=\"http://"
				+ GirgitParimaan.यूआरऍलमुख्य() + "/disclaimer.html\">"
				+ "Disclaimer</a><br />You may also see this page in " +

				"<a href=\"http://" + GirgitParimaan.यूआरऍलबंग्ला() + "/"
				+ यूआरऍल.getHost() + यूआरऍल.getPath() + "\">Bangla</a>, "
				+ "<a href=\"http://" + GirgitParimaan.यूआरऍलदेवनागरी() + "/"
				+ यूआरऍल.getHost() + यूआरऍल.getPath() + "\">Devanagari</a>, "
				+ "<a href=\"http://" + GirgitParimaan.यूआरऍलगुजराती() + "/"
				+ यूआरऍल.getHost() + यूआरऍल.getPath() + "\">Gujarati</a>, "
				+ "<a href=\"http://" + GirgitParimaan.यूआरऍलगुरुमुखी() + "/"
				+ यूआरऍल.getHost() + यूआरऍल.getPath() + "\">Gurmukhi</a>, "
				+ "<a href=\"http://" + GirgitParimaan.यूआरऍलकन्नड़() + "/"
				+ यूआरऍल.getHost() + यूआरऍल.getPath() + "\">Kannada</a>, "
				+ "<a href=\"http://" + GirgitParimaan.यूआरऍलमलयालम() + "/"
				+ यूआरऍल.getHost() + यूआरऍल.getPath() + "\">Malayalam</a>, "
				+ "<a href=\"http://" + GirgitParimaan.यूआरऍलउड़िया() + "/"
				+ यूआरऍल.getHost() + यूआरऍल.getPath() + "\">Oriya</a>, "
				+ "<a href=\"http://" + GirgitParimaan.यूआरऍललातिनी() + "/"
				+ यूआरऍल.getHost() + यूआरऍल.getPath() + "\">Roman(Eng)</a>, "
				+ "<a href=\"http://" + GirgitParimaan.यूआरऍलतमिल() + "/"
				+ यूआरऍल.getHost() + यूआरऍल.getPath() + "\">Tamil</a>, "
				+ "<a href=\"http://" + GirgitParimaan.यूआरऍलतेलुगु() + "/"
				+ यूआरऍल.getHost() + यूआरऍल.getPath() + "\">Telugu</a> </div>";

	}

	private boolean अनिच्छासूचीमेंहै(StringBuilder र) {
		// बाद में यह सूची किसी संचिका में डालनी होगी
		if (र.toString().startsWith("http://www.blogofcrappyness.com")) {
			return true;
		}

		return false;
	}

	private String चीनीलाओ(URL यूआरऍल) {
		String चीनी = यूआरऍल.getPath();
		return चीनी;
	}

	private String पानीलाओ(String लिपि) {
		return getInitParameter(लिपि + "url");
	}

	private String लिपि_लाओ(String बैरा) {

		
		if (बैरा.equals(GirgitParimaan.यूआरऍलबंग्ला())) {
			return "bn";
		} else if (बैरा.equals(GirgitParimaan.यूआरऍललातिनी())) {
			return "en";

		} else if (बैरा.equals(GirgitParimaan.यूआरऍलगुजराती())) {
			return "gu";
		} else if (बैरा.equals(GirgitParimaan.यूआरऍलदेवनागरी())) {
			return "hi";

		}

		else if (बैरा.equals(GirgitParimaan.यूआरऍलकन्नड़())) {
			return "kn";

		} else if (बैरा.equals(GirgitParimaan.यूआरऍलमलयालम())) {
			return "ml";

		} else if (बैरा.equals(GirgitParimaan.यूआरऍलउड़िया())) {
			return "or";

		} else if (बैरा.equals(GirgitParimaan.यूआरऍलगुरुमुखी())) {
			return "pa";

		} else if (बैरा.equals(GirgitParimaan.यूआरऍलतमिल())) {
			return "ta";

		} else if (बैरा.equals(GirgitParimaan.यूआरऍलतेलुगु())) {
			return "te";

		}
		if (बैरा.equals("localhost")) {
			return getInitParameter("devlipi");

		}
		return "";
	}


}
