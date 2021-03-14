class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTri = new ArrayList<List<Integer>>();
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        pascalTri.add(list);
        
        for(int i=1; i < numRows; i++)
        {
            List<Integer> subList = new ArrayList<Integer>();
            subList.add(1);
            for(int j=1; j < i; j++)
            {
                int num = (pascalTri.get(i-1).get(j-1) + pascalTri.get(i-1).get(j));
                subList.add(num);
            }
            subList.add(1);
            pascalTri.add(subList);
        }
        
        return pascalTri;
    }
}

