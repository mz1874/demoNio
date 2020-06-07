package com.candy.mz;

import java.nio.ByteBuffer;

/**
 * 根据数据类型具有对应的缓冲区
 */
public class TestBuffer {

    public static void testByteBuffer() {

        /**
         * capacity 最大容量
         * limit 缓冲区中可以操作数据的大小 后的数据不允许操作
         *  mark 标记
         * position 正在操作的位置
         */
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);


        System.out.println("正在操作的位置" + byteBuffer.position());

        System.out.println(byteBuffer.limit());

        System.out.println(byteBuffer.capacity());


        System.out.println("put");

        byteBuffer.put("abcde".getBytes());


        System.out.println("正在操作的位置" + byteBuffer.position());

        System.out.println(byteBuffer.limit());

        System.out.println(byteBuffer.capacity());

        System.out.println("开始读取数据");

        byteBuffer.flip();

        System.out.println("正在操作的位置" + byteBuffer.position());

        System.out.println(byteBuffer.limit());

        System.out.println(byteBuffer.capacity());

        byte [] bytes = new byte[byteBuffer.limit()];

        byteBuffer.get(bytes);

        System.out.println(new String(bytes,0,bytes.length));

        System.out.println("正在操作的位置" + byteBuffer.position());

        System.out.println(byteBuffer.limit());

        System.out.println(byteBuffer.capacity());

        byteBuffer.rewind();


        System.out.println("正在操作的位置" + byteBuffer.position());

        System.out.println(byteBuffer.limit());

        System.out.println(byteBuffer.capacity());

        byteBuffer.clear();

        /*清空缓冲区后 数据还在，指针进行重置 数据并没有被清空*/

        byte b = byteBuffer.get(1);

        System.out.println((char) b);


    }

    public static void testByteBuffer2() {

        String str = "abcde";

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put(str.getBytes());

        buffer.flip();

        byte [] dist =  new byte[buffer.limit()];
        buffer.get(dist,0,2);

        System.out.println(new String(dist,0,2));

        System.out.println(buffer.position());

        buffer.mark();

        byte [] dist2 =  new byte[buffer.limit()];
        buffer.get(dist2,2,2);

        System.out.println(new String(dist2,2,2));

        /*判断缓冲区中是否还有可以操作的数据*/
        if (buffer.hasRemaining()) {
            /*可以操作数据的长度*/
            System.out.println(buffer.remaining());
        }

        System.out.println(buffer.position());

        /*移动指针位于 mark位置*/
        buffer.reset();

        System.out.println(buffer.position());

        /*可操作数据增加*/
        if (buffer.hasRemaining()) {
            System.out.println(buffer.remaining());
        }
    }




    public static void main(String[] args) {
//        testByteBuffer();
        testByteBuffer2();
    }
}
