package com.challenges.gfg.dream11;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private List<Player> players;
	private float totalCreditSum;
	private int wicketKeepersCount;
	private int batsmanCount;
	private int allRoundersCount;
	private int bowlersCount;
	private int team1Count;
	private int team2Count;
	private float totalSelectedBy;
	private float totalPoints;
	private float totalCaptainBy;
	private float totalViceCaptainBy;

	public Team() {
		players = new ArrayList<>();
		totalCreditSum = 0;
		wicketKeepersCount = 0;
		batsmanCount = 0;
		allRoundersCount = 0;
		bowlersCount = 0;
		team1Count = 0;
		team2Count = 0;
		totalSelectedBy = 0;
		totalPoints = 0;
		totalCaptainBy = 0;
		totalViceCaptainBy = 0;
	}

	public float getTotalCaptainBy() {
		return totalCaptainBy;
	}

	public float getTotalViceCaptainBy() {
		return totalViceCaptainBy;
	}

	public float getTotalSelectedBy() {
		return totalSelectedBy;
	}

	public float getTotalPoints() {
		return totalPoints;
	}

	public float getTotalCreditSum() {
		return totalCreditSum;
	}

	public int getWicketKeepersCount() {
		return wicketKeepersCount;
	}

	public int getBatsmanCount() {
		return batsmanCount;
	}

	public int getAllRoundersCount() {
		return allRoundersCount;
	}

	public int getBowlersCount() {
		return bowlersCount;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player newPlayer) {
		// 0. Should only have 11 players
		if (players.size() >= 11) {
			return;
		}
		// 1. Sum of all Players credits should be le 100
		if ((totalCreditSum > 100) || ((totalCreditSum + newPlayer.getCredits()) > 100)) {
			return;
		}
		if (team1Count == 7 && newPlayer.getTeam() == 1) {
			return;
		}
		if (team2Count == 7 && newPlayer.getTeam() == 2) {
			return;
		}
		// 2. Should have 1 - 4 Wicket keepers
		// 3. Should have 3 - 6 Batsman
		// 4. Should have 1 - 4 All rounders
		// 5. Should have 3 - 6 Bowlers;

		if (!ensureMinimumExceptType(newPlayer.getType())) {
			return;
		}
		if (newPlayer.getType() == Type.WICKETKEEPER) {
//			if (wicketKeepersCount == 4) {
//				return;
//			}
//
//			// If we are trying for 2 wicket keepers combination then
//			if ((wicketKeepersCount == 1) && (batsmanCount > 5 || allRoundersCount > 3 || bowlersCount > 5
//					|| batsmanCount + allRoundersCount == 8 || allRoundersCount + bowlersCount == 8
//					|| batsmanCount + bowlersCount == 10)) {
//				return;
//			}
//
//			// If we are trying for 3 wicket keepers combination then
//			if ((wicketKeepersCount == 2) && (batsmanCount > 4 || allRoundersCount > 2 || bowlersCount > 4)) {
//				return;
//			}
//
//			// If we are tyring for 4 wicket keepers combinations then
//			if ((wicketKeepersCount == 3) && (batsmanCount > 3 || allRoundersCount > 1 || bowlersCount > 3)) {
//				return;
//			}
//
//			// Ensure minimum count of other player types
//			if (players.size() == 10) {
//				if (batsmanCount < 3 || allRoundersCount < 1 || bowlersCount < 3) {
//					return;
//				}
//			}
			wicketKeepersCount++;
		} else if (newPlayer.getType() == Type.BATSMAN)

		{
//			if (batsmanCount == 6) {
//				return;
//			}
//
//			// If we are trying for 4 batsmans combination then
//			if ((batsmanCount == 3) && (wicketKeepersCount > 3 || allRoundersCount > 3 || bowlersCount > 5
//					|| wicketKeepersCount + allRoundersCount == 6 || wicketKeepersCount + bowlersCount == 8
//					|| allRoundersCount + bowlersCount == 8)) {
//				return;
//			}
//
//			// If we are trying for 5 batsmans combination then
//			if ((batsmanCount == 4) && (wicketKeepersCount > 2 || allRoundersCount > 2 || bowlersCount > 4)) {
//				return;
//			}
//
//			// If we are trying for 6 batsmans combination then
//			if ((batsmanCount == 5) && (wicketKeepersCount > 1 || allRoundersCount > 1 || bowlersCount > 3)) {
//				return;
//			}
//
//			// Ensure minimum count of other player types
//			if (players.size() == 10) {
//				if (wicketKeepersCount < 1 || allRoundersCount < 1 || bowlersCount < 3) {
//					return;
//				}
//			}
			batsmanCount++;
		} else if (newPlayer.getType() == Type.ALLROUNDER) {
//			if (allRoundersCount == 4) {
//				return;
//			}
//
//			// If we are trying for 2 allrounders combination then
//			if ((allRoundersCount == 1) && (batsmanCount > 5 || wicketKeepersCount > 3 || bowlersCount > 5
//					|| batsmanCount + wicketKeepersCount == 8 || bowlersCount + wicketKeepersCount == 8
//					|| bowlersCount + batsmanCount == 10)) {
//				return;
//			}
//
//			// If we are trying for 3 allrounders combination then
//			if ((allRoundersCount == 2) && (batsmanCount > 4 || wicketKeepersCount > 2 || bowlersCount > 4)) {
//				return;
//			}
//
//			// If we are trying for 4 allrounders combination then
//			if ((allRoundersCount == 3) && (batsmanCount > 3 || wicketKeepersCount > 1 || bowlersCount > 3)) {
//				return;
//			}
//
//			// Ensure minimum count of other player types
//			if (players.size() == 10) {
//				if (wicketKeepersCount < 1 || batsmanCount < 3 || bowlersCount < 3) {
//					return;
//				}
//			}
			allRoundersCount++;
		} else if (newPlayer.getType() == Type.BOWLER) {
//			if (bowlersCount == 4) {
//				return;
//			}
//
//			// If we are trying for 4 bowlers combination then
//			if ((bowlersCount == 3) && (wicketKeepersCount > 3 || allRoundersCount > 3 || batsmanCount > 5)) {
//				return;
//			}
//
//			// If we are trying for 5 batsmans combination then
//			if ((bowlersCount == 4) && (wicketKeepersCount > 2 || allRoundersCount > 2 || batsmanCount > 4)) {
//				return;
//			}
//
//			// If we are trying for 6 batsmans combination then
//			if ((bowlersCount == 5) && (wicketKeepersCount > 1 || allRoundersCount > 1 || batsmanCount > 3)) {
//				return;
//			}
//
//			// Ensure minimum count of other player types
//			if (players.size() == 10) {
//				if (wicketKeepersCount < 1 || batsmanCount < 3 || allRoundersCount < 1) {
//					return;
//				}
//			}
			bowlersCount++;
		}
		if (newPlayer.getTeam() == 1) {
			team1Count++;
		} else {
			team2Count++;
		}
		players.add(newPlayer);
		totalCreditSum = totalCreditSum + newPlayer.getCredits();
		totalSelectedBy = totalSelectedBy + newPlayer.getSelectedBy();
		totalPoints = totalPoints + newPlayer.getPoints();
		totalCaptainBy = totalCaptainBy + newPlayer.getCaptainPercentage();
		totalViceCaptainBy = totalViceCaptainBy + newPlayer.getViceCaptainPercentage();
	}

	private boolean ensureMinimumExceptType(Type type) {
		if (type == Type.WICKETKEEPER) {
			int proposedCount = wicketKeepersCount + 1;
			int remainingCount = 11 - proposedCount;
			// Ensure overall remaining count
			if (remainingCount < 5) {
				return false;
			}
			// Ensure batsman count
			if ((remainingCount - (bowlersCount + allRoundersCount)) < 3) {
				return false;
			}
			// Ensure allrounders count
			if ((remainingCount - (batsmanCount + bowlersCount)) < 1) {
				return false;
			}
			// Ensure bowlers count
			if ((remainingCount - (batsmanCount + allRoundersCount)) < 3) {
				return false;
			}
		} else if (type == Type.BATSMAN) {
			int proposedCount = batsmanCount + 1;
			int remainingCount = 11 - proposedCount;
			// Ensure overall remaining count
			if (remainingCount < 7) {
				return false;
			}
			// Ensure wicketkeepers count
			if ((remainingCount - (bowlersCount + allRoundersCount)) < 1) {
				return false;
			}
			// Ensure allrounders count
			if ((remainingCount - (wicketKeepersCount + bowlersCount)) < 1) {
				return false;
			}
			// Ensure bowlers count
			if ((remainingCount - (wicketKeepersCount + allRoundersCount)) < 3) {
				return false;
			}
		} else if (type == Type.ALLROUNDER) {
			int proposedCount = allRoundersCount + 1;
			int remainingCount = 11 - proposedCount;
			// Ensure overall remaining count
			if (remainingCount < 7) {
				return false;
			}
			// Ensure wicketkeepers count
			if ((remainingCount - (bowlersCount + batsmanCount)) < 1) {
				return false;
			}
			// Ensure batsman count
			if ((remainingCount - (wicketKeepersCount + bowlersCount)) < 3) {
				return false;
			}
			// Ensure bowlers count
			if ((remainingCount - (wicketKeepersCount + batsmanCount)) < 3) {
				return false;
			}

		} else if (type == Type.BOWLER) {
			int proposedCount = bowlersCount + 1;
			int remainingCount = 11 - proposedCount;
			// Ensure overall remaining count
			if (remainingCount < 7) {
				return false;
			}
			// Ensure wicketkeepers count
			if ((remainingCount - (allRoundersCount + batsmanCount)) < 1) {
				return false;
			}
			// Ensure batsman count
			if ((remainingCount - (wicketKeepersCount + allRoundersCount)) < 3) {
				return false;
			}
			// Ensure allrounders count
			if ((remainingCount - (wicketKeepersCount + batsmanCount)) < 3) {
				return false;
			}

		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Player player : players) {
			sb.append(player.getName());
			sb.append(",");
//			sb.append("," + player.getType());
//			sb.append("," + player.getCredits());
//			sb.append(",Team" + player.getTeam());
//			sb.append("\n");
		}
		sb.append("\n");
		return sb.toString();

	}
}
