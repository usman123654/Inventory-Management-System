package pk.gov.dgip.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pk.gov.dgip.entities.Item;
import pk.gov.dgip.entities.User;
import pk.gov.dgip.services.CategoryDAOService;
import pk.gov.dgip.services.ConditionDAOService;
import pk.gov.dgip.services.ItemsDAOService;
import pk.gov.dgip.services.UserDAOService;

@Controller
public class DailyReportInventoryController {

	@Autowired
	private UserDAOService userService;

	@Autowired
	private ItemsDAOService itemsService;
	
	@Autowired
	private ConditionDAOService conditionService;
	
	@Autowired
	private CategoryDAOService categoryService;
	
	@PostMapping("/daily-report-inventory")
	public String dailyReportInventoryController(@ModelAttribute("userID") String userid, Model model) {
		User user = userService.getUserById(Integer.parseInt(userid));
		model.addAttribute("userid", userid);
		List<Item> items = itemsService.findItemsByUser(user);
		model.addAttribute("items", items);
		model.addAttribute("rpoName", user.getFullname());
		model.addAttribute("category",categoryService.getAllCategories());
		model.addAttribute("condition",conditionService.getAllConditions());
		model.addAttribute("category",categoryService.getAllCategories());
		return "daily-report-inventory";
	}
}
