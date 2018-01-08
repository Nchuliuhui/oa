package com.ponshine.oa.common.util;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @date
 */
public class StringUtil {

    /**
     * 判断字符串是否为NULL或空字符串
     */
    public static boolean isNullOrEmpty(Object obj) {
        return obj == null || "".equals(obj.toString());
    }

    /**
     * 判断字符串是否包含单引号,如果存在，则将单引号替换为两个单引号
     */
    public static String replaceSingleQuotes(String str){
        if(str!=null&&!"".equals(str)){
            str = str.trim().replace("'","''");
        }else{
            str = "";
        }
        return str;
    }

    /**生成一个由大小写字母，数字组成的密码字符串
     * @param pwd_len  密码长度
     * @return
     */
    public static String genRandomNum(int pwd_len){
        //35是因为数组是从0开始的，26个字母+10个数字
        final int  maxNum = 36;
        int i;  //生成的随机数
        int count = 0; //生成的密码的长度
        char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'A', 'B', 'B', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while(count < pwd_len){
            //生成随机数，取绝对值，防止生成负数，

            i = Math.abs(r.nextInt(maxNum));  //生成的数最大为36-1

            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count ++;
            }
        }

        return pwd.toString();
    }

    //去除数组中重复的记录
    public static String[] array_unique(String[] a) {
        // array_unique
        List<String> list = new LinkedList<String>();
        for(int i = 0; i < a.length; i++) {
            if(!list.contains(a[i])) {
                list.add(a[i]);
            }
        }
        return (String[])list.toArray(new String[list.size()]);
    }

    /**截取文件名中的扩展名
     * @param fileName
     * @ret
     */
    public static  String getFileType(String fileName){
        String fileType = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        return fileType;
    }


    /**判断一个字符串是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        try {
            new BigDecimal(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**保留小数
     * @param value 数值
     * @param roundNum 保留小数位
     * @return
     */
    public static String  roundNumber(Object value,int roundNum){
        if(value!=null){
            if(value instanceof Double){
                if((Double)value==0){
                    return "";
                }
                NumberFormat nbf=NumberFormat.getInstance();
                if(roundNum<=0){
                    roundNum=1;
                }
                nbf.setMinimumFractionDigits(roundNum);
                return nbf.format(value);
            }else if(value instanceof String){
                if(isNumeric(value.toString())){//如果是数字，也需要保留小数
                    Double d = Double.parseDouble(value.toString());
                    if(d==0){
                        return "";
                    }
                    NumberFormat nbf=NumberFormat.getInstance();
                    if(roundNum<=0){
                        roundNum=1;
                    }
                    nbf.setMinimumFractionDigits(roundNum);
                    return nbf.format(d);
                }else{
                    return value.toString();
                }
            }
        }
        return "";
    }

    /**将数组转化为字符串，用逗号分隔
     * @param obj
     * @return
     */
    public static String changeArrayToString(String[] obj){
        StringBuffer str = new StringBuffer();
        for(String s:obj){
            if(str.equals("")){
                str.append(s);
            }else{
                str.append(","+s);
            }
        }
        return str.toString();
    }
    /**将List转化为字符串，用逗号分隔
     * @param obj
     * @return
     */
    public static String changeListToString(List<String> list){
        StringBuffer str = null;
        for(Object s:list){
            if(str==null){
                str = new StringBuffer(s.toString());
            }else{
                str.append(","+s);
            }
        }
        return str.toString();
    }

    /**
     * 将组织架构树去零，并保留偶数位数字，如果截取后只剩下奇数位，则补0
     * @param structureId
     * @return
     */
    public static String removeStructureZero(String structureId){
        String rex = "0+?$";//去掉多余的0
        structureId=structureId.replaceAll(rex,"");
        if(structureId.length()%2!=0)//奇数，补零
            structureId+="0";
        return structureId;
    }
    /**
     * 移除开头的0
     * @param structureId
     * @return
     */
    public static String removeStartZero(String str){
        String rex = "^[0]+";//去掉多余的0
        str=str.replaceAll(rex,"");
        return str;
    }

    /**
     * 去除字符串前中后的空格
     * @param str 需要处理的字符串
     * @return String
     */
    public static String removeSpace(String str){
        str = str.replace(" ","");
        return str;
    }

    /**
     * 得到字符串中第一个英文字典的下标
     * @param s
     * @return
     */
    public static int findFirstLetterIndexOf(String s){
        int m = -1;
        if(isNullOrEmpty(s)){
            return m;
        }
        try {
            for(int i = 0;i<s.length();i++){    //遍历整个字符串
                char c = s.charAt(i) ;        //字符串中每个字符
                if((c>='a'&&c<='z')||(c>='A'&&c<'Z')){    //英文字符
                    m = i ;    //输出歌英文字符的位置
                    break;
                }
            }
        } catch (Exception e) {}
        return m;
    }
}
