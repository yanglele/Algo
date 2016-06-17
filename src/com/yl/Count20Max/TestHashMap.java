package com.yl.Count20Max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestHashMap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//读入文件到stringbuffer
		BufferedReader bufferedReader=null;
		StringBuffer sbuffer=null;
		try {
			bufferedReader=new BufferedReader(new FileReader("D:/masterSpring/algo/src/com/yl/Count20Max/english.txt"));
			System.out.println("Read under this dir!");
			sbuffer = new StringBuffer();
			String line =null;
			while((line=bufferedReader.readLine()) != null){
				sbuffer.append(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		Pattern expression=Pattern.compile("[a-zA-Z]+");
		String string1=sbuffer.toString().toLowerCase();
		Matcher matcher=expression.matcher(string1);
		
		HashMap<String, Integer> mHashMap=new HashMap<>();
		int count=0;
		String word=null;
		Integer num=0;
		
		while(matcher.find()){
			word=matcher.group();
			count++;
			if(mHashMap.containsKey(word)){
				num=mHashMap.get(word);
				mHashMap.put(word, ++num);
			}else{
				mHashMap.put(word, 1);
			}
		}
		
		System.out.println("统计结果在result.txt文件中");
		BufferedWriter bufferedWriter=null;
		try {
			bufferedWriter=new BufferedWriter(new FileWriter("D:/masterSpring/algo/src/com/yl/Count20Max/result1.txt"));
			Iterator<String> iterator=mHashMap.keySet().iterator();
			String key=null;
			while(iterator.hasNext()){
				key=iterator.next();
				bufferedWriter.write(key+" : "+mHashMap.get(key));
				bufferedWriter.newLine();
			}
			bufferedWriter.write("一共有"+count+"个单词");
			bufferedWriter.newLine();
			bufferedWriter.write("一共有"+mHashMap.size()+"个不同单词");
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("出现次数最多的20个单词：");
		List<Map.Entry<String, Integer>> list=new ArrayList<>(mHashMap.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for(int i=0;i<20;i++){
			System.out.println(list.get(i).getKey()+" : "+list.get(i).getValue());
		}

	}

}
