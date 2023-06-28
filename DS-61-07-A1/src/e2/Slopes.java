package e2;

public class Slopes {
    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * @param slopeMap A square matrix representing the slope with spaces
     * represented as "." and trees represented as "#".
     * @param right Movement to the right
     * @param down Downward movement
     * @return Number of trees
     * @throws IllegalArgumentException if the matrix is incorrect because :
     * - It is not square .
     * - It has characters other than "." and "#"
     * - right >= number of columns or right < 1
     * - down >= number of rows of the matrix or down < 1
     */
    public static int downTheSlope ( char [][] slopeMap , int right , int down ) {

        int i, j, k, t, p, lastDown;
        int numTrees = 0, countI = 0, countJ = 0;
        int rows = slopeMap.length;
        int columns = slopeMap[0].length;

        for(p = 0; p < rows; p ++) {
            if (rows != slopeMap[p].length)
                throw new IllegalArgumentException();
        }
        for(k = 0; k < rows; k++){
            for(t = 0; t < columns; t++) {
                if ((slopeMap[k][t] != '#') && (slopeMap[k][t] != '.'))
                    throw new IllegalArgumentException();
            }
        }
        if((right >= columns) || (right < 1))
            throw new IllegalArgumentException();
        if((down >= rows) || (down < 1))
            throw new IllegalArgumentException();

        while (countI + down < rows ){
            for (j = 0; j < right; j++) {
                if(countJ + 1 == columns)
                    countJ = 0;
                else
                    countJ++;
                if (slopeMap[countI][countJ] == '#')
                    numTrees++;
            }
            for (i = 0; i < down; i++){
                countI++;
                if (slopeMap[countI][countJ] == '#')
                    numTrees++;
            }
        }
        for (j = 0; j < right; j++) {
            if(countJ + 1 == columns)
                countJ = 0;
            else
                countJ++;
            if (slopeMap[countI][countJ] == '#')
                numTrees++;
        }
        lastDown = rows - countI - 1;
            if(lastDown > 0) {
                for (i = 0; i < lastDown; i++){
                    countI++;
                    if (slopeMap[countI][countJ] == '#') {
                        numTrees++;
                    }
                }
            }
        return numTrees;
    }

    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * Since it " jumps " from the initial position to the final position ,
     * only takes into account the trees on those initial / final positions .
     *
     * Params , return value and thrown expections as in downTheSlope ...
     */
    public static int jumpTheSlope ( char [][] slopeMap , int right , int down ) {

        int count, k, t, p;
        int i = 0, j = 0, numTrees = 0;
        int rows = slopeMap.length;
        int columns = slopeMap[0].length;

        for(p = 0; p < rows; p ++) {
            if (rows != slopeMap[p].length)
                throw new IllegalArgumentException();
        }
        for(k = 0; k < rows; k++){
            for(t = 0; t < columns; t++) {
                if ((slopeMap[k][t] != '#') && (slopeMap[k][t] != '.'))
                    throw new IllegalArgumentException();
            }
        }
        if((right >= columns) || (right < 1))
            throw new IllegalArgumentException();
        if((down >= rows) || (down < 1))
            throw new IllegalArgumentException();

        while (i < rows){
            if (slopeMap[i][j] == '#')
                numTrees++;
            if((j + right) > (columns -1) ) {
                count = (j + right) - (columns);
                if( (i + down) > (rows - 1) )
                    return numTrees;
                i = i + down;
                j = count;
            }
            else {
                if( (i + down) == (rows - 1) ){
                    j = j + right;
                    i = (rows - 1);
                    if (slopeMap[i][j] == '#')
                        numTrees++;
                    return numTrees;
                }
                if( (i + down) > (rows - 1) )
                    return numTrees;
                else {
                    i = i + down;
                    j = j + right;
                }
            }
        }
        return numTrees;
    }
}