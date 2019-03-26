package com.soft1841.list.week4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



public class ArticleListTest {
    public static void main(String[] args) throws ParseException {
        List<Article> list = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        list.add(new Article(1, "东野圭吾的小说是日本的后续", "  东野圭吾", simpleDateFormat.parse("2019-03-18 20:20:20")));
        list.add(new Article(2, "余华的活着是中国的后续", "     余华 ", simpleDateFormat.parse("2019-03-18 17:18:18")));
        list.add(new Article(3, "马里奥的教父是美国的后续", " 马里奥 ", simpleDateFormat.parse("2019-03-18 20:17:16")));
        System.out.println("id      标题                   作者      写作时间");
        //用Iterator循环遍历集合
        Iterator<Article> integer = list.iterator();
        while (integer.hasNext()) {
            //增加时间的循环上去
            Article article = integer.next();
            String result;
            result = timeCal(simpleDateFormat.format(article.getWriteTime()));
            System.out.println(article.getId() + "   "
                    + article.getTitle()+
                    article.getAuthor() + "   " + result);

        }
    }
    private static String timeCal(String time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1;
        long diff = 0;
        try {
            d1 = format.parse(time);
            Date now = new Date();
            diff = now.getTime() - d1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        if (seconds < 60) {
            return "刚刚";
        } else if (minutes < 60) {
            return minutes + "分钟前";
        } else if (hours < 24) {
            return hours + "小时前";
        } else {
            return days + "天前";
        }
    }
}
