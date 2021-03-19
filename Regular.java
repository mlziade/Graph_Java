package java.grafo;

public class Regular extends Grafo{

    public Regular(){
    }

    public boolean analisaRegular(Grafo g){
        boolean primeiraVez = true;
        int qtdVizPrim = 0;

        Lista no = g.prim;
        if (no.prox_no == null) return true; //Se so tiver 1 no no grafo
        do{ //Verifica para cada no
            Vizinho aux = no.prox_viz;
            int qtdViz = 0;
            while (aux != null) { //Se vizinho não for null
                if(primeiraVez) qtdVizPrim += 1;
                else qtdViz += 1;
                aux = aux.prox;
            }

            if(!primeiraVez) if (qtdViz != qtdVizPrim) return false;
            if(primeiraVez) primeiraVez = false;
            no = no.prox_no;
        }while(no != null);

        return true;
    }
}
