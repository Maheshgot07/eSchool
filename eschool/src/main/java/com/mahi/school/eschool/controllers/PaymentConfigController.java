package com.mahi.school.eschool.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mahi.school.eschool.service.PaymentService;

import common.datamodel.FeeItem;
import common.datamodel.FeeStructure;
import common.datamodel.FeeStructureWrapper;

@RestController
public class PaymentConfigController {
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping("/initFeeStructure.html")
	public ModelAndView initFeeStructure(@ModelAttribute("feeStructureWrapper")FeeStructureWrapper feeStructureWrapper) {
		ModelAndView mav = new ModelAndView("feeStructure");
		FeeStructure feeStructure = new FeeStructure();
		List<FeeItem> itemList = new ArrayList<FeeItem>();
		itemList.add(new FeeItem());
		feeStructureWrapper.setFeeItems(itemList);
		feeStructureWrapper.setFeeStructure(feeStructure);
		mav.addObject("feeStructureWrapper",feeStructureWrapper);
		return mav;
	}

	@RequestMapping(value="createFeeStructure.html", method= RequestMethod.POST)
	public ModelAndView createFeeSTructure(@ModelAttribute("feeStructureWrapper")FeeStructureWrapper feeStructureWrapper) {
		ModelAndView mav = new ModelAndView("feeStructure");
		System.out.println(feeStructureWrapper.getFeeStructure());
		FeeStructure feeStructure = paymentService.createFeeStructure(feeStructureWrapper.getFeeStructure());
		
		if(feeStructure.getFeeItems() != null) {
			for(FeeItem fee: feeStructure.getFeeItems()  ) {
				System.out.println(fee.getItemName());
			}
			
		}
		feeStructureWrapper.setFeeStructure(feeStructure);
		mav.addObject("feeStructureWrapper",feeStructureWrapper);
		return mav;
	}

}
