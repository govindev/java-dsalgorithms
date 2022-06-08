package com.gfg.dsalgo.others;

import java.util.List;
import java.util.UUID;
import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.IOException;

public class CSVTools {

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
//		String entity = "AlertProductAuthUrl";
		// String entity = "IssueResolution";
		String entity = "Alerting";
		int createdOnIndex = 0;
		int modifiedOnIndex = 0;
		int dateIndex = -1;
		List<Integer> uuidIndexes = new ArrayList<>();
		boolean dateManipulationReq = false;
		boolean uuidManipulationReq = false;
		if (entity.equals("AlertProductAuthUrl")) {
			dateManipulationReq = true;
			createdOnIndex = 6;
			modifiedOnIndex = 4;
		} else if (entity.equals("IssueResolution")) {
			uuidManipulationReq = true;
			dateManipulationReq = true;
			uuidIndexes.add(0);
			createdOnIndex = 4;
			modifiedOnIndex = 6;
		} else if (entity.equals("Alerting")) {
			uuidManipulationReq = true;
			uuidIndexes.add(0);
			uuidIndexes.add(12);
			uuidIndexes.add(13);
			dateIndex = 1;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> strs = new ArrayList<>();
		String temp = br.readLine();
		while (temp != null && !temp.isEmpty()) {
			temp = temp.substring(temp.indexOf(';') + 1, temp.length());
			strs.add(temp);
			temp = br.readLine();
		}
		for (String str : strs) {
			// String[] splits = str.split(";");
			String[] splits = str.split(";", -1); // Emtpy values are also considered
			if (uuidManipulationReq) {
				for (Integer uuidIndex : uuidIndexes) {
					String uuid = splits[uuidIndex];
					if (uuid != null && !uuid.isEmpty() && uuid.length() == 32 && !uuid.contains("_")) {
						StringBuilder uuidN = new StringBuilder();
						uuidN.append(uuid.substring(0, 8));
						uuidN.append("-");
						uuidN.append(uuid.substring(8, 12));
						uuidN.append("-");
						uuidN.append(uuid.substring(12, 16));
						uuidN.append("-");
						uuidN.append(uuid.substring(16, 20));
						uuidN.append("-");
						uuidN.append(uuid.substring(20));
						splits[uuidIndex] = uuidN.toString();
					} else {
						UUID uid = UUID.randomUUID();
						splits[uuidIndex] = uid.toString();
					}
					if (splits[uuidIndex].length() > 36) {
						System.out.println("Exceeded the max length of a uuid string");
					}
				}
				
			}
			if (dateIndex > -1) {
				String dateStr = splits[dateIndex];
				if (dateStr != null && !dateStr.equals("")) {
					// System.out.println(dateStr);
					SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
					Date date = sdf.parse(dateStr);
					SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					splits[dateIndex] = newDateFormat.format(date);
				}
			}
			if (dateManipulationReq) {
				String createdOn = splits[createdOnIndex];
				String lastModified = splits[modifiedOnIndex];

				if (createdOn != null && !createdOn.equals("")) {
					createdOn = createdOn.replace("GMT+0000 (UTC)", "UTC");
					SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss zzz");
					Date date = sdf.parse(createdOn);
					Timestamp timeStamp = new Timestamp(date.getTime());
					splits[createdOnIndex] = timeStamp.toString();
				}
				if (lastModified != null && !lastModified.equals("")) {
					lastModified = lastModified.replace("GMT+0000 (UTC)", "UTC");
					SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss zzz");
					Date date = sdf.parse(lastModified);
					Timestamp timeStamp = new Timestamp(date.getTime());
					splits[modifiedOnIndex] = timeStamp.toString();
				}
			}
			StringBuilder newString = new StringBuilder();
			for (int i = 0; i < splits.length; i++) {
				newString.append(splits[i]);
				newString.append(";");
			}
			str = newString.toString();
			System.out.println(str.substring(0, str.length() - 1));
		}
	}
}
