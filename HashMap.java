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

    
    private int hash(int key) {
        return key % 10;
    }

    
    public void put(int key, int value) {
        int index = hash(key);
        HashNode newNode = new HashNode(key, value);

        if (map[index] == null) {
            map[index] = newNode;
        } else {
            
            HashNode current = map[index];
            while (current != null) {
                if (current.key == key) {
                   
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
        return -1; 
    }

    
    public int get(int key) {
        int index = hash(key);
        HashNode current = map[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1; 
    }

    
    public void clear() {
        map = new HashNode[10];
        size = 0;
    }

    
    public int size() {
        return size;
    }
}
