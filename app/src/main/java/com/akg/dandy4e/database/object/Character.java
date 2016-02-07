package com.akg.dandy4e.database.object;

public class Character {
    private final Long dbID;
    private String characterName;
    private String characterRace;
    private String characterClass;
    private Integer characterLevel;

    public Character(final Long dbID, final String characterName, final String characterRace, final String characterClass, final Integer characterLevel) {
        this.dbID = dbID;
        this.characterName = characterName;
        this.characterRace = characterRace;
        this.characterClass = characterClass;
        this.characterLevel = characterLevel;
    }

    public Long getDBID() {
        return dbID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(final String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(final String characterRace) {
        this.characterRace = characterRace;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(final String characterClass) {
        this.characterClass = characterClass;
    }

    public Integer getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(final Integer characterLevel) {
        this.characterLevel = characterLevel;
    }
}