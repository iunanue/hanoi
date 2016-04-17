package heuristics;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import formulation.HanoiState;

public class HanoiEvaluationFunction extends EvaluationFunction {

	@Override
	public double calculateG(Node arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateH(Node node) {
		// TODO Auto-generated method stub
		HanoiState hanoiState = (HanoiState) node.getState();		
		return hanoiState.getPropuesta1();
//		return hanoiState.getPropuesta2();
//		return hanoiState.getPropuesta3();
	}

}
