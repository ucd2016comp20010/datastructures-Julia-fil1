package projectCode20280;

import java.util.ArrayList;
import java.util.Comparator;

public class SplayTreeMap<K,V> extends TreeMap<K,V> {

    protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();


    /** Constructs an empty map using the natural ordering of keys. */
    public SplayTreeMap() { super(); }

    /**
     * Constructs an empty map using the given comparator to order keys.
     * @param comp comparator defining the order of keys in the map
     */
    public SplayTreeMap(Comparator<K> comp) { super(comp); }

    /** Utility used to rebalance after a map operation. */
    private void splay(Position<Entry<K,V>> p) {
        while (!isRoot(p)){
            Position<Entry<K, V>> parent = parent(p);
            Position<Entry<K, V>> grand = parent(parent);
            if (grand == null){
                rotate(p);
            }
            else if ((parent == left(grand)) == (p == left(parent))){
                rotate(parent);//move parent upward
                rotate(p);//move p upward
            } else {
                rotate(p);//move p upward
                rotate(p);//move p upward
            }
        }
    }

    /** Overrides the TreeMap rebalancing hook that is called after a node access. */
    @Override
    protected void rebalanceAccess(Position<Entry<K,V>> p) {
        if (isExternal(p)){
            p = parent(p);
        }
        if (p != null){
            splay(p);
        }
    }

    /** Overrides the TreeMap rebalancing hook that is called after an insertion. */
    @Override
    protected void rebalanceInsert(Position<Entry<K,V>> p) {
        splay(p);
    }

    /** Overrides the TreeMap rebalancing hook that is called after a deletion. */
    @Override
    protected void rebalanceDelete(Position<Entry<K,V>> p) {
        if (!isRoot(p)){
            splay(parent(p));
        }
    }

    @Override
    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
        for (Position<Entry<K,V>> p : tree.inorder())
            if (isInternal(p)) buffer.add(p.getElement());
        return buffer;
    }
}
