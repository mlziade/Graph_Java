package java.grafo;

public class Completo extends Grafo{

    public Completo(){
    }

    public boolean analisaCompleto(Grafo g){
        Lista no = g.prim;
        if(no.prox_no == null) return false; //Se so tiver 1 no no grafo
        Lista aux = no;
        boolean completo = true;
        do { //AnalisaCompleto para cada no
            while(aux != null){ //Anda pela lista de nos e vê se cada um pertencem a lista de vizinhos do no da vez
                if(no != aux && no.pertence(aux.no) == null) { //Se um dos nos nao pertencer a lista de vizinhos e não for ele mesmo
                    completo = false;
                    return completo;
                }
                aux = aux.prox_no;
            }
            no = no.prox_no;
            aux = g.prim;
        }while(no != null);
        return completo;
    }
}
