package ejercicio1.GrafosVirtuales;


import us.lsi.astar.AStarGraph;
import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.SimpleVirtualGraph;

public class VerticeElemento extends SimpleVirtualGraph<VertexElement, SimpleEdge<VertexElement>> implements AStarGraph<VertexElement, SimpleEdge<VertexElement>>{	
	
	public static VerticeElemento create(VertexElement...v) {
		return new VerticeElemento();
	}
	
	protected VerticeElemento(VertexElement...elements){
		super(elements);
	}
}
