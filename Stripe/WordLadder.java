class Solution {
    public int ladderLength(String b, String e, List<String> w) {
        Set<String> set= new HashSet<>(w);
        if(!set.contains(e)) return 0;

        Queue<String> q= new LinkedList<>();
        q.offer(b);
        int len=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String s=q.poll();
                // System.out.println(s);
                if(s.equals(e)) return len;

                for(int j=0;j<s.length();j++){
                    char[] ch=s.toCharArray();
                    for(char c='a';c<='z';c++){
                        ch[j]=c;
                        String ns=new String(ch);
                        if(set.contains(ns)){
                            q.offer(ns);
                            set.remove(ns);
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }
}