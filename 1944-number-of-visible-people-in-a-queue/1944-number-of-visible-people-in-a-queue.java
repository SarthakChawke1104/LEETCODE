class Solution {
    public int[] canSeePersonsCount(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(arr[n-1]);
        ans[n-1] = 0;
        for(int i = n - 2; i >= 0; i--){
            int cnt = 0;
            while(st.size()>0 && st.peek()<=arr[i]){
                cnt++;
                st.pop();
            }
            if(st.size()>0) cnt++;
            ans[i] = cnt;
            st.push(arr[i]);
        }
        return ans;

    }
}