class HashMap {
    private class HashNode {
        int key;
        int value;
        HashNode next;

        HashNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private HashNode[] map;
    private int size;

    public HashMap() {
        map = new HashNode[10];
        size = 0;
    }

    // Função hash simples
    private int hash(int key) {
        return key % 10;
    }

    // Adiciona o par chave/valor ao mapa
    public void put(int key, int value) {
        int index = hash(key);
        HashNode newNode = new HashNode(key, value);

        if (map[index] == null) {
            map[index] = newNode;
        } else {
            // Resolução de colisão por encadeamento
            HashNode current = map[index];
            while (current != null) {
                if (current.key == key) {
                    // Substitui o valor se a chave já existir
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Remove o valor associado à chave e o retorna
    public int delete(int key) {
        int index = hash(key);
        HashNode current = map[index];
        HashNode prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    map[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return -1; // Retorna -1 se a chave não for encontrada
    }

    // Retorna o valor associado à chave
    public int get(int key) {
        int index = hash(key);
        HashNode current = map[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1; // Retorna -1 se a chave não for encontrada
    }

    // Remove todos os elementos do mapa
    public void clear() {
        map = new HashNode[10];
        size = 0;
    }

    // Retorna o tamanho atual do mapa
    public int size() {
        return size;
    }
}
