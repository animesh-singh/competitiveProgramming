import java.io.*;
import java.util.*;

public class Solution
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        int endRow = sc.nextInt() ;
        int endColumn = sc.nextInt() ; 
        int rotation = sc.nextInt();

        int[][] matrix = new int[endRow][endColumn];

        for( int i = 0 ; i < endRow ; i++ )
        {
            for( int j = 0 ; j < endColumn ; j++ )
            {
                matrix[i][j] = sc.nextInt();
            }
        }

        matrix = rotateMatrix(endRow,endColumn,rotation,matrix);

        for( int i = 0 ; i < endRow ; i++ )
        {
            for( int j = 0 ; j < endColumn ; j++ )
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }



    public static int[][] rotateMatrix(int endRow , int endColumn , int rotation , int[][] matrix)
    {
// number of circles to be formed from the matrix
        int numberCircles = ((Math.min(endRow,endColumn)%2)==0) ? Math.min(endRow,endColumn)/2 : (Math.min(endRow,endColumn)/2) + 1 ;



// final rotated matrix
        int[][] rotatedMatrix = new int[endRow][endColumn];

        int startRow = 0;
        int startColumn = 0;
        endRow--;
        endColumn--;
        int startRowCopy = 0;
        int endRowCopy = endRow;
        int startColumnCopy = 0;
        int endColumnCopy = endColumn;

        
        while(numberCircles-->0)
        {
            int[] circle = toCircle(matrix,startRowCopy,endRowCopy,startColumnCopy,endColumnCopy);
            
            startRowCopy++;endRowCopy--;
            startColumnCopy++;endColumnCopy--;


            int[] rotatedCircle = new int[circle.length];

//rotation function
            for(int s=0;s<circle.length;s++)
            {
                rotatedCircle[s] = circle[(s+rotation)%circle.length];
            }

            /*
            for(int n : rotatedCircle)
            {
                System.out.print(n+" ");
            }
            System.out.println("\n"); //+rotatedCircle.length);
            */

//restoring values to matrix
            int iterator = 0;                 

            for(int j = startColumn ; j <= endColumn ; j++)
            {
                rotatedMatrix[startRow][j] = rotatedCircle[iterator++];
            }
            startRow++;

            for(int j = startRow ; j <= endRow ; j++)
            {
                rotatedMatrix[j][endColumn] = rotatedCircle[iterator++];
            }
            endColumn--;

            for(int j=endColumn ; j >= startColumn ; j--)
            {
                rotatedMatrix[endRow][j] = rotatedCircle[iterator++];
            }                                             
            endRow--;

            for(int j=endRow ; j >= startRow ;j--)
            {
                rotatedMatrix[j][startColumn] = rotatedCircle[iterator++];
            }
            startColumn++;               
        }


        return rotatedMatrix;
    }



    private static int[] toCircle(int[][] matrix , int startRow , int endRow , int startColumn , int endColumn)
    {

        int[] circle;

        if(Math.min(endRow,endColumn)<2)
        {
            //System.out.println("endRow : "+endRow+"\t endColummn : "+endColumn);
            //System.out.println("min less than two :"+(endRow)+" * "+(endColumn));

            circle = new int[(endRow+1)*(endColumn+1)];
        }
        else if(Math.min(endRow,endColumn)==2)
        {
            //System.out.println("endRow : "+endRow+"\t endColummn : "+endColumn);
            //System.out.println("min equal to two : "+(endRow+1-startRow)+"*"+(endColumn+1-startColumn));


            circle = new int[(endRow+1-startRow)*(endColumn+1-startColumn)];
        }
        else
        {
            //System.out.println("endRow : "+endRow+"\t endColummn : "+endColumn);
            //System.out.println(((endRow+1-startRow)+"*"+(endColumn+1-startColumn))+" - "+((endRow-1-startRow)+"*"+(endColumn-1-startColumn)));
            

            circle = new int[   ((endRow+1-startRow)*(endColumn+1-startColumn)) - ((endRow-1-startRow)*(endColumn-1-startColumn))   ];
        }


        //System.out.println(circle.length);
        int iterator = 0;

        // top
        for ( int i = startColumn; i <= endColumn; i++ )
        {
            circle[iterator++] = matrix[startRow][i];
        }
        startRow++;

        //right
        for( int i = startRow ; i <= endRow ; i++ )
        {
            circle[iterator++] = matrix[i][endColumn];
        }
        endColumn--;

        //bottom
        for(int i = endColumn ; i >= startColumn ; i-- )
        {
            circle[iterator++] = matrix[endRow][i];
        }
        endRow--;

        //left
        for( int i = endRow ; i >= startRow ; i-- )
        {
            circle[iterator++] = matrix[i][startColumn];
        }
        startColumn++; //not really necessary

        return circle;
    }             
}
