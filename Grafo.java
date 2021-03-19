package java.grafo;

public class Grafo {

    Lista prim;
    Grafo(){ prim = null; }

    Lista pertence(int no){ //Ve se um no esta no grafo
        Lista resp = prim;
        while((resp != null) && (no != resp.no)) resp = resp.prox_no;
        return resp;
    }
    void insere(int no){ //Insere no no grafo
        Lista p = pertence(no);
        if(p == null){
            p = new Lista(no);
            Lista q = prim;
            if(q == null){
                prim = p;
                return;
            }
            while(q.prox_no != null) q = q.prox_no;
            q.prox_no = p;
        }
    }
    void insere(int no1, int no2){ //Insere conexao
        Lista p = pertence(no1);
        p.ins_Viz(no2);
    }
    public String toString(){
        String resp = "";
        Lista p = prim;
        while(p != null){
            resp += p.toString();
            p = p.prox_no;
        }
        return resp;
    }
}
