package polygoni;

import java.util.ArrayList;


public class Logiikka {

	static class Piste {
		int x;
		int y;
		
		public Piste(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private ArrayList<Piste> polynomi = new ArrayList<Piste>();
	static int LOPUTON = 10000;
	
	//laitetaan polynomi piste muotoon myöhemmin tarkastetaan että onnistuiko se
	public void setPolynomi(String polynomi) {
		if(!this.polynomi.isEmpty()) {
			this.polynomi.clear();
		}
		String piste[] = polynomi.split("\\)");
		int i = 0;
		while(i < piste.length-1) {
			String vali[] = piste[i].replace("(", "").split(",");
			int x = Integer.parseInt(vali[0]);
			int y = Integer.parseInt(vali[1]);
			this.polynomi.add(new Piste(x,y));
			i++;
		}
	}
	
	Logiikka(String polynomi){
		setPolynomi(polynomi);
	}
	
	/*
	 * Katsoo onko piste q pisteiden p ja r muodostamalla janalla
	 */
	static boolean janalla(Piste p, Piste q, Piste r) {
		if(q.x <= Math.max(p.x, r.x) &&
           q.x >= Math.min(p.x, r.x) &&
           q.y <= Math.max(p.y, r.y) &&
           q.y >= Math.min(p.y, r.y)){
			return true;
        }
        return false;
	}
	
	/*
	 * Katsoo suunan järjestetyissä kolmessa pisteessä.
	 * Funktio palauttaa seuraavia arvoja suunan perusteella
	 * 0 jos ovat samalla suoralla
	 * 1 jos on myötäpäivää ja
	 * 2 jos on vastapäivää.
	 */
	static int suunta(Piste p, Piste q, Piste r) {
		int arvo = (q.y - p.y)*(r.x - q.x) - (q.x - p.x)*(r.y - q.y);
		if(arvo == 0) {
			return 0;
		}
		return (arvo > 0) ? 1 : 2;
	}
	
	/*
	 * Funktio palauttaa true jos janat p1q1 ja p2q2 leikaavat toisensa
	 */
	
	static boolean leikkaavat(Piste p1, Piste q1, Piste p2, Piste q2) {
		// katsoo suunan perustarkastuksien varten
        int s1 = suunta(p1, q1, p2);
        int s2 = suunta(p1, q1, q2);
        int s3 = suunta(p2, q2, p1);
        int s4 = suunta(p2, q2, q1);
 
        // yleinen tapaus
        if(s1 != s2 && s3 != s4){
            return true;
        }
 
        // erikoistapausksia p1, q1 ja p2 ovat samalla suoralla ja p2 on janalla p1q1
        if(s1 == 0 && janalla(p1, p2, q1)){
            return true;
        }
 
        // p1, q1 ja p2 ovat samalla viivalla ja q2 sijaitsee janalla p1q1
        if(s2 == 0 && janalla(p1, q2, q1)){
            return true;
        }
 
        // p2, q2 ja p1 ovat samalla suoralla ja p1 sijaitsee janalla p2q2
        if(s3 == 0 && janalla(p2, p1, q2)){
            return true;
        }
 
        // p2, q2 ja q1 ovat samalla suoralla ja q1 sijaitsee janalla p2q2
        if(s4 == 0 && janalla(p2, q1, q2)){
            return true;
        }
 
        // Ei mene mihinkään näistä
        return false;
	}
	

    private String sisalla(Piste p){
    	
        // Pitää olla vähintää 3 pistettä polynomissa, jotta sen sisällä voi olla piste
        if(polynomi.size() < 3){
            return "ulkona, ";
        }
 
        // tehdään piste janaan varten p:stä loputtomaan
        Piste iso = new Piste(LOPUTON, p.y);
 
        // laskee kuinka monta kertaa pisteen viiva ylittää polynomin sivuja
        int count = 0, i = 0;
        do{
            int seuraava = (i + 1) % polynomi.size();
            //katsoo jos jana p:stä lopputomaan leikkaa viivan polynomi.get(i):n ja polynomi.get(seuraava):n kanssa
            if(leikkaavat(polynomi.get(i), polynomi.get(seuraava), p, iso)){
            	// Jos piste p on linjassa janan i-seuraavan kanssa, niin tarkistetaan onko se janalla. 

                if(suunta(polynomi.get(i), p, polynomi.get(seuraava)) == 0){
                	if(janalla(polynomi.get(i), p, polynomi.get(seuraava))) {
                    return "reunaviivalla, ";
                	}
                }
                count++; 
            }
            i = seuraava;
        } while(i != 0);
 
        if((count % 2 == 1)) {
        	return "sisällä, ";
        }
        
        return "ulkona, ";
        
    }
 
	
	//saa muodossa (x,y
	public String pisteTarkistus(String piste) {
		String vali[] = piste.replace("(", "").split(",");
		int x = Integer.parseInt(vali[0]);
		int y = Integer.parseInt(vali[1]);
		Piste tutkittavaPiste = new Piste(x,y);
	
		return sisalla(tutkittavaPiste);
	}
}
