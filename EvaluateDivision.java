class Pair<U,V>{
    U s;
    V val;
    public Pair(U s, V val){
        this.s=s;
        this.val=val;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Pair<String,Double>>> map= new HashMap<>();
        int n=values.length, q=queries.size();
        for(int i=0;i<n;i++){
            String k=equations.get(i).get(0);
            String v=equations.get(i).get(1);
            double val=values[i];

            Pair<String,Double> p= new Pair<>(v,val);
            Pair<String,Double> pp= new Pair<>(k,1/val);
            map.computeIfAbsent(k, key-> new ArrayList<>()).add(p);
            map.computeIfAbsent(v, key -> new ArrayList<>()).add(pp);
        }
        
        double[] ans= new double[q];
        for(int i=0;i<q;i++){
            Set<String> vis= new HashSet<>();
            String a=queries.get(i).get(0);
            String b=queries.get(i).get(1);
            ans[i]=dfs(map,a,b,vis);
        }
        return ans;
    }

    public double dfs(Map<String,List<Pair<String,Double>>> map, String a, String b, Set<String> vis){
        if(!map.containsKey(a) || !map.containsKey(b)) return -1.0;

        if(a.equals(b)) return 1.0;

        vis.add(a);
        List<Pair<String,Double>> neighbour= map.get(a);
        for(Pair<String,Double> p: neighbour){
            String nei=p.s;
            double val=p.val;
            if(!vis.contains(nei)){
                double res=dfs(map,nei,b,vis);
                if(res!=-1.0) return val*res;
            }
        }
        return -1.0;
    }
}