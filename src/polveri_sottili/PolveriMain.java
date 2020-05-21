package polveri_sottili;

import mylib.InputDati;
/**
 * 
 * @author Kevin Salvetti , Michele Mozzanica
 * Programma per il controllo delle polveri sottili nell' aria.
 *
 */
public class PolveriMain {

	private final static String MESS_BENVENUTO = "\nBENVENUTO NEL PROGRAMMA DI MONITORAGGIO DELLE POVERI SOTTILI\n\n";
	private final static String DATI_SETTIMANA = "\nRIEPILOGO DEI DATI DELLA SETTIMANA\n";
	private final static String INSERIMENTO_ANNO = "Inserire l'anno a cui la settimana appartiene:";
	private final static String INSERIMENTO_NUM_SETTIMANA = "Inserire il numero della settimana all'interno dell'anno:";
	private final static String MEX_INSERT_MISURE = "Inserire il valore di polveri sottili del giorno ";
	private final static String MESS_FINE_PROGRAMMA = "VUOI CONTINUARE?";
	private final static String MESS_USCITA_PROGRAMMA = "ARRIVEDERCI, GRAZIE PER AVER USATO IL PROGRAMMA POLVERI SOTTILI ";
	
	private final static String ALLARME_MAX = "IL VALORE DI POLVERI SOTTILI GIORNALIERO HA SUPERATO LA SOGLIA MASSIMA!";
	private final static String ALLARME_MEDIO = "IL VALORE DI POLVERI SOTTILI SETTIMANALE HA SUPERATO LA SOGLIA MASSIMA!";

	private final static int GIORNI_SETTIMANA = 7;
	private final static int ANNO_MINIMO = 1950;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(MESS_BENVENUTO);
		
		do {
		SettimanaPolveri datiRaccolti = creaSettimana();

		System.out.println(DATI_SETTIMANA);
		System.out.println(datiRaccolti.toString());

		if (datiRaccolti.allarmeMax()) {
			System.out.println(ALLARME_MAX);
		}
		if (datiRaccolti.allarmeMedio()) {
			System.out.println(ALLARME_MEDIO);
		}
	
		
		}while(InputDati.yesOrNo(MESS_FINE_PROGRAMMA));
		
		System.out.println(MESS_USCITA_PROGRAMMA);
	}
	
	/**
	 * Metodo per la creazione di un oggetto settimana
	 * @return oggetto SettimanaPolveri contenenti i dati inseriti dall' utente
	 */
	

	private static SettimanaPolveri creaSettimana() {

		int anno = InputDati.leggiInteroConMinimo(INSERIMENTO_ANNO, ANNO_MINIMO);
		int numeroSettimana = InputDati.leggiIntero(INSERIMENTO_NUM_SETTIMANA, 1, 53);
		int[] misure = new int[GIORNI_SETTIMANA];
		for (int i = 0; i < misure.length; i++) {
			misure[i] = InputDati.leggiInteroConMinimo(MEX_INSERT_MISURE + (i + 1) + "\t", 0);
		}

		return new SettimanaPolveri(anno, numeroSettimana, misure);
	}

}
