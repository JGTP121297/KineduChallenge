package com.kineduchallenge.ui.events

import com.kineduchallenge.core.database.schema.Character
import com.kineduchallenge.core.database.schema.Comic

interface UIEvent

/**
 * UI Event to show the list of characters
 */
class ShowListCharacters(val characters: List<Character>): UIEvent

/**
 * UI Event to show the list of comics
 */
class ShowListComics(val comics: List<Comic>): UIEvent

/**
 * UI Event to show the list of characters
 */
class ShowCharacter(val character: Character): UIEvent