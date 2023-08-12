package com.bigmoney.testproject.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bigmoney.testproject.service.ItemService;
@Controller
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping(value = "/create" ,method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("item/create");
	}
	@RequestMapping(value = "/create" ,method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String,Object> map) 
	{
		ModelAndView mav = new ModelAndView();		
		String id = itemService.insert(map);
		if(id == null)
			mav.setViewName("redirect:/create");
		
		else
//			mav.setViewName("redirect:/detail?id="+id);
			mav.setViewName("redirect:/select");
		return mav;
	}
	@GetMapping("/detail")
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap =  itemService.detail(map);
		ModelAndView mv = new ModelAndView();
		mv.addObject("isFaile", false);
		mv.addObject("data", detailMap);
		mv.setViewName("/item/detail");
		return mv;		
	}
	
	@PostMapping("/modify")
	@ResponseBody
	public String modify(@RequestParam Map<String, Object> map) throws Exception {		
		try {
			itemService.update(map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";	
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam Map<String, Object> map) throws Exception {		
		try {
			itemService.delete(map);
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return "success";	
	}
	
	@GetMapping(value = "/select")
	public ModelAndView select(HttpServletRequest req) {
		HttpSession session =  req.getSession();
		List<Map<String, Object>> allItems =  itemService.selectAll();		
		// �뵒踰꾧퉭�슜
		Consumer<Map<String, Object>> c = x -> {
			System.out.printf("%s %s %s %s \n", 
					x.get("id"), x.get("item_name"),x.get("f_id"),x.get("price"));
		};
		
		for (Map<String, Object> map : allItems) {
			c.accept(map);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("email", session.getAttribute("email"));
		mv.addObject("allItems", allItems);
		mv.setViewName("item/lists");
		return mv;
	}
	
	@GetMapping("/pselect")
	public ModelAndView getPage(@RequestParam(defaultValue = "1") int page) {
		int pageSize = 10;
		int offset = (page-1)*pageSize;
		List<Map<String, Object>> pageItems =  itemService.pselect(offset,pageSize);
		int totalCount = itemService.getcount();
		int totalPage = (int)Math.ceil( (double)totalCount/pageSize); 
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("allItems", pageItems);
		mv.addObject("totalCount", totalCount);
		mv.addObject("totalPage", totalPage);
		mv.addObject("currentPage", page);
		mv.setViewName("item/lists");
		return mv;
	}
	
}
