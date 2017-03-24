package com.westeros.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sd.westeros.data.House;
import com.sd.westeros.data.Player;
import com.sd.westeros.data.WesterosDAO;

@SessionAttributes("obj")
@Controller
public class HomeController {
	
	@Autowired
	private WesterosDAO dao;

//	@ModelAttribute("obj")
//	public House initHouse() {
//		return new House();
//	}

	public void setWesterosDAO(WesterosDAO w) {
		this.dao = w;
	}

//	@RequestMapping(path = "welcome.do", method = RequestMethod.GET)
	@RequestMapping("*.do")
	public String getHomePage(Model model) {
//		model.addAttribute("houses", dao.getHouses());
		return "home";
	}
	
//	@RequestMapping(path = "gethousebyname.do", method = RequestMethod.GET)
	public String getHouseByName(Model model, String house) {
		model.addAttribute("house", dao.getHouse(house));
		return "house";
	}
	
//	@RequestMapping(path = "getplayerbyname.do", method = RequestMethod.GET)
//	public String getPlayerByName(Model model, String player) {
//		model.addAttribute("player", dao.getPlayer(player));
//		return "player";
//	}
//	
//	@RequestMapping(path = "newhouse.do", method = RequestMethod.GET)
//	public String addNewHouse(Model model, House newHouse) {
//		model.addAttribute("houses", dao.addHouse(newHouse));
//		return "newhouse";
//	}
//	
//	@RequestMapping(path = "newplayer.do", method = RequestMethod.GET)
//	public String addNewPlayer(Model model, Player newPlayer) {
//		model.addAttribute("houses", dao.addPlayer(newPlayer));
//		return "newplayer";
//	}
//	
//	@RequestMapping(path = "retrieve.do", method = RequestMethod.GET)
//	public String retrievePlayer(Model model, int id) {
//		model.addAttribute("houses", dao.getHouse());
//		return "home";
//	}

	
}
