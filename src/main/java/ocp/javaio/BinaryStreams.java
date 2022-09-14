package ocp.javaio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryStreams {

    public static void main(String[] args) throws IOException {
        doBytes();
    }


    private static void doBytes() throws IOException {
        var s = "hello";
        byte i = 100;

        var fos = new FileOutputStream("./data.bin");
        var dos = new DataOutputStream(fos);

        dos.writeUTF(s);
        dos.writeByte(i);

        dos.flush();
        dos.close();
        fos.close();

        var dis = new DataInputStream(new FileInputStream("./data.bin"));
        var str = dis.readUTF();
        System.out.println(str);
        var b = dis.readByte();
        System.out.println(b);


    }

}
