package calendario;

import java.util.Calendar;


public class Main {

	public static void main(String[] args) {
		DataUtil dataUtil = new DataUtil();
		
		Calendar calendario = Calendar.getInstance();
		Calendar calendario1 = Calendar.getInstance();
		Calendar calendario2 = Calendar.getInstance();
		Calendar calendario3 = Calendar.getInstance();
		
		calendario.set(Calendar.DAY_OF_MONTH, 1);
		calendario.set(Calendar.MONTH, 8);
		calendario.set(Calendar.YEAR, 2019);
			
		calendario1.set(Calendar.DAY_OF_MONTH, 4);
		calendario1.set(Calendar.MONTH, 8);
		calendario1.set(Calendar.YEAR, 2019);
		
		calendario2.set(Calendar.DAY_OF_MONTH, 11);
		calendario2.set(Calendar.MONTH, 8);
		calendario2.set(Calendar.YEAR, 2019);
		
		calendario3.set(Calendar.DAY_OF_MONTH, 30);
		calendario3.set(Calendar.MONTH, 8);
		calendario3.set(Calendar.YEAR, 2019);
		Calendar[] feriado = {calendario1 , calendario2};
		System.out.println("Dias uteis "+ dataUtil.diadaSemana(calendario));
	}

}
