# 🌌 SpongeBob: Ovládnutí Galaxie

Textová sci-fi adventura napsaná v jazyce **Java** s využitím návrhového vzoru **Command Pattern**.

---

## 🌟 Highlights

- 🎮 Konzolová textová hra
- 🧠 Implementace návrhového vzoru **Command**
- 🗺️ Cestování mezi planetami (pouze mezi sousedními)
- 🎒 Funkční inventář
- 🧩 Hádan ky načítané z TXT souborů
- 📦 Herní data načítaná z JSON (Gson)
- 🏆 Výherní i proherní podmínka
- 🧱 Objektově orientovaný návrh (polymorfismus)

---

## ℹ️ Overview

**SpongeBob: Ovládnutí Galaxie** je konzolová textová hra, ve které hráč ovládá SpongeBoba a cestuje mezi různými planetami.

Během hry může:

- cestovat mezi propojenými planetami
- komunikovat s NPC postavami
- sbírat a používat předměty
- řešit hádanky
- ztrácet nebo získávat životy

Cílem hry je splnit finální podmínku a ovládnout galaxii.

Projekt vznikl jako semestrální práce zaměřená na objektově orientované programování a návrhové vzory.

---

## 🎮 Používání hry

Hráč zadává příkazy do konzole.

### Dostupné příkazy:

-jdi <planeta>
-vezmi <item>
-pouzij <item>
-mluv
-hadanka
-prozkoumej
-inventar

### Příklady:
jdi mechaon
vezmi medkit
pouzij medkit
---

## 🏗 Architektura projektu

### 🧩 Command Pattern

Každý příkaz je samostatná třída implementující rozhraní:

public interface Command {
    void execute(String[] args);
}

CommandManager ukládá příkazy do HashMap<String, Command> a podle vstupu uživatele spouští odpovídající logiku.
## 📦 Herní data (JSON)

Planety, NPC a předměty jsou načítány z gamedata.json pomocí knihovny Gson.

To umožňuje:

oddělení dat od logiky

snadné přidávání nových planet

rozšiřitelnost bez úpravy kódu

## 🧠 Hádanky 

Hádanky jsou načítány z jsonu.

Formát souboru:

Otázka
Správná odpověď
Poškození

Při špatné odpovědi hráč ztratí životy.

## 🎒 Inventář

Hráč má vlastní instanci inventáře.

Předměty lze vzít pouze pokud jsou na aktuální planetě

Každý předmět má vlastní metodu use() (polymorfismus)

Některé předměty léčí, jiné jsou nutné pro výhru

## 🏆 Výhra a prohra
# Výhra

hráč se nachází na finální planetě

použije klíčový předmět (např. DataKey)

# Prohra

životy hráče klesnou na 0
