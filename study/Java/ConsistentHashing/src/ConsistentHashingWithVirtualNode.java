import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashingWithVirtualNode {
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};

    // 由真实节点组成的列表，考虑到频繁的添加节点或删除节点，因此使用 LinkedList
    private static List<String> realNodes = new LinkedList<>();

    // 虚拟节点，key 表示虚拟节点的 hash 值，value 表示虚拟节点的名称
    private static SortedMap<Integer, String> virtualNodes = new TreeMap<>();

    // 虚拟节点的数量
    private static final int VIRTUAL_NODES = 5;

    static {
        // 添加真实节点
        for (int i = 0; i < servers.length; i++) {
            realNodes.add(servers[i]);
        }
        // 添加虚拟节点
        for (String str : realNodes) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNodeName = str + "&&VN" + String.valueOf(i);
                int hash = getHash(virtualNodeName);
                System.out.println("虚拟节点 [ " + virtualNodeName + "] 被添加，hash 值为 " + hash);
                virtualNodes.put(hash, virtualNodeName);
            }
        }
        System.out.println();
    }

    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        return (hash < 0) ? Math.abs(hash) : hash;
    }

    private static String getServer(String node) {
        // 得到待路由节点的值
        int hash = getHash(node);
        // 得到大于 hash 值的所有 map
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        Integer i = subMap.firstKey();
        // 返回对应的虚拟节点的名称
        String virtualNode = subMap.get(i);
        return virtualNode.substring(0, virtualNode.indexOf("&&"));
    }

    public static void main(String[] args) {
        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "10.221.0.1.3333"};
        for (int i = 0; i < nodes.length; i++) {
            System.out.println("[" + nodes[i] + "] 的 hash 值为 " +
                    getHash(nodes[i]) + ", 被路由到节点 [" + getServer(nodes[i]) + "]");
        }
    }
}
