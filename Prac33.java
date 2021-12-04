// Min Cost to Connect All Points
 class Solution {
    int[] parents;
    class Pair{
        int index1;
        int index2;
        
        public Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        parents = new int[points.length+1];
        
        for(int i = 0 ; i <= points.length; i++) {
            parents[i] = i;
        }
        //List<Integer> weights = new ArrayList<>();
        TreeMap<Integer, ArrayList<Pair>> map = new TreeMap<>();
        for(int i = 0 ; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                if(!map.containsKey(manhattan(points[i][0],points[i][1],points[j][0],points[j][1]))) {
                   map.put(manhattan(points[i][0],points[i][1],points[j][0],points[j][1]), new ArrayList<>()); 
                }
                map.get(manhattan(points[i][0],points[i][1],points[j][0],points[j][1])).add(new Pair(i,j));
                //weights.add(manhattan(points[i][0],points[i][1],points[j][0],points[j][1]));
                }
            }
         // System.out.println(map);
         // System.out.println(weights);
        int result = 0;
        
        for(Integer i : map.keySet()) {
            List<Pair> current = map.get(i);
            for(Pair p : current) {
                int i1 = p.index1;
                int i2 = p.index2;
                
                int parentX = find(i1);
                int parentY = find(i2);
            
                if(parentX != parentY) {
                    result += i;
                    parents[parentX] = parentY;
                }
            }
            
        }
        return result;
        }
    public int manhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
    private int find(int x) {
        if(parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
}class Solution {
    int[] parents;
    class Pair{
        int index1;
        int index2;
        
        public Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        parents = new int[points.length+1];
        
        for(int i = 0 ; i <= points.length; i++) {
            parents[i] = i;
        }
        //List<Integer> weights = new ArrayList<>();
        TreeMap<Integer, ArrayList<Pair>> map = new TreeMap<>();
        for(int i = 0 ; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                if(!map.containsKey(manhattan(points[i][0],points[i][1],points[j][0],points[j][1]))) {
                   map.put(manhattan(points[i][0],points[i][1],points[j][0],points[j][1]), new ArrayList<>()); 
                }
                map.get(manhattan(points[i][0],points[i][1],points[j][0],points[j][1])).add(new Pair(i,j));
                //weights.add(manhattan(points[i][0],points[i][1],points[j][0],points[j][1]));
                }
            }
         // System.out.println(map);
         // System.out.println(weights);
        int result = 0;
        
        for(Integer i : map.keySet()) {
            List<Pair> current = map.get(i);
            for(Pair p : current) {
                int i1 = p.index1;
                int i2 = p.index2;
                
                int parentX = find(i1);
                int parentY = find(i2);
            
                if(parentX != parentY) {
                    result += i;
                    parents[parentX] = parentY;
                }
            }
            
        }
        return result;
        }
    public int manhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
    private int find(int x) {
        if(parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
}