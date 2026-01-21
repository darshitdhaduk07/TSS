package com.tss.string;

import java.util.Scanner;

public class EncodeDecode {
    public static StringBuilder encode(StringBuilder sb)
    {
        sb = new StringBuilder(sb.toString().toLowerCase());
        System.out.println(sb);


        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch == ' ') continue;
            else if (ch == 'a') sb.setCharAt(i, '@');
            else if (ch == 'e') sb.setCharAt(i, '#');
            else if (ch == 'i') sb.setCharAt(i, '!');
            else if (ch == 'o') sb.setCharAt(i, '*');
            else if(ch == 'u') sb.setCharAt(i, '$');

        }


        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch == ' ')
                continue;
            if(ch >= 'a' && ch <= 'z')
                sb.setCharAt(i, (char)('a' + ((ch - 'a'+1)%26)));

        }

        sb.reverse();
        return sb;
    }
    public static StringBuilder decode(StringBuilder sb)
    {
        sb.reverse();

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch == ' ')
                continue;
            if(ch >= 'a' && ch <= 'z')
                sb.setCharAt(i, (char)('a' + ((ch - 'a'+25)%26)));

        }

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch == ' ') continue;
            else if (ch == '@') sb.setCharAt(i, 'a');
            else if (ch == '#') sb.setCharAt(i, 'e');
            else if (ch == '!') sb.setCharAt(i, 'i');
            else if (ch == '*') sb.setCharAt(i, 'o');
            else if(ch == '$') sb.setCharAt(i, 'u');

        }


        return sb;


    }
    public static void main(String[] args) {
        System.out.println("Enter a String :");

        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        sb.append(str);

        //Encoding
        sb = encode(sb);

        System.out.println("\nEncoded String :" + sb);

        //decoding
        sb = decode(sb);

        System.out.println("Decoded String :"+sb);





    }
}
