# 🎵 Music App (Java OOP)

[![CI](https://github.com/rafauto/music-app/actions/workflows/ci.yml/badge.svg)](https://github.com/rafauto/music-app/actions/workflows/ci.yml)
![Java](https://img.shields.io/badge/Java-17%2B-orange)
![License](https://img.shields.io/badge/license-MIT-blue)
![Status](https://img.shields.io/badge/status-academic%20project-lightgrey)

A command-line music player built as the final project of an elective **Object-Oriented Programming (Java)** course at university. It simulates a music app with a playlist, playback state, volume and music genres.

> The source code, comments and console messages are kept in **Portuguese**, exactly as submitted for the course.

## Why I built this

The goal of the assignment was to apply the core OOP concepts in a small, working product: modelling a real-world app (a music player) as classes, contracts and behaviours.

## Features

- Open the app, start playback and show a menu with status (on/playing), a volume bar and the current song
- Pre-loaded playlist with 3 sample songs
- Add a song (name + artist) to the playlist
- Remove a song by name or artist
- Search a song by name or artist
- List music genres (Pop, Sertanejo, Rock, MPB, Funk) using polymorphism
- Volume up/down, play/pause, next/previous and shuffle (implemented in `App`, not wired to the main flow)

## OOP concepts applied

| Concept | Where |
| --- | --- |
| Interface / abstraction | `Tela` declares the app's operations; `App` implements them |
| Encapsulation | Private attributes with getters/setters in `App` and `Musica` |
| Inheritance | `Pop`, `Sertanejo`, `Rock`, `MPB` and `Funk` extend `Musica` |
| Polymorphism | `Principal.categMusica()` calls `categoria()` on each genre |
| Collections | `ArrayList<Musica>` for the playlist, `Collections.shuffle` for shuffle |

## How it works

```mermaid
flowchart LR
    U[User - terminal input] --> P[Principal - main]
    P --> A[App implements Tela]
    A --> L[(Playlist - ArrayList of Musica)]
    P --> G[Genres: Pop / Sertanejo / Rock / MPB / Funk]
    G -. extends .-> M[Musica]
    L --> M
```

`Principal` creates the app, opens it, starts playback and shows the menu. It then prints the genre list through polymorphism and runs three interactive steps in sequence: **add**, **remove** and **search** a song. All data lives in memory while the program runs.

## Project structure

```
music-app/
├── src/TrabalhoFinal/
│   ├── Principal.java    # entry point (main)
│   ├── Tela.java         # interface with the app operations
│   ├── App.java          # app logic: state, playlist, menu, add/remove/search
│   ├── Musica.java       # base class (song name + artist)
│   └── Pop, Sertanejo, Rock, MPB, Funk.java   # genre subclasses
├── .github/workflows/ci.yml
├── LICENSE
└── README.md
```

## Getting started

Requirements: **JDK 17 or later**.

```bash
git clone https://github.com/rafauto/music-app.git
cd music-app
javac -encoding UTF-8 -d out src/TrabalhoFinal/*.java
java -cp out TrabalhoFinal.Principal
```

## Usage

The program asks three questions in order. Answer `1` (yes) or `2` (no), then type the song or artist name:

1. Add a song → name and artist
2. Remove a song → name or artist
3. Search a song → name or artist

Non-interactive run (same input the CI uses):

```bash
printf '1\nMusica3\nCantor3\n1\nCantor1\n1\nmusica0\n' | java -cp out TrabalhoFinal.Principal
```

## Continuous integration

GitHub Actions compiles the project on Java 17 and 21 and runs a smoke test that feeds scripted input to the app and checks that add, remove and search print the expected results.

## Changelog

The first commit holds the code exactly as submitted for the course. A follow-up `fix:` commit improved it:

- Search no longer removes the song it finds.
- Remove reports the right result (it used to say "not found" after a successful removal).
- Search and remove share one helper, `procurar()`, that ignores letter case and extra spaces.
- Genre subclasses now keep their name and artist, and `categoria()` is a real override of `Musica` (it was misspelled `cetegoria()`).
- Sample songs are loaded once, in the constructor, not every time the menu opens.
- Volume stays between 0 and 100; next/previous wrap around the playlist; shuffle prints each song once.

## Known limitations

- Volume, next/previous, pause and shuffle are implemented but not reachable from the main flow.
- The flow is a fixed sequence (add → remove → search), not a menu loop.
- Data lives in memory only and is not saved between runs.

## License

[MIT](LICENSE)

## Author

**Rafaela Uto** · [GitHub](https://github.com/rafauto)
