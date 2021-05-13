/*
@author Kishan-Gupta
*/

boolean solve(int arr[], int pieces[][]){
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        // System.out.println(map);
        int count = 0;
        for(int[] piece : pieces){
            if(piece.length > 1){
                for(int i=0;i<piece.length-1;i++){
                    int piece1 = map.getOrDefault(piece[i+1], -2);
                    int piece2 = map.getOrDefault(piece[i], -2)+1;
                    if(piece2 != piece1 || piece1 < 0 || piece2 < 0) {
                        return false;
                   }
                }
            }
            for(int x:piece){
                ++count;
                if(!map.containsKey(x) || count > arr.length) return false;
            }
        }
        if(count != arr.length) return false;
        return true;
    }
