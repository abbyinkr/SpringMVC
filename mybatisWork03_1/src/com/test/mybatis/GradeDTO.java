/*=================================
  GradeDTO.java
  - 데이터 저장 및 전송 전용 객체
=================================*/

package com.test.mybatis;

public class GradeDTO
{
	// 총점 평균 등급(합격,과락,불합격)
	private String sid, name, ch;
	// 과목1, 과목2, 과목3, 총점, 평균
	private int sub1, sub2, sub3, tot, avg;
	
	// getter / setter 구성
	public String getSid()
	{
		return sid;
	}
	public void setSid(String sid)
	{
		this.sid = sid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getCh()
	{
		return ch;
	}
	public void setCh(String ch)
	{
		this.ch = ch;
	}
	public int getSub1()
	{
		return sub1;
	}
	public void setSub1(int sub1)
	{
		this.sub1 = sub1;
	}
	public int getSub2()
	{
		return sub2;
	}
	public void setSub2(int sub2)
	{
		this.sub2 = sub2;
	}
	public int getSub3()
	{
		return sub3;
	}
	public void setSub3(int sub3)
	{
		this.sub3 = sub3;
	}
	public int getTot()
	{
		return tot;
	}
	public void setTot(int tot)
	{
		this.tot = tot;
	}
	public int getAvg()
	{
		return avg;
	}
	public void setAvg(int avg)
	{
		this.avg = avg;
	}
	
	
	
	
}
