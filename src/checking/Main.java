/**
* 文件重复率检查
* Author: FruitBasket
* Time: 2013/5/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package checking;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		SourceFile sourceFile=new SourceFile();
		Checking recheck=new Checking();
		
		String article1,article2;
		float repetitiveRate;
		
		try {
			sourceFile.readArticle();
		} catch (IOException e) {
			System.exit(1);
		}
		
		article1=sourceFile.getArticle1();
		article2=sourceFile.getArticle2();
		
		int length1=article1.length();
        int length2=article2.length();
        int i=20;
        int count=0;
        float sum=0;
		String temp1,temp2;
		
		System.out.println("开始查重......");
		
		System.out.println("第一篇文章字数:"+length1);
		System.out.println("第二篇文章字数:"+length2);
		while(i<length1 && i<length2){//循环
			
			temp1=article1.substring(i-20, i);
			temp2=article2.substring(i-20,i);
			sum+=recheck.getRepetitiveRate(temp1,temp2);
			i+=20;
			count++;
		}
		temp1=article1.substring(i-20,length1);
		temp2=article2.substring(i-20,length2);
		sum+=recheck.getRepetitiveRate(temp1,temp2);
		count++;
		repetitiveRate=sum/count;
		
		System.out.println("重复率："+repetitiveRate*100+"%");
		System.out.println("查重结束！");
	}
}
