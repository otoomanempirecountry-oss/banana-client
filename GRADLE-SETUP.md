# 🍌 Banana Client - Gradle Wrapper Setup Guide

## Problem
The Gradle wrapper JAR file (`gradle/wrapper/gradle-wrapper.jar`) needs to be downloaded and set up before you can use the `gradlew` or `gradlew.bat` scripts.

## Solution

Choose one of the following options:

---

## Option 1: Automated Setup (Recommended)

### On Linux/Mac:
```bash
chmod +x setup-wrapper.sh
./setup-wrapper.sh
```

### On Windows:
```bash
setup-wrapper.bat
```

This will automatically:
1. ✅ Check if Java is installed
2. ✅ Download Gradle 8.3 distribution
3. ✅ Extract the wrapper JAR
4. ✅ Clean up temporary files

---

## Option 2: Manual Setup

### Step 1: Download Gradle 8.3
Download from: https://services.gradle.org/distributions/gradle-8.3-bin.zip

### Step 2: Extract the Wrapper JAR

**Windows:**
1. Extract the ZIP file
2. Navigate to `gradle-8.3/lib/plugins/`
3. Copy `gradle-wrapper-8.3.jar` to your project's `gradle/wrapper/` directory
4. Rename it to `gradle-wrapper.jar`
5. Delete the extracted `gradle-8.3` folder

**Mac/Linux:**
```bash
unzip gradle-8.3-bin.zip
cp gradle-8.3/lib/plugins/gradle-wrapper-8.3.jar gradle/wrapper/gradle-wrapper.jar
rm -rf gradle-8.3 gradle-8.3-bin.zip
```

### Step 3: Make scripts executable (Linux/Mac only)
```bash
chmod +x gradlew
```

---

## Option 3: Using Gradle Command

If you already have Gradle installed:

```bash
gradle wrapper --gradle-version 8.3
```

This will automatically generate all wrapper files including the JAR.

---

## Verify Installation

### On Linux/Mac:
```bash
./gradlew --version
```

### On Windows:
```bash
gradlew.bat --version
```

You should see:
```
------------------------------------------------------------
Gradle 8.3
------------------------------------------------------------
```

---

## After Setup

You can now use any of these commands:

### Build the mod:
```bash
# Linux/Mac
./gradlew build

# Windows
gradlew.bat build
```

### Run Minecraft with the mod:
```bash
# Linux/Mac
./gradlew runClient

# Windows
gradlew.bat runClient
```

### Run tests:
```bash
# Linux/Mac
./gradlew test

# Windows
gradlew.bat test
```

### Clean build:
```bash
# Linux/Mac
./gradlew clean

# Windows
gradlew.bat clean
```

---

## Troubleshooting

### Error: "Could not find or load main class org.gradle.wrapper.GradleWrapperMain"
**Solution:** The JAR file is missing. Run one of the setup options above.

### Error: "Java not found"
**Solution:** Install Java 17 or higher from https://www.oracle.com/java/technologies/downloads/

### Permission denied on Linux/Mac
**Solution:** Run `chmod +x setup-wrapper.sh` and try again.

### Download failed
**Solution:** Download the ZIP manually from https://services.gradle.org/distributions/gradle-8.3-bin.zip and extract the JAR as described in Option 2.

---

## 📁 Final Project Structure

After setup, your project should have:

```
banana-client/
├── gradlew ✅
├── gradlew.bat ✅
├── setup-wrapper.sh ✅
├── setup-wrapper.bat ✅
├── GRADLE-SETUP.md ✅ (this file)
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar ✅ (downloaded)
│       └── gradle-wrapper.properties ✅
├── build.gradle
├── settings.gradle
├── gradle.properties
└── src/...
```

---

## 🍌 You're Ready!

Once the wrapper JAR is in place, you have a fully self-contained build system that requires only Java to be installed!

Happy coding! 🚀
