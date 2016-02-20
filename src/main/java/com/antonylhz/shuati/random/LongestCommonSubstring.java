package com.antonylhz.shuati.random;

import java.util.*;

public class LongestCommonSubstring {
private String s1, s2;
	
	public LongestCommonSubstring(String s1, String s2) {
		this.s1=s1;
		this.s2=s2;
	}
	
	public ResultSet calculatelcs_dp()
	{
		ResultSet[][] array = new ResultSet[s1.length()+1][s2.length()+1];

		for(int m = 0; m<=s1.length();m++)
			for(int n = 0; n<=s2.length(); n++)
			{
				if(m==0||n==0)
					array[m][n] = new ResultSet();
				else if(s1.charAt(m-1)==s2.charAt(n-1))
				{
					ResultSet rs = new ResultSet(array[m-1][n-1].set);
					ArrayList<String> tmp = rs.append(s1.charAt(m-1));
					array[m][n] = new ResultSet(tmp);
				}
				
				//array[m][n] = new ResultSet(array[m-1][n-1].append(s1.charAt(m-1)));
				else
				{
					if(array[m-1][n].curLength>array[m][n-1].curLength)
						array[m][n] = new ResultSet(array[m-1][n].set);
					else if(array[m-1][n].curLength<array[m][n-1].curLength)
						array[m][n] = new ResultSet(array[m][n-1].set);
					else
					{
						ArrayList<String> tmpset = new ArrayList<String>();
						int i = 0;
						int m1nsize = array[m-1][n].set.size();
						while(i<m1nsize)
						{
							tmpset.add(array[m-1][n].set.get(i));
							i++;
						}
						for(; i<m1nsize+array[m][n-1].set.size(); i++)
							if(!tmpset.contains(array[m][n-1].set.get(i-m1nsize)))
								tmpset.add(array[m][n-1].set.get(i-m1nsize));
						
						array[m][n] = new ResultSet(tmpset);
					}
				}
				
			}
		
		return array[s1.length()][s2.length()];
	}
	
	public class ResultSet
	{
		public ArrayList<String> set = new ArrayList<String>();
		public int curLength = 0;
		
		public ResultSet(ArrayList<String> sblist)
		{
			if(sblist.size()>0)
			{
				this.set.addAll(sblist);
				this.curLength = sblist.get(0).length();
			}
		}
		
		public ResultSet()
		{}
		
		public ArrayList<String> append(char c)
		{
			ArrayList<String> newSet = new ArrayList<String>();
			if(curLength==0)
				newSet.add(String.valueOf(c));
			else
			{
				newSet.addAll(set);
				for(int i = 0; i < newSet.size(); i++)
				{
					StringBuffer tmpsb = new StringBuffer(newSet.get(0));
					newSet.remove(0);
					tmpsb.append(c);
					newSet.add(tmpsb.toString());
				}
			}
			return newSet;
		}
	}
}
