package java.grafo;

import java.util.ArrayList;
import java.util.List;

public class Bipartido extends Grafo{

    private static int AZUL = 0;
    private static int VERDE = 0;

    private int[] azul;
    private int qtdAzul;
    private int[] verde;
    private int qtdVerde;

    public Bipartido(Grafo g){
        Lista aux = g.prim;
        int totalNos = 0;
        while(aux != null){
            totalNos += 1;
            aux = aux.prox_no;
        }

        this.azul = new int[totalNos];
        this.qtdAzul = 0;
        this.verde = new int[totalNos];
        this.qtdVerde = 0;
    }

    void addNaCor(int no, int cor){
        if(cor == AZUL){
            azul[qtdAzul] = no;
            qtdAzul += 1;
        }
        if(cor == VERDE){
            verde[qtdVerde] = no;
            qtdVerde += 1;
        }
    }

    boolean pertenceCor(int no, int cor) {
        if (cor == AZUL) {
            for (int i = 0; i < qtdAzul; i++) {
                if (this.azul[i] == no) return true;
            }
        }
        if (cor == VERDE) {
            for (int i = 0; i < qtdVerde; i++) {
                if (this.verde[i] == no) return true;
            }
        }
        return false;
    }

    public boolean analisaBipartido(Grafo g){
        if((g.prim == null) || (g.prim.prox_no == null)) return false;
        List<Integer> cjtoU = new ArrayList<>();
        List<Integer> cjtoV = new ArrayList<>();
        Lista p = g.prim;

        while(p != null){
            Vizinho viz = p.prox_viz;
            while(viz != null){
                int i;
                for(i = 0; i < cjtoV.size(); i++){
                    int elem = cjtoV.get(i).intValue();
                    if(elem == viz.no_viz) break;
                }
                if(i < cjtoV.size()) break;
                viz = viz.prox;
            }
            if(viz == null) cjtoV.add(p.no);
            else{
                viz = p.prox_viz;
                while(viz != null){
                    int i;
                    for(i = 0; i < cjtoU.size(); i++){
                        int elem = cjtoU.get(i).intValue();
                        if(elem == viz.no_viz) break;
                    }
                    if(i < cjtoU.size()) break;
                    viz = viz.prox;
                }
                if(viz != null) return false;
                cjtoU.add(p.no);
            }
            p = p.prox_no;
        }
        return true;
    }

}
