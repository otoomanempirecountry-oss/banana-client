# 🍌 Banana Client

A lightweight, feature-rich Minecraft client mod built with Fabric. Includes an intuitive Click GUI and powerful combat features like Kill Aura.

## ✨ Features

### Click GUI
- **Toggle Key:** Press **B** to open/close the GUI
- **Draggable Panels:** Move GUI panels around your screen
- **Clean Interface:** Easy-to-use button system for toggling features
- **Toggleable Components:** Enable/disable features on the fly

### Kill Aura
- ✅ **Toggle On/Off** - Easily enable/disable from the GUI
- 🎯 **Configurable Range** - Adjust attack distance (1-10 blocks)
- ⏱️ **Attack Delay** - Set custom delay between attacks
- 👤 **Player Targeting** - Option to attack players
- 🐷 **Mob Targeting** - Option to attack mobs
- 🔄 **Auto-targeting** - Automatically targets closest entity

## 🛠️ Installation

### Prerequisites
- Java 17+
- Gradle 7.0+
- Minecraft 1.20.1
- Fabric Loader

### Build from Source

```bash
# Clone the repository
git clone https://github.com/otoomanempirecountry-oss/banana-client.git
cd banana-client

# Build the mod
./gradlew build

# The compiled mod will be in build/libs/
```

### Installation to Minecraft

1. Download and install [Fabric Loader](https://fabricmc.net/use/)
2. Download and install [Fabric API](https://www.curseforge.com/minecraft/mods/fabric-api)
3. Place the compiled JAR from `build/libs/` into your `.minecraft/mods/` directory
4. Launch Minecraft with the Fabric profile

## 🎮 Usage

### Opening the GUI
- Press **B** to toggle the Click GUI open/closed
- Click and drag the panel header to move it around

### Kill Aura
- Click the "Kill Aura" button in the GUI to toggle it on/off
- When enabled, it will automatically attack nearby entities
- Settings are adjustable through the feature panel

## 📋 Project Structure

```
src/
├── main/
│   ├── java/com/otoomanempire/banana/
│   │   ├── BananaClient.java              # Main client manager
│   │   ├── BananaClientModMain.java       # Fabric mod entry point
│   │   ├── features/
│   │   │   └── KillAura.java              # Kill Aura implementation
│   │   ├── gui/
│   │   │   ├── ClickGui.java              # Main GUI controller
│   │   │   └── components/
│   │   │       ├── Panel.java             # Draggable GUI panels
│   │   │       ├── Button.java            # Toggle buttons
│   │   │       └── GuiComponent.java      # Component interface
│   │   ├── events/
│   │   │   └── KeyInputHandler.java       # Input handling
│   │   └── client/
│   │       └── BananaClientEvents.java    # Client-side events
│   └── resources/
│       └── fabric.mod.json                # Fabric mod metadata
├── test/
│   └── java/com/otoomanempire/banana/
│       └── BananaClientTest.java          # Unit tests
build.gradle                               # Gradle configuration
settings.gradle                            # Gradle settings
gradle.properties                           # Gradle properties
README.md                                  # This file
LICENSE                                    # MIT License
```

## 🔧 Development

### Running in Development

```bash
# Generate Minecraft sources
./gradlew genSources

# Run Minecraft with the mod
./gradlew runClient
```

### Running Tests

```bash
./gradlew test
```

## 📚 Configuration

Key configuration files:

- `gradle.properties` - Minecraft version, Fabric versions, and mod metadata
- `build.gradle` - Build configuration and dependencies
- `src/main/resources/fabric.mod.json` - Fabric mod metadata

## 🤝 Contributing

Contributions are welcome! Please read [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**otoomanempire** - [GitHub](https://github.com/otoomanempirecountry-oss)

## 🐛 Issues & Feedback

Found a bug or have a suggestion? Please [open an issue](https://github.com/otoomanempirecountry-oss/banana-client/issues) on GitHub.

## 📦 Dependencies

- Fabric Loader 0.14.21
- Fabric API 0.90.0+1.20.1
- Minecraft 1.20.1
- Java 17+

---

**Banana Client** - Making Minecraft better, one feature at a time. 🍌✨
