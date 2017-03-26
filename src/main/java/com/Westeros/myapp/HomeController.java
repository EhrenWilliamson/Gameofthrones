package com.westeros.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sd.westeros.data.House;
import com.sd.westeros.data.Player;
import com.sd.westeros.data.WesterosDAO;


@Controller
@SessionAttributes({"house","player"})
public class HomeController {
	
	@Autowired
	private WesterosDAO dao;
 
	@ModelAttribute("house")
	public House house(){
		return new House();
	}
	
	@ModelAttribute("player")
	public Player player(){
		return new Player();
	}
	

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
		House h = dao.getHouse(house);
		
		if (h != null) {
			model.addAttribute("house", h);
			return "house";
		} else {
			model.addAttribute("houseNotFound", true);
			return "home";
		}
		
	}
	
	@RequestMapping(path = "getplayerbyname.do", method = RequestMethod.GET)
	public String getPlayerByName(Model model, String player) {
		
		Player p = dao.getPlayer(player); 
		if (p != null) {
			model.addAttribute("player", p);
			return "player";
		} else {
			model.addAttribute("playerNotFound", true);
			return "home";
		}
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
	public String getEditHouseForm(Model model, @ModelAttribute("house") House house) {
		model.addAttribute(house);
		return "edithouse";
	}
	
	@RequestMapping(path="goEditPlayerForm.do", method = RequestMethod.GET)
	public String getPlayerForm(Model model, @ModelAttribute("player") Player player) {
		model.addAttribute(player);
		return "editplayer";
	}
	
	@RequestMapping(path="goDeleteHouse.do", method = RequestMethod.GET)
	public String getDeleteHouse(Model model, int id) {
		System.out.println(id);
		dao.deleteHouse(id);
		return "home";
	}
	
	@RequestMapping(path="goDeletePlayer.do", method = RequestMethod.GET)
	public String getDeletePlayer(Model model, int id) {
		System.out.println(id);
		dao.deletePlayer(id);
		return "home";
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
		public String editAndSaveHouse(Model model, House editHouse){
		model.addAttribute(dao.editHouse(editHouse));
		return "house";
	}
	
	@RequestMapping(path="editPlayer.do", method = RequestMethod.POST)
	public String editAndSavePlayer(Model model, Player editPlayer){
		model.addAttribute(dao.editPlayer(editPlayer));
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
