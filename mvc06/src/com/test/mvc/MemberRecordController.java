/*===============================
   MemberRecordController.java
================================*/

package com.test.mvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberRecordController
{
   // ※ 액션 처리를 위한 메소드는 사용자 지정
   /*
   @RequestMapping("URL 매핑 주소")
   public String 메소드 이름(매개변수)
   {
      // ※ 비즈니스 로직 처리(모델 활용)
      //  ...
      
      return "뷰 이름.jsp";
   }
   */
   
   // 데이터베이스의 데이터를 읽어오는 과정
   @RequestMapping("/memberlist.action")
   public String memberList(Model model)
   {
      // ※ 비즈니스 로직 처리(모델 활용)
      String result = "";
      
      ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
      MemberDAO dao = new MemberDAO();
      
      try
      {
         dao.connection();
         list = dao.lists();
         
      } catch (Exception e)
      {
         System.out.println(e.toString());
      }
      finally
      {
         try
         {
            dao.close();
            
         } catch (Exception e)
         {
            System.out.println(e.toString());
         }
      }
      
      model.addAttribute("list", list);
      
      result = "/WEB-INF/views/MemberList.jsp";
      
      //return "뷰 이름.jsp";
      return result;
   }
   
   // 데이터 입력(회원 등록) 폼 요청 관련 액션 메소드 정의 - insertformaction
   @RequestMapping("/memberinsertform.action")
   public String memberInsertForm()
   {
      String result = "";
      
      result = "/WEB-INF/views/MemberInsertForm.jsp";
      
      return result;
   }
   
   // 데이터 입력(회원 등록) 액션 메소드 정의 - insertaction
   @RequestMapping("/memberinsert.action")
   public String memberInsert(MemberDTO dto)	// memberinsertform 에서 넘겨받은 id, pw, name, tel, email 
   {														// 알아서 dto에 set 해준다.. 
      String result = "";
      MemberDAO dao = new MemberDAO();
      
      try
		{
      	dao.connection();
      	dao.intsertQuery(dto);
      	
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
      finally
      {
         try
         {
            dao.close();
            
         } catch (Exception e)
         {
            System.out.println(e.toString());
         }
      }
      
      result = "redirect:memberlist.action";
      
      
      return result;
   }
}