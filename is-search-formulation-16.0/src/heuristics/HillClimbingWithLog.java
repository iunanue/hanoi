
package heuristics;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.BestFS;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import es.deusto.ingenieria.is.search.algorithms.log.SearchLog;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HillClimbingWithLog
extends BestFS {
    private List<Node> successorNodes;

	public HillClimbingWithLog(EvaluationFunction function) {
        super(function);
    }

    @Override
    public Node search(Problem problem, State initialState) {
		//A list to keep the nodes generated during the search process.
		List<Node> frontier = new ArrayList<Node>();
		//List of states generated during the search process. This is used to check for repeated states.
		List<State> generatedStates = new ArrayList<State>();
		//List of states expended during the search process. This is used to check for repeated states.
		List<State> expandedStates = new ArrayList<State>();
		//First node in the list of generated nodes.
		Node firstNode = null;
		//successor nodes list.
		List<Node> successorNodes = null;
		//Flag that signals whether a solution has been found.
		boolean solutionFound = false;
		boolean solucionLocal = false;
		//Defines and initializes the search log.
		SearchLog searchLog = this.createSearchLog();
		
		//Initialize the generated nodes list with a node containing the problem's initial state.
		frontier.add(new Node(initialState));

		//Loop until the problem is solved or the generated nodes list is empty
		while ((!solutionFound && !frontier.isEmpty())|| solucionLocal==false ) {			
			//write the content of the generated nodes list in the search log.
			this.writeInSeachLog(searchLog, frontier);			
			//remove the first node from the generated nodes list.
			firstNode = frontier.remove(0);
			
			//If the first node contains a problem's final state
			if (problem.isFinalState(firstNode.getState())) {
				//change the flag to signal that the problem is solved
				solutionFound = true;
				continue;
			//If the first node doesn't contain a problem's final state				
			} else {
				//Expand the first node.
				successorNodes = this.expand(firstNode, problem, generatedStates, expandedStates);
				//If new successor nodes resulted from the expansion
				if ((successorNodes != null) && (!successorNodes.isEmpty())) {
					
					frontier.addAll(successorNodes);
					Collections.sort(frontier);
					if(firstNode.getH()<=frontier.get(0).getH()){
						
						solucionLocal = true;
					}
				}
			}
		}
		
		// closes the search log.
		this.closeSearchLog(searchLog);
		
		// If the problem is solved
		if (solutionFound) {
			//Return the first node as it contains the problem's final state
			return firstNode;
		//If the problem is not solved
		} else {
			//return null
			return null;
		}
	}
}

