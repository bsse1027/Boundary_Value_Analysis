package BVA;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        int parameterNo, lowLimit, upperLimit;

        Scanner input= new Scanner(System.in);

        System.out.println("Enter number of parameter");

        parameterNo=input.nextInt();

        int [][] stat= new int[parameterNo][7];

        for(int i=0;i<parameterNo;i++)
        {
            System.out.println("Enter Lower Limit(s) & Upper Limit(s)");

            lowLimit=input.nextInt();
            upperLimit=input.nextInt();

            //System.out.println("The Output is: "+parameterNo+" "+lowLimit+" "+upperLimit);

            int minPlus=lowLimit+1,nominal=((lowLimit+upperLimit)/2),maxMinus=upperLimit-1,minMinus=lowLimit-1, maxPlus=upperLimit+1;

            stat[i][0]=lowLimit;
            stat[i][1]=minPlus;
            stat[i][2]=upperLimit;
            stat[i][3]=maxMinus;
            stat[i][4]=nominal;
            stat[i][5]=minMinus;
            stat[i][6]=maxPlus;


        }

        /*for(int i=0;i<parameterNo;i++)
        {
            for(int j=0;j<7;j++)
            {
                System.out.println("stat["+i+"] [j"+j+"] ="+stat[i][j]);
            }
        }*/

        int row=(4*parameterNo)+1, column=parameterNo+1;

        int [][] BVC=new int[row][column];

        for(int a=0;a<row;a++)
        {
            BVC[a][0]=a+1;
        }

        for(int i=0;i<parameterNo;i++)
        {
            int count=0;
            for(int j=0;j<row;j++)
            {
                if(j>=i*4 && j<i*4+4)
                {
                    BVC[j][i+1]=stat[i][count];
                    count++;
                }
                else BVC[j][i+1]=stat[i][4];
            }

        }

        /*for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                System.out.println("BVC["+i+"] ["+j+"] ="+BVC[i][j]);
            }
        }*/

        StringBuilder builder = new StringBuilder();
        builder.append("Test ID,");

        for(int i=0;i<parameterNo;i++)
        {
            builder.append("Parameter No."+(i+1)+",");
        }

        builder.append("Expected Output\n");


        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < column; j++)
            {

                builder.append(BVC[i][j]+"");
                if(j < BVC.length - 1)
                    builder.append(",");
            }
            builder.append("\n");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("BVC.csv"));
        writer.write(builder.toString());
        writer.close();

        int Rrow=(6*parameterNo)+1, Rcolumn=parameterNo+1;

        int [][] RobustT=new int[Rrow][Rcolumn];

        for(int a=0;a<Rrow;a++)
        {
            RobustT[a][0]=a+1;
        }

        for(int i=0;i<parameterNo;i++)
        {
            int count=0;
            for(int j=0;j<Rrow;j++)
            {
                if(j>=i*6 && j<i*6+6)
                {
                    RobustT[j][i+1]=stat[i][count];
                    count++;
                }
                else RobustT[j][i+1]=stat[i][4];
            }

        }

        /*for(int i=0;i<Rrow;i++)
        {
            for(int j=0;j<Rcolumn;j++)
            {
                System.out.println("RobustT["+i+"] ["+j+"] ="+RobustT[i][j]);
            }
        }*/

        StringBuilder builderRo = new StringBuilder();
        builderRo.append("Test ID,");

        for(int i=0;i<parameterNo;i++)
        {
            builderRo.append("Parameter No."+(i+1)+",");
        }

        builderRo.append("Expected Output\n");


        for(int i = 0; i < Rrow; i++)
        {
            for(int j = 0; j < Rcolumn; j++)
            {

                builderRo.append(RobustT[i][j]+"");
                if(j < Rrow - 1)
                    builderRo.append(",");
            }
            builderRo.append("\n");
        }
        BufferedWriter writerRo = new BufferedWriter(new FileWriter("robust.csv"));
        writerRo.write(builderRo.toString());//save the string representation of the board
        writerRo.close();

        int wRow= (int) ((Math.pow(5,parameterNo)));
        System.out.println(wRow);
        int wColumn=parameterNo+1;

        int [][] WorstCase=new int[wRow][wColumn];

        for(int a=0;a<wRow;a++)
        {
            WorstCase[a][0]=a+1;
        }

        for(int i=0;i<parameterNo;i++)
        {
            int count=0;
            int counter=0;
            int changeValue=(int) (Math.pow(5,i));
            //System.out.println(changeValue);
            for(int j=0;j<wRow;j++)
            {
                if(j%changeValue==0)
                {
                    counter++;
                }
                if(i==0)
                {
                    WorstCase[j][i+1]=stat[i][count%5];
                    count++;
                }

                else
                {
                    WorstCase[j][i+1]=stat[i][counter%5];
                }






            }

        }

        /*for(int i=0;i<wRow;i++)
        {
            for(int j=0;j<wColumn;j++)
            {
                System.out.println("WC["+i+"] ["+j+"] ="+WorstCase[i][j]);
            }
        }*/

        StringBuilder builderWC = new StringBuilder();
        builderWC.append("Test ID,");

        for(int i=0;i<parameterNo;i++)
        {
            builderWC.append("Parameter No."+(i+1)+",");
        }

        builderWC.append("Expected Output\n");


        for(int i = 0; i < wRow; i++)
        {
            for(int j = 0; j < wColumn; j++)
            {

                builderWC.append(WorstCase[i][j]+"");
                if(j < wRow - 1)
                    builderWC.append(",");
            }
            builderWC.append("\n");
        }
        BufferedWriter writerWC = new BufferedWriter(new FileWriter("worst.csv"));
        writerWC.write(builderWC.toString());//save the string representation of the board
        writerWC.close();


















    }
}
