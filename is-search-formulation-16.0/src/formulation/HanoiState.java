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
		int numDiscosSoporteFinal = 0;
		for(int i=0;i<list.size();i++){
			if(list.get(i)==numSoportes){
				numDiscosSoporteFinal= numDiscosSoporteFinal+1;
			}
		}
		desempeño = numDiscosSoporteFinal/numDiscos;
		
		
		return desempeño;
	}

}
