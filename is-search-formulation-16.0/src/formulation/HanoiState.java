package formulation;

import java.util.ArrayList;
import java.util.List;

public class HanoiState extends es.deusto.ingenieria.is.search.formulation.State{

	private List<Integer> list;
	private int numSoportes;

	
	public HanoiState(int numSoportes) {
		list = new ArrayList<Integer>();
		this.numSoportes = numSoportes;
	}
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 != null && arg0 instanceof HanoiState) {
			boolean equals;
			HanoiState finalState =(HanoiState) arg0;
			List<Integer> listaFinalState = finalState.getList();
			equals = true;
			for (int i = 0; i < listaFinalState.size(); i++) {
				if(listaFinalState.get(i)!=this.list.get(i)){
					equals = false;
				}
//					System.out.println("Equals: " + equals);
			}
			return equals;
		} else {
			return false;
		}
	}
	
	public HanoiState clone(){
		HanoiState clon = new HanoiState(numSoportes);
		List<Integer> clonList = new ArrayList<Integer>();
		for(int i = 0; i < this.list.size(); i++) 
		{
			clonList.add(i, list.get(i));
		}
		clon.setList(clonList);
		return clon;
	}
	
	
	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
		
	}
	
	@Override
	public String toString() {
		String string = "";
		for(int i=0;i<numSoportes;i++){
			string = string + ("Soporte " + i + ":" +"\n");
			for(int j=(list.size()-1);j>=0;j--){
				if((list.get(j))==i){
					string = string + ("[" + j + "]") + "\n";
				}
			}
		}
		string = string + "\n";
		return string;
	}
	public int getTotalHanoi() {
		int desempeño;
		int numDiscos = list.size();
		int numDiscosNoSoporteFinal = 0;
		for(int i=0;i<list.size();i++){
			if(list.get(i)!=numSoportes){
				numDiscosNoSoporteFinal= numDiscosNoSoporteFinal+1;
			}
		}
		desempeño = numDiscosNoSoporteFinal/numDiscos;
		
		
		return desempeño;
	}
	
	//Heurística Propuesta 1: Discos que están en el soporte inicial
	public int getPropuesta1() {
		int desempeño;
		int numDiscosSoporteInicial = 0;
		for(int i=0;i<list.size();i++){
			if(list.get(i) == 1){
				numDiscosSoporteInicial = numDiscosSoporteInicial+1;
			}
		}
		desempeño = numDiscosSoporteInicial;
		return desempeño;
	}
	
	//Heurística Propuesta 2: Discos que no están en el soporte final
	public int getPropuesta2() {
		int desempeño;
		int numDiscosNoSoporteFinal = 0;
		for(int i=0;i<list.size();i++){
			if(list.get(i)!=numSoportes){
				numDiscosNoSoporteFinal= numDiscosNoSoporteFinal+1;
			}
		}
		desempeño = numDiscosNoSoporteFinal;
		return desempeño;
	}
	
	//Heurística Propuesta 3: Discos que están en el soporte final + discos que están en su posición correcta del soporte final
		public int getPropuesta3() {
			int desempeño;
			int total = 0;
			int numDiscosFinal = 0;
			for(int i=0;i<list.size();i++){
				if(list.get(i)==numSoportes){
					numDiscosFinal= numDiscosFinal+1;
				}
			}
			if(list.get(0)== numSoportes){
				total = total + 5;
				if(list.size()>1){
					for(int i=1;i<list.size();i++){
						if(list.get(i) == numSoportes){
							total = total + 5;
						}
						else{
							break;
						}
					}
					
				}
			}
			
			desempeño = -(numDiscosFinal + total);
			return desempeño;
		}	

}
