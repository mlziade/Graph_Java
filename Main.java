package java.grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in;
        in = new BufferedReader(new FileReader("src/lista.txt")); //LEMBRAR DE TROCAR PRA ARGS[0]
        try {
            while(true){
                Grafo gr = new Grafo();
                String str = in.readLine();
                if(str == null) break;
                String[] linha = str.split(" ");
                for (int i = 0; i < linha.length; i++) {
                    gr.insere(Integer.parseInt(linha[i]));
                }
                while (!(str = in.readLine()).equals("FIM")){
                    linha = str.split(" ");
                    gr.insere(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]));
                }
                Completo comp = new Completo();
                boolean respComp = comp.analisaCompleto(gr);

                Bipartido bip = new Bipartido(gr);
                boolean respBip = bip.analisaBipartido(gr);

                Regular reg = new Regular();
                boolean respReg = reg.analisaRegular(gr);

                if(!respBip & !respComp & !respReg) System.out.println("Simples");
                else{
                    if(respBip) System.out.print(" java.grafo.Bipartido");
                    if(respComp) System.out.print(" java.grafo.Completo");
                    if(respReg) System.out.print(" java.grafo.Regular");
                    System.out.println();
                }

            }
            in.close();
        }catch (Exception e){
            System.out.println("Excecao\n");
            e.printStackTrace();
        }
    }
}