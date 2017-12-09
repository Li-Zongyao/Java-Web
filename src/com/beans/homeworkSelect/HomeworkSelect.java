package com.beans.homeworkSelect;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HomeworkSelect {
    String fileName;
    private boolean select[] ;
    private Random random;
    private String homeworkContent;
    private final int homeworkNum = 60 ;
    public  HomeworkSelect(){

        select = new boolean[homeworkNum];

        for( int i = 0; i < select.length; i++)
            select[i] = false;
        select[10] = true;

        homeworkContent = "请开始选题~";

        random = new Random();
    }



    public void readTextFile() throws IOException
    {
        StringBuffer stringBuffer = new StringBuffer();

        FileInputStream fileInputStream = new FileInputStream("G:\\echo\\TestDoc\\"+fileName);

        InputStreamReader inputStreamReader =new InputStreamReader(fileInputStream,"GBK");

        BufferedReader bufferedReader = new BufferedReader( inputStreamReader );

        String buff;
        if( ( buff = bufferedReader.readLine()  ) != null)
            stringBuffer.append(buff+"<br>") ;			//read standard answer
        else
            return ;
        while( (  buff = bufferedReader.readLine()  ) != null ) {
            stringBuffer.append(buff + "<br>");
        }
        homeworkContent = stringBuffer.toString();

        bufferedReader.close();
        inputStreamReader.close();;
        fileInputStream.close();
    }

    public void select()
    {
        int count = 1;
        try{
            int temp;
            for( int i = 0; i < select.length; i++ )
                if( select[i] == true )
                    count++;
            if( count <= homeworkNum)
            {
                while( select[temp = random.nextInt(homeworkNum) ] == true  );
                fileName = String.valueOf( temp ) + ".txt";
                select[temp] = true;
                readTextFile();
            }
            else
            {
                homeworkContent = "题目已选完~";
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getHomeworkContent(){

        return homeworkContent;
    }
}
