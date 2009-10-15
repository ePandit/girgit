/**
 * 
 */
package in.chitthajagat.girgit.server;

import net.htmlparser.jericho.*;

import java.util.*;

/**
 * Copyright © 2009 Jain, Vipul(drvipuljain@gmail.com) and Kumar, Alok(alok.kumar@gmail.com) under the GNU General Public License (GPL)
 *
 * 
 */
public class Bandar {

	private Source स्रोत = null;
	private OutputDocument बदलू = null;

	Bandar(String हटमल) {
		this.स्रोत = new Source(हटमल);
		बदलू = new OutputDocument(this.स्रोत);
	}

	Bandar(Source मेरा_स्रोत) {
		this.स्रोत = मेरा_स्रोत;
		बदलू = new OutputDocument(this.स्रोत);
	}

	Bandar(OutputDocument बदलूदस्तावेज़) {
		this.बदलू = बदलूदस्तावेज़;
		स्रोत = new Source(this.बदलू.getSourceText());
	}

	Bandar(Source मेरा_स्रोत, OutputDocument बदलूदस्तावेज़) {
		this.स्रोत = मेरा_स्रोत;
		this.बदलू = बदलूदस्तावेज़;
	}

	public String जूँनिकालो() {
		for (Iterator<Segment> उँगली = this.स्रोत.getNodeIterator(); उँगली
				.hasNext();) {
			Segment हिस्सा = उँगली.next();
			if (हिस्सा instanceof CharacterReference) {
				List<CharacterReference> थैली = हिस्सा
						.getAllCharacterReferences();

				for (int क = 0; क < थैली.size(); ++क) {
					CharacterReference खटमल = थैली.get(क);
					एकज़ूज़ूबदलो(खटमल, बदलू);
				}
			}

			else if (हिस्सा instanceof Tag) {
				ज़ूज़ूनिकालो(हिस्सा, बदलू, HTMLElementName.A, "title");
				ज़ूज़ूनिकालो(हिस्सा, बदलू, HTMLElementName.IMG, "alt");

			}

		}
		return बदलू.toString();

	}

	public boolean देवनागरीहै(CharacterReference अक्षर) {
		int कूटबिंदु = CharacterReference
				.getCodePointFromCharacterReferenceString(अक्षर);
		if (कूटबिंदु >= 2305 && कूटबिंदु <= 2421) {
			return true;
		}
		return false;

	}

	private void ज़ूज़ूनिकालो(Segment हिस्सा, OutputDocument बदलू, String नाम,
			String खासियत) {
		List<StartTag> पट्टियाँ = हिस्सा.getAllStartTags(नाम);
		for (int क = 0; क < पट्टियाँ.size(); ++क) {
			StartTag पट्टी = पट्टियाँ.get(क);

			Attributes खासियतें = पट्टी.getAttributes();
			Attribute शीर्षक = खासियतें.get(खासियत);
			if (शीर्षक != null) {
				Segment टुकड़ा = शीर्षक.getValueSegment();

				String लेख = टुकड़ा.toString();
				Source लेखस्रोत = new Source(लेख);
				OutputDocument बदलालेख = new OutputDocument(लेखस्रोत);
				for (Iterator<Segment> ख = लेखस्रोत.getNodeIterator(); ख
						.hasNext();) {
					Segment पत्ती = ख.next();
					if (पत्ती instanceof CharacterReference) {
						List<CharacterReference> पोटली = पत्ती
								.getAllCharacterReferences();

						for (int ग = 0; ग < पोटली.size(); ++ग) {
							CharacterReference जूँ = पोटली.get(ग);
							एकज़ूज़ूबदलो(जूँ, बदलालेख);
						}

					}
				}
				बदलू.replace(टुकड़ा, बदलालेख.toString());
			}
		}
	}

	private void एकज़ूज़ूबदलो(CharacterReference ज़ूज़ू, OutputDocument यहाँलिखो) {
		if (ज़ूज़ू.getUnicodeText().equals("U+200D")) {
			// System.out.println("zu detected!");
			यहाँलिखो.replace(ज़ूज़ू, "");
		} else if (ज़ूज़ू.getUnicodeText().equals("U+200C")) {

			// System.out.println("zuzu detected!");
			यहाँलिखो.replace(ज़ूज़ू, "");
		} else {
			if (देवनागरीहै(ज़ूज़ू)) {
				यहाँलिखो.replace(ज़ूज़ू, CharacterReference.decode(ज़ूज़ू
						.toString()));
			}
		}
	}
}

