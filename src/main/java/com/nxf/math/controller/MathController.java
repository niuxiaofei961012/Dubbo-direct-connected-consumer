package com.nxf.math.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nxf.math.service.MathService;

@Controller
public class MathController {
	@Reference(url = "dubbo://127.0.0.1:20880")
	private MathService mathService;
	
	@GetMapping
	public String math(Model model) {
		//调用MathService暴露的方法
		int jia = mathService.jia(4, 6);
		int jian = mathService.jian(66, 6);
		int cheng = mathService.cheng(4, 6);
		int chu = mathService.chu(4,2);
		//将结果存入model
		model.addAttribute("jia", jia);
		model.addAttribute("jian", jian);
		model.addAttribute("cheng", cheng);
		model.addAttribute("chu", chu);
		return "math";
	}
}	
