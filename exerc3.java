public class ListaEncadeada {
    private Node head; // Início da lista
    private int tamanho; // Tamanho da lista

    // Classe interna para representar o nó
    private static class Node {
        int valor;
        Node proximo;

        Node(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    // Método para adicionar um nó ao final da lista
    public void push(int valor) {
        Node novoNo = new Node(valor);
        if (head == null) {
            head = novoNo;
        } else {
            Node atual = head;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
        tamanho++;
    }

    // Método para remover e retornar o nó no final da lista
    public int pop() {
        if (head == null) {
            System.out.println("A lista está vazia!");
            return -1;
        }
        if (head.proximo == null) {
            int valor = head.valor;
            head = null;
            tamanho--;
            return valor;
        }
        Node atual = head;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }
        int valor = atual.proximo.valor;
        atual.proximo = null;
        tamanho--;
        return valor;
    }

    // Método para inserir um nó em uma posição específica
    public void insert(int index, int valor) {
        if (index < 0 || index > tamanho) {
            System.out.println("Índice fora dos limites!");
            return;
        }
        Node novoNo = new Node(valor);
        if (index == 0) {
            novoNo.proximo = head;
            head = novoNo;
        } else {
            Node atual = head;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;
        }
        tamanho++;
    }

    // Método para remover um nó em uma posição específica
    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            System.out.println("Índice fora dos limites!");
            return;
        }
        if (index == 0) {
            head = head.proximo;
        } else {
            Node atual = head;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
        }
        tamanho--;
    }

    // Método para retornar o elemento em um índice específico
    public int elementAt(int index) {
        if (index < 0 || index >= tamanho) {
            System.out.println("Índice fora dos limites!");
            return -1;
        }
        Node atual = head;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }

    // Método para retornar o tamanho da lista
    public int size() {
        return tamanho;
    }

    // Método para imprimir a lista
    public void printList() {
        Node atual = head;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
}
