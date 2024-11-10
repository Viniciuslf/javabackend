public class Fila {
    private int[] elementos;
    private int tamanho;
    private int frente;
    private int fim;

    // Construtor para inicializar a fila com um tamanho fixo
    public Fila(int capacidade) {
        elementos = new int[capacidade];
        tamanho = 0;
        frente = 0;
        fim = -1;
    }

    // Método para adicionar um elemento ao fim da fila
    public void enqueue(int valor) {
        if (tamanho < elementos.length) { // Verifica se há espaço na fila
            fim = (fim + 1) % elementos.length; // Atualiza o índice do fim em um ciclo
            elementos[fim] = valor;
            tamanho++;
            System.out.println("Elemento " + valor + " adicionado à fila.");
        } else {
            System.out.println("A fila está cheia! Não é possível adicionar o valor " + valor);
        }
    }

    // Método para remover e retornar o elemento da frente da fila
    public int dequeue() {
        if (tamanho > 0) { // Verifica se a fila não está vazi
