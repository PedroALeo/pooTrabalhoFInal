package Util;

import Model.Endereco;

import java.io.*;
import java.util.*;

public class StreamIoUtil {




    public static void WriteOne(Serializable obj){

        Collection objs = (Collection) obj;

        if(!objs.isEmpty()){
            String FileName = obj instanceof Collection ? objs.toArray()[0].getClass().getSimpleName() : obj.getClass().getSimpleName();
            try {
                FileOutputStream file = new FileOutputStream("src/Data/" +FileName + ".txt" );
                ObjectOutputStream out = new ObjectOutputStream(file);
                out.writeObject(obj);
                file.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }



    }


    public static Object ReadOne(String path){
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object r = (Object) in.readObject();
            return r;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("FALHA AO LER ARQUIVO");
        }
    }



}
