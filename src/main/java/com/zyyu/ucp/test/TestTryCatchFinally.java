package com.zyyu.ucp.test;

/**
 * catch块中return ,finally也会执行，执行顺序为：先执行catch中return之前的语句，再执行finally，最后执行catch中的return
 */
public class TestTryCatchFinally {

    public static void main(String[] args) {

        String name = "ab";

        try{
            int name1 = Integer.parseInt(name);;
        }catch (NumberFormatException e){
            System.out.println(e);
            return;
        }finally {
            System.out.println("finally");
        }

    }
}
