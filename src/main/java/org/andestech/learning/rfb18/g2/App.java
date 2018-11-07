package org.andestech.learning.rfb18.g2;

import java.util.Arrays;

enum Answers
{    Yes, No, DoNotKnow;
}

enum FileMode{
    Read, Write, ReadWrite, Append;
}

interface IFileMode{
    int Read = 0;
    int Write = 1;

}


public class App


{
    private static void openFile(String name, FileMode fm){
        //
        //
    }


    private static void openFile(String name, int flag){
        //
        //
    }

    public static void main( String[] args )
    {
        Answers answers = Answers.Yes;

        int mode = IFileMode.Write;

        System.out.println(Arrays.toString(Answers.values()));

        for(Answers a: Answers.values()){

            System.out.println(a + " : " + a.ordinal());
        }

        FileMode fileMode = FileMode.Append;


      switch (fileMode) {
          case Write:
              //...
              System.out.println("write to file..");
              break;

          case Read:
              //...
              System.out.println("read from file..");
              break;
          //.....
      }

      openFile("ff.txt",FileMode.Write);

    }
}
