package com.example.tvdatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TVPopulator implements CommandLineRunner {

	@Resource
	TVRepository tvRepo;

	@Override
	public void run(String... args) throws Exception {

		List<TV> tvs = readTvsFromCSV("Table.csv");

		tvs.forEach(System.out::println);

		for (TV unit : tvs) {
			if (unit.getModel().equals("TVMODEL")) {
				continue;
			} else {
				unit = tvRepo.save(unit);
			}
		}
	}

	private static List<TV> readTvsFromCSV(String fileName) {
		List<TV> tvs = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);

		try (BufferedReader fileReader = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

			String line = fileReader.readLine();

			while (line != null) {

				String[] columns = line.split(",");

				TV tv = setUpTV(columns);

				tvs.add(tv);

				line = fileReader.readLine();
			}

		} catch (IOException exception) {
			exception.printStackTrace();
		}

		return tvs;
	}

	private static TV setUpTV(String[] parts) {
		String model = parts[0];
		String dateUpdated = parts[1];
		String price = parts[2];

		return new TV(model, dateUpdated, price);
	}

}
