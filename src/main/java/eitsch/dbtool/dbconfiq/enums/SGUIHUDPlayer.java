package eitsch.dbtool.dbconfiq.enums;

import static eitsch.dbtool.dbconfiq.enums.ConfigType.BOOLEAN;
import static eitsch.dbtool.dbconfiq.enums.ConfigType.HUD_ELEMENT;
import static eitsch.dbtool.dbconfiq.enums.ConfigType.NUMBER;
import static eitsch.dbtool.dbconfiq.enums.ConfigType.RESOLUTION;

public enum SGUIHUDPlayer {
	/*
	 * Descriptions thankfully recycled from 
	 * https://www.reddit.com/r/dirtybombconfigs/comments/43m0gy/hud_elements_their_common_names_and_centered/
	 */
	NativeHUDResolution(RESOLUTION, ""),
	ScopeInfoPosition(HUD_ELEMENT, ""),
	ConsoleMessageLogPosition(HUD_ELEMENT, "Text chat and console messages (PLAYER)"),
	SpectatorConsoleMessageLogPosition(HUD_ELEMENT, "Text chat and console messages output when spectating"),
	ChatInputPosition(HUD_ELEMENT, "Your text input box, where you type to chat with other players"),
	SpectatorChatInputPosition(HUD_ELEMENT, "Text chat input box when spectating"),
	IncapMenuPosition(HUD_ELEMENT, "While dead it shows which mercs/loadouts you have available so you can change them"),
	ObjectiveProgressionPosition(HUD_ELEMENT, ""),
	ObjectiveProgressionNotificationPosition(HUD_ELEMENT, ""),
	ObjectiveClockPosition(HUD_ELEMENT, ""),
	MinimapPosition(HUD_ELEMENT, "Location of the Minimap"),
	ObituaryMessageLogPosition(HUD_ELEMENT, "Shows a scrolling list of who has recently been killed by whom"),
	InteractionFillbarPosition(HUD_ELEMENT, "Shows a progress bar for actively completing an objective, eg. while planting/defusing the C4"),
	ExpCounterPosition(HUD_ELEMENT, ""),
	GameplayNotificationPosition(HUD_ELEMENT, "Shows XP gained from various sources in a scrolling list"),
	SubtitlesPosition(HUD_ELEMENT, "Shows subtitles of the narrator and also a description of the map/gamemode you are playing when you join the match"),
	ObjectiveNotificationPosition(HUD_ELEMENT, "Temporary notifications for when objectives change state, eg. EV has been repaired/disabled"),
	GameInfoPosition(HUD_ELEMENT, ""),
	SpectatorInfoPosition(HUD_ELEMENT, ""),
	DetectedNotificationPosition(HUD_ELEMENT, "Notification when you have been detected by recon abilities. (Vassili: Heartbeatsensor / RedEye:Eye / Aimee: Snitch Device"),
	DebilitatedNotificationPosition(HUD_ELEMENT, "Shows an icon if you've been debuffed by Aimee's snitch device"),
	WeaponAmmoPosition(HUD_ELEMENT, "Shows the ammo that your currently equipped weapon has loaded and total extra ammo beside that, like so: loaded/total"),
	AbilityCooldownPosition(HUD_ELEMENT, "Your merc abilities and their cooldown counters"),
	CarryBombPosition(HUD_ELEMENT, "Shows an icon if you have the C4 bomb in Execution mode"),
	PlayerHealthPosition(HUD_ELEMENT, "Shows your current health bar and HP number out of that merc's max HP"),
	ShieldBarPosition(HUD_ELEMENT, "Shows how much of Phantom's shield ability is left while active"),
	ReadyUpPosition(HUD_ELEMENT, "Shows if you are ready-up and how many players are ready-up total in match"),
	BadgeNotificationPosition(HUD_ELEMENT, "Temporary pop-up notification for Badges you earned"),
	ExecutionBadgeNotificationPosition(HUD_ELEMENT, ""),
	DeathInfoCardPosition(HUD_ELEMENT, "Shows the loadout for your teammate that you are spectating while dead"),
	SpectatorGameWaveTimerPosition(HUD_ELEMENT, "Match time left and next wave countdown when spectating"),
	GameWaveTimerPosition(HUD_ELEMENT, "Match time left and next wave countdown in one"),
	ObjectivePosition(HUD_ELEMENT, "A yellow progress bar showing the current level of overall objective completion, eg. how much longer until the C4 detonates"),
	SpectatorObjectivePosition(HUD_ELEMENT, "Shows current level of overall objective completion when spectating"),
	ActionMenuPosition(HUD_ELEMENT, "The vote menu box"),
	SpectatorActionMenuPosition(HUD_ELEMENT, "The Vote menu box when spectating"),
	CharacterSelectionPosition(HUD_ELEMENT, "Shows which mercs/loadouts you have to choose from before the match begins"),
	SpectatorCardPosition(HUD_ELEMENT, "The loadout for the player you are currently spectating"),
	ExecutionGameStatusPosition(HUD_ELEMENT, "New HUD style, shows you and your teammates' current mercs and if you/they are alive/downed/dead on a horizontal bar, at the top of the screen by default"),
	ExecutionCountdownPosition(HUD_ELEMENT, "For Execution game-mode only, countdown timer for the current round"),
	ExecutionRoundNotificationPosition(HUD_ELEMENT, "For Execution game-mode only, shows the current round number and number of wins/losses so far"),
	ExecutionRoundIntroPosition(HUD_ELEMENT, "For Execution game-mode only, shows you and your teammates' mercs and selections before the round begins, near the top of the screen by default"),
	MaxNumHitReticules(NUMBER, ""),
	MaxNumConsoleMsg(NUMBER, ""),
	MaxConsoleMsgTime(NUMBER, ""),
	MaxConsoleParentDisplayTime(NUMBER, ""),
	ConsoleMsgYBufferHeight(NUMBER, ""),
	MaxNumObituaryMsg(NUMBER, ""),
	MaxObituaryMsgTime(NUMBER, ""),
	ObituaryMsgYBufferHeight(NUMBER, ""),
	m_bEnableHudShake(BOOLEAN, "");
	
	public final ConfigType type;
	public final String description;

	private SGUIHUDPlayer(ConfigType type, String description) {
		this.type = type;
		this.description = description;
	}
}
