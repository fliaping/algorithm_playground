class Solution {
    public String multiply(String num1, String num2) {
        // 校验参数，leetcode本题有限定条件，是不需要校验的
        String num1c = numCheckAndRemoveHeadZero(num1);
        String num2c = numCheckAndRemoveHeadZero(num2);
        if (num1c == null || num2c == null) {
            throw new IllegalArgumentException("参数不合法");
        }

        if (num1c.equals("0") || num2c.equals("0")) {
            return "0";
        }
        // 处理结果的符号
        boolean negative = false;
        int negativeCount = 0;
        if (num1c.charAt(0) == '-') {
            negativeCount++;
            num1c = num1c.substring(1);
        }
        if (num2c.charAt(0) == '-') {
            negativeCount++;
            num2c = num2c.substring(1);
        }
        if (negativeCount == 1) {
            negative = true;
        }
        String result = "0";
        char[] mRes = new char[num2c.length() + 1];
        StringBuilder appendZero = new StringBuilder();
        // 按照乘法运算规则，循环相乘相加
        for (int i = num1c.length() - 1; i >= 0; i--) {
            int multiplyUpNum = 0;
            int oneNum = num1c.charAt(i) - '0';
            if (i < num1c.length() - 1) {
                appendZero.append("0");
            }
            for (int j = num2c.length() - 1; j >= 0; j--) {
                int twoNum = num2c.charAt(j) - '0';
                int jNum = oneNum * twoNum + multiplyUpNum;
                if (jNum > 9) {
                    multiplyUpNum = jNum / 10;
                    mRes[j + 1] = (char) (jNum % 10 + '0');
                } else {
                    multiplyUpNum = 0;
                    mRes[j + 1] = (char) (jNum + '0');
                }
            }
            if (multiplyUpNum == 0) {
                result = add(new String(mRes, 1, mRes.length - 1) + appendZero, result);
            } else {
                mRes[0] = (char) (multiplyUpNum + '0');
                result = add(new String(mRes) + appendZero, result);
            }
        }
        return negative ? '-' + result : result;
    }

    /**
     * 两个正数相加
     */
    private String add(String num1, String num2) {
        String max;
        String min;
        if (num1.length() > num2.length()) {
            max = num1;
            min = num2;
        } else {
            max = num2;
            min = num1;
        }
        int minIndex = min.length() - 1;
        char[] result = new char[max.length() + 1];
        boolean addUp = false;

        for (int maxIndex = max.length() - 1; maxIndex >= 0; maxIndex--) {
            int iChar;
            if (minIndex < 0) {
                iChar = addUp ? max.charAt(maxIndex) + 1 : max.charAt(maxIndex);
            } else {
                int i1 = max.charAt(maxIndex) + min.charAt(minIndex--) - '0';
                iChar = addUp ? i1 + 1 : i1;
            }
            addUp = iChar > '9';
            result[maxIndex + 1] = (char) (addUp ? iChar - 10 : iChar);
        }
        if (addUp) {
            result[0] = '1';
            return new String(result);
        } else {
            return new String(result, 1, result.length - 1);
        }
    }

    /**
     * 带符号的数字检查，并去除前导0
     */
    private String numCheckAndRemoveHeadZero(String num) {
        if (num.length() == 0) {
            return null;
        }
        char firstChar = num.charAt(0);
        boolean negative = false;
        int numBegin = 0;
        if (firstChar == '-') {
            negative = true;
            numBegin = 1;
        } else if (firstChar == '+') {
            numBegin = 1;
        }
        if (numBegin > num.length() - 1) {
            return null;
        }
        int headZeroIndex = numBegin - 1;
        boolean headZeroRemoved = false;
        for (int i = numBegin; i < num.length(); i++) {
            char aChar = num.charAt(i);
            if (aChar < '0' || aChar > '9') {
                return null;
            }
            if (!headZeroRemoved) {
                if (aChar == '0' && i < num.length() - 1) {
                    headZeroIndex = i;
                } else {
                    headZeroRemoved = true;
                }
            }
        }
        String result = num.substring(headZeroIndex + 1);
        if (negative) {
            if (result.equals("0")) {
                result = "0";
            } else {
                result = '-' + result;
            }
        }
        return result;
    }
}