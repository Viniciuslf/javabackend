public class Pilha {
    private int[] elementos;
    private int topo;

    public Pilha(int tamanho) {
        elementos = new int[tamanho];
        topo = -1; 
    }

    
    public void push(int valor) {
        if (topo < elementos.length - 1) { 
            topo++;
            elementos[topo] = valor;
            System.out.println("Elemento " + valor + " empilhado.");
        } else {
            System.out.println("A pilha está cheia! Não é possível empilhar o valor " + valor);
        }
    }

    // Método para remover e retornar o elemento do topo da pilha
    public int pop() {
        if (topo >= 0) { // Verifica se a pilha não está vazia
            int valor = elementos[topo];
            topo--;
            System.out.println("Elemento " + valor + " desempilhado.");
            return valor;
        } else {
            System.out.println("A pilha está vazia! Não é possível desempilhar.");
            return -1; // Retorna -1 para indicar que a pilha está vazia
        }
    }

    // Método para espiar o elemento no topo da pilha sem removê-lo
    public int top() {
        if (topo >= 0) { // Verifica se a pilha não está vazia
            return elementos[topo];
        } else {
            System.out.println("A pilha está vazia! Não há elemento no topo.");
            return -1; // Retorna -1 para indicar que a pilha está vazia
        }
    }

    // Método para verificar se a pilha está vazia
    public boolean isEmpty() {
        return topo == -1;
    }

    // Método para retornar o número de elementos na pilha
    public int size() {
        return topo + 1;
    }
}
