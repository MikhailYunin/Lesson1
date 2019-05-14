package nio;

import java.io.FileOutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOExample {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        assert byteBuffer.position() == 0;//текущая позиция
        assert byteBuffer.capacity() == 16;//размер
        assert byteBuffer.limit() == 16;//лимит
        assert byteBuffer.remaining() == 16;// разница между текущей позицией и лимитом
        byteBuffer.hasRemaining();

        byteBuffer.putInt(100); // позиция увеличится на 4
        assert byteBuffer.position() == 4;
        assert byteBuffer.remaining() == 12;
        byteBuffer.putDouble(100.24);
        assert byteBuffer.position() == 12;
        assert byteBuffer.remaining() == 4;

        // лимит на текущую позицию
        // позиция установлена на 0
        byteBuffer.flip();

        assert byteBuffer.position() == 0;
        assert byteBuffer.remaining() == 12;
        assert byteBuffer.remaining() == 12;

        int someInt = byteBuffer.getInt();
        assert byteBuffer.position() == 4;
        assert byteBuffer.remaining() == 8;

        double someDouble = byteBuffer.getDouble();
        assert byteBuffer.position() == 12;
        assert byteBuffer.remaining() == 0;

        // подготавливает буфер для повторного чтения
        // выставляет позицию на 0

        byteBuffer.rewind();
        assert byteBuffer.position() == 0;
        assert byteBuffer.limit() == 12;

        someInt = byteBuffer.getInt();
        someDouble = byteBuffer.getDouble();

        // подготавливает буфер для новой записи
        // выставляет позицию на 0
        // выставляет лимит на размер буфера

        byteBuffer.clear();

//        FileChannel;
//        fileOutputStream.getChannel;
//        fileInputStream.getChannel;
//        randomAcessFile.getChannel;
//
//        DatagramChannel; // для передачи по UDP протоколу
//        SocketChannel; // для передачи данных по tcp протоколу
//        ServerSocketChannel; // позволяет слушать входящие  по tcp соеднинения
//                //для каждого соедлнияния воссоздает SocketChannel
//
//
//        Connect SelectionKey.OP_CONNECT
//        Accept SelectionKey.OP_ACCEPT
//        Read SelectionKey.OP_READ
//        Write SelectionKey.OP_WRITE
//
//        key.isAcceptable();
//        key.isReadable();
//        key.isWriteable();
//        key.isConnectable();

    }
}
