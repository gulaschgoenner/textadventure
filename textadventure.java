package textadventure

import java.util.Scanner;
import java.util.Random;

public class test {
	int gld = 5;
	String name = "";
	Scanner sc = new Scanner(System.in);
	boolean jm = false;
	Random r = new Random();
	
	public static void main(String[] args) {
		test jus = new test();
		jus.doStuff();
	}
	
	//story
	public void doStuff() {
		getName();
		telefonat();
		hausDurchsuchen();
		weg();
		casino();
	}
	
	public boolean doCoolStuff(String url){
		try {
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	public void printGeld() {
		System.out.println("Du hast " + gld + " Euronen. ");
	}
	
	public String getNext() {
		String nL = sc.nextLine().trim().toLowerCase();
		while(nL.equals("1") || nL.equals("2")) {
			switch(nL) {
			case "1":
				printGeld();
				break;
			case "2":
				if(jm) {
				doCoolStuff("https://www.youtube.com/watch?v=jnhTxejPYFQ");
				}
				break;
			}
			nL = sc.nextLine().trim().toLowerCase();
		}
		return nL;
	}
	
	public String getNextnoCheck() {
		return sc.nextLine();
	}
	
	public void p(String op) {
		while(op.length() > 99) {
			System.out.println(op.substring(0, 100));
			op = op.substring(100);
		}
		System.out.println(op);
	}
	public void p(String spr, String op) {
		System.out.println(spr +": "+ op);
	}
	
	public void telefonat() {
		p("*Telefon klingelt*");
		while(!false) {
			p("Möchtest du abnehmen? [Y/N]");
			if(getNext().equals("y")) {break;}
			p("Du solltest abnehmen.");
			p("*Klingeln intensifies*");
		}
		p("Wütende Stimme", "Wasch dengscht du eig wod du herg'kommen bischt. Überweisch deine 2000 Miede für letschden Monat du Oaschloch!!!");
		p("");
		p("Du solltest wohl deine Miete zahlen...[ Zahlen / Nicht zahlen ]");
		while(!getNext().equals("z")) {
			p("Du solltest Miete zahlen, weil *Logik*.");
		}
		p("Da du nen miesen Kater hast weißt du nicht mehr, wo dein Geld ist.");

		
	}
	
	public void hausDurchsuchen() {
		String ip = "";
		int i = 0;
		
		p("Durchsuche das Haus noch Moneten. [Küche/Schlafzimmer]");
		
		while (sc.hasNext()) {
			ip = getNext();
			if(ip.equals("k")) {
				p("Du hast keine Küche, du bist broke.");
				continue;
			} 
			if(ip.equals("s")) {
				p("Du gehst ins Schlafzimmer, bzw. du stehst auf, du wohnst in einer 1-Zimmer-Wohnung.");
				break;
			}
			p("Junge, zwei Optionen!");
		}
		ip = "";
		boolean s = false;
		boolean b = false;
		boolean j = false;
		while (!(s && b && j)){
			p("Im Schlafzimmer hast du einen Schrank und dein Bett. [Schrank/ Bett/ Jacke]");
			ip = getNext();
			if(ip.equals("s")) {
				if(s) {
					p("Du hast hier schon gesucht(kek)");
					continue;
				}
				p("Du durchsuchst den Schrank und findest etwas Zaster.");
				gld += 5;
				s = true;
				printGeld();
			} else if(ip.equals("b")) {
				if(b) {
					p("Du hast hier schon gesucht(kek)");
					continue;
				}
				p("Du durchsuchst das Bett und findest nur deine Kreditkarte, aber die ist gesperrt (451). Dafür findest du eine Flasche Jägermeister. Du kannst sie jederzeit trinken. [2]");
				b = true;
				jm = true;
			} else if(ip.equals("j")){
				if(j) {
					p("Du hast hier schon gesucht(kek)");
					continue;
				}
				p("In deiner Jacke findest du etwas Kohle. Du steckst es ein.");
				gld += 10;
				printGeld();
				j = true;
			} else {
				p("Versuchs nochmal...");
			}
		}
		p("Du hast den ganzen Raum abgesucht, das ist noch nicht genug.");
	}

	public void weg() {
		p("Das ist nicht genug, du musst irgendwie anders an Geld kommen. [Arbeiten/Casino]");
		String answer = "";
		answer = getNext();
		switch(answer){
		case "a":
			p("Du bist glücksspielsüchtig, das ist keine Option.");
			break;
		case "c":
			p("Du machst dich auf den Weg ins Casino.");
			break;
		default:
		p("Du hast keine anderen Optionen außer dem Casino, du bist arm. Geh jetzt dein Geld verzocken!");
		}
		p("Du machst dich auf den Weg ins Casino.");
		p("Du steigst in dein Auto. Aus der Entfernung nähert sich dein Vermieter, du beeilst dich und steigst ins Auto, doch er nähert sich schneller.");
		p("Der Vermieter gelangt zum Auto, bevor du losfahren kannst. [Aufgeben]");
		if(sc.hasNext()) {
			doCoolStuff("https://www.youtube.com/watch?v=R4SRI-v_KlU");
		}
		p("Du überzeugst den Vermieter, dass du das Geld noch zahlen kannst und fährst los.");
	}
	
	public void casino() {
		p("Du kommst im Casino an.");
		p("Jetzt musst du an deine 2000 Euro Miete kommen.");
		while(gld<2000) {
			if(gld<2000) {
				p("Du hast nur Zugang zum Standard-Bereich mit niedrigen Einsätzen. Wo gehst du hin? [Roulette]");
			} else {
				p("Du kannst mit hohen Einsätzen spielen. Was tust du? [Roulette/Hoher einsatz]");
			}
			switch(getNext()) {
				case "r": 
					roulette();
					break;
				case "h":
					if(gld>=2000) {
						p("Du gehst zum Raum mit den hohen Einsätzen. Als du dich der Tür näherst hörst du Musik...");
						try {
							Thread.sleep(9000);
							doCoolStuff("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
							
						} catch(Exception e) {
							
						}
					}
				default:
					p("Diese Abteilung existiert nicht.");
			}
			
		}
	}
	public void roulette() {
		p("Du gehst an den Roulettetisch");
		String inp = "";
		p("Roulette-Typ", "Möchtest du mitspielen? [Weiter/Zurück]");
		while(getNext().equals("w")) {
		while(true) {
			p("Worauf möchtest du setzen?");
			p("[0-36/Rot/Schwarz]");
			
			inp = getNextnoCheck();
			if(inp.equals("r") || inp.equals("s")) {
				p("Du wählst " + (inp.equals("s") ? "Schwarz." : "Rot."));
				break;
			}
			else if(inp.matches("-?\\d+")) {
				if(Integer.parseInt(inp) >= 0 && Integer.parseInt(inp) <= 36) {
					p("Du wählst " + inp);
					break;
				}
			} else {
				p("Das Feld existiert nicht.");
			}
		}
		int einsatz = 0;
		while(true) {
			p("Roulette-Typ", "Wie viel möchtest du setzen?" +"(max. "+ gld +")");
			try {
				einsatz = Integer.parseInt(getNextnoCheck());
				if(einsatz > gld || einsatz <= 0) {
					p("Du hast nicht genug Geld.");
				} else {
					break;
				}
			} catch(Exception e) {
				p("Nicht möglich du kek.");
			}
			
		}
		gld -= einsatz;
		int ergebnis = r.nextInt(37);
		p("Ergebnis: " + ergebnis);
		int reward = 0;
		if(ergebnis == 0 && inp == "0") {
			reward = einsatz*5 +r.nextInt((10)-5);
			gld += reward;
			p("Du erhältst "+ reward +" Euronen.");
		} 
		else if(Integer.toString(ergebnis).equals(inp)) {
			reward = einsatz*2 +r.nextInt((10)-1);
			p("Du erhältst "+ reward + " Euronen.");
		} 
		else if (ergebnis % 2 == 0 && inp == "s") {
			reward = einsatz +r.nextInt((10)-1);
			p("Du erhältst "+ reward + " Euronen.");
		}
		else if (ergebnis % 2 != 0 && inp == "r") {
			reward = einsatz +r.nextInt((10)-1);
			p("Du erhältst "+ reward + " Euronen.");
		} else {
			p("Roulette-Typ", "Schade, die nächste Runde wird besser.");
		}
		
	
		if(gld <= 0) {
			p("Du hast dein ganzes Geld verzockt.");
			try {
				Thread.sleep(3000);
				doCoolStuff("https://www.escapistmagazine.com/wp-content/uploads/2021/03/youdied.jpg");
				while(true) {p("*Gameplay*");}
			} catch(Exception e) {}
		}
		if(gld > 1000) {
			p("Du kannst jetzt deine Miete bezahlen...");
			p("Oder du gehst in den bereich mit hohen Einsätzen. [Miete/Hoher einsatz]");
			getNext();
			p("Du bist glücksspielsüchtig, du gehst jetzt zu den hohen Einsätzen.");	
		}
		p("Roulette-Typ", "Möchtest du nochmal? [Weiter/Zurückgehen]");
		}
	}
	public void getName() {
		p("Du kannst jederzeit* mit [1] auf deinen Kontostand aka den Inhalt deiner Hosentasche zugreifen. Optionen so dargestellt[Option1/oPtion2]. Um eine aufzurufen wähle den ersten Großbuchstaben und Enter.[Verstanden/Nee]");
		while(!getNext().equals("v")) {
			System.out.println("kek");
		}
		//nicht jederzeit
		System.out.println("Wie heißt du?");
		if(sc.hasNext()) {
			name = getNextnoCheck().toLowerCase();
		}
		if(name.contains("gönn")) {
			gld = 2000;
		} else {
			System.out.println("Komischer Name...");
		}
		printGeld();
		System.out.println("");
	}
}

