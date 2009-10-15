package in.chitthajagat.girgit.server;

import java.util.*;
import java.util.logging.Logger;

import net.htmlparser.jericho.*;

/**
 * Copyright © 2009 Jain, Vipul(drvipuljain@gmail.com) and Kumar,
 * Alok(alok.kumar@gmail.com) under the GNU General Public License (GPL)
 * 
 * 
 */

public class Doodhwala {

	private Source स्रोत = null;
	private OutputDocument बदलू = null;
	final Logger चिट्ठा = Logger.getLogger(Doodhwala.class.getName());

	Doodhwala(String हटमल) {
		this.स्रोत = new Source(हटमल);
		this.बदलू = new OutputDocument(this.स्रोत);
	}

	Doodhwala(Source मेरा_स्रोत) {
		this.स्रोत = मेरा_स्रोत;
		this.बदलू = new OutputDocument(this.स्रोत);
	}

	Doodhwala(OutputDocument बदलूदस्तावेज़) {
		this.बदलू = बदलूदस्तावेज़;
		this.स्रोत = new Source(this.बदलू.getSourceText());
	}

	Doodhwala(Source मेरा_स्रोत, OutputDocument बदलूदस्तावेज़) {
		this.स्रोत = मेरा_स्रोत;
		this.बदलू = बदलूदस्तावेज़;
	}

	public void कड़ीमेंमिलाओ(String पानी, String दूध, String चीनी,
			ArrayList<String> सिवाय) {
		String नईकड़ी = null;
		List<StartTag> कड़ीकीथैली = this.स्रोत
				.getAllStartTags(HTMLElementName.A);
		for (int क = 0; क < कड़ीकीथैली.size(); ++क) {
			boolean मिलानाहै = true;
			StartTag येकड़ी = कड़ीकीथैली.get(क);
			String कड़ी = येकड़ी.getAttributeValue("href");
			if (कड़ी != null) {
				if (कड़ी.startsWith("http://") || कड़ी.startsWith("https://")) {
					String[] दोकड़ियाँ = कड़ी.split("://", 2);
					for (int ख = 0; ख < सिवाय.size(); ++ख) {
						
						if (दोकड़ियाँ[1].startsWith(सिवाय.get(ख))) {
							मिलानाहै = false;
							break;
						}
					}
					// पानी == गिरगिट वाला हिस्सा
					if (मिलानाहै) {
						नईकड़ी = दोकड़ियाँ[0] + "://" + पानी + "/"
								+ दोकड़ियाँ[1];
					}
				} else if (कड़ी.startsWith("/")) {
					// पानी == गिरगिट वाला हिस्सा, दूध == असली स्थल
					नईकड़ी = "http://" + पानी + "/" + दूध + /* "/" + */कड़ी;
				} else if (कड़ी.startsWith(".")) {
					// इसमें पंगा है
					नईकड़ी = "http://" + पानी + "/" + दूध + चीनी + कड़ी;
				}
				if (मिलानाहै) {
					Attributes खासियतें = येकड़ी.getAttributes();
					Attribute खासियत = खासियतें.get("href");
					Segment टुकड़ा = खासियत.getValueSegment();
					this.बदलू.replace(टुकड़ा, नईकड़ी);
					// चिट्ठा.warning("a: [" + कड़ी + "] बदल के [" + नईकड़ी +
					// "] हुई");
				}
			}
		}

	}

	public void चीनीडालो(String चीनी, String धातुनाम, String प्रकार) {
		String नईकड़ी = null;
		List<StartTag> कड़ीकीथैली = this.स्रोत.getAllStartTags(धातुनाम);
		for (int क = 0; क < कड़ीकीथैली.size(); ++क) {
			StartTag येकड़ी = कड़ीकीथैली.get(क);
			String कड़ी = येकड़ी.getAttributeValue(प्रकार);

			if (कड़ी != null) {
				if (कड़ी.startsWith("http://") || कड़ी.startsWith("https://")) {

				} else if (कड़ी.startsWith(".") || कड़ी.startsWith("/")) {
					// पानी == गिरगिट वाला हिस्सा, दूध == असली स्थल
					नईकड़ी = "http://" + चीनी + कड़ी;
					Attributes खासियतें = येकड़ी.getAttributes();
					Attribute खासियत = खासियतें.get(प्रकार);
					Segment टुकड़ा = खासियत.getValueSegment();
					this.बदलू.replace(टुकड़ा, नईकड़ी);

					// चिट्ठा.warning(धातुनाम + ":" + प्रकार + ":" + "[" + कड़ी
					// + "] बदल के [" + नईकड़ी
					// + "] हुई");

				}

			}
		} // for
		/*
		 * List<StartTag> लिंकथैली = this.स्रोत.getAllStartTags("link"); for
		 * (int क = 0; क < लिंकथैली.size(); ++क) { StartTag येकड़ी =
		 * कड़ीकीथैली.get(क); String कड़ी = येकड़ी.getAttributeValue("href"); if
		 * (कड़ी != null) { if (कड़ी.startsWith("http://") ||
		 * कड़ी.startsWith("https://")) {
		 * 
		 * } else if (कड़ी.startsWith(".") || कड़ी.startsWith("/")) { // पानी ==
		 * गिरगिट वाला हिस्सा, दूध == असली स्थल नईकड़ी = "http://" + चीनी +
		 * कड़ी; Attributes खासियतें = येकड़ी.getAttributes(); Attribute खासियत
		 * = खासियतें.get("href"); Segment टुकड़ा = खासियत.getValueSegment();
		 * this.बदलू.replace(टुकड़ा, नईकड़ी); चिट्ठा.warning("link: [" + कड़ी +
		 * "] बदल के [" + नईकड़ी + "] हुई");
		 * 
		 * } } } //for
		 */
	}

	public void सीऍसऍसबदलो(String चीनी) {
		List<StartTag> स्टाइलथैली = this.स्रोत.getAllStartTags("style");
		for (int क = 0; क < स्टाइलथैली.size(); ++क) {
			StartTag येस्टाइल = स्टाइलथैली.get(क);
			Attributes खासियतें = येस्टाइल.getAttributes();
			if (खासियतें != null) {
				Attribute खासियत = खासियतें.get("type");
				if (खासियत != null && खासियत.getValue() != null
						&& खासियत.getValue().equals("text/css")) {
					Element पूरा = येस्टाइल.getElement();
					if (पूरा.isEmpty() == false) {
						Segment शुरुआत = new Segment(स्रोत,
								येस्टाइल.getBegin(), येस्टाइल.getEnd());
						Segment अंत = new Segment(स्रोत, पूरा.getEndTag()
								.getBegin(), पूरा.getEndTag().getEnd());
						Segment टुकड़ा = new Segment(स्रोत,
								येस्टाइल.getEnd() + 1, पूरा.getEndTag()
										.getBegin() - 1);

						// चिट्ठा.warning(टुकड़ा.toString());
						StringBuilder रस्सी = new StringBuilder(टुकड़ा
								.toString());
						इंपोर्टबदलो(रस्सी, चीनी);
						// कड़ीबदलो(रस्सी, चीनी);

						this.बदलू.replace(पूरा, शुरुआत.toString()
								+ रस्सी.toString() + अंत.toString());
						चिट्ठा.fine("style: [" + टुकड़ा.toString()
								+ "] बदल के [" + रस्सी.toString() + "] हुई");
						चिट्ठा.fine(this.बदलू.getDebugInfo());
					}
				}
			}
		}
	}

	public void रोबोटडालो() {
		boolean मिला = false;
		List<StartTag> मेटाथैली = this.स्रोत
				.getAllStartTags(HTMLElementName.META);
		for (int क = 0; क < मेटाथैली.size(); ++क) {
			StartTag मेटा = मेटाथैली.get(क);
			Attributes खासियतें = मेटा.getAttributes();
			if (खासियतें != null) {
				Attribute पहलीखासियत = खासियतें.get("content");
				if (पहलीखासियत != null && पहलीखासियत.getValue() != null
						&& पहलीखासियत.getValue().equals("allow-index")) {
					Attribute दूसरीखासियत = खासियतें.get("name");
					if (दूसरीखासियत != null && दूसरीखासियत.getValue() != null
							&& दूसरीखासियत.getValue().equals("tell-girgit")) {
						मिला = true;
						चिट्ठा.fine("tell-girgit मिला");
						break;
					}
				}
			}
		}
		if (मिला == false) { // अभी तक नहीं मिला है
			List<StartTag> टिप्पणीथैली = this.स्रोत
					.getAllStartTags(StartTagType.COMMENT);
			for (int क = 0; क < टिप्पणीथैली.size(); ++क) {
				StartTag टिप्पणी = टिप्पणीथैली.get(क);
				if (टिप्पणी.getTagContent().toString().contains(
						"girgitallowindex")) {
					मिला = true;
					चिट्ठा.fine("girgitallowindex मिला");
					break;
				}
			}

		}

		if (मिला == false) {
			चिट्ठा
					.fine("tell-girgit और girgitallowindex में से कोई भी नहीं मिला");
			boolean सिरमिला = false;
			List<StartTag> सिरथैली = this.स्रोत
					.getAllStartTags(HTMLElementName.HEAD);
			for (int क = 0; क < सिरथैली.size(); ++क) {
				StartTag सिर = सिरथैली.get(क);

				Element मेरासर = सिर.getElement();
				Segment टुकड़ा = मेरासर.getContent();
				this.बदलू.replace(टुकड़ा,
						"<meta name=\"robots\" content=\"noindex,nofollow\"/>"
								+ टुकड़ा.toString());
				break; // पहला मिल गया बहुत है
			}

		}

	}

	private void इंपोर्टबदलो(StringBuilder रस्सी, String चीनी) {
		int लंबाई = रस्सी.length();
		while (लंबाई >= 0) {

			int इंपोर्टकीजगह = रस्सी.lastIndexOf("@import", लंबाई);
			if (इंपोर्टकीजगह == -1) {
				break;
			}
			int यहाँसे = इंपोर्टकीजगह + "@import".length() + 1;
			int क = 0;
			while ((यहाँसे + क) < रस्सी.length()) {
				char उ = रस्सी.charAt(यहाँसे + क);

				if (उ == '\"') {
					char यूआरऍलशुरू = रस्सी.charAt(यहाँसे + क + 1);
					if ((रस्सी.substring(यहाँसे + क + 1, यहाँसे + क + 1
							+ "http://".length())).equals("http://")) {
						लंबाई = इंपोर्टकीजगह - 1;
						break;
					} else if (यूआरऍलशुरू == '/') {
						रस्सी.insert(यहाँसे + क + 1, "http://" + चीनी);
						लंबाई = इंपोर्टकीजगह - 1;
						break;
					} else { // ., .., या बिना http:// वाले - का कुछ करना पड़ेगा
						// फ़िलहाल बस छोड़ रहे हैं
						लंबाई = इंपोर्टकीजगह - 1;
						break;
					}
				} else { // अभी " नहीं आया है, आगे बढ़ो पर लंबाई तक ही
					++क;
				}

			}

		}
	}

	private void कड़ीबदलो(StringBuilder रस्सी, String चीनी) {

	}

	public void परिचयडालो(String परिचय) {

		if (परिचय == null || परिचय.trim().length() == 0) {
			return;
		}
		List<StartTag> शवकीथैली = this.स्रोत
				.getAllStartTags(HTMLElementName.BODY);
		for (int क = 0; क < शवकीथैली.size(); ++क) {
			StartTag येशव = शवकीथैली.get(क);
			Element शव = येशव.getElement();
			Segment टुकड़ा = शव.getContent();
			this.बदलू.replace(टुकड़ा, परिचय + टुकड़ा.toString());
		} // for
	}

}