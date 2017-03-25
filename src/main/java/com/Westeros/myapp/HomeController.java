package com.westeros.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sd.westeros.data.House;
import com.sd.westeros.data.Player;
import com.sd.westeros.data.WesterosDAO;


//@SessionAttributes("obj")
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

	@RequestMapping(path = "welcome.do", method = RequestMethod.GET)
	public String getHomePage(Model model) {
//		model.addAttribute("houses", dao.getHouses());
		return "home";
	}
	
	@RequestMapping(path = "gethousebyname.do", method = RequestMethod.GET)
	public String getHouseByName(Model model, String house) {
		model.addAttribute("house", dao.getHouse(house));
		return "house";
	}
	
	@RequestMapping(path = "getplayerbyname.do", method = RequestMethod.GET)
	public String getPlayerByName(Model model, String player) {
		model.addAttribute("player", dao.getPlayer(player));
		return "player";
	}
	
	@RequestMapping(path="goNewHouseForm.do", method = RequestMethod.GET)
	public String getHouseForm(Model model) {
		return "newhouse";
	}
	
	@RequestMapping(path="goNewPlayerForm.do", method = RequestMethod.GET)
	public String getEditPlayerForm(Model model) {
		return "newplayer";
	}
	
	@RequestMapping(path="goEditHouseForm.do", method = RequestMethod.GET)
	public String getEditHouseForm(Model model) {
		return "edithouse";
	}
	
	@RequestMapping(path="goEditPlayerForm.do", method = RequestMethod.GET)
	public String getPlayerForm(Model model) {
		return "editplayer";
	}
	
	@RequestMapping(path = "newhouse.do", method = RequestMethod.POST)
	public String addNewHouse(Model model, House newHouse) {
		model.addAttribute(dao.addHouse(newHouse));
		return "home";
	}
	
	@RequestMapping(path = "newplayer.do", method = RequestMethod.POST)
	public String addNewPlayer(Model model, Player newPlayer) {
		model.addAttribute(dao.addPlayer(newPlayer));
		return "home";
	}
	
	@RequestMapping(path="editHouse.do", method = RequestMethod.POST)
		public String editAndSaveHouse(Model model, House house){
		model.addAttribute(dao.editHouse(house));
		return "player";
	}
	
	@RequestMapping(path="editPlayer.do", method = RequestMethod.POST)
	public String editAndSavePlayer(Model model, Player player){
		model.addAttribute(dao.editPlayer(player));
		return "player";
	}
	
//	@RequestMapping(path="deleteCharacter.do", method = RequestMethod.POST)
//    public ModelAndView deletePlayer(@RequestParam("id") int id){
//        dao.deletePlayer(id);
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("home");
//        return null;
//    }
//	
//	@RequestMapping(path="deleteHouse.do", method = RequestMethod.POST)
//    public ModelAndView deleteHouse(@RequestParam("id") int id){
//        dao.deleteHouse(id);
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("home");
//        return null;
//    }

//	@RequestMapping(path = "retrieve.do", method = RequestMethod.GET)
//	public String retrievePlayer(Model model, int id) {
//		model.addAttribute("houses", dao.getHouse());
//		return "home";
//	}

	
}
