package com.sd.Westeros.data;
import java.util.List;

public interface WesterosDAO {

List<House> getHouse(House house);
List<Player> getPlayer (Player player);
Player addPlayer(Player player);
House addHouse(House house);
List<Player> getPlayersByHouse(House house);
}
