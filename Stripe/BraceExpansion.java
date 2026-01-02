class Solution {
    public List<String> braceExpansionII(String exp) {
        int n=exp.length();
        TreeSet<String> set= new TreeSet<>();
        Queue<String> q= new LinkedList<>();
        q.offer(exp);

        while(!q.isEmpty()){
            String s=q.poll();

            int l=-1, r=0;
            while(r<s.length() && s.charAt(r)!='}'){
                if(s.charAt(r)=='{'){
                    l=r;
                }
                r++;
            }

            if(l==-1){
                //means no opening '{' and thus no '}'
                set.add(s);
                continue;
            }

            String pref=s.substring(0,l);
            String suff=s.substring(r+1,s.length());
            String[] part=s.substring(l+1,r).split(",");
            for(String p:part){
                q.offer(new StringBuilder(pref).append(p).append(suff).toString());
            }
        }

        return new ArrayList<>(set);
    }
}