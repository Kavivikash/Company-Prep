class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] dist=Arrays.copyOf(time,time.length);
        List<Integer>[] graph= new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        int[] ind= new int[n];
        
        for(int[] r:relations){
            graph[r[0]-1].add(r[1]-1);
            ind[r[1]-1]++;
        }
        // System.out.println(Arrays.toString(ind));
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++) if(ind[i]==0) q.offer(i);
        
        while(!q.isEmpty()){
            int cour=q.poll();
            // if(graph[cour].size()==0) continue;
            for(int nei: graph[cour]){
                dist[nei]=Math.max(dist[nei],time[nei]+dist[cour]);
                ind[nei]--;
                if(ind[nei]==0) q.offer(nei);
            }
        }
        int max=0;
        for(int el:dist) max=Math.max(el,max);
        return max;
    }
}