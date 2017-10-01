package eitsch.dbtool.dbconfiq.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eitsch.dbtool.dbconfiq.enums.ConfigType;
import eitsch.dbtool.dbconfiq.enums.SGUIHUDPlayer;
import eitsch.dbtool.dbconfiq.model.HudElement;

public class ShooterUIParser implements ConfigParser {

	private static final Logger log = LoggerFactory.getLogger(ShooterUIParser.class);

	private final Path filepath;
	private Map<String, HudElement> hudElementsMappedByString = new HashMap<>();
	private Map<SGUIHUDPlayer, HudElement> hudElementsMappedByEnum = new HashMap<>();

	public ShooterUIParser(Path path) {
		super();
		this.filepath = path;
		this.parseIniFile();
	}
	
	public void parseIniFile() {
		List<String> iniLines = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(this.filepath.toAbsolutePath())) {
			// br returns as stream and convert it into a List
			iniLines = br.lines().collect(Collectors.toList());
		} catch (IOException | SecurityException e) {
			log.error("error parsing ini-file", e);
		}
		
		this.hudElementsMappedByEnum.clear();
		this.hudElementsMappedByEnum = parseSGUIHUDPlayer(iniLines);
		
		this.hudElementsMappedByString.clear();
		for (Entry<SGUIHUDPlayer, HudElement> entry : this.hudElementsMappedByEnum.entrySet()) {
			hudElementsMappedByString.put(entry.getKey().name(), entry.getValue());
		}
	}

	private Map<SGUIHUDPlayer, HudElement> parseSGUIHUDPlayer(List<String> iniLines) {
		Map<String, String> entryMap = new HashMap<>();
		Map<SGUIHUDPlayer, HudElement> elementMap = new HashMap<>();
		boolean inIniSection = false;

		for (String line : iniLines) {
			if (!inIniSection && "[ShooterGame.SGUIHUDPlayer]".equalsIgnoreCase(line)) { // start of section
				inIniSection = true;
			} else if (inIniSection && line.startsWith("[")) { // reached start of next section
				inIniSection = false;
			}

			if (inIniSection && !line.startsWith("[") && !line.isEmpty()) { // we do not want to parse the start of the section 
				HudElement element = HudElement.fromIniLine(line);
				
				if(null != element.getElementType() && element.getElementType().type == ConfigType.HUD_ELEMENT) {
					log.info(String.format("%s -- %s", element.getElementType(), element.toIniLine()));
					elementMap.put(element.getElementType(), element);
				}
			}
		}
		return elementMap;
	}

	public Map<String, HudElement> getHudElementsMappedByString() {
		return hudElementsMappedByString;
	}

	public Map<SGUIHUDPlayer, HudElement> getHudElementsMappedByEnum() {
		return hudElementsMappedByEnum;
	}

}
