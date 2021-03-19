package java.grafo;

public class Lista {

    int no; //No de origem
    Vizinho prox_viz; //java.grafo.Lista encadeada vizinhos
    Lista prox_no; //java.grafo.Lista encadeada nos

    Lista(int c){ //Construtor
        no = c;
        prox_viz = null;
        prox_no = null;
    }
    Vizinho pertence(int no){ //Testa se o no é vizinho e esta na lista encadeada de vizinhos
        Vizinho resp = prox_viz;
        while((resp != null) && (no != resp.no_viz))
            resp = resp.prox;
        return resp;
    }
    void ins_Viz(int c){ //Insere no na primeira posição da lista encadeada de vizinhos
        Vizinho v = pertence(c);
        if(v != null) return;
        v = new Vizinho(c);
        v.prox = prox_viz;
        prox_viz = v;
    }
    public String toString(){
        String resp = no + "(" + "): \n";
        Vizinho p = prox_viz;
        while(p != null){
            resp += p.toString();
            p = p.prox;
        }
        return resp + "\n";
    }


}
