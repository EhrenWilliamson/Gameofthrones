package com.sd.westeros.data;
import java.util.List;

public interface WesterosDAO {

House getHouse(String house);
Player getPlayer (String player);
//Player addPlayer(Player player);
//House addHouse(House house);
//List<Player> getPlayersByHouse(House house);
//void deletePlayer(Integer id);
//void deleteHouse(House house);
List<House> getHouses();
//List<Player> getPlayers();

}
