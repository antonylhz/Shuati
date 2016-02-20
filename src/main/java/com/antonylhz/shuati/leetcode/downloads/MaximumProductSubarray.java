public class Solution {
    public int maxProduct(int[] A) {
        int firstNegInd = 0, lastNegInd = 0;
        int headProduct = 1, midProduct = 1, tailProduct = 1;
        int cntNeg = 0;
        int length = A.length;

        if(length <2){
            //If only one element exists, return it
            return A[0];
        }

        for(int i = 0; i<length; i++) {
            if(A[i] == 0){
                return maxProductWithZeroElement(A, i);
            }else if(A[i]>0){
                if(cntNeg == 0){
                    headProduct *=A[i];
                }else{
                    tailProduct *= A[i];
                }
            }else if(A[i]<0){
                lastNegInd = i;
                if(cntNeg == 0){
                    firstNegInd = i;
                    headProduct *= -A[i];
                }else{
                    midProduct *= tailProduct;
                    tailProduct = -A[i];
                }
                cntNeg++;
            }
        }

        if(cntNeg == 0){
            //When all numbers are positive, return product of all
            return headProduct;
        }else if(cntNeg == 1){
            //When only one negative exists, return either head or tail
            headProduct/=-A[firstNegInd];
            if(headProduct >= tailProduct){
                return headProduct;
            }else{
                return tailProduct;
            }
        }else{
            //When more than one negative exist
            int testEven = 1;
            testEven &= cntNeg;
            if(testEven == 0){
                //If even number of negatives, return product of all
                return headProduct*midProduct*tailProduct;
            }else{
                //Else, discard either head or tail
                if(headProduct>=tailProduct){
                    return headProduct*midProduct;
                }else{
                    return tailProduct*midProduct;
                }
            }

        }

    }

    private int maxProductWithZeroElement(int[] A, int zeroIndex) {
        int[] A1 = new int[zeroIndex];
        int length2 = A.length - zeroIndex - 1;
        int[] A2 = new int[length2];

        for(int i=0; i<zeroIndex; i++){
            A1[i] = A[i];
        }

        for(int i=zeroIndex+1; i<A.length; i++){
            A2[i-zeroIndex-1] = A[i];
        }

        if(zeroIndex == 0){
            int maxProduct = maxProduct(A2);
            if(maxProduct>0)
                return maxProduct;
            else
                return 0;
        }else if(zeroIndex == A.length-1){
            int maxProduct = maxProduct(A1);
            if(maxProduct>0)
                return maxProduct;
            else
                return 0;
        }

        int product1 = maxProduct(A1);
        int product2 = maxProduct(A2);
        if(product1 >= product2 && product1 > 0){
            return product1;
        }else if(product2 > product1 && product2 >0){
            return product2;
        }
        else{
            return 0;
        }
    }
}