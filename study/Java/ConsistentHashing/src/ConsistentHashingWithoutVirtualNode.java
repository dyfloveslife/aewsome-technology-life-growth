import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 不带虚拟节点的一致性 hash 算法
 * Ref: https://www.cnblogs.com/xrq730/p/5186728.html
 */
public class ConsistentHashingWithoutVirtualNode {
    // 待加入 hash 环的服务器列表
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};

    // key 表示服务器的 hash 值，value 表示服务器的名称
    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();

    // 程序的初始化工作，将所有的服务器放入 sortedMap 中
    static {
        for (int i = 0; i < servers.length; i++) {
            int hash = getHash(servers[i]);
            System.out.println("[" + servers[i] + "] 加入集合中，其 hash 值为 " + hash);
            sortedMap.put(hash, servers[i]);
        }
        System.out.println();
    }

    // 使用 FNV1_32_HASH 算法计算服务器的 hash 值
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

    // 得到应当路由到的节点
    private static String getServer(String node) {
        // 得到待路由节点的 hash 值
        int hash = getHash(node);
        // 得到大于该 hash 值的所有 map
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        // 找到第一个 map，该 map 就是距离 node 最近的那个节点
        Integer i = subMap.firstKey();
        // 返回对应的服务器名称
        return subMap.get(i);
    }

    public static void main(String[] args) {
        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "10.221.0.1.3333"};
        for (int i = 0; i < nodes.length; i++) {
            System.out.println("[" + nodes[i] + "] 的 hash 值为 " +
                    getHash(nodes[i]) + ", 被路由到节点 [" + getServer(nodes[i]) + "]");
        }
    }
}
