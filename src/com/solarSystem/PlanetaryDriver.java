package com.solarSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PlanetaryDriver {

	public static void main(String[] args) {
		
		PlanetInit planet1 = new PlanetInit ();
		planet1.planet = "Mercury";
		planet1.moons = 0;
		planet1.rings=false ;

		PlanetInit planet2 = new PlanetInit ();
		planet2.planet = "Venus";
		planet2.gases.add("Carbon Dioxide");
		planet2.gases.add("Nitrogen");
		planet2.moons = 0;
		planet2.rings=false ;

		PlanetInit planet3 = new PlanetInit ();
		planet3.planet = "Earth";
		planet3.gases.add("Nitrogen");
		planet3.gases.add("Oxygen");
		planet3.moons = 1;
		planet3.rings=false ;

		PlanetInit planet4 = new PlanetInit ();
		planet4.planet = "Jupitor";
		planet4.gases.add("Hydrogen");
		planet4.gases.add("Helium");
		planet4.moons = 79;
		planet4.rings=true ;

		PlanetInit planet5 = new PlanetInit ();
		planet5.planet = "Saturn";
		planet5.gases.add("Hydrogen");
		planet5.gases.add("Helium");
		planet5.moons = 83;
		planet5.rings=true ;

		PlanetInit planet6 = new PlanetInit ();
		planet6.planet = "Uranus";
		planet6.gases.add("Hydrogen");
		planet6.gases.add("Helium");
		planet6.gases.add("Methane");
		planet6.moons = 27;
		planet6.rings=true ;

		List <PlanetInit> planetaries = new ArrayList <> () ;

		planetaries.add(planet1);
		planetaries.add(planet2);
		planetaries.add(planet3);
		planetaries.add(planet4);
		planetaries.add(planet5);
		planetaries.add(planet6);

		System.out.println("Total moons of planets with rings: " + totalMoonsWithRings(planetaries));
		System.out.println("Common gas found on planets: " + gasFoundOnMaxPlanets(planetaries));
		}

		public static int totalMoonsWithRings (List<PlanetInit> planetaries)
		{
		int moonSum = 0;
		for (PlanetInit planet : planetaries) {
		if (planet.rings) {
		moonSum += planet.moons;
		}
		}
		return moonSum;
		}
		
		public static String gasFoundOnMaxPlanets(List<PlanetInit> planetaries)
		{
			List <String> list = new ArrayList<> ();
			for (PlanetInit planet: planetaries) {
				for (String x: planet.gases) {
					list.add(x);
				}
			}
			Map<Integer, String> map = new TreeMap<> (); 
			for (int i = 0 ; i < list.size(); i ++) {
				int count = 0;
				
				if(map.containsValue(list.get(i)))
					continue;
				for ( int j= i ; j< list.size(); j++)
				{
					if (list.get(i).equals(list.get(j))) {
						map.put(++count, list.get(i));
					}
				}
			}
			Set<Integer> set= map.keySet();
			String temp = "";
			for (Integer x : set) {
				temp = map.get(x);
			}
			return temp; 
		}

	}


