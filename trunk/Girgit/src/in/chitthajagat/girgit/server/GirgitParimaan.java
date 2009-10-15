package in.chitthajagat.girgit.server;
import java.util.*;
public class GirgitParimaan {
	private static String यूआरऍल_बंग्ला = null;
	private static String यूआरऍल_देवनागरी = null;
	private static String यूआरऍल_गुजराती = null;
	private static String यूआरऍल_गुरुमुखी = null;
	private static String यूआरऍल_कन्नड़ = null;
	private static String यूआरऍल_लातिनी = null;
	private static String यूआरऍल_मलयालम = null;
	private static String यूआरऍल_उड़िया = null;
	private static String यूआरऍल_तमिल = null;
	private static String यूआरऍल_तेलुगु = null;
	private static String यूआरऍल_मुख्य = null;
	
	private static int यूआरऍल_बंग्ला_लंबाई = 0;
	private static int यूआरऍल_देवनागरी_लंबाई = 0;
	private static int यूआरऍल_गुजराती_लंबाई = 0;
	private static int यूआरऍल_गुरुमुखी_लंबाई = 0;
	private static int यूआरऍल_कन्नड़_लंबाई = 0;
	private static int यूआरऍल_लातिनी_लंबाई = 0;
	private static int यूआरऍल_मलयालम_लंबाई = 0;
	private static int यूआरऍल_उड़िया_लंबाई = 0;
	private static int यूआरऍल_तमिल_लंबाई = 0;
	private static int यूआरऍल_तेलुगु_लंबाई = 0;
	private static int यूआरऍल_मुख्य_लंबाई = 0;
	private static ArrayList<String> सिवाय = null;
	
	public static String यूआरऍलबंग्ला() {
		return यूआरऍल_बंग्ला;
	}

	public static String यूआरऍलदेवनागरी() {
		return यूआरऍल_देवनागरी;
	}

	public static String यूआरऍलगुजराती() {
		return यूआरऍल_गुजराती;
	}
	public static String यूआरऍलगुरुमुखी() {
		return यूआरऍल_गुरुमुखी;
	}
	public static String यूआरऍलकन्नड़() {
		return यूआरऍल_कन्नड़;
	}
	public static String यूआरऍललातिनी() {
		return यूआरऍल_लातिनी;
	}
	public static String यूआरऍलमलयालम() {
		return यूआरऍल_मलयालम;
	}
	public static String यूआरऍलउड़िया() {
		return यूआरऍल_उड़िया;
	}
	public static String यूआरऍलतमिल() {
		return यूआरऍल_तमिल;
	}

	public static String यूआरऍलतेलुगु() {
		return यूआरऍल_तेलुगु;
	}
	public static String यूआरऍलमुख्य() {
		return यूआरऍल_मुख्य;
	}
	public static void जमाओयूआरऍलबंग्ला(String र) {
		यूआरऍल_बंग्ला = र;
		यूआरऍल_बंग्ला_लंबाई = र.length();
	}

	public static void जमाओयूआरऍलदेवनागरी(String र) {
		यूआरऍल_देवनागरी = र;
		यूआरऍल_देवनागरी_लंबाई = र.length();
	}

	public static void जमाओयूआरऍलगुजराती(String र) {
		यूआरऍल_गुजराती = र;
		यूआरऍल_गुजराती_लंबाई = र.length();
	}

	public static void जमाओयूआरऍलगुरुमुखी(String र) {
		यूआरऍल_गुरुमुखी = र;
		यूआरऍल_गुरुमुखी_लंबाई = र.length();
	}

	public static void जमाओयूआरऍलकन्नड़(String र) {
		यूआरऍल_कन्नड़ = र;
		यूआरऍल_कन्नड़_लंबाई = र.length();
	}

	public static void जमाओयूआरऍललातिनी(String र) {
		यूआरऍल_लातिनी = र;
		यूआरऍल_लातिनी_लंबाई = र.length();
	}

	public static void जमाओयूआरऍलमलयालम(String र) {
		यूआरऍल_मलयालम = र;
		यूआरऍल_मलयालम_लंबाई = र.length();
	}

	public static void जमाओयूआरऍलउड़िया(String र) {
		यूआरऍल_उड़िया = र;
		यूआरऍल_उड़िया_लंबाई = र.length();
	}

	public static void जमाओयूआरऍलतमिल(String र) {
		यूआरऍल_तमिल = र;
		यूआरऍल_तमिल_लंबाई = र.length();
	}

	public static void जमाओयूआरऍलतेलुगु(String र) {
		यूआरऍल_तेलुगु = र;
		यूआरऍल_तेलुगु_लंबाई = र.length();
	}

	public static void जमाओयूआरऍलमुख्य(String र) {
		यूआरऍल_मुख्य = र;
		यूआरऍल_मुख्य_लंबाई = र.length();
	}

	public static int यूआरऍलबंग्लालंबाई() {
		return यूआरऍल_बंग्ला_लंबाई;
	}

	public static int यूआरऍलदेवनागरीलंबाई() {
		return यूआरऍल_देवनागरी_लंबाई;
	}

	public static int यूआरऍलगुजरातीलंबाई() {
		return यूआरऍल_गुजराती_लंबाई;
	}
	public static int यूआरऍलगुरुमुखीलंबाई() {
		return यूआरऍल_गुरुमुखी_लंबाई;
	}
	public static int यूआरऍलकन्नड़लंबाई() {
		return यूआरऍल_कन्नड़_लंबाई;
	}
	public static int यूआरऍललातिनीलंबाई() {
		return यूआरऍल_लातिनी_लंबाई;
	}
	public static int यूआरऍलमलयालमलंबाई() {
		return यूआरऍल_मलयालम_लंबाई;
	}
	public static int यूआरऍलउड़ियालंबाई() {
		return यूआरऍल_उड़िया_लंबाई;
	}
	public static int यूआरऍलतमिललंबाई() {
		return यूआरऍल_तमिल_लंबाई;
	}

	public static int यूआरऍलतेलुगुलंबाई() {
		return यूआरऍल_तेलुगु_लंबाई;
	}
	public static int यूआरऍलमुख्यलंबाई() {
		return यूआरऍल_मुख्य_लंबाई;
	}

	public static void जमाओसिवाय() {
		सिवाय = new ArrayList<String> (11);
		सिवाय.add(यूआरऍल_बंग्ला);
		सिवाय.add(यूआरऍल_देवनागरी);
		सिवाय.add(यूआरऍल_गुजराती);
		सिवाय.add(यूआरऍल_गुरुमुखी);
		सिवाय.add(यूआरऍल_कन्नड़);
		सिवाय.add(यूआरऍल_लातिनी);
		सिवाय.add(यूआरऍल_मलयालम);
		सिवाय.add(यूआरऍल_उड़िया);
		सिवाय.add(यूआरऍल_तमिल);
		सिवाय.add(यूआरऍल_तेलुगु);
		सिवाय.add(यूआरऍल_मुख्य);
		
	}
	
	public static ArrayList<String> सिवाय() {
		return सिवाय;
	}
	
}
