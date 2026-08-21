class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int leftPointer = 0, rightPointer = matrix[0].length;
        int topPointer = 0, bottomPointer = matrix.length;
        while(leftPointer < rightPointer && topPointer < bottomPointer) {
            
            for(int index = leftPointer; index < rightPointer; index++)
                result.add(matrix[topPointer][index]);
            topPointer++;

            for(int index = topPointer; index < bottomPointer; index++)
                result.add(matrix[index][rightPointer - 1]);
            rightPointer--;
            
            if(!(leftPointer < rightPointer && topPointer < bottomPointer))
                break;

            for(int index = rightPointer - 1; index >= leftPointer; index--)
                result.add(matrix[bottomPointer - 1][index]);
            bottomPointer--;

            for(int index = bottomPointer - 1; index >= topPointer; index--)
                result.add(matrix[index][leftPointer]);
            leftPointer++;
        }
        return result;
    }
}
