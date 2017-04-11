import org.apache.commons.lang3.StringUtils;

import java.util.BitSet;

/**
 * @author Anton Koksharov
 *         Date: 21.11.2016
 */
public class BitSetUtils {

    public static String bitSetToBinaryString(java.util.BitSet bs) {
        if (bs == null || bs.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = bs.length() - 1; i >= 0; i--) {
            sb.append(bs.get(i) ? "1" : "0");
        }

        return sb.toString();
    }

    public static java.util.BitSet binaryStringToBitSet(String s) throws IllegalArgumentException {
        if (StringUtils.isEmpty(s)) {
            return new java.util.BitSet();
        }

        int len = s.length();
        java.util.BitSet bs = new java.util.BitSet(len);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(len - i - 1);
            switch (c) {
                case '1':
                    bs.set(i);
                    break;
                case '0':
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        return bs;
    }

    public static String encodeBinaryString(String str) {
        return new java.math.BigInteger(str, 2).toString(Character.MAX_RADIX);
    }

    public static String decodeBinaryString(String str) {
        return new java.math.BigInteger(str, Character.MAX_RADIX).toString(2);
    }

    public static void main(String[] args) {
//        String decodeBinaryString = BitManipulationUtils.decodeBinaryString("2");
//        java.util.BitSet set = BitManipulationUtils.binaryStringToBitSet(decodeBinaryString);
//        System.out.println(set.get(1));

        //Обратное получение полномочий из битсет строки
        String str_1 = decodeBinaryString("521am24xjfx0gh8xha2jsr5tvaluqcvn4fbgbsoqxv470doc6spkxlegbrg6qaiad0s4hebaf95awpdc2ceduiafwgbrbvdb4isn0t9bay3kxyj9r3d7op6y5zxqgou9idbowu9lgltx14gcn");
        BitSet bs_1 = binaryStringToBitSet(str_1); //{0, 1, 2, 6, 7, 24, 25, 26, 27, 28, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 92, 96, 97, 98, 99, 100, 220, 240, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 312, 313, 314, 315, 316, 336, 337, 338, 339, 340, 341, 342, 343, 480, 481, 482, 483, 504, 528, 529, 552, 553, 554, 555, 556, 557, 576, 600, 601, 602, 603, 604, 624, 625, 626, 627, 628, 648, 649, 650, 651, 652, 653, 654, 655, 744, 745, 746}
        System.out.println(bs_1);

        String str_2 = decodeBinaryString("4jixi84mych6ha7hkr11qp0btwovs8gi3b33r1mm9pt569v");
        BitSet bs_2 = binaryStringToBitSet(str_2); //{0, 1, 24, 25, 26, 27, 48, 49, 50, 51, 96, 97, 98, 99, 240}
        System.out.println(bs_2);

        //кодировка в битсет
        BitSet bs_bs = new BitSet();

        String str_str = bitSetToBinaryString(bs_bs);
        System.out.println(str_str);

    }
}


