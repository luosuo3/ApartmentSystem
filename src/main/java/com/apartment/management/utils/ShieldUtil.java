package com.apartment.management.utils;

/**
 * @author 王峥
 * @date 2020/6/3 9:38 上午
 */
public class ShieldUtil {
    public static String replace(String str) {

        String words[]={"牛逼","垃圾","傻逼","SB","sb"};
        for(int i=0;i<words.length;i++)
        {
            if(str.matches(".*"+words[i]+".*"))
            {
//				计算需要的*的个数
                String s="";
                for(int j=0;j<words[i].length();j++)
                {
                    s+="*";
                }
                str=str.replaceAll(words[i], s);
            }
        }

        System.out.println(str);
        return str;

    }
}
