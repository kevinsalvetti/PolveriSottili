package polveri_sottili;

public class SettimanaPolveri {

	private final static String MEX_USCITA = "Settimana numero %d dell'anno %d %n ";
	private final static String ANALISI_MISURA = "Giorno: %d - Misura = %d %n";

	private final static double MAX_PER_GIORNO = 75.00;
	private final static double MEDIO_PER_SETTIMANA = 50.00;
	private final static int GIORNI_SETTIMANA = 7;

	private int anno;
	private int numeroSettimana;
	private int[] misure;

	public SettimanaPolveri(int anno, int numeroSettimana, int[] misure) {
		this.anno = anno;
		this.numeroSettimana = numeroSettimana;
		this.misure = misure;
	}

	/**
	 * Metodo per il controllo del dato inserito dall' utente comunicando un allarme
	 * se è maggiore di 75.00.
	 * 
	 * @return true o false
	 */

	public boolean allarmeMax() {
		double max = 0;

		for (int i = 0; i < misure.length; i++) {
			if (misure[i] >= max) {

				max = misure[i];
			}
		}

		if (max >= MAX_PER_GIORNO) {
			return true;
		}
		return false;
	}

	/**
	 * Metodo per il controllo della settimana inserita dall' utente comunicando un
	 * allarme se la media è maggiore di 50.00.
	 * 
	 * @return true o false
	 */

	public boolean allarmeMedio() {
		double media = 0;
		for (int j = 0; j < misure.length; j++) {
			media += misure[j];
		}
		media /= GIORNI_SETTIMANA;

		if (media >= MEDIO_PER_SETTIMANA) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {

		StringBuffer risultato = new StringBuffer();
		risultato.append(String.format(MEX_USCITA, numeroSettimana, anno));

		for (int i = 0; i < misure.length; i++) {
			risultato.append(String.format(ANALISI_MISURA, i + 1, misure[i]));
		}

		return risultato.toString();
	}

}
