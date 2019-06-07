package ejercicio1.GrafosVirtuales;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


import us.lsi.astar.AStarAlgorithm;
import us.lsi.astar.AStarGraph;
import us.lsi.astar.AStarSimpleVirtualGraph;
import us.lsi.graphs.SimpleEdge;



public class TestProblema1GV {
	public static void main(String[] args) {
		List<Integer> ls = new ArrayList<>();
		ls.add(5);ls.add(8);ls.add(11);ls.add(1);ls.add(3);ls.add(1);ls.add(1);ls.add(2);ls.add(10);ls.add(6);
		
		
		VertexElement c = new VertexElement(ls);
		
		Predicate<VertexElement> goal = (VertexElement v)->CMP(v);
		
		AStarGraph<VertexElement,SimpleEdge<VertexElement>> graph = AStarSimpleVirtualGraph.of(x->x.getEdgeWeight());
		AStarAlgorithm<VertexElement,SimpleEdge<VertexElement>> a = AStarAlgorithm.of(graph,c,goal,null);
		System.out.println(a.getShortestPath().getEdgeList());
		
	
		
		
	}
	public static Boolean CMP(VertexElement v) {
		Integer s1 = v.getC1().stream().mapToInt(x->x).sum();
		Integer s2 = v.getC2().stream().mapToInt(x->x).sum();
		Boolean res = s1.equals(s2);
		Boolean size1 = v.getC1().size() < v.getC2().size();
		Boolean size2 = v.getC1().size()  > v.getC2().size();
		return res && (size1 || size2);
	}
	
	

}