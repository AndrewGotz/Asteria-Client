package com.runescape.applet.drawing;

import com.runescape.net.JagBuffer;

@SuppressWarnings("all")
public final class TextInput {

    public static String method525(int i, JagBuffer jagBuffer) {
        int j = 0;
        int k = -1;
        for (int l = 0; l < i; l++) {
            int i1 = jagBuffer.readUnsignedByte();
            int j1 = i1 >> 4 & 0xf;
            if (k == -1) {
                if (j1 < 13)
                    aCharArray631[j++] = validChars[j1];
                else
                    k = j1;
            } else {
                aCharArray631[j++] = validChars[((k << 4) + j1) - 195];
                k = -1;
            }
            j1 = i1 & 0xf;
            if (k == -1) {
                if (j1 < 13)
                    aCharArray631[j++] = validChars[j1];
                else
                    k = j1;
            } else {
                aCharArray631[j++] = validChars[((k << 4) + j1) - 195];
                k = -1;
            }
        }

        boolean flag1 = true;
        for (int k1 = 0; k1 < j; k1++) {
            char c = aCharArray631[k1];
            if (flag1 && c >= 'a' && c <= 'z') {
                aCharArray631[k1] += '\uFFE0';
                flag1 = false;
            }
            if (c == '.' || c == '!' || c == '?')
                flag1 = true;
        }
        return new String(aCharArray631, 0, j);
    }

    public static void method526(String s, JagBuffer jagBuffer) {
        if (s.length() > 80)
            s = s.substring(0, 80);
        s = s.toLowerCase();
        int i = -1;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            int k = 0;
            for (int l = 0; l < validChars.length; l++) {
                if (c != validChars[l])
                    continue;
                k = l;
                break;
            }

            if (k > 12)
                k += 195;
            if (i == -1) {
                if (k < 13)
                    i = k;
                else
                    jagBuffer.writeWordBigEndian(k);
            } else if (k < 13) {
                jagBuffer.writeWordBigEndian((i << 4) + k);
                i = -1;
            } else {
                jagBuffer.writeWordBigEndian((i << 4) + (k >> 4));
                i = k & 0xf;
            }
        }
        if (i != -1)
            jagBuffer.writeWordBigEndian(i << 4);
    }

    public static String processText(String s) {
        jagBuffer.currentOffset = 0;
        method526(s, jagBuffer);
        int j = jagBuffer.currentOffset;
        jagBuffer.currentOffset = 0;
        String s1 = method525(j, jagBuffer);
        return s1;
    }

    private static final boolean aBoolean630 = true;
    private static final char[] aCharArray631 = new char[100];
    private static final JagBuffer jagBuffer = new JagBuffer(new byte[100]);
    private static final char[] validChars = { ' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u', 'm', 'w', 'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '!', '?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '@', '#', '+', '=', '\243', '$', '%', '"', '[', ']' };

}
