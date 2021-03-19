package java.grafo;

public class Vizinho {

    int no_viz;
    Vizinho prox;

    Vizinho(int c){
        no_viz = c;
        prox = null;
    }
    public String toString(){ return no_viz + " "; }
}
