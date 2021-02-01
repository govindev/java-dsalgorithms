package com.challenges.gfg.dream11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BestTeam {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		List<Player> players = new ArrayList<>();
//		for (int i = 0; i < 1; i++) {
//			Player player = new Player();
//			System.out.println("Name : ");
//			player.setName(br.readLine());
//			System.out.println("Credits : ");
//			player.setCredits(Float.parseFloat(br.readLine()));
//			System.out.println("Type : ");
//			player.setType(Type.valueOf(br.readLine()));
//			System.out.println("Points : ");
//			player.setPoints(Float.parseFloat(br.readLine()));
//			System.out.println("Batting Position : ");
//			player.setPoints(Integer.parseInt(br.readLine()));
//			System.out.println("Selected By : ");
//			player.setSelectedBy(Float.parseFloat(br.readLine()));
//			System.out.println("Captain Percentage : ");
//			player.setCaptainPercentage(Float.parseFloat(br.readLine()));
//			System.out.println("Vice Captain Percentage : ");
//			player.setViceCaptainPercentage(Float.parseFloat(br.readLine()));
//			players.add(player);
//		}
		List<Player> players = getPlayers();
		printPlayers(players);
		getAllCombinations(players);
	}

	private static final String mustHaves[] = { "BUMRAH", "RABADA", "STOINIS", "BOULT", "DCOCK", "IYER", "SYADAV" };
	private static final String mustNotHaves[] = { "PANT", "AXARPATEL", "COULTERNILE", "DUBEY" };

	public static List<Player> getPlayers() {
		String strs[] = { "DCOCK,10,WICKETKEEPER,1,840,73.26,17.9,8.53", "KISHAN,9,WICKETKEEPER,1,664,65.98,5.41,5.24",
				"PANT,8.5,WICKETKEEPER,2,492,27.66,0.83,1.07", "DAWAN,10,BATSMAN,2,851,69.18,12.62,10.25",
				"ROHITH,9.5,BATSMAN,1,416,45.58,11.03,5.29", "SYADAV,9,BATSMAN,1,699,76.95,8.25,7.96",
				"IYER,9,BATSMAN,2,640,54.63,3.01,4.15", "HPANDYA,9,BATSMAN,1,440,51.49,2.22,3.12",
				"RAHANE,8.5,BATSMAN,2,193,19.38,0.69,1.01", "HETMEYER,8,BATSMAN,2,310,55.95,0.83,1.61",
				"STOINIS,9.5,ALLROUNDER,2,809,85.48,14.81,16.08", "POLLARD,8.5,ALLROUNDER,1,536,49.68,1.8,3.23",
				"AXARPATEL,8.5,ALLROUNDER,2,492,23.76,0.28,0.58", "KPANDYA,8,ALLROUNDER,1,365,33.75,0.39,0.81",
				"RABADA,9.5,BOWLER,2,925,78.36,4.77,8.84", "BUMRAH,9.5,BOWLER,1,792,84.77,10.36,12.15",
				"BOULT,9,BOWLER,1,664,69.71,3.17,6.02", "NORTJE,9,BOWLER,2,583,34.33,0.75,1.66",
				"CHAHAR,8.5,BOWLER,1,463,22.04,0.28,0.56", "ASHWIN,8.5,BOWLER,2,435,37.32,0.6,1.39",
				"COULTERNILE,8,BOWLER,1,130,15.41,0.16,0.26", "DUBEY,7.5,BOWLER,2,21,12.11,0.08,0.11" };
		List<Player> players = new ArrayList<>();
		for (String str : strs) {
			String[] props = str.split(",");
			Player player = new Player();
			player.setName(props[0]);
			player.setCredits(Float.parseFloat(props[1]));
			player.setType(Type.valueOf(props[2]));
			player.setTeam(Integer.parseInt(props[3]));
			player.setPoints(Float.parseFloat(props[4]));
			player.setSelectedBy(Float.parseFloat(props[5]));
			player.setCaptainPercentage(Float.parseFloat(props[6]));
			player.setViceCaptainPercentage(Float.parseFloat(props[7]));
			players.add(player);
		}
		return players;
	}

	private static int getAllCombinations(List<Player> players) {
		List<int[]> combinations = Helper.generate(22, 11);
		List<Team> teams = new ArrayList<>();
		for (int[] combination : combinations) {
			Team team = new Team();
			team.addPlayer(players.get(combination[0]));
			team.addPlayer(players.get(combination[1]));
			team.addPlayer(players.get(combination[2]));
			team.addPlayer(players.get(combination[3]));
			team.addPlayer(players.get(combination[4]));
			team.addPlayer(players.get(combination[5]));
			team.addPlayer(players.get(combination[6]));
			team.addPlayer(players.get(combination[7]));
			team.addPlayer(players.get(combination[8]));
			team.addPlayer(players.get(combination[9]));
			team.addPlayer(players.get(combination[10]));
			if (team.getPlayers().size() == 11) {
				// Must haves 1. Bumrah 2. Rabada 3. Stoinis 4.
				int mustHavesCount = 0, mustNotHavesCount = 0;
				for (Player player : team.getPlayers()) {
					for (int j = 0; j < mustHaves.length; j++) {
						if (player.getName().contains(mustHaves[j]))
							mustHavesCount++;
					}
					for (int j = 0; j < mustNotHaves.length; j++) {
						if (player.getName().contains(mustNotHaves[j]))
							mustNotHavesCount++;
					}
				}
				Collections.sort(teams, new Comparator<Team>() {
					public int compare(Team t1, Team t2) {
						Float score1 = t1.getTotalSelectedBy() + (t1.getTotalPoints() / 11) + t1.getTotalCaptainBy()
								+ t1.getTotalViceCaptainBy();
						Float score2 = t2.getTotalSelectedBy() + (t2.getTotalPoints() / 11) + t2.getTotalCaptainBy()
								+ t2.getTotalViceCaptainBy();
						return score2.compareTo(score1);
					}
				});
				if (mustHavesCount >= mustHaves.length && mustNotHavesCount < 1)
					teams.add(team);
			}
		}
		System.out.println("No of possible teams : " + teams.size());
		// Print top teams
		for (int i = 0; i < teams.size(); i++) {
			float score = teams.get(i).getTotalSelectedBy() + teams.get(i).getTotalPoints();
			System.err.println("Team : " + i + ", Total Credits : " + teams.get(i).getTotalCreditSum() + ", Score :"
					+ score + "\n" + teams.get(i));
		}
		return 0;
	}

	private static void printPlayers(List<Player> players) {
		for (Player player : players) {
			System.out.println(player);
		}
	}
}
