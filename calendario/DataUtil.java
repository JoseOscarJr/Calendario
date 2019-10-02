package calendario;

import java.util.Calendar;
import java.util.Date;


public class DataUtil {

	public int quantidadeSab(Calendar inicio, Calendar fim) {
		int sab = 0;
		while(inicio.getTime().before(fim.getTime())) {
			if(inicio.get(Calendar.DAY_OF_WEEK) == 7) {
				sab++;
			}
			inicio.set(Calendar.DAY_OF_MONTH, inicio.get(Calendar.DAY_OF_MONTH) +1 );
		}
		return sab;
	}
	public int quantidadeDom(Calendar inicio, Calendar fim) {
		int dom = 0;
		while(inicio.getTime().before(fim.getTime())) {
			if(inicio.get(Calendar.DAY_OF_WEEK) == 1 ) {
				dom++;
			}
			inicio.set(Calendar.DAY_OF_MONTH, inicio.get(Calendar.DAY_OF_MONTH) +1 );
		}
		return dom;
	}
	public int quantidadeDiasUteis(Calendar inicio, Calendar fim, Calendar[] feriado) {
		int diasUteis = 0;
		boolean flag =false;
		
		while(inicio.getTime().before(fim.getTime())) {
			flag =false;
			for (int i = 0; i < feriado.length; i++) {
				if((inicio.get(Calendar.DAY_OF_MONTH) == feriado[i].get(Calendar.DAY_OF_MONTH) && 
						inicio.get(Calendar.MONTH) == feriado[i].get(Calendar.MONTH))
						|| inicio.get(Calendar.DAY_OF_WEEK) == 7 || inicio.get(Calendar.DAY_OF_WEEK) == 1) {
					flag = true;
				}
			}
			if(flag == false) {
				diasUteis++;
			}
			inicio.set(Calendar.DAY_OF_MONTH, inicio.get(Calendar.DAY_OF_MONTH) +1 );
		}
		return diasUteis;
	}
	public int diasPagamentos(int parcelas, Calendar[] feriado) {
		Calendar inicio = Calendar.getInstance();
		int cont =0;
		boolean flag = true;
		for (int i = 0; i < parcelas; i++) {
			while(flag) {	
				if(inicio.get(Calendar.DAY_OF_WEEK) != 7 && inicio.get(Calendar.DAY_OF_WEEK) != 1) {
					for (int j = 0; j < feriado.length; j++) {
						if(inicio.get(Calendar.DAY_OF_MONTH) == feriado[j].get(Calendar.DAY_OF_MONTH) && 
								inicio.get(Calendar.MONTH) == feriado[j].get(Calendar.MONTH)&& 
								inicio.get(Calendar.YEAR) == feriado[j].get(Calendar.YEAR)) {
							inicio.set(Calendar.DAY_OF_MONTH, inicio.get(Calendar.DAY_OF_MONTH) +1 );
							cont++;
						}else {
							System.out.println("parcela "+ i+ "--->"+inicio.getTime());
							flag = false;
							break;
						}
					}
				}else {
					inicio.set(Calendar.DAY_OF_MONTH, inicio.get(Calendar.DAY_OF_MONTH) +1 );
					cont++;
					
				}
			}
			inicio.set(Calendar.MONTH, inicio.get(Calendar.MONTH) +1 );
			inicio.set(Calendar.DAY_OF_MONTH, inicio.get(Calendar.DAY_OF_MONTH) -cont );
			flag = true;
			cont = 0;
		}

		return 0;
	}
	public String diadaSemana(Calendar data) {
		String dataString;
		if(data.get(Calendar.DAY_OF_WEEK) == 1) {
			dataString = "Domingo";
		}else if(data.get(Calendar.DAY_OF_WEEK) == 2) {
			dataString = "Segunda";
		}else if(data.get(Calendar.DAY_OF_WEEK) == 3) {
			dataString = "Terça";
		}else if(data.get(Calendar.DAY_OF_WEEK) == 4) {
			dataString = "Quarta";
		}else if(data.get(Calendar.DAY_OF_WEEK) == 5) {
			dataString = "Quinta";
		}else if(data.get(Calendar.DAY_OF_WEEK) == 6) {
			dataString = "Sexta";
		}else {
			dataString = "Sabado";
		}
		return dataString;
	}
	
}
