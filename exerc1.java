public class Pilha {
    private int[] elementos;
    private int topo;

    // Construtor para inicializar a pilha com um tamanho fixo
    public Pilha(int tamanho) {
        elementos = new int[tamanho];
        topo = -1; // Indica que a pilha está vazia
    }

    // Método para adicionar um elemento no topo da pilha
    public void push(int valor) {
        if (topo < elementos.length - 1) { // Verifica se há espaço na pilha
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
}
