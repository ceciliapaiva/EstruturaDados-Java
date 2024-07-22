package pilhas;

public class PilhaEstrutura {
    /*Regra LIFO: Last in first out - Último a entrar primeiro a sair
    * Push: Empilha
    * Pop: Desempilha
    * Top: Topo da pilha
    * - Imagine uma pilha de pratos, quando precisa comer você pop o prato do topo
    * depois de lavar este, você push o prato na pilha.
    * */

    String pilhaPratos[];
    int topo;

    public PilhaEstrutura() {
        this.pilhaPratos = new String[5];
        this.topo = 0;
    }

    public void push(String prato){ // Empilhar
        if (isFull()){
            System.out.println("Pilha cheia!");
            return;
        }
        pilhaPratos[topo] = prato;
        topo++;
    }

    public String pop(){ // Desempilhar
        if (isEmpty()){
            return "Pilha vazia!";
        }
        topo--;
        String prato = pilhaPratos[topo];
        pilhaPratos[topo] = null;
        return prato;
    }

    public String peek(){
        if (isEmpty()) System.out.println("Pilha vazia!");
        return pilhaPratos[topo -1];
    }

    public boolean isFull(){
        return (topo == pilhaPratos.length);
    }

    public boolean isEmpty(){
        return (topo == 0);
    }

    public String[] getPilhaPratos() {
        return pilhaPratos;
    }

    public static void main(String[] args) {
        PilhaEstrutura p = new PilhaEstrutura();
        int num = 0;

        // Empilhar pratos limpos
        System.out.println("====Empilhando os pratos====");
        for (int i=0; i < p.getPilhaPratos().length; i++){
            p.push("Prato" + num);
            System.out.println("Prato" +num);
            num++;
        }

        // Mostra o topo da pilha
        System.out.println("====Topo da pilha====");
        System.out.println(p.peek());

        // Tentando empilhar uma pilha cheia
        System.out.println("====Tentando empilhar uma pilha cheia====");
        p.push("Prato5");

        // Depois de comer, Desempilhar para lavar pratos sujos
        System.out.println("====Desempilhando os pratos====");
        for (int i=0; i < p.getPilhaPratos().length; i++){
            String pratoPop = p.pop();
            System.out.println("Pegou " +pratoPop);
        }

        // Tentando desempilhar uma pilha vazia
        System.out.println("====Tentando desempilhar uma pilha vazia====");
        String pratoPop = p.pop();
        System.out.println(pratoPop);
    }
}
