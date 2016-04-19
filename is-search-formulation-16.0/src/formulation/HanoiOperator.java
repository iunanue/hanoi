package formulation;

import es.deusto.ingenieria.is.search.formulation.State;

public class HanoiOperator  extends es.deusto.ingenieria.is.search.formulation.Operator{


	private int disco;
	private int soporteDestino;
	private int numSoportes;

	
	
	public HanoiOperator(int disco, int soporteDestino, int numSoportes){
		super();
		this.disco = disco;
		this.soporteDestino = soporteDestino;
		this.numSoportes = numSoportes;
	}
	
	@Override
	protected State effect(State arg0) {
		HanoiState newState = (HanoiState) ((HanoiState)arg0).clone();
		newState.getList().set(disco, soporteDestino);
		return newState;
	}

	@Override
	protected boolean isApplicable(State state) {
		HanoiState hanoiState = (HanoiState) state;
		boolean isApplicable = true;

		int soporteOrigen = hanoiState.getList().get(disco);
//		System.out.println(
//				"\nDisco: " + disco + " Soporte destino: " + soporteDestino + " Soporte origen: " + soporteOrigen);

		if (soporteDestino == soporteOrigen) {// -El soporte destino no sea el
												// mismo que el soporte origen
			isApplicable = false;
//			System.out.println("El soporte destino no sea el mismo que el soporte origen");
//			System.out.println(isApplicable);
		} else {
			if ((disco) == (hanoiState.getList().size() - 1)) {
				isApplicable = true;
//				System.out.println("Es el mas pequeño");
//				System.out.println(isApplicable);
			} else {
				if((disco) == (hanoiState.getList().size()-1))
					isApplicable = true;
				else{
					for (int i=disco+1; i<hanoiState.getList().size(); i++) {
						int soporteAux = hanoiState.getList().get(i);
							if(soporteAux == soporteOrigen){
								isApplicable = false;
//								System.out.println("No haya discos más pequeños en el soporte origen");
//								System.out.println(isApplicable);
							}
							else{
								if(soporteAux==soporteDestino){
									isApplicable = false;
//									System.out.println("Que no haya discos más pequeños en el soporte destino");
//									System.out.println(isApplicable);
								}			
							}		
					}
				}
			}
		}
		return isApplicable;
	}

}
